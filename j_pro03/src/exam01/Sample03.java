package exam01;

import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		/*
		 * 환율 계산 프로그램
		 *		원달러 환율 값 입력 : 1235.00
		 *
		 *		달러를 원화로 계산하겠습니까? 아니면 원화를 달러로 계산하겠습니까?
		 *		(1:달러->원화, 2:원화->달러)
		 *
		 *		달러값 입력 : 100
		 *		100 달러는 123500 원 입니다.
		 *
		 *		원화값 입력 : 100000
		 *		100000 원은 약 80.97 달러 입니다.
		 */
		double rate, sMoney, dMoney;
		int menu;
		String mStr;	String result = "";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원달러 환율 값 입력 : ");
		rate = sc.nextDouble();
		
		System.out.println("달러를 원화로 계산하겠습니까? 아니면 원화를 달러로 계산하겠습니까?");
		System.out.print("(1:달러->원화, 2:원화->달러) -> ");
		menu = sc.nextInt();
		
		mStr = menu == 1 ? "달러" : "원화";
		System.out.print(mStr + "값 입력 : ");
		sMoney = sc.nextDouble();
		
		if(menu == 1) {	// 달러를 원화로 변환
			dMoney = sMoney * rate;
			result = "%,.0f 달러는 %,.0f 원 입니다.";
		} else {	// 원화를 달러로 변환
			dMoney = sMoney / rate;
			result = "%,.0f 원은 약 %,.2f 달러 입니다.";
		}
		
		System.out.printf(result, sMoney, dMoney);
	}

}
