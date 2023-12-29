/**
 * 
 */
package com.vedha.collections.features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

/**
 * @author sarath.perumal
 *
 */
public class Java11Features {

	public static void main(String[] args) throws IOException {

		var hashMap = new HashMap<>();
		hashMap.put(100, "Vedha");
		System.out.println(hashMap);
		
		List<String> readAllLines = Files.readAllLines(Path.of(new ClassPathResource("/files/Test.txt").getURI()));
		System.out.println(readAllLines);
		
		Path createFile = Files.createFile(Path.of(""));
		System.out.println(createFile.getFileName());
		
	}

}
