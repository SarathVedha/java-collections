package com.vedha.collections.maps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File(".\\src\\main\\resources\\test.properties")));
		System.out.println(properties);
		properties.put("Briyani", "50");
		properties.store(new FileOutputStream(new File(".\\src\\main\\resources\\test.properties")), "Updated");
	}

}
