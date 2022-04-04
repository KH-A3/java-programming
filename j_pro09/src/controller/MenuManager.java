package controller;

import java.util.Scanner;

import model.vo.Grade;
import model.vo.Student;

public class MenuManager {
	
	private Scanner sc = new Scanner(System.in);
	private DatabaseManager db = new DatabaseManager();
	
	public void main() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. 성적 조회\n");
		sb.append("2. 학생 정보 추가\n");
		sb.append("3. 성적 정보 수정\n");
		sb.append("4. 학생 정보 삭제\n");
		sb.append("9. 프로그램 종료\n");
		sb.append(">>> ");
		
		while(true) {
			System.out.print(sb.toString());
			int menuNumber = Integer.parseInt(sc.nextLine());
			
			switch(menuNumber) {
				case 1:
					searchMenu();	break;
				case 2:
					studentAddMenu();	break;
				case 3:
					subjectModifyMenu();	break;
				case 4:
					studentDeleteMenu();	break;
				case 9:
					System.exit(0);
			}
		}
		
		/*
		 * 사용자 입력을 받아서 위의 메뉴에 해당하는 번호를 입력하면 다음의 메서드를 동작
		 *     - 성적 조회 : searchMenu();
		 *     - 학생 정보 추가 : studentAddMenu();
		 *     - 성적 정보 수정 : subjectModifyMenu();
		 *     - 학생 정보 삭제 : studentDeleteMenu();
		 *     - 프로그램 종료 : System.exit(0); <- 이 코드를 그대로 사용하면 프로그램이 종료 됨.
		 */
	}
	
	public void studentDeleteMenu() {
		while(true) {
			System.out.print("삭제 할 학생의 이름 : ");
			String name = sc.nextLine();
			boolean result = db.remove(name);
			if(result) {
				System.out.println("삭제 작업이 완료되었습니다.");
				break;
			} else {
				System.out.println("삭제할 학생 정보가 존재하지 않습니다. 다른 이름을 입력하세요.");
			}
		}
	}

	public void subjectModifyMenu() {
		while(true) {
			System.out.print("학생명 : ");
			String name = sc.nextLine();
			
			System.out.print("과목명 : ");
			String subject = sc.nextLine();
			
			System.out.print("점수 : ");
			int score = Integer.parseInt(sc.nextLine());
			
			Student result = db.modify(name, subject, score);
			if(result != null) {
				System.out.println("수정 작업이 완료되었습니다.");
				break;
			} else {
				System.out.println("학생명, 과목명이 잘못입력하였습니다. 다시 확인하세요.");
			}
		}
	}

	public void studentAddMenu() {
		while(true) {
			System.out.print("추가 할 학생의 이름 : ");
			String name = sc.nextLine();
			boolean result = db.add(name);
			if(result) {
				System.out.println("추가 작업이 완료되었습니다.");
				break;
			} else {
				System.out.println("중복된 이름이 존재합니다. 다른 학생을 추가하세요.");
			}
		}
	}

	public void searchMenu() {
		/*
		 * DatabaseManager 클래스의 search 메서드를 사용하여 성적 정보가 출력될 수 있게 한다.
		 * 
		 * --------------------
		 * 이름 : 홍길동
		 * --------------------
		 * 국어    영어    수학    과학
		 * xx점    xx점    xx점    xx점
		 * x등급   x등급   x등급   x등급
		 * --------------------
		 * 평균 : xx.xx 점
		 * --------------------
		 */
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			Grade[] grades = db.search(name);
			if(grades == null) {
				System.out.println("해당 학생 정보가 존재하지 않습니다. 다시 입력하세요.");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("이름 : " + name + "\n");
				sb.append("--------------------\n");
				for(int i = 0; i < grades.length; i++) {
					sb.append(grades[i].getName() + "\t");
				}
				sb.append("\n");
				double avg = 0;
				for(int i = 0; i < grades.length; i++) {
					sb.append(grades[i].getScore() + "점\t");
					avg += grades[i].getScore();
				}
				avg /= grades.length;
				sb.append("\n");
				for(int i = 0; i < grades.length; i++) {
					sb.append(grades[i].getLevel() + "등급\t");
				}
				sb.append("\n");
				sb.append("--------------------\n");
				sb.append("평균 : " + avg + "\n");
				sb.append("--------------------\n");
				
				System.out.println(sb.toString());
				break;
			}
		}
	}
}
