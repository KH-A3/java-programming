package model.vo;

public abstract class Account {
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean changePassword(String currPass, String changePass) {
		if(currPass.equals(getPassword())) {
			setPassword(changePass);
			return true;
		}
		return false;
	}
	
}