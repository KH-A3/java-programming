package exam07;

// 대리
public class AssistantManager extends Employee {
	
	private int corpCardTotal;
	
	public AssistantManager(String name, int age) {
		super(name, age);
		setSalary(3000);
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

	public int getCorpCardTotal() {
		return corpCardTotal;
	}

	public void setCorpCardTotal(int corpCardTotal) {
		this.corpCardTotal = corpCardTotal;
	}
	
}
