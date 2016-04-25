package org.zsl.testmybatis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;
	@Autowired
	private UserServiceImpl userServiceImpl;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

//	@Test
//	public void test1() {
//		User user = userService.getUserById(1);
//		// System.out.println(user.getUserName());
//		// logger.info("值："+user.getUserName());
//		logger.info(JSON.toJSONString(user));
//	}
	
	@Test
	public void testTransaction(){
		List<User> users = new ArrayList<User>();
		for(int i=1;i<5;i++){
			User user = new User();
			user.setAge(i);
			user.setPassword(i+"111111");
			user.setUserName("测试"+i);
			users.add(user);
		}
		userServiceImpl.insertUser(users);
	}
}
