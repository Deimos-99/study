package com.example;

import com.example.core.io.ClassPathResource;
import com.example.core.io.FileSystemResource;
import com.example.core.io.Resource;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {

	@BeforeMethod
	public void setUp() {}

	@AfterMethod
	public void tearDown(){}

	@Test
	public void testClassPathResource() {
		Resource resource = new ClassPathResource("application-v1.xml");
		testResourceNotNull(resource);
	}

	@Test
	public void testFileSystemPathResource() {
		Resource resource = new FileSystemResource("D:\\test_source\\my-spring\\src\\test\\resources\\application-v1.xml");
		testResourceNotNull(resource);
	}

	private void testResourceNotNull(Resource resource) {
		InputStream is = null;
		try {
			is = resource.getInputStream();
			Assert.assertNotNull(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



}
