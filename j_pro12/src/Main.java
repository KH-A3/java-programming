import java.util.Scanner;

import game.Correct;
import game.Fail;
import game.GuessNum;
import game.Result;
import menu.SettingMenu;

public class Main {

	public static void main(String[] args) {
		/*
		 * 업앤다운
		 *     1. 임의로 숫자 하나를 정한다.
		 *     2. 임의로 정해진 숫자를 맞춘다.
		 *         2-1. 정해진 숫자보다 낮은 숫자를 입력하면 -> UP!
		 *         2-2. 정해진 숫자보다 높은 숫자를 입력하면 -> DOWN!
		 *     3. 정해진 숫자를 맞추면 게임 종료
		 *        단, 정해진 횟수 안에서 맞추어야 한다.
		 *        횟수를 초과하면 실패!
		 */
		
		/*
		 *  GuessNum 클래스
		 *      - 생성하면 바로 임의의 숫자를 만든다.
		 *      - 생성할 때 맞출 수 있는 횟수를 제한한다.
		 *      - 임의의 정수값을 전달하면 Up, Down 을 반환한다.
		 *      - 정답을 맞추기 위해 시도를 할 때마다 횟수를 차감한다.
		 *      - 정답을 맞춘 경우 Correct 을 반환한다.
		 *      - 횟수를 초과하여 실패한 경우 Fail을 반환한다.
		 */
		
		// Up 클래스 : 클래스로만 생성하여 쓰도록 한다.
		// Down 클래스 : 클래스로만 생성하여 쓰도록 한다.
		// Fail 클래스 : 클래스로만 생성하여 쓰도록 한다.
		// Correct 클래스 : 클래스로만 생성하여 쓰도록 한다.
		Scanner sc = new Scanner(System.in);
		
		String menu = "";
		menu += "<<<<< UP! & DOWN! >>>>>\n";
		menu += "┌─────────────────────┐\n";
		menu += "│ 1. Game Start       │\n";
		menu += "│ 2. Penalty Setting  │\n";
		menu += "│ 3. Exit             │\n";
		menu += "└─────────────────────┘\n";
		menu += ": ";
		
		while(true) {
			System.out.print(menu);
			String input = sc.nextLine();
			
			switch(input.charAt(0)) {
				case '1':
					System.out.println("게임 시작");
					break;
				case '2':
					System.out.println("벌칙 셋팅 메뉴로 이동합니다.");
					SettingMenu sMenu = new SettingMenu();
					sMenu.show();
					break;
				case '3':
					System.out.println("게임을 종료 합니다.");
					System.exit(0);
				default:
					System.out.println("잘못된 번호를 입력하였습니다. 다시 입력하세요.");
					System.out.println("Enter 키를 누르면 다시 메뉴 화면이 나옵니다.");
					sc.nextLine();
			}
		}
		
		
//		System.out.println("업앤다운 게임입니다.");
//		System.out.println("임의로 생성된 값을 맞추어 보세요.\n기본 생성값은 1 ~ 100 사이의 값 입니다.");
//		while(true) {
//			GuessNum guess = new GuessNum();
//			
//			while(true) {
//				System.out.print(">>> ");
//				int num = sc.nextInt(); sc.nextLine();
//				
//				Result res = guess.guessing(num);
//				System.out.println(res);
//				
//				if(res instanceof Correct || res instanceof Fail) {
//					System.out.println("게임이 종료되었습니다. 새로운 값을 생성합니다.");
//					break;
//				}
//			}
//			
//		}
	}

}
