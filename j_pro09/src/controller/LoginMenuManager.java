package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.vo.Account;
import model.vo.Student;
import model.vo.Teacher;

public class LoginMenuManager {

	private TeacherDatabaseManager tDB = new TeacherDatabaseManager();
	private DatabaseManager sDB = new DatabaseManager();
	private Scanner sc = new Scanner(System.in);
	
	public void main() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. 교사용 로그인\n");
		sb.append("2. 학생용 로그인\n");
		sb.append("9. 프로그램 종료\n");
		sb.append(">>> ");
		
		while(true) {
			System.out.print(sb.toString());
			String menuNumber = sc.nextLine();
			switch(menuNumber.charAt(0)) {
				case '1':
					teacherLoginMenu();	break;
				case '2':
					studentLoginMenu();	break;
				case '9':
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
			}
		}
	}

	private void teacherLoginMenu() {
		System.out.print("이름 : ");
		String username = sc.nextLine();
		
		for(int i = 0; i < 3; i++) {
			System.out.print("패스워드 : ");
			String password = sc.nextLine();
			
			Account loginAccount = tDB.login(username, password);
			
			if(loginAccount != null) {
				if(((Teacher)loginAccount).getLoginDate() != null) {
					System.out.println("최근 접속 시간 : " + ((Teacher)loginAccount).getLoginDateFormat());
				} else {
					System.out.println("첫 로그인을 환영합니다.");
				}
				
				((Teacher)loginAccount).setLoginDate(new Date());
				
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
				System.out.println("현재 접속 시간 : " + sFormat.format(new Date()));
				
				MenuManager m = new MenuManager(loginAccount);
				m.main();
				break;
			} else {
				System.out.println("로그인 실패. 패스워드를 다시 입력하세요.");
			}
		}
		
	}

	private void studentLoginMenu() {
		System.out.print("이름 : ");
		String username = sc.nextLine();
		
		for(int i = 0; i < 3; i++) {
			System.out.print("패스워드 : ");
			String password = sc.nextLine();
			
			Account loginAccount = sDB.login(username, password);
			
			if(loginAccount != null) {
				MenuManager m = new MenuManager(loginAccount);
				m.main();
				break;
			} else {
				System.out.println("로그인 실패. 패스워드를 다시 입력하세요.");
			}
		}
	}
	
	
}
