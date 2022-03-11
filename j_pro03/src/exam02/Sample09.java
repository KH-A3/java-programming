package exam02;

import java.util.Scanner;

public class Sample09 {

	public static void main(String[] args) {
		/*
		 * 문자열에서 문자만 추출하는 방법
		 * 		문자열변수명.charAt(위치값)
		 */
		String s = "Hello Java Programming";
		char c = s.charAt(4);
		System.out.println(c);
		
		/*
		 * 문자열의 길이를 알아내는 방법(문자열의 길이는 문자열의 문자 수를 의미)
		 * 		문자열변수명.length()
		 */
		s = "Hello Java Programming";
		int len = s.length();
		System.out.println("문자열의 문자수 : " + len);
		
		/*
		 * 문자열과 문자열 비교하는 방법
		 * 		문자열변수명.equals(문자열)
		 */
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = "문자열";
		
		if(str2.equals(str1)) {
			System.out.println("equals 로 비교한 동일한 문자열 값 입니다.");
		}
		
		if(str2 == str1) {
			System.out.println("== 로 비교한 문자열 값 입니다. 비교 결과 거짓으로 나온다.");
		}
	}

}
