package exam10;

public class Main {

	public static void main(String[] args) {
		/*
		 * 인터페이스
		 *     - 추상 클래스의 변형체
		 *     - 상수형 필드와 추상 메서드만을 작성할 수 있다.
		 *         - 인터페이스에 작성된 모든 메서드는 abstract 키워드를 생략할 수 있다.
		 *         - 인터페이스에 작성된 모든 멤버 변수 public static final 생략되어 있다.
		 *     - 메서드의 통일성(일관성)을 부여하기 위해 사용한다.
		 *     - 인터페이스를 상속하는 클래스는 implements 키워드를 사용한다.
		 *     - 인터페이스는 다중 상속이 가능하다.
		 *     - 인터페이스로 객체 생성은 할 수 없지만, 참조 타입으로는 사용할 수 있다.
		 */
		// Shape s1 = new Shape();
		Shape s2 = new Circle();
		Shape s3 = new Square();
	}

}
