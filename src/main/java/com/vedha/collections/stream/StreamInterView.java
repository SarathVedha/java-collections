package com.vedha.collections.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamInterView {

    public static final List<Student> list = Arrays.asList(
            new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
            new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
            new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
            new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
            new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
            new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
            new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
            new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
            new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
            new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98)
    );

    public static void main(String[] args) {

        // 1- Find list of students whose first name starts with alphabet A
        System.out.println("1- Find list of students whose first name starts with alphabet A");
        List<Student> a = list.stream().filter(student -> student.getFirstName().startsWith("A")).toList();
        a.forEach(System.out::println);
        System.out.println();

        // 2- Group The Student By Department Names
        System.out.println("2- Group The Student By Department Names");
        Map<String, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName));
        collect.forEach((s, students) -> System.out.println("key: " + s + " value: " + students));
        System.out.println();

        // 3- Find the total count of student using stream
        System.out.println("3- Find the total count of student using stream");
        long count = list.stream().count();
        System.out.println(count);
        System.out.println();

        // 4- Find the max age of student
        System.out.println("4- Find the max age of student");
        OptionalInt max1 = list.stream().mapToInt(Student::getAge).max();
        System.out.println(max1);
        Optional<Student> max = list.stream().max(Comparator.comparingInt(Student::getAge));
        System.out.println(max);
        System.out.println();

        // 5- Find all departments names
        System.out.println("5- Find all departments names");
        List<String> list1 = list.stream().map(Student::getDepartmentName).distinct().toList();
        list1.forEach(System.out::println);
        System.out.println();

        // 6- Find the count of student in each department
        System.out.println("6- Find the count of student in each department");
        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()));
        collect1.entrySet().forEach(System.out::println);
        System.out.println();

        // 7- Find the list of students whose age is less than 30
        System.out.println("7- Find the list of students whose age is less than 30");
        List<Student> list2 = list.stream().filter(student -> student.getAge() < 30).toList();
        list2.forEach(System.out::println);
        System.out.println();

        // 8- Find the list of students whose rank is in between 50 and 100
        System.out.println("8- Find the list of students whose rank is in between 50 and 100");
        List<Student> list3 = list.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100).toList();
        list3.forEach(System.out::println);
        System.out.println();

        // 9- Find the average age of male and female students
        System.out.println("9- Find the average age of male and female students");
        Map<String, Double> collect2 = list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        collect2.entrySet().forEach(System.out::println);
        System.out.println();

        // 10- Find the department who is having maximum number of students
        System.out.println("10- Find the department who is having maximum number of students");
        Optional<Map.Entry<String, Long>> max2 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(max2);
        System.out.println();

        // 11- Find the Students who stays in Mumbai and sort them by their names
        System.out.println("11- Find the Students who stays in Mumbai and sort them by their names");
        List<Student> delhi = list.stream().filter(student -> student.getCity().equalsIgnoreCase("Mumbai"))
                .sorted(Comparator.comparing(Student::getFirstName)).toList();
        delhi.forEach(System.out::println);
        System.out.println();

        // 12- Find the average rank in all departments
        System.out.println("12- Find the average rank in all departments");
        Map<String, Double> collect3 = list.stream().collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.averagingInt(Student::getRank)));
        collect3.entrySet().forEach(System.out::println);
        System.out.println();

        // 13- Find the highest rank in each department
        System.out.println("13- Find the highest rank in each department");
        Map<String, Optional<Student>> collect4 = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.maxBy(Comparator.comparingInt(Student::getRank))));
        collect4.entrySet().forEach(System.out::println);
        System.out.println();

        // 13- Find the Lowest rank in each department
        System.out.println("13- Find the Lowest rank in each department");
        Map<String, Optional<Student>> collect5 = list.stream()
                .collect(Collectors.groupingBy(Student::getDepartmentName, Collectors.minBy(Comparator.comparingInt(Student::getRank))));
        collect5.entrySet().forEach(System.out::println);
        System.out.println();

        // 14- Find the list of students and sort them by their rank ASC
        System.out.println("14- Find the list of students and sort them by their rank ASC");
        List<Student> list4 = list.stream().sorted(Comparator.comparingInt(Student::getRank)).toList();
        list4.forEach(System.out::println);
        System.out.println();

        // 14- Find the list of students and sort them by their rank DESC
        System.out.println("14- Find the list of students and sort them by their rank DESC");
        List<Student> list5 = list.stream().sorted(Comparator.comparingInt(Student::getRank).reversed()).toList();
        list5.forEach(System.out::println);
        System.out.println();

        // 15- Find the student who has second rank
        System.out.println("15- Find the student who has second rank");
        Optional<Student> first = list.stream().sorted(Comparator.comparingInt(Student::getRank).reversed()).skip(1).findFirst();
        System.out.println(first);
        System.out.println();

        // 16- Write a single line code to print all the student sort by first and last names joining with comma
        System.out.println("16- Write a single line code to print all the student first and last names joining with comma");
        String collect6 = list.stream().map(student -> student.getFirstName().concat(" ").concat(student.getLastName())).sorted()
                .collect(Collectors.joining(", "));
        System.out.println(collect6);
        System.out.println();

        // 17- Write a single line code to print all the student first and last names joining and seperated by comma
        System.out.println("17- Write a single line code to print all the student first and last names joining and seperated by comma");
        String collect7 = list.stream().map(student -> student.getFirstName().concat(" ").concat(student.getLastName())).sorted()
                .collect(Collectors.joining(", ", "(", ")"));
        System.out.println(collect7);

//        String collect7 = list.stream().map(student -> "?").collect(Collectors.joining(", ", "(", ")"));
//        System.out.println(collect7);
    }
}
