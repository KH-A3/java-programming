package exam01;

public class Sample01 {

	public static void main(String[] args) {
		int i1 = 500;
		byte b1;
		
		b1 = (byte)i1;	// 강제 형변환
		
		System.out.println(i1);
		System.out.println(b1);
		
		byte b2 = 100;
		int i2;
		
		i2 = b2;	// 자동 형변환
		
		double d1 = 10.4;
		int i3 = 5;
		int i4;
		
		i4 = (int)(i3 + d1);	// 자동 형변환, 강제 형변환
		System.out.println(i4);
		
		double d2 = 10.6;
		double d3 = 10.7;
		int i5, i6;
		
		i5 = (int)(d2 + d3);
		i6 = (int)d2 + (int)d3;
		
		System.out.println(i5);
		System.out.println(i6);
		
		int i7 = 0;
		// boolean b3 = (boolean)i7;	// boolean 형의 캐스팅은 안됨.
		
		String s2 = "100";
		// i7 = (int)s2;	// 문자열을 기본자료형으로 변환(캐스팅) 안됨.
		
		s2 = i7 + "";	// 캐스팅은 아니지만 기본타입을 문자열로 변환할 수 있다.
	}

}
