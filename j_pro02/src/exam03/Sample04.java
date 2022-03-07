package exam03;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		
		System.out.print("첫 번쨰 정수 입력 : ");
		num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 입력 : ");
		num2 = sc.nextInt();
		
		int result = num1 + num2;
		System.out.println("더하기 연산 결과 : " + result);
		System.out.printf("%d + %d = %d\n", num1, num2, result);
	}

}
