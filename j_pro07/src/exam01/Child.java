package exam01;

public class Child extends Parent {
	
	public Child(int number) {
		super(number);	// 부모생성자 명시
	}
	
	// 안해도 상관 없지만 오버라이딩이 가능한 메서드인지 확인하기 위한 용도로 쓰인다.
	@Override
	public int getNumber() {
		System.out.println("자식의 getNumber 메서드 시작");
		int num = super.getNumber();
		System.out.println("자식의 getNumber 메서드 끝");
		return num + 10;
	}
}
