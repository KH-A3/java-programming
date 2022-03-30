package exam07;

// 부장
public class Director extends DeputyGeneralManager {
	
	public Director(String name, int age) {
		super(name, age);
		setSalary(8000);
	}
	
	@Override
	public void bonus(int month) {
		switch(month) {
			case 12:
				double bonus = getSalary() * 0.25;
				System.out.printf("보너스 %,d 원 지급하였습니다.\n", (int)(bonus * 10000));
		}
	}
	
}
