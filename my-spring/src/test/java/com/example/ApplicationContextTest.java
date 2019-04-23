package com.example;

import com.example.context.ApplicationContext;
import com.example.context.support.ClassPathApplicationContext;
import com.example.context.support.FileSystemApplicationContext;
import com.example.service.v1.UserService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApplicationContextTest {


	@BeforeMethod
	public void setUp() {}

	@AfterMethod
	public void tearDown(){}

	@Test
	public void testClassPathApplication() {
		ApplicationContext context = new ClassPathApplicationContext("application-v1.xml");
		UserService userService = (UserService) context.getBean("userService");
		Assert.assertNotNull(userService);
	}

	@Test
	public void testFileSystemPathApplication() {
		ApplicationContext context = new FileSystemApplicationContext("D:\\test_source\\my-spring\\src\\test\\resources\\application-v1.xml");
		UserService userService = (UserService) context.getBean("userService");
		Assert.assertNotNull(userService);
	}

}
