package exam06;

public class Customer {
	private String name;
	private int age;
	private char gender;
	private double priceTotal;
	
	public Customer(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	
	public void buy(String productName, double price) {
		System.out.printf("%s님이 %s을(를) %,.0f원에 구입하였습니다.\n", this.name, productName, price);
	}
}
