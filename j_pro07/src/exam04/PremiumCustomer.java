package exam04;

public class PremiumCustomer extends Customer {
	private double discount;
	private double priceTotal;
	
	public PremiumCustomer(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	@Override
	public void buy(String productName, double price) {
		price = _calcDiscount(price);
		this.priceTotal += price;
		System.out.printf("%s님이 %s을(를) 할인율 %.2f 적용하여 %,.0f원에 구입하였습니다.\n"
				, getName(), productName, this.discount, price);
	}
	
	private double _calcDiscount(double price) {
		if(this.priceTotal >= 10000000) {
			this.discount = 0.1;
		} else if(this.priceTotal >= 5000000) {
			this.discount = 0.05;
		} else if(this.priceTotal >= 3000000) {
			this.discount = 0.02;
		}
		price = price * (1 - discount);
		return price;
	}
}
