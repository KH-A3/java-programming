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
				super.bonus(month);
		}
	}
}
