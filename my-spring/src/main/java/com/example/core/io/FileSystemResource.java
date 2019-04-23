package com.example.core.io;

import com.example.util.Assert;

import java.io.*;

public class FileSystemResource implements Resource {

	private String path;

	private File file;

	public FileSystemResource(String path) {
		Assert.notNull(path, "file path must not be null");
		this.path = path;
		file = new File(path);
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}

	@Override
	public String getDescription() {
		return "file:[" + file.getAbsolutePath() + "]";
	}
}
