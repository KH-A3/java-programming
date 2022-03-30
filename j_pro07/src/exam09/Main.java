package exam09;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		/*
		 * - 일반 고객 5명을 생성한다.
		 * - 일반 고객 5명을 랜덤으로 선택하여 랜덤한 가격으로 물품 구입하게 한다.
		 * - 물품 누적구입액이 1,000,000 원을 초과하면 프리미엄 고객으로 전환을 시켜서 다음 번
		 *   물품 구입에 할인율이 적용될 수 있게 만든다.
		 * - 고객이 물품을 구입한는 작업을 반복문을 이용하여 작업한다.(반복횟수는 100번)
		 * 
		 * 일반 고객 -> 프리미엄 고객 전환
		 *     NormalCustomer n1 = new NormalCustomer("홍길동", 35, 'M');
		 *     PremiumCustomer p1 = new PremiumCustomer(n1.getName(), n1.getAge(), n1.getGender());
		 */
		
		Random rand = new Random();
		Customer[] cArr = new Customer[5];
		
		cArr[0] = new NormalCustomer("홍길동", 35, 'M');
		cArr[1] = new NormalCustomer("고길동", 35, 'M');
		cArr[2] = new NormalCustomer("강조석", 25, 'M');
		cArr[3] = new NormalCustomer("최조한", 38, 'M');
		cArr[4] = new NormalCustomer("라주성", 29, 'M');
		
		for(int i = 0; i < 100; i++) {
			int idx = rand.nextInt(cArr.length);
			cArr[idx].buy("xxxxxx", (int)(rand.nextInt(500000) + 10000) / 10000 * 10000);
			
			if(cArr[idx] instanceof NormalCustomer) {
				if(cArr[idx].getPriceTotal() > 1000000) {
					PremiumCustomer p = new PremiumCustomer(cArr[idx].getName(), cArr[idx].getAge(), cArr[idx].getGender());
					p.setPriceTotal(cArr[idx].getPriceTotal());
					cArr[idx] = p;
					System.out.printf("%s님의 등급이 프리미엄 등급으로 상향되었습니다.\n", cArr[idx].getName());
					System.out.printf("현재 적용된 할인율은 %.2f 입니다.", ((PremiumCustomer) cArr[idx]).getDiscount());
				}
			}
		}
		
	}

}
