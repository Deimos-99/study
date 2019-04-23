package com.example.core.io;

import com.example.util.Assert;
import com.example.util.ClassUtils;

import java.io.InputStream;

public class ClassPathResource implements Resource {

	private String path;

	private ClassLoader classLoader;

	public ClassPathResource(String path) {
		this(path, (ClassLoader) null);
	}

	public ClassPathResource(String path, ClassLoader classLoader) {
		Assert.notNull(path, "class path must not null");
		this.path = path;
		this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
	}

	@Override
	public InputStream getInputStream() {
		return classLoader.getResourceAsStream(path);
	}

	@Override
	public String getDescription() {
		return path;
	}
}
