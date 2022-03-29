package exam04;

public class Main {

	public static void main(String[] args) {
		PremiumCustomer p1 = new PremiumCustomer("홍길동", 35, 'M');
		NormalCustomer n1 = new NormalCustomer("고길동", 45, 'M');
		
		p1.buy("루이비통", 3500000);
		p1.buy("루이비통", 3500000);
		p1.buy("루이비통", 3500000);
		p1.buy("루이비통", 3500000);
		n1.buy("루이비통", 3500000);
	}

}
