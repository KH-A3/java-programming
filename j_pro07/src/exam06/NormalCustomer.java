package exam06;

public class NormalCustomer extends Customer {
	public NormalCustomer(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	@Override
	public void buy(String productName, double price) {
		super.buy(productName, price);
		this.setPriceTotal(this.getPriceTotal() + price);
	}
}
