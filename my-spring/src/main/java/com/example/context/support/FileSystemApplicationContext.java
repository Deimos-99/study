package com.example.context.support;

import com.example.bean.factory.support.DefaultBeanFactory;
import com.example.bean.factory.xml.XmlBeanDefinitionReader;
import com.example.context.ApplicationContext;
import com.example.core.io.ClassPathResource;
import com.example.core.io.FileSystemResource;
import com.example.core.io.Resource;

public class FileSystemApplicationContext extends AbstractApplicationContext {

	public FileSystemApplicationContext(String path) {
		super(path);
	}

	@Override
	public Resource getResrouce(String path) {
		return new FileSystemResource(path);
	}
}
