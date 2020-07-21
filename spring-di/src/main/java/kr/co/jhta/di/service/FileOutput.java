package kr.co.jhta.di.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutput implements Output {

	private PrintWriter writer;
	
	public FileOutput(String directory, String filename) {
		
		try {
			File file = new File(directory, filename);
			writer = new PrintWriter(file, "utf-8");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void write(String text) {
		writer.println(text);
		writer.flush();
	}
}
