import java.util.Scanner;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.player.ComPlayer;
import game.player.UserPlayer;

public class Main {

	public static void main(String[] args) {
		/*
		 * 가위, 바위, 보 게임을 클래스, 상속, 다형성, 인터페이스
		 * 예외처리 등을 사용하여 구현.
		 *     - 컴퓨터와 플레이어(사용자) 간의 가위, 바위, 보 게임
		 *     - 컴퓨터와 사용자 모두 cheat 기능을 사용할 수 있다.
		 *       단, 연속 3번을 졌을 경우에만 1번 사용할 수 있는 기회를 누적한다.
		 *     - 모든 승, 패, 무 기록을 Record 클래스에 기록한다.(컴퓨터, 사용자 모두)
		 *     - 게임은 사용자가 종료하기 원할 때 까지 계속 진행하도록 한다.
		 *     - 매 대결이 진행될 때마다 승, 패, 무 결과와 승률을 출력한다.(컴퓨터, 사용자 모두)
		 *     - 기본 제공하는 메서드와 클래스 외에 추가로 만들 기능이 있으면 더 추가하여도 된다.
		 */
		Scanner sc = new Scanner(System.in);
		UserPlayer uPlay = new UserPlayer();
		ComPlayer cPlay = new ComPlayer();
		Hand uHand, cHand;
		String uRes, cRes;
		
		System.out.println("가위 바위 보 게임을 진행합니다.");
		System.out.println("가위 바위 보 중 하나를 입력하세요.");
		System.out.println("입력하지 않고 Enter 키를 누른 경우 랜덤으로 생성합니다.");
		
		while(true) {
			System.out.print("가위/바위/보 >>> ");
			String userInput = sc.nextLine();
			
			uPlay.setHand(userInput);
			cPlay.randomCardHand();
			
			uRes = uPlay.versus(cPlay.getHand());
			cRes = cPlay.versus(uPlay.getHand());
			
			System.out.println("플레이어 " + uRes);
			System.out.println("컴퓨터 " + cRes);
			
			System.out.println("플레이어 치트 횟수 : " + uPlay.getCheatCnt());
			System.out.println("컴퓨터 치트 횟수 : " + cPlay.getCheatCnt());
			
			System.out.println(uPlay.getTotalRecord());
		}
	}

}
