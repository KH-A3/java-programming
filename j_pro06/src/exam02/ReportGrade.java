package exam02;

import java.util.Arrays;

public class ReportGrade {
	private String name;
	private String[] subjects;
	private double[] grades;

	public ReportGrade(String name) {
		this.name = name;
	}

	public ReportGrade(String name, String[] subjects) {
		this.name = name;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	
	public void setGrades(String subject, double grade) {
		int idx = this._findIndex(subject);
		this.grades[idx] = grade;
	}
	
	public double getGrade(String subject) {
		int idx = this._findIndex(subject);
		return this.grades[idx];
	}
	
	public void add(String subject, double grade) {
		int len = this.subjects.length;
		this.subjects = Arrays.copyOf(this.subjects, len + 1);
		this.grades = Arrays.copyOf(this.grades, len + 1);
		
		this.subjects[len] = subject;
		this.grades[len] = grade;
	}
	
	private int _findIndex(String subject) {
		int idx = 0;
		for(int i = 0; i < this.subjects.length; i++) {
			String s = this.subjects[i];
			if(subject.equals(s)) {
				idx = i;	// 동일한 과목명을 찾아서 인덱스 저장
				break;
			}
		}
		return idx;
	}
}
