package com.example;


import com.example.bean.BeanDefinition;
import com.example.bean.factory.BeanFactory;
import com.example.bean.factory.support.DefaultBeanFactory;
import com.example.service.v1.UserService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeanTest {

	@BeforeMethod
	public void setUp() {}

	@AfterMethod
	public void tearDown() {}

	@Test
	public void getBeanTest() {
		BeanFactory beanFactory = new DefaultBeanFactory("application-v1.xml");
		BeanDefinition beanDefinition = beanFactory.getDefinition("userService");
		Assert.assertEquals("com.example.service.v1.UserService", beanDefinition.getBeanClassName());

		UserService userService = (UserService) beanFactory.getBean("userService");
		Assert.assertNotNull(userService);
	}

	@Test
	public void testValidateBean() {
		try {
			BeanFactory beanFactory = new DefaultBeanFactory("application-v1.xml");
			beanFactory.getBean("xxx");
		} catch (Exception e) {
			return;
		}
		Assert.fail("expect BeanCreationException..");
	}

	@Test
	public void testValidateXml() {
		try {
			new DefaultBeanFactory("xx.xml");
		} catch (Exception e) {
			return;
		}
		Assert.fail("expect BeanDefinitionStoreException...");
	}


}
