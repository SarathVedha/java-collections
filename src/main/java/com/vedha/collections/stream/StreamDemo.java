package com.vedha.collections.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vedha.collections.dtos.TestDTO;

public class StreamDemo {

	public static void main(String[] args) {

		// Stream is interface supports of method is static to create Object
		Stream<String> of = Stream.of("A", "B", "C");
		of.forEach(System.out::println);

		System.out.println();

		// Collection as Stream
		Collection<String> collection = Arrays.asList("Java", "Python", "C++", "C++");
		Stream<String> stream = collection.stream();
		stream.forEach(System.out::println);

		System.out.println();

		// List as Stream
		ArrayList<String> arrayList = new ArrayList<>(collection);
		Stream<String> stream2 = arrayList.stream();
		stream2.forEach(System.out::println);

		System.out.println();

		// Set as Stream
		HashSet<String> hashSet = new HashSet<>(collection);
		Stream<String> stream3 = hashSet.stream();
		stream3.forEach(System.out::println);

// ---------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println();
		System.out.println("Filter");

		// Stream Filters
		// Get C++ Record As List from collections
		List<String> collect = collection.stream().filter(t -> t.equalsIgnoreCase("c++")).collect(Collectors.toList());
		System.out.println(collect);

		System.out.println();

		// Get By Age Above 25
		ArrayList<TestDTO> testListDto = new ArrayList<>();
		testListDto.add(new TestDTO(100l, "vedha", 20, 100.0));
		testListDto.add(new TestDTO(101l, "Master", 28, 250.0));
		testListDto.add(new TestDTO(102l, "Beast", 25, 350.0));
		testListDto.add(new TestDTO(103l, "Theri", 15, 450.0));
		testListDto.add(new TestDTO(104l, "Kaithi", 40, 250.0));
		testListDto.add(new TestDTO(106l, "Leo", 50, 350.0));
		testListDto.add(new TestDTO(107l, "Leo", 90, 950.0));
		testListDto.add(new TestDTO(105l, "Leo", 60, 750.0));

		List<TestDTO> collect2 = testListDto.stream().filter(t -> t.getAge() > 25).toList();
		System.out.println(collect2);

// ----------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println();
		System.out.println("Sort ASC");

		// Sort as ASC
		// Wrapper Class -> .sorted() gives ASC ** Only For Wrapper Class
		List<String> collect3 = arrayList.stream().sorted().collect(Collectors.toList());
		System.out.println(collect3);

		// Wrapper Class --> Comparator.naturalOrder() gives ASC ** Only For Wrapper
		// Class
		List<String> collect4 = arrayList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		System.out.println(collect4);

		// Implementing Lambda Sorting ASC
		List<String> collect5 = arrayList.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
		System.out.println(collect5);

		// Custom DTO ASC
		List<TestDTO> collect6 = testListDto.stream().sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge()))
				.collect(Collectors.toList());
		System.out.println(collect6);

		// Comparator Interface Having some methods to compare
		List<TestDTO> collect7 = testListDto.stream().sorted(Comparator.comparingInt(TestDTO::getAge))
				.collect(Collectors.toList());
		System.out.println(collect7);

		// Sort DTO By Name ASC
		List<TestDTO> collect8 = testListDto.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());
		System.out.println(collect8);

		// Sort DTO By Name ASC
		Stream<TestDTO> stream4 = testListDto.stream();
		List<TestDTO> collect9 = stream4.sorted(Comparator.comparing(TestDTO::getName)).collect(Collectors.toList());
		System.out.println(collect9);

// -----------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println();
		System.out.println("Sort DESC");

		// Sort as DESC
		// Wrapper Class --> Comparator.reverseOrder() gives DESC ** Only For Wrapper
		// Class
		List<String> collect10 = arrayList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(collect10);

		// Implementing Lambda Sorting DESC reverse the compareTo Method
		List<String> collect11 = arrayList.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
		System.out.println(collect11);

		// Implementing Lambda Sorting DESC reverse the compareTo Method
		List<TestDTO> collect12 = testListDto.stream().sorted((o1, o2) -> o2.getAge().compareTo(o1.getAge()))
				.collect(Collectors.toList());
		System.out.println(collect12);

		// Custom DTO DESC
		List<TestDTO> collect13 = testListDto.stream().sorted(Comparator.comparingInt(TestDTO::getAge).reversed())
				.collect(Collectors.toList());
		System.out.println(collect13);

		List<TestDTO> collect14 = testListDto.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
				.collect(Collectors.toList());
		System.out.println(collect14);

		List<TestDTO> collect15 = testListDto.stream().sorted(Comparator.comparing(TestDTO::getName).reversed())
				.collect(Collectors.toList());
		System.out.println(collect15);

