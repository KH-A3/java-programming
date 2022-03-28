package exam01;

public class Main {

	public static void main(String[] args) {
		/*
		 * 상속
		 *     - 부모 클래스, 자식 클래스 나뉘어서 사용하며, 이때 자식 클래스가 부모 클래스를 상속해서 사용.
		 *     - 부모 클래스를 상속한 자식은 부모가 가지는 메서드, 멤버 변수를 그대로 사용할 수 있다.
		 *     - 상속을 사용할 때 자식 클래스에서 extends 키워드로 부모 클래스를 지정하여 사용한다.
		 *     
		 * 상속 이점
		 *     - 클래스의 재사용성을 높여 줄수 있다.
		 *     - 클래스간에 공통 코드를 상속을 통해 관리하면, 코드의 추가 및 변경이 용이(유지보수가 쉬워짐)
		 *     - 코드의 중복을 제거하여 프로그램의 생산성/유지보수에 기여
		 */
		
		Child child = new Child(1);
		System.out.println(child.getNumber());
		child.setNumber(20);
		// System.out.println(child.getNumber());
	}

}
