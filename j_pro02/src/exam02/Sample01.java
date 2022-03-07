package exam02;

public class Sample01 {

	public static void main(String[] args) {
		System.out.print("안녕하세요.");
		System.out.print("반갑습니다.");
		System.out.print("제 이름은 홍길동 입니다.");
		
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");
		System.out.println("제 이름은 홍길동 입니다.");
		
		// 출력 형식을 지정하는 메서드
		int i1 = 30;
		System.out.println("당신의 나이는 " + i1 + " 세 입니다.");
		System.out.printf("당신의 나이는 %d 세 입니다.\n", i1);
		System.out.printf("당신의 나이는 %o 세 입니다.\n", i1);
		System.out.printf("당신의 나이는 %x 세 입니다.\n", i1);
		System.out.printf("당신의 나이는 %c 세 입니다.\n", i1 + 3);
		
		double d1 = 1234.5678;
		System.out.printf("실수 표기 형식 : %f\n", d1);
		System.out.printf("실수 표기 형식 : %.2f\n", d1);
		System.out.printf("실수 표기 형식 : %.3f\n", d1);
		System.out.printf("실수 표기 형식 : %.10f\n", d1);
		System.out.printf("실수 표기 형식 : %e\n", d1);
		System.out.printf("실수 표기 형식 : %g\n", d1);
		System.out.printf("실수 표기 형식 : %A\n", d1);
	}

}
