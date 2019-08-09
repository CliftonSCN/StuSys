package stusys;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.clifton.dto.Exposer;
import com.clifton.dto.SeckillExecution;
import com.clifton.exception.RepeatKillException;
import com.clifton.exception.SeckillCloseException;
import com.clifton.pojo.Elective;
import com.clifton.service.ElectiveService;

/**  
* @author Clifton  
* @date 2019年8月6日 下午3:40:52 
* @project stusys
*/
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mybatis.xml" })
public class ServiceTest {

	private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    ElectiveService electiveService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Elective> list=electiveService.getElectiveList("");
        logger.info("list={}", list);
    }

    @Test
    public void testGetById() throws Exception {
        int id=1;
        Elective elective=electiveService.getById(id);
        logger.info("e={}", elective);
    }
    
    @Test
    public void testExportSeckillUrl() throws Exception {
        int id=2;
        Exposer exposer=electiveService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
    }
    
    @Test
    @Rollback(false)
    public void testExecuteSeckill() throws Exception {
        int id=2;
        int stuNum=1610701123;
        String md5="f2a31d15c46442c1d0c9bc8368334211";
        
        try {
        	SeckillExecution execution=electiveService.executeSeckill(id,stuNum,md5);
            logger.info("result={}", execution);
        }catch (RepeatKillException e)
        {
            logger.error(e.getMessage());
        }catch (SeckillCloseException e1)
        {
            logger.error(e1.getMessage());
        }

    }

}
