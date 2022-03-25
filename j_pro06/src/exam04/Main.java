package exam04;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Grade 에는 과목에 대한 성적 정보가 있는 객체
		 * 
		 * GradeList 에는 Grade 를 배열로 관리하는 객체
		 * 		- 과목에 대한 성적 관리를 위해 Grade 객체를 추가/수정/삭제/조회
		 *        할 수 있는 기능을 만든다.
		 *      - 가능하면 가장 높은 점수를 가지는 과목으로 정렬 할 수 있는 기능을
		 *        만든다. 
		 */
		GradeList datas = new GradeList();
		datas.add("영어", 56);
		datas.add("국어", 37);
		datas.add("수학", 67);
		datas.add("과학", 39);
		
		System.out.println(Arrays.toString(datas.getUnder()));
		System.out.println(Arrays.toString(datas.getUnder(60)));
		System.out.println(datas.getTop());
		System.out.println(Arrays.toString(datas.getTop(2)));
		System.out.println(datas.getBottom());
		System.out.println(Arrays.toString(datas.getBottom(2)));
		datas.sort(false);
		
		for(int i = 0; i < datas.length(); i++) {
			System.out.println(datas.getName(i) + ":" + datas.getScore(i));
		}
		
		Scanner sc = new Scanner(System.in);
		GradeList gList = new GradeList();
		
		while(true) {
			do {
				System.out.println("1. 조회");
				System.out.println("2. 추가");
				System.out.println("3. 수정");
				System.out.println("4. 삭제");
				System.out.println("9. 종료");
				System.out.print(": ");
			} while(!sc.hasNextInt());
			
			int menu = sc.nextInt();	sc.nextLine();
			
			switch(menu) {
				case 1:
					System.out.println("조회 기능 수행");
					break;
				case 2:
					System.out.println("추가 기능 수행");
					break;
				case 3:
					System.out.println("수정 기능 수행");
					break;
				case 4:
					System.out.println("삭제 기능 수행");
					break;
				case 9:
					System.out.println("프로그램 종료");
					System.exit(0);
			}
			System.out.println("\n\n\n\n\n");
		}
	}

}
