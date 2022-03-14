package exam02;

import java.util.Scanner;
import java.util.Random;

public class Sample15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		String name = "", player = "", sCom = "";
		int computer = 0;
		int result = 0;
		
		System.out.print("당신의 이름을 입력하세요. : ");
		name = sc.nextLine();
		
		for(;;) {
			System.out.print("가위 바위 보 입력 : ");
			player = sc.nextLine();
			computer = rd.nextInt(3);	// 0(가위), 1(바위), 2(보)
			
			if(computer == 0) {
				sCom = "가위";
			} else if(computer == 1) {
				sCom = "바위";
			} else if(computer == 2) {
				sCom = "보";
			}
			
			if(player.equals("exit")) {
				break;
			} else if(player.equals("가위") || player.equals("바위") || player.equals("보")) {
				System.out.println("컴퓨터 : " + sCom);
				System.out.println(name + " : " + player);
				if(player.equals("가위")) {
					if(computer == 0) {
						result = 0;
					} else if(computer == 1) {
						result = -1;
					} else if(computer == 2) {
						result = 1;
					}
				} else if(player.equals("바위")) {
					if(computer == 0) {
						result = 1;
					} else if(computer == 1) {
						result = 0;
					} else if(computer == 2) {
						result = -1;
					}
				} else if(player.equals("보")) {
					if(computer == 0) {
						result = -1;
					} else if(computer == 1) {
						result = 1;
					} else if(computer == 2) {
						result = 0;
					}
				}
				
				switch(result) {
					case -1:
						System.out.println("졌습니다.");	break;
					case 0:
						System.out.println("비겼습니다.");	break;
					case 1:
						System.out.println("이겼습니다.");
				}
			} else {
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
			}
			
			
		}
	}

}
