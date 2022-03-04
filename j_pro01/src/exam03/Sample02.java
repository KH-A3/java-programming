package exam03;

public class Sample02 {

	public static void main(String[] args) {
		// 지역변수는 반드시 초기화가 필요.
		int x;
		x = 1;
		System.out.println(x);
		
		/* 
		 * 상수 : 한 번 초기화를 한 후에는 값을 변경할 수 없다.
		 * 변수 선언 방식과 유사하며, 변수 선언 할 때 쓰이는 자료형 앞에 final 예약어를 쓰면 된다.
		 */
		final int i1;
		i1 = 2;
		
		final int i2 = 3;
		
		String str1 = "기차" + 123 + 45 + "출발";
		String str2 = 123 + 45 + "기차" + "출발";
		String str3 = "기차" + (123 + 45) + "출발";
				
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
