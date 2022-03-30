package exam09;

public class NormalCustomer extends Customer {
	public NormalCustomer(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	@Override
	public void buy(String productName, double price) {
		System.out.printf("%s님이 %s을(를) %,.0f원에 구입하였습니다.\n", getName(), productName, price);
		this.setPriceTotal(this.getPriceTotal() + price);
	}

	@Override
	public boolean refund(String productName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean basket(String productName, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String searchDelivery(String orderCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addPoint(int price) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] suggestionProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
