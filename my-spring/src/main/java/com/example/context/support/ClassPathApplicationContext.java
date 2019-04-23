package com.example.context.support;

import com.example.core.io.ClassPathResource;
import com.example.core.io.Resource;

public class ClassPathApplicationContext extends AbstractApplicationContext{

	public ClassPathApplicationContext(String path) {
		super(path);
	}

	@Override
	public Resource getResrouce(String path) {
		return new ClassPathResource(path);
	}
}
