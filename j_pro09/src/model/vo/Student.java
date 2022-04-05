package model.vo;

public class Student extends Account {
	private Grade[] grades;
	
	public Student(String name) {
		setName(name);
		setPassword("1111");
	}
	
	public Student(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public Grade[] getGrades() {
		return grades;
	}
	
	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}
	
}
