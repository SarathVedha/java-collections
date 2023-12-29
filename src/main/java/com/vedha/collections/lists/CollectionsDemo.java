package com.vedha.collections.lists;

import java.util.ArrayList;
import java.util.Collections;

import com.vedha.collections.dtos.TestDTO;

public class CollectionsDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, SecurityException {

		ArrayList<String> list = new ArrayList<>();

		/*
		 * Insert
		 */
		list.add("Mersal");
		list.add("Master");
		list.add("Beast");
		list.add("Leo");
		list.add("Vedha");
		list.add("Vedha");
		list.add("Vedha");

		System.out.println("Before Sort : " + list);

		Collections.sort(list);

		System.out.println("After Sort To ASEC : " + list);

		String max = Collections.max(list);
		System.out.println("max : " + max);

		String min = Collections.min(list);
		System.out.println("min : " + min);

		int binarySearch = Collections.binarySearch(list, "Leo");
		System.out.println("Binary Search : " + binarySearch);

		Collections.reverse(list);
		System.out.println("Reversed : " + list);

		Collections.sort(list, (o1, o2) -> {

			String s1 = (String) o1;
			String s2 = (String) o2;

			int compareTo = s1.compareTo(s2);
			if (compareTo > 0) {

				return -1;
			} else if (compareTo < 0) {

				return 1;
			} else {

				return 0;
			}

		});

		System.out.println("After Sort : " + list);

		boolean replaceAll = Collections.replaceAll(list, "Vedha", "Vedha-Duplicate");
		System.out.println("is replaced : " + replaceAll);

		System.out.println("After Replaced : " + list);

		ArrayList<TestDTO> testListDto = new ArrayList<>();
		testListDto.add(new TestDTO(100l, "vedha", 20, 100.0));
		testListDto.add(new TestDTO(101l, "Master", 28, 250.0));
		testListDto.add(new TestDTO(102l, "Beast", 25, 350.0));
		testListDto.add(new TestDTO(103l, "Theri", 15, 450.0));
		testListDto.add(new TestDTO(104l, "Kaithi", 40, 250.0));
		testListDto.add(new TestDTO(106l, "Leo", 50, 350.0));
		testListDto.add(new TestDTO(107l, "Leo", 90, 950.0));
		testListDto.add(new TestDTO(105l, "Leo", 60, 750.0));

		System.out.println("DTO WithOut Sort : " + testListDto);

		Collections.sort(testListDto, (o1, o2) -> {

			TestDTO dto1 = (TestDTO) o1;
			TestDTO dto2 = (TestDTO) o2;

			if (dto1.getAge() > dto2.getAge()) {

				return 1;
			} else if (dto1.getAge() < dto2.getAge()) {

				return -1;
			} else {
				// If Same means Sort By Id
				if (dto1.getId() > dto2.getId()) {

					return 1;
				} else if (dto1.getId() < dto2.getId()) {

					return -1;
				} else {

					return 0;
				}

			}
		});

		System.out.println("DTO Sort By Age : " + testListDto);

	}

}
