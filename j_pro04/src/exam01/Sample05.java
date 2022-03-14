package exam01;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 * 카이사르 암호 만들기.
		 * 		- 사용자 입력으로 영단어를 입력 받는다.
		 * 		- 입력받은 영단어는 문자 배열로 생성한다.
		 * 		- 생성된 문자 배열에 대해 암호화된 배열을 저장하기 위한 배열을 새로 만든다.
		 * 		- 문자 쉬프트는 3으로 하고 만약 'z' 문자에 대한 쉬프트가 필요한 경우 'a' 로 넘어가게 해야 한다.
		 * 
		 * 출력 형식
		 * 		암호화 전 : apple
		 * 		암호화 후 : dssoh
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영단어 입력 : ");
		String sInput = sc.nextLine();
		
		// 문자열을 문자 배열로 변환
		char[] origin = sInput.toCharArray();
		// char[] origin = new char[sInput.length()];
		// for(int i = 0; i < sInput.length(); i++) {
		// 	origin[i] = sInput.charAt(i);
		// }
		
		char[] crypto = new char[origin.length];
		for(int i = 0; i < origin.length; i++) {
			if(origin[i] + 3 > 'z') {
				crypto[i] = (char)(origin[i] + 3 - 26);
			} else {
				crypto[i] = (char)(origin[i] + 3);
			}
		}
		
		String res1 = new String(origin);
		String res2 = new String(crypto);
		
		// for(int i = 0; i < sInput.length(); i++) {
		// 	res1 += origin[i];
		// 	res2 += crypto[i];
		// }
		
		System.out.println("암호화 전 : " + res1);
		System.out.println("암호화 후 : " + res2);
	}

}
