package exam02;

import java.util.Scanner;

public class Sample11 {

	public static void main(String[] args) {
		/*
		 * 2. 사용자가 입력한 영단어에서 'a', 'e', 'i', 'o', 'u' 문자의
		 * 수를 구해 출력한다.
		 * "java programming" -> 5개.
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();
		
		int cnt = 0;
		for(int i = 0; i < input.length(); i++) {
			switch(input.charAt(i)) {
				case 'a':	case 'e':	case 'i': 	case 'o':	case 'u':
					cnt++;
			}
		}
		System.out.printf("'a', 'e', 'i', 'o', 'u' 문자가 총 %d 개 있습니다.", cnt);
	}

}
