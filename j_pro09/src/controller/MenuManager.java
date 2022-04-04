package controller;

public class MenuManager {
	public void main() {
		String menu = "";
		menu += "1. 성적 조회\n";
		menu += "2. 학생 정보 추가\n";
		menu += "3. 성적 정보 수정\n";
		menu += "4. 학생 정보 삭제\n";
		menu += "9. 프로그램 종료\n";
		menu += ">>>";
		System.out.print(menu);
		
		/*
		 * 사용자 입력을 받아서 위의 메뉴에 해당하는 번호를 입력하면 다음의 메서드를 동작
		 *     - 성적 조회 : searchMenu();
		 *     - 학생 정보 추가 : studentAddMenu();
		 *     - 성적 정보 수정 : subjectModifyMenu();
		 *     - 학생 정보 삭제 : studentDeleteMenu();
		 *     - 프로그램 종료 : System.exit(0); <- 이 코드를 그대로 사용하면 프로그램이 종료 됨.
		 */
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
	}
}
