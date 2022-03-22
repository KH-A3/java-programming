package exam10.model.vo;

public class Member {

	private String memberId;
	private String memberPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	// 기본 생성자는 매개변수가 있는 생성자가 없으면 자동 생성
	
	public void changeName(String name) {
		memberName = name;
	}
	
	public void printName() {
		System.out.println(memberName);
	}
}
