package exam03;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받기 위한 Scanner 클래스
		 * 		- 기본적으로 모든 사용자 입력 데이터는 문자열이다.
		 * 		- 사용자 입력 데이터에 대해 정수 또는 실수 데이터로 사용하기 위해서는 별도의 메서드를 사용해야 한다.
		 * 		  (sc.nextInt(), sc.nextDouble())
		 */
		
		// Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요. : ");
		int iInput = sc.nextInt();
		
		System.out.println("사용자 입력 값 : " + iInput);
		System.out.printf("사용자 입력 값 : %d\n", iInput);
		
		System.out.print("실수를 입력하세요. : ");
		double dInput = sc.nextDouble();
		
		System.out.println("사용자 입력 값 : " + dInput);
		System.out.printf("사용자 입력 값 : %.2f\n", dInput);
	}

}
