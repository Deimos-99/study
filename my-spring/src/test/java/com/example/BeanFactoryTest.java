package com.example;

import com.example.bean.BeanDefinition;
import com.example.bean.factory.BeanFactory;
import com.example.bean.factory.support.DefaultBeanFactory;
import com.example.bean.factory.xml.XmlBeanDefinitionReader;
import com.example.core.io.ClassPathResource;
import com.example.service.v1.UserService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeanFactoryTest {

	private DefaultBeanFactory beanFactory;
	private XmlBeanDefinitionReader reader;
	@BeforeMethod
	public void setUp() {
		beanFactory = new DefaultBeanFactory();
		reader = new XmlBeanDefinitionReader(beanFactory);
	}

	@AfterMethod
	public void tearDown() {}

	@Test
	public void getBeanTest() {
		reader.loadDefinition(new ClassPathResource("application-v1.xml"));

		BeanDefinition beanDefinition = beanFactory.getDefinition("userService");
		Assert.assertEquals("com.example.service.v1.UserService", beanDefinition.getBeanClassName());

		Assert.assertTrue(beanDefinition.isSingleton());
		Assert.assertFalse(beanDefinition.isPrototype());
		Assert.assertEquals(BeanDefinition.SCOPE_DEFAULT, beanDefinition.getScope());

		UserService userService = (UserService) beanFactory.getBean("userService");
		Assert.assertNotNull(userService);

		UserService userService1 = (UserService) beanFactory.getBean("userService");
		Assert.assertEquals(userService, userService1);
	}

	@Test
	public void testValidateBean() {
		try {
			reader.loadDefinition(new ClassPathResource("application-v1.xml"));

			beanFactory.getBean("xxx");
		} catch (Exception e) {
			return;
		}
		Assert.fail("expect BeanCreationException..");
	}

	@Test
	public void testValidateXml() {
		try {
			reader.loadDefinition(new ClassPathResource("xx-v1.xml"));
		} catch (Exception e) {
			return;
		}
		Assert.fail("expect BeanDefinitionStoreException...");
	}


}
