package exam02;

import java.util.Scanner;

public class Sample10 {

	public static void main(String[] args) {
		/*
		 * 1. 사용자가 입력할 수 있는 문자열의 길이를 제한하는 코드를 작성하시오.
		 * (길이 제한은 최소 3자 ~ 최대 5자)
		 * 제한을 넘긴 경우 다시 입력하도록 한다.
		 */
		Scanner sc = new Scanner(System.in);
		String input = "";
		
		while(true) {
			System.out.print("문자열 입력 : ");
			input = sc.nextLine();
			
			if(input.length() >= 3 && input.length() <= 5) {
				break;
			}
			
			System.out.println("입력 제한을 초과하였습니다. 3 ~ 5자 사이로 입력하세요.");
		}
		
	}

}
