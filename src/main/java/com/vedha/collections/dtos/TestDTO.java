package com.vedha.collections.dtos;

public class TestDTO {
	private Long id;

	private String name;

	private Integer age;

	private Double salary;

	public TestDTO() {

	}

	public TestDTO(Long id, String name, Integer age, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "TestDTO [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}
