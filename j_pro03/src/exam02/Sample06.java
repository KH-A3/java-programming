package exam02;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 사용자가 입력한 정수값 까지 반복 출력하는 코드를 작성한다.
		 * (1 ~ 사용자 입력 값 까지 출력)
		 */
		int num;
		
		System.out.print("정수값 입력 : ");
		num = sc.nextInt();
		for(int i = 0; i < num; i++) {
			System.out.println(i + 1);
		}
		
		/*
		 * 사용자가 입력한 정수값 부터 ~ 1 까지 반복 출력하는 코드를 작성한다.
		 */
		System.out.print("정수값 입력 : ");
		num = sc.nextInt();
		for(int i = num; i >= 1; i--) {
			System.out.println(i);
		}
		
		/*
		 * 위 문제에서 반복 출력할 때 한 줄에 7개의 정수 값이 출력되도록 코드를 작성한다.
		 */
		System.out.print("정수값 입력 : ");
		num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			System.out.print(i + 1 + " ");
			if((i + 1) % 7 == 0) {
				System.out.println();
			}
		}
	}

}
