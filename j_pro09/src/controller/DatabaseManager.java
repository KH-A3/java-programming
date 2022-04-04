package controller;

import model.vo.Grade;
import model.vo.Student;

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
		int idx = -1;
		for(int i = 0; i < datas.length; i++) {
			if(name.equals(datas[i].getName())) {
				idx = i;
			}
		}
		if(idx == -1) {
			return null;
		} else {
			return datas[idx].getGrades();
		}
	}

	@Override
	public boolean add(String name) {
		return false;
	}

	@Override
	public Student modify(String name, String subject, int score) {
		return null;
	}

	@Override
	public boolean remove(String name) {
		return false;
	}

}
