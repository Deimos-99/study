package com.example.jdbc.service.impl;

import com.example.jdbc.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	private UserService userService;

	@Before
	public void setUp() {
		userService.deleteAllUsers();
	}

	@Test
	public void testUserService() {
		// 增加测试3个用户
		userService.create("张三", 10);
		userService.create("李四", 20);
		userService.create("王五", 30);

		// 查询数据库用户数
		Assert.assertEquals(3, userService.getUserCount().intValue());

		// 删除张三用户
		userService.deleteByName("张三");

		// 查询数据库用户数
		Assert.assertEquals(2, userService.getUserCount().intValue());
	}
}
