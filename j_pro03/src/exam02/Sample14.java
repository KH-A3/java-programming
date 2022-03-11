package exam02;

import java.util.Scanner;
import java.util.Random;

public class Sample14 {

	public static void main(String[] args) {
		/*
		 * 12자의 시리얼 넘버를 생성하시오.(시리얼 넘버는 'A' ~ 'Z' 사이의 문자로만 이루어져 있는 것으로 한다.)
		 * 사용자 입력을 통해 생성할 시리얼 넘버의 수량을 파악하고 해당 수만큼 출력한다.
		 * 그리고 시리얼 번호의 출력 형식은 다음과 같다.
		 * 		"LFLH-BQJN-XCUG"
		 */
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		String serial = "";
		char start = 'A';	char end = 'Z';
		
		int count = 0;
		
		System.out.print("시리얼 번호 생성 갯수 : ");
		count = sc.nextInt();
		
		for(int j = 1; j <= count; j++) {
			for(int i = 0; i < 12; i++) {
				char c = (char)(random.nextInt(end - start + 1) + start);
				serial += c;
				if(i % 4 == 3 && i != 11) {
					serial += "-";
				}
			}
			System.out.println(serial);
			serial = "";
		}
	}

}
