/**
 * 
 */
package com.vedha.collections.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.core.io.ClassPathResource;

import com.vedha.collections.dtos.TestDTO;

/**
 * @author sarath.perumal
 *
 */
public class StreamRealProblems {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// Remove duplicates in Array
		String[] arg = { "1", "5", "3", "1" };

		List<String> list = Arrays.stream(arg).distinct().toList();
		System.out.println(list);

		// Reverse The Array
		List<String> list2 = Arrays.stream(arg).distinct().sorted(Comparator.reverseOrder()).toList();
		System.out.println(list2);

		// Get Max Of Array Of String Numbers
		String string = Arrays.stream(arg).map(Integer::parseInt).max(Comparator.naturalOrder()).map(String::valueOf)
				.get();
		System.out.println(string);

		// Count The String of each Numbers In the Array
		Map<String, Long> collect = Arrays.stream(arg).collect(Collectors.groupingBy(t -> t, Collectors.counting()));
		System.out.println(collect);

		// Get String of each Numbers In the Array
		Map<String, List<String>> collect2 = Arrays.stream(arg)
				.collect(Collectors.groupingBy(t -> t, Collectors.mapping(t -> t, Collectors.toList())));
		System.out.println(collect2);

		ArrayList<TestDTO> arrayList = new ArrayList<>();
		arrayList.add(new TestDTO(1001l, "Vedha", 20, 100.0));
		arrayList.add(new TestDTO(1002l, "Master", 21, 100.0));
		arrayList.add(new TestDTO(1003l, "Theri", 25, 1000.0));
		arrayList.add(new TestDTO(1004l, "Leo", 29, 3000.0));
		arrayList.add(new TestDTO(1005l, "Vijay", 30, 20000.0));
		arrayList.add(new TestDTO(1006l, "Vijay Sethupathi", 40, 10000.0));
		arrayList.add(new TestDTO(1007l, "Vikram", 20, 10000.0));

		// Sort DTO By Salary
		List<TestDTO> collect5 = arrayList.stream().sorted(Comparator.comparingDouble(TestDTO::getSalary))
				.collect(Collectors.toList());
		System.out.println(collect5);

		// Sort By Salary and Group by salary
		Map<Double, Set<TestDTO>> collect4 = arrayList.stream().sorted(Comparator.comparingDouble(TestDTO::getSalary))
				.collect(Collectors.groupingBy(TestDTO::getSalary, Collectors.toSet()));
		System.out.println(collect4);

		// get max salary id only
		Long long1 = arrayList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(TestDTO::getSalary)))
				.map(TestDTO::getId).get();
		System.out.println(long1);

		Long long2 = arrayList.stream().max(Comparator.comparingDouble(TestDTO::getSalary)).map(TestDTO::getId).get();
		System.out.println(long2);

		// get DTO by grouping with salary with name by salary range from above 1000 and
		// below 10000
		Map<Double, List<String>> collect3 = arrayList.stream().parallel().filter(t -> {
			if (t.getSalary() >= 1000.0 && t.getSalary() <= 10000.0) {
				return true;
			} else {
				return false;
			}
		}).collect(
				Collectors.groupingBy(TestDTO::getSalary, Collectors.mapping(TestDTO::getName, Collectors.toList())));

		System.out.println(collect3);

		// File Streaming
		ClassPathResource classPathResource = new ClassPathResource("/files/Test.txt");
		System.out.println(classPathResource.getFile().getAbsolutePath());

		Path path = Paths.get(classPathResource.getFile().getAbsolutePath());
		Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);

		List<String> collect6 = lines.filter(t -> !t.isBlank()).collect(Collectors.toList());
		System.out.println(collect6);
		lines.close();

		Stream<String> lines2 = Files.lines(path, StandardCharsets.UTF_8);
		lines2.filter(t -> !t.isBlank()).forEach(System.out::println);
		lines2.close();

	}

}
