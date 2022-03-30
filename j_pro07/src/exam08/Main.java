package exam08;

public class Main {

	public static void main(String[] args) {
		/*
		 * 추상 클래스
		 *     - 몸체 없는 메서드(추상 메서드)를 포함하는 클래스, abstract 키워드를 사용해서 만든다.
		 *     - 미완성 클래스를 만들어서 추상 클래스를 상속하는 자식 클래스들이 미완성된 부분을
		 *       완성하게 강제시켜 준다.
		 *     - 추상 클래스를 사용하여 객체를 생성 할 수 없다.
		 *       (단, 참조 타입으로 사용할 수 있다.)
		 *     - 미완성된/완성된 메서드를 포함하여 생성할 수 있다.
		 */
		Shape s1 = new Circle();
		Shape s2 = new Square();
	}

}
