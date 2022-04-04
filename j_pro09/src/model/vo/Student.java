package model.vo;

public class Student {
	private String name;
	private Grade[] grades;
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Grade[] getGrades() {
		return grades;
	}
	
	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}
	
}
