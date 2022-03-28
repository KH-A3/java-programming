package exam03;

public class Main {

	public static void main(String[] args) {
		// 아래의 두 방식 모두 점수를 설정을 했을 때 등급이 설정되게 하시오.
		Grade g1 = new Grade(87.3);
		System.out.println(g1.getPoint());
		System.out.println(g1.getLevel());
		System.out.println(g1);
		
		Grade g2 = new Grade();
		g2.setPoint(85.3);
		System.out.println(g2.getPoint());
		System.out.println(g2.getLevel());
		System.out.println(g2);
		
		System.out.println(g1.equals(g2));
	}

}
