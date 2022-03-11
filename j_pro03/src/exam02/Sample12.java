package exam02;

import java.util.Scanner;

public class Sample12 {

	public static void main(String[] args) {
		/*
		 * 3. 사용자 입력한 영단어에서 대문자/소문자의 수를 구해서 출력한다.
		 * "Java Programming" -> 대문자 2개, 소문자 13개
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();
		
		int cnt1 = 0, cnt2 = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
				cnt1++;
			} else if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				cnt2++;
			}
		}
		System.out.printf("대문자 %d개, 소문자 %d개 있습니다.", cnt1, cnt2);
	}

}
