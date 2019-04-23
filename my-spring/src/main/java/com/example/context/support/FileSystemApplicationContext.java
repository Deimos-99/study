package com.example.context.support;

import com.example.core.io.FileSystemResource;
import com.example.core.io.Resource;

public class FileSystemApplicationContext extends AbstractApplicationContext {

	public FileSystemApplicationContext(String path) {
		super(path);
	}

	@Override
	public Resource getResrouceByPath(String path) {
		return new FileSystemResource(path);
	}
}
