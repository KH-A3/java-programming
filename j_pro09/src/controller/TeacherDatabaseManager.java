package controller;

import model.vo.Teacher;

public class TeacherDatabaseManager {
	
	private Teacher[] datas;
	
	{
		datas = new Teacher[2];
		datas[0] = new Teacher("고명환", "1234");
		datas[1] = new Teacher("김수덕");
	}
	
	public Teacher login(String username, String password) {
		for(int i = 0; i < datas.length; i++) {
			if(username.equals(datas[i].getName()) && password.equals(datas[i].getPassword())) {
				return datas[i];
			}
		}
		return null;
	}
	
	public boolean isExisted(String name) {
		boolean result = false;
		if(_findIndex(name) != -1) {
			result = true;
		}
		return result;
	}
	
	public Teacher getTeacher(String name) {
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
}
