package exam02;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		
		// 3번 입력 제한을 설정했음.
		// 3번 입력 제한 안에 올바른 값을 입력하지 않은 경우 -> 입력 횟수를 초과하였습니다.
		for(int i = 0; i < 3; i++) {
			System.out.print("1 ~ 5 사이의 정수값 입력 : ");
			num = sc.nextInt();
			
			if(num >= 1 && num <= 5) {
				break;
			}
			
			if(i == 2) {
				System.out.println("입력 횟수를 초과하였습니다.");
			}
		}
		
	}

}
