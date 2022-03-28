package exam01;

public class Parent {
	private int number = 10;
	
	public Parent(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		System.out.println("부모의 getNumber 메서드 시작");
		System.out.println("부모의 getNumber 메서드 끝");
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
