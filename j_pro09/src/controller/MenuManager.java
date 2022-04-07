package controller;

import java.util.Scanner;

import model.vo.Account;
import model.vo.Grade;
import model.vo.Student;
import model.vo.Teacher;

public class MenuManager {
	
	private Scanner sc = new Scanner(System.in);
	private DatabaseManager db = new DatabaseManager();
	private Account loginAccount;
	
	public MenuManager(Account loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public void main() {
		if(loginAccount instanceof Teacher) {
			teacherMenuList();
		} else {
			studentMenuList();
		}
	}
	
	public void teacherMenuList() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. 성적 조회\n");
		sb.append("2. 학생 정보 추가\n");
		sb.append("3. 성적 정보 수정\n");
		sb.append("4. 학생 정보 삭제\n");
		sb.append("5. 패스워드 변경\n");
		sb.append("9. 로그아웃\n");
		sb.append(">>> ");
		
		boolean logout = false;
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
				case 5:
					passwordChangeMenu();	break;
				case 9:
					logout = true;
			}
			if(logout) {
				break;
			}
		}
	}
	
	public void studentMenuList() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. 성적 조회\n");
		sb.append("2. 패스워드 변경\n");
		sb.append("9. 로그아웃\n");
		sb.append(">>> ");
		
		boolean logout = false;
		while(true) {
			System.out.print(sb.toString());
			int menuNumber = Integer.parseInt(sc.nextLine());
			
			switch(menuNumber) {
				case 1:
					printGrades(
							((Student)loginAccount).getName(),
							((Student)loginAccount).getGrades()
					);
					break;
				case 2:
					passwordChangeMenu();	break;
				case 9:
					logout = true;
			}
			
			if(logout) {
				break;
			}
		}
	}
	
	public void passwordChangeMenu() {
		System.out.print("현재 패스워드 : ");
		String curPass = sc.nextLine();
		
		System.out.print("변경 패스워드 : ");
		String changePass = sc.nextLine();
		
		boolean result = loginAccount.changePassword(curPass, changePass);
		
		if(result) {
			System.out.println("패스워드 변경이 완료되었습니다.");
		} else {
			System.out.println("패스워드 변경에 실패하였습니다. 현재 패스워드를 다시 확인하세요.");
		}
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
			String name;
			Grade[] grades = new Grade[0];
			while(true) {
				System.out.print("학생 이름 : ");
				name = sc.nextLine();
				grades = db.search(name);
				if(grades == null) {
					System.out.println("해당 학생 정보가 존재하지 않습니다. 다시 입력하세요.");
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append("--------------------\n");
					for(int i = 0; i < grades.length; i++) {
						sb.append(grades[i].getName() + "\t");
					}
					sb.append("\n--------------------\n");
					
					System.out.println(sb.toString());
					break;
				}
			}
			
			System.out.print("점수 : ");
			String[] inputArr = sc.nextLine().split(" ");
			int[] scoreArr = new int[grades.length];
			
			for(int i = 0; i < grades.length; i++) {
				scoreArr[i] = Integer.parseInt(inputArr[i]);
				Student result = db.modify(name, grades[i].getName(), scoreArr[i]);
				if(result != null) {
					System.out.printf("%s 과목의 점수를 수정 하였습니다.\n", grades[i].getName());
				} else {
					System.out.println("수정 작업에 문제가 발생하였습니다.");
				}
			}
			break;
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
				printGrades(name, grades);
				break;
			}
		}
	}
	
	public void printGrades(String name, Grade[] grades) {
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
	}
}
