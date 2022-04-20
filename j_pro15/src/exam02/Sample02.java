package exam02;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.Random;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * 로또 번호 생성
		 *     - 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
		 *     - 중복된 값 없이 리스트에 담도록 한다.
		 *     - 총 6개의 정수값을 리스트에 저장 한다.
		 *     - 마지막에 출력 할 때는 오름차순으로 정렬하여 출력되도록 한다.(Set 을 List 바꾸어서 출력.)
		 */
		Set<Integer> lotto = new HashSet<Integer>();
		Random rand = new Random();
		
		for(int i = 0; i < 6;) {
			int r = rand.nextInt(45) + 1;
			if(lotto.add(Integer.valueOf(r))) {
				i++;
			}
		}
		List<Integer> sortLotto = new ArrayList<Integer>(lotto);
		Collections.sort(sortLotto);
		System.out.println(sortLotto);
	}

}
