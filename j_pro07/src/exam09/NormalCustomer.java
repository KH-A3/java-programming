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
	public void modify(String productName, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String productName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] listUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] listUp(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(String orderCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String pay(String productCode, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancel(String produtCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirm(String payCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refund(String productName) {
		// TODO Auto-generated method stub
		
	}
	
	
}
