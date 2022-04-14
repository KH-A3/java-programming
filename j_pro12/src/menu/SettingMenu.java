package menu;

import java.util.Scanner;

import db.PenaltyDatabase;

public class SettingMenu {

	private Scanner sc = new Scanner(System.in);
	
	public void show() {
		String menu = "";
		menu += "<<<<< Penalty Setting >>>>>\n";
		menu += "┌─────────────────────────┐\n";
		menu += "│ 1. Penalty Add          │\n";
		menu += "│ 2. Penalty Modify       │\n";
		menu += "│ 3. Penalty Remove       │\n";
		menu += "│ 4. Back                 │\n";
		menu += "└─────────────────────────┘\n";
		menu += ": ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			switch(input.charAt(0)) {
				case '1':
					addMenu();
					break;
				case '2':
					modifyMenu();
					break;
				case '3':
					removeMenu();
					break;
				case '4':
					return;
			}
		}
	}

	private void addMenu() {
		String menu = "";
		menu += "추가할 벌칙을 입력하세요. 입력을 중단하려면 exit 를 입력하세요.\n";
		menu += ": ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			if(input.equals("exit")) {
				System.out.println("추가 작업을 중단 합니다.");
				break;
			}
			
			PenaltyDatabase pDB = new PenaltyDatabase();
			pDB.add(input);
			System.out.println("입력한 벌칙을 추가하였습니다.");
		}
	}

	private void modifyMenu() {
		String menu = penaltyListUp() + "\n";
		menu += "수정할 벌칙을 다음 항목에 맞추어 입력하세요. 입력을 중단하려면 exit 를 입력하세요.\n";
		menu += "수정 할 벌칙의 번호 : ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			if(input.equals("exit")) {
				System.out.println("추가 작업을 중단 합니다.");
				break;
			}
			
			int number = Integer.parseInt(input);
			
			System.out.print("벌칙 입력 : ");
			input = sc.nextLine();
			
			PenaltyDatabase pDB = new PenaltyDatabase();
			pDB.modify(number, input);
			System.out.println("벌칙을 수정하였습니다.");
		}
	}

	private void removeMenu() {
		String menu = penaltyListUp() + "\n";
		menu += "삭제할 벌칙 번호를 입력하세요. 입력을 중단하려면 exit 를 입력하세요.\n";
		menu += "삭제 할 벌칙의 번호 : ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			if(input.equals("exit")) {
				System.out.println("추가 작업을 중단 합니다.");
				break;
			}
			
			int number = Integer.parseInt(input);
			
			PenaltyDatabase pDB = new PenaltyDatabase();
			pDB.remove(number);
			System.out.println("벌칙을 삭제하였습니다.");
		}
	}
	
	private String penaltyListUp() {
		PenaltyDatabase pDB = new PenaltyDatabase();
		String data = pDB.load();
		String[] listUp = data.split("\n");
		
		String res = "";
		for(int i = 0; i < listUp.length; i++) {
			res += String.format("%d. %s\n", i+1, listUp[i]);
		}
		return res;
	}

}
