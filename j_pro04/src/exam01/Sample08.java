package exam01;

import java.util.Scanner;

public class Sample08 {

	public static void main(String[] args) {
		/*
		 * 사용자가 입력한 영문자열에서 입력된 문자의 수를 구하는 코드를 작성
		 * 		1. 영문자를 제외한 다른 문자는 무시한다.
		 * 		2. 영문자의 대/소문자를 구분하지 않고 문자 수를 구한다.
		 * 
		 * 예제
		 * 		영문자 입력 : hello java programming
		 * 
		 * 		입력한 영문자 분포
		 * 		a(3), e(1), g(2), h(1), i(1),
		 *      j(1), l(2), m(2), n(1), o(2),
		 *      p(1), r(2), v(1)
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영문자 입력 : ");
		String data = sc.nextLine();
		
		// 알파벳 사용 횟수를 저장하기 위한 배열
		// 0:a, 1:b, 2:c, .... 25:z
		int[] cArr = new int[26];
		
		for(int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			
			if((c >= 'A' && c <= 'Z')) {
				cArr[c - 'A'] += 1;
			} else if((c >= 'a' && c <= 'z')) {
				cArr[c - 'a'] += 1;
			}
			
		}
		
		for(int i = 0; i < cArr.length; i++) {
			if(cArr[i] > 0) {
				System.out.printf("%c(%d)\t", (char)(i + 97), cArr[i]);
			}
		}
	}

}
