package stusys;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clifton.dao.ElectiveMapper;
import com.clifton.dao.SuccessKilledMapper;
import com.clifton.pojo.Elective;
import com.clifton.redis.RedisHandle;

/**
* @author Clifton  
* @date 2019年8月1日 上午8:25:07 
* @project jsj
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mybatis.xml" })
public class SpringTest {
	

	@Autowired
	ElectiveMapper electiveMapper;
	
	@Autowired
	SuccessKilledMapper successKilledMapper;
	
	@Autowired
	RedisHandle redisHandle;

	@Test
	public void test() {
		 List<Elective> list = electiveMapper.queryAll("");
		 System.out.println(list);
	}
	
	
	@Test
	public void test1() {
		electiveMapper.reduceNumber(1, new Date());
	}
	
	@Test
	public void test2() {
		successKilledMapper.insertSuccessKilled(1, 1610701120, new Date());
	}
	
	@Test
	public void test3( ) {
		redisHandle.set("123", 12313232, (long) 60);
	}

}
