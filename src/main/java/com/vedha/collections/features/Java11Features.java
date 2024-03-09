/**
 * 
 */
package com.vedha.collections.features;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

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

		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(ResourceLoader.CLASSPATH_URL_PREFIX.concat("/files/"));

		Files.readAllLines(Path.of(resource.getFile().getPath().concat("/sample.txt")), Charset.forName("Cp1252")).forEach(System.out::println);
		List<String> cp12522 = Files.readAllLines(Path.of(resource.getFile().getPath().concat("/sample.txt")), Charset.forName("Cp1252")).stream().skip(3).toList();

		Path path = Path.of("C:\\Users\\sarat\\Downloads\\sample2.txt");
		Files.deleteIfExists(path);
		Path file = Files.createFile(path);
		Path cp1252 = Files.write(file, cp12522, Charset.forName("Cp1252"));
		Files.readAllLines(cp1252, Charset.forName("Cp1252")).forEach(System.out::println);

		System.out.println(Charset.defaultCharset().displayName());
	}

}
