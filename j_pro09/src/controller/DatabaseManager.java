package controller;

import java.util.Arrays;

import model.vo.Grade;
import model.vo.Student;
import model.vo.Teacher;

public class DatabaseManager implements ImplDatabaseManager {

	private Student[] datas;
	
	// 초기화 블록
	{
		datas = new Student[5];
		datas[0] = new Student("홍길동");	datas[1] = new Student("김도원");
		datas[2] = new Student("박수아");	datas[3] = new Student("최종희");
		datas[4] = new Student("이정우");
		
		for(int i = 0; i < datas.length; i++) {
			datas[i].setGrades(new Grade[] {
					new Grade("국어"), new Grade("영어"), new Grade("수학"), new Grade("과학")
			});
		}
	}
			
	@Override
	public Grade[] search(String name) {
		int idx = _findIndex(name);
		
		if(idx == -1) {
			return null;
		} else {
			return datas[idx].getGrades();
		}
	}

	@Override
	public boolean add(String name) {
		int idx = _findIndex(name);
		
		if(idx == -1) {
			datas = Arrays.copyOf(datas, datas.length + 1);
			datas[datas.length - 1] = new Student(name);
			Grade[] init = new Grade[] {
					new Grade("국어"), new Grade("영어"), new Grade("수학"), new Grade("과학")
			};
			datas[datas.length - 1].setGrades(init);
			return true;
		}
		
		return false;
	}

	@Override
	public Student modify(String name, String subject, int score) {
		int idx = _findIndex(name);
		
		if(idx != -1) {
			Grade[] grades = datas[idx].getGrades();
			for(int i = 0; i < grades.length; i++) {
				if(subject.equals(grades[i].getName())) {
					grades[i].setScore(score);
					break;
				}
			}
			return datas[idx];
		}
		
		return null;
	}

	@Override
	public boolean remove(String name) {
		int idx = _findIndex(name);
		
		if(idx != -1) {
			Student[] temp = new Student[datas.length - 1];
			System.arraycopy(datas, 0, temp, 0, idx);
			System.arraycopy(datas, idx + 1, temp, idx, datas.length - (idx + 1));
			datas = temp;
			return true;
		}
		
		return false;
	}
	
	public boolean isExisted(String name) {
		boolean result = false;
		if(_findIndex(name) != -1) {
			result = true;
		}
		return result;
	}
	
	public Student getStudent(String name) {
		return datas[_findIndex(name)];
	}
	
	private int _findIndex(String name) {
		int idx = -1;
		for(int i = 0; i < datas.length; i++) {
			if(name.equals(datas[i].getName())) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	public Student login(String username, String password) {
		for(int i = 0; i < datas.length; i++) {
			if(username.equals(datas[i].getName()) && password.equals(datas[i].getPassword())) {
				return datas[i];
			}
		}
		return null;
	}

}
