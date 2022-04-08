package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Teacher extends Account {
	
	private Date loginDate = new Date();
	
	public Teacher(String name) {
		setName(name);
		setPassword("A1111a");
	}
	
	public Teacher(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	public String getLoginDateFormat() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		return sFormat.format(loginDate);
	}
	
	public String resetPassword() {
		Random r = new Random();
		String prefix = "TCH_";
		String newPass = "";
		for(int i = 0; i < 6; i++) {
			newPass += (char)(r.nextInt(26) + 65);
		}
		setPassword(prefix + newPass);
		return prefix + newPass;
	}
	
}
