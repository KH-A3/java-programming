package exam07;

// 과장
public class DepartmentManager extends Employee {
	
	private boolean teamManager;	// 팀장직 수행 여부를 구분하기 위한 멤버 변수
	
	public DepartmentManager(String name, int age) {
		super(name, age);
		setSalary(4000);
	}
	
	@Override
	public void payMonth() {
		super.payMonth();
		if(teamManager) {
			double bonusPay = getSalary() * 0.1 / 12;
			System.out.printf("팀장직 수행 보너스 %,d 원을 추가 지급하였습니다.\n", (int)(bonusPay * 10000));
		}
	}

	public boolean isTeamManager() {
		return teamManager;
	}

	public void setTeamManager(boolean teamManager) {
		this.teamManager = teamManager;
	}
	
}
