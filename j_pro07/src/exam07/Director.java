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
				super.bonus(month);
		}
	}
	
}
