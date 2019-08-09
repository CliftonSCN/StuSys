package com.clifton.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.clifton.dao.ElectiveMapper;
import com.clifton.dao.SuccessKilledMapper;
import com.clifton.dto.Exposer;
import com.clifton.dto.SeckillExecution;
import com.clifton.enums.SeckillStatEnum;
import com.clifton.exception.RepeatKillException;
import com.clifton.exception.SeckillCloseException;
import com.clifton.exception.SeckillException;
import com.clifton.pojo.Elective;
import com.clifton.pojo.SuccessKilled;

/**
 * @author Clifton
 * @date 2019年8月6日 下午3:00:49
 * @project stusys
 */
@Service
public class ElectiveServiceImpl implements com.clifton.service.ElectiveService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private final String salt = "aksehiucka24sf*&%&^^#^%$";

	@Autowired
	ElectiveMapper electiveMapper;
	
	@Autowired
	SuccessKilledMapper seccessKilledMapper;

	@Override
	public List<Elective> getElectiveList(String order) {
		return electiveMapper.queryAll(order);
	}

	@Override
	public Elective getById(int id) {
		return electiveMapper.queryById(id);
	}

	@Override
	public Exposer exportSeckillUrl(int id) {
		Elective elective = electiveMapper.queryById(id);
		if (elective == null) // 说明查不到这个秒杀产品的记录
		{
			return new Exposer(false, id);
		}

		// 若是秒杀未开启
		Date startTime = elective.getStartTime();
		Date endTime = elective.getEndTime();
		// 系统当前时间
		Date nowTime = new Date();
		if (startTime.getTime() > nowTime.getTime() || endTime.getTime() < nowTime.getTime()) {
			return new Exposer(false, id, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}

		// 秒杀开启，返回秒杀商品的id、用给接口加密的md5
		String md5 = getMD5(id);
		return new Exposer(true, md5, id);
	}

	private String getMD5(int id) {
		String base = id + "/" + salt;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

	//秒杀是否成功，成功:减库存，增加明细；失败:抛出异常，事务回滚
	@Override
	@Transactional
	public SeckillExecution executeSeckill(int id, int stuNum, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		if (md5==null||!md5.equals(getMD5(id)))
        {
            throw new SeckillException("seckill data rewrite");//秒杀数据被重写了
        }
        //执行秒杀逻辑:减库存+增加购买明细
        Date nowTime=new Date();

        try{
            //减库存
            int updateCount=electiveMapper.reduceNumber(id,nowTime);
            if (updateCount<=0)
            {
                //没有更新库存记录，说明秒杀结束
                throw new SeckillCloseException("seckill is closed");
            }else {
                //否则更新了库存，秒杀成功,增加明细
                int insertCount=seccessKilledMapper.insertSuccessKilled(id, stuNum, nowTime);
                //看是否该明细被重复插入，即用户是否重复秒杀
                if (insertCount<=0)
                {
                    throw new RepeatKillException("seckill repeated");
                }else {
                    //秒杀成功,得到成功插入的明细记录,并返回成功秒杀的信息
                    SuccessKilled successKilled=seccessKilledMapper.queryByIdWithElective(stuNum);
                    return new SeckillExecution(id,SeckillStatEnum.SUCCESS,successKilled);
                }
            }
        }catch (SeckillCloseException e1)
        {
            throw e1;
        }catch (RepeatKillException e2)
        {
            throw e2;
        }catch (Exception e)
        {
            logger.error(e.getMessage(),e);
            //将编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error :"+e.getMessage());
        }
	}

}
