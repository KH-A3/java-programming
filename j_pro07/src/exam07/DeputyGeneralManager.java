package exam07;

// 차장
public class DeputyGeneralManager extends DepartmentManager implements HeadManager {
	
	private boolean headManager;	// 본부장직 수행 여부를 구분하기 위한 멤버 변수
	
	public DeputyGeneralManager(String name, int age) {
		super(name, age);
		setSalary(5500);
	}
	
	@Override
	public void bonus(int month) {
		switch(month) {
			case 4: case 8: case 12:
				double bonus = getSalary() * 0.25;
				System.out.printf("보너스 %,d 원 지급하였습니다.\n", (int)(bonus * 10000));
		}
	}
	
	@Override
	public void headPayBonus() {
		if(isHeadManager()) {
			double bonusPay = getSalary() * 0.2 / 12;
			System.out.printf("본부장직 수행 보너스 %,d 원을 추가 지급하였습니다.\n", (int)(bonusPay * 10000));
		}
	}

	public boolean isHeadManager() {
		return headManager;
	}

	public void setHeadManager(boolean headManager) {
		this.headManager = headManager;
	}
	
}
