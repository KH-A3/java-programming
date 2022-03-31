package exam09;

public class PremiumCustomer extends Customer {
	private double discount;
	
	public PremiumCustomer(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	public double getDiscount() {
		return discount;
	}

	@Override
	public void buy(String productName, double price) {
		price = _calcDiscount(price);
		this.setPriceTotal(this.getPriceTotal() + price);
		System.out.printf("%s님이 %s을(를) 할인율 %.2f 적용하여 %,.0f원에 구입하였습니다.\n"
				, getName(), productName, this.discount, price);
	}
	
	private double _calcDiscount(double price) {
		if(this.getPriceTotal() >= 10000000) {
			this.discount = 0.1;
		} else if(this.getPriceTotal() >= 5000000) {
			this.discount = 0.05;
		} else if(this.getPriceTotal() >= 3000000) {
			this.discount = 0.02;
		}
		price = price * (1 - discount);
		return price;
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
