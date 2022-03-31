package exam09;

public abstract class Customer implements Basket, Delivery, Payment {
	private String name;
	private int age;
	private char gender;
	private double priceTotal;
	
	public Customer(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public abstract void buy(String productName, double price);
	
	@Override
	public void add(String productName) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(String productName, int count) {
		// TODO Auto-generated method stub
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public double getPriceTotal() {
		return this.priceTotal;
	}
	
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	
}
