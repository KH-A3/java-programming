package exam07;

// 차장
public class DeputyGeneralManager extends Employee {
	
	private int corpCardTotal;
	private boolean teamManager;	// 팀장직 수행 여부를 구분하기 위한 멤버 변수
	private boolean headManager;	// 본부장직 수행 여부를 구분하기 위한 멤버 변수
	
	public DeputyGeneralManager(String name, int age) {
		super(name, age);
		setSalary(5500);
	}
	
	@Override
	public void payMonth() {
		super.payMonth();
		if(teamManager) {
			double bonusPay = getSalary() * 0.1 / 12;
			System.out.printf("팀장직 수행 보너스 %,d 원을 추가 지급하였습니다.\n", (int)(bonusPay * 10000));
		}
		if(headManager) {
			double bonusPay = getSalary() * 0.2 / 12;
			System.out.printf("본부장직 수행 보너스 %,d 원을 추가 지급하였습니다.\n", (int)(bonusPay * 10000));
		}
	}
	
	public void corpCard(int amount) {
		if(getSalary() * 0.015 * 10000 > corpCardTotal + amount) {
			System.out.printf("%,d 원을 법인카드로 지불하였습니다.\n", amount);
			corpCardTotal += amount;
		} else {
			System.out.println("법인 카드의 한도를 초과하였습니다.");
			System.out.printf("현재까지 사용액은 %,d원 입니다.\n", corpCardTotal);
			System.out.printf("한도내에서 %,.0f원 만큼만 사용할 수 있습니다.\n", getSalary() * 0.015 * 10000 - corpCardTotal);
		}
	}

	public boolean isTeamManager() {
		return teamManager;
	}

	public void setTeamManager(boolean teamManager) {
		this.teamManager = teamManager;
	}

	public boolean isHeadManager() {
		return headManager;
	}

	public void setHeadManager(boolean headManager) {
		this.headManager = headManager;
	}
	
	public int getCorpCardTotal() {
		return corpCardTotal;
	}

	public void setCorpCardTotal(int corpCardTotal) {
		this.corpCardTotal = corpCardTotal;
	}
	
}
