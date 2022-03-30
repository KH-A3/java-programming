package exam07;

// 부장
public class Director extends Employee {
	
	private boolean teamManager;	// 팀장직 수행 여부를 구분하기 위한 멤버 변수
	private boolean headManager;	// 본부장직 수행 여부를 구분하기 위한 멤버 변수
	
	public Director(String name, int age) {
		super(name, age);
		setSalary(8000);
	}
}
