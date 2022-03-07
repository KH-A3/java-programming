package exam04;

public class Sample02 {

	// 이항 연산자 : 피연산자가 2개 있는 연산
	// 1 + 1, 1 * 2, ...
	public static void main(String[] args) {
		// 산술 연산자
		// +, -, *, /(나누기), %(나머지)
		int num1, num2;
		
		num1 = 10;	// Scanner 사용해서 사용자 입력을 받는 것으로 변경.
		num2 = 3;	// Scanner 사용해서 사용자 입력을 받는 것으로 변경.
		
		System.out.printf("%d + %d = %d\n", num1 ,num2, num1 + num2);
		System.out.printf("%d - %d = %d\n", num1 ,num2, num1 - num2);
		System.out.printf("%d * %d = %d\n", num1 ,num2, num1 * num2);
		System.out.printf("%d / %d = %f\n", num1 ,num2, (double)num1 / num2);
		System.out.printf("%d %% %d = %d\n", num1 ,num2, num1 % num2);
		
		// 비교 연산자
		// ==(같다), !=(다르다), <(왼쪽 피연산자가 작다), >(왼쪽 피연산자가 크다),
		// <=(왼쪽 피연산자가 작거나 같다), >=(왼쪽 피연산자가 크거나 같다)
		num2 = 10;
		System.out.printf("%d == %d -> %b\n", num1, num2, num1 == num2);
		System.out.printf("%d != %d -> %b\n", num1, num2, num1 != num2);
		System.out.printf("%d > %d -> %b\n", num1, num2, num1 > num2);
		System.out.printf("%d < %d -> %b\n", num1, num2, num1 < num2);
		System.out.printf("%d >= %d -> %b\n", num1, num2, num1 >= num2);
		System.out.printf("%d <= %d -> %b\n", num1, num2, num1 <= num2);
	}

}
