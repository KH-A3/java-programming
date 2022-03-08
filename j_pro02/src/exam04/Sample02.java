package exam04;

import java.util.Scanner;

public class Sample02 {

	// 이항 연산자 : 피연산자가 2개 있는 연산
	// 1 + 1, 1 * 2, ...
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 산술 연산자
		// +, -, *, /(나누기), %(나머지)
		int num1, num2;
		
		/*
		System.out.print("첫번째 정수 입력 : ");
		num1 = sc.nextInt();	// Scanner 사용해서 사용자 입력을 받는 것으로 변경.
		System.out.print("두번째 정수 입력 : ");
		num2 = sc.nextInt();	// Scanner 사용해서 사용자 입력을 받는 것으로 변경.
		*/
		num1 = 10;	num2 = 3;
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
		
		// 논리 연산자
		// 		&& : and 논리 연산 기호, 두 피연산자의 논리값이 전부 참인 경우에만 참으로 연산하는 연산자
		// 		|| : or 논리 연산 기호, 두 피연산자의 논리값이 전부 거짓인 경우에만 거짓으로 연산하는 연산자
		// 논리 연산은 true, false 논리 값으로만 연산을 수행한다.
		System.out.printf("%b && %b -> %b\n", true, true, true && true);
		System.out.printf("%b && %b -> %b\n", true, false, true && false);
		System.out.printf("%b && %b -> %b\n", false, true, false && true);
		System.out.printf("%b && %b -> %b\n", false, false, false && false);
		
		System.out.printf("%b || %b -> %b\n", true, true, true || true);
		System.out.printf("%b || %b -> %b\n", true, false, true || false);
		System.out.printf("%b || %b -> %b\n", false, true, false || true);
		System.out.printf("%b || %b -> %b\n", false, false, false || false);
		
	}

}
