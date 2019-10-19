package stusys;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clifton.dao.ElectiveMapper;
import com.clifton.dao.SuccessKilledMapper;
import com.clifton.dao.TeacherMapper;
import com.clifton.dao.UserMapper;
import com.clifton.dto.TeacherFin;
import com.clifton.pojo.Elective;
import com.clifton.pojo.User;
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

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	TeacherMapper teacherMapper;

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
	public void test3() {
		redisHandle.set("123", 12313232, (long) 60);
	}

	@Test
	public void test4() {
		User user = userMapper.findUserByUserName("1610701120");
		System.out.println(user);
	}
	
	@Test
	public void test5() {
		Set<String> list = userMapper.findRoles("1610701120");
		System.out.println(list);
	}
	
	@Test
	public void test6() {
		Set<String> list = userMapper.findPermissions("1610701120");
		System.out.println(list);
	}
	
	@Test
	public void test7() {
		List<TeacherFin> list = teacherMapper.selectByStuNum("1610701120");
		System.out.println(list);
	}

}
