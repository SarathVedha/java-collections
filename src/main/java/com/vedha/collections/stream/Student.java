package com.vedha.collections.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Student.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String gender;

    private String departmentName;

    private int joinedYear;

    private String city;

    private int rank;

}