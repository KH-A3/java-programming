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
}
