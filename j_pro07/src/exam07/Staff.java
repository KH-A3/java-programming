package exam07;

// 사원
public class Staff extends Employee {
	public Staff(String name, int age) {
		super(name, age);
		setSalary(2800);
	}
	
	@Override
	public void bonus(int month) {
		switch(month) {
			case 6: case 12:
				double bonus = getSalary() * 0.25;
				System.out.printf("보너스 %,d 원 지급하였습니다.\n", (int)(bonus * 10000));
		}
	}
}