// ----------------------------------------------------------------------------------------------------------------------------------------------

		System.out.println();
		System.out.println("Use Case --> TestDTO Filter with Name having LEO and Sort By Age DESC");

		// Use Case
		// TestDTO Filter with Name having LEO and Sort By Age DESC
		List<TestDTO> collect16 = testListDto.stream().filter(t -> t.getName().equalsIgnoreCase("LEO"))
				.sorted(Comparator.comparingInt(TestDTO::getAge).reversed()).collect(Collectors.toList());
		System.out.println(collect16);

		System.out.println();
		System.out.println("Use Case --> TestDTO Filter with Name having LEO and Sort By Age DESC And Get There IDs");
		List<Long> collect17 = testListDto.stream().filter(t -> t.getName().equalsIgnoreCase("LEo"))
				.sorted(Comparator.comparingInt(TestDTO::getAge).reversed()).map(TestDTO::getId)
				.collect(Collectors.toList());
		System.out.println(collect17);

		System.out.println();
		System.out.println("Find First");
		// Get The First Value, if empty get an empty optional
		Optional<TestDTO> findFirst = testListDto.stream().findFirst();
		if (findFirst.isPresent()) {

			TestDTO testDTO = findFirst.get();
			System.out.println(testDTO);
		} else {

			System.out.println("Stream Is Empty");
		}

		System.out.println();
		System.out.println("Find Any");
		// Get The Any Value, if empty get an empty optional
		Optional<TestDTO> findAny = testListDto.stream().findAny();
		if (findAny.isPresent()) {

			TestDTO testDTO = findAny.get();
			System.out.println(testDTO);
		} else {

			System.out.println("Stream Is Empty");
		}

		System.out.println();
		System.out.println("Count");
		// Count Of Stream
		long count = testListDto.stream().count();
		System.out.println(count);

		long count2 = arrayList.stream().count();
		System.out.println(count2);

		System.out.println();
		System.out.println("Min");
		// Minimum You Need to Sort
		String string = arrayList.stream().min(Comparator.naturalOrder()).get();
		System.out.println(string);

		TestDTO testDTO = testListDto.stream().min(Comparator.comparing(TestDTO::getAge)).get();
		System.out.println(testDTO);

		System.out.println();
		System.out.println("Max");
		// Maximum You Need to Sort
		String string2 = arrayList.stream().max(Comparator.naturalOrder()).get();
		System.out.println(string2);

		TestDTO testDTO2 = testListDto.stream().max(Comparator.comparing(TestDTO::getAge)).get();
		System.out.println(testDTO2);

		System.out.println();
		System.out.println("Flat Map");

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// Flat Map is used to convert the list of list to single list
		List<List<String>> list = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("D", "C"), Arrays.asList("F", "E"), Arrays.asList("G", "G"));

		List<String> list1 = list.stream().flatMap(Collection::stream).toList();
		System.out.println(list1);

		// Converting into Lower Case
		List<String> collect18 = list.stream().flatMap(strings ->  strings.stream().map(String::toLowerCase)).toList();
		System.out.println(collect18);

		// Distinct remove duplicates
		System.out.println();
		List<String> list2 = list.stream().flatMap(Collection::stream).distinct().toList();
		System.out.println(list2);

		// Sorting
		System.out.println();
		List<String> list3 = list.stream().flatMap(Collection::stream).distinct().sorted().toList();
		System.out.println(list3);

		// Limit
		System.out.println();
		List<String> list4 = list.stream().flatMap(Collection::stream).distinct().sorted().limit(3).toList();
		System.out.println(list4);

		// Joining
		System.out.println();
		String collect19 = list.stream().flatMap(Collection::stream).distinct().sorted().collect(Collectors.joining());
		System.out.println(collect19);

		// Joining with Delimiter
		System.out.println();
		String collect20 = list.stream().flatMap(Collection::stream).distinct().sorted().collect(Collectors.joining(","));
		System.out.println(collect20);

		// Sorts as per ASCII Ascending Order First A-Z and a-z
		System.out.println();
		List<String> a = List.of("A", "B", "C", "D", "E", "F", "a", "G", "b", "H");

		List<String> list5 = a.stream().distinct().sorted().toList();
		System.out.println(list5);

		System.out.println();
		String reduce = a.stream().distinct().sorted().reduce("", String::concat);
		System.out.println(reduce);

		// -----------------------------------------------------------------------------------------------------------------------------------------------

		// HashMap Stream Operations
		System.out.println();
		System.out.println("HashMap Stream Operations");
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("Ab", "Apple");
		hashMap.put("ba", "Bad");
		hashMap.put("aa", "Dog");
		hashMap.put("Bd", "Ball");
		System.out.println(hashMap);

		// Key Set (Key always unique)
		Set<String> keySet = hashMap.keySet();

		// Values Collection (Values can be duplicate)
		Collection<String> values = hashMap.values();

		// Entry Set (entry -> Key and Value) Entry is unique
		Set<Map.Entry<String, String>> entries = hashMap.entrySet();

		// Key Set Stream
		List<String> list6 = keySet.stream().sorted().toList();
		System.out.println(list6);

		// Values Stream
		List<String> list7 = values.stream().sorted().toList();
		System.out.println(list7);

		// Entry Set Stream
		List<Map.Entry<String, String>> list8 = entries.stream().sorted(Map.Entry.comparingByValue()).toList();
		System.out.println(list8);
	}
}
