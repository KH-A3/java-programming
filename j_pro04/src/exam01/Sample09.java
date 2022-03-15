package exam01;

import java.util.Random;

public class Sample09 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 5 인 정수 배열을 생성하고 해당 배열에 1 ~ 19 까지의
		 * 정수 값을 임의로 생성하여 초기화 하는 작업을 수행하도록한다.
		 * 단, 배열에 초기화된 값은 중복되어서는 안된다.
		 */
		Random rand = new Random();
		int[] arr1 = new int[5];
		boolean duplicate;
		
		for(int i = 0; i < arr1.length;) {
			int num = rand.nextInt(19) + 1;
			duplicate = false;
			
			for(int j = 0; j < i; j++) {
				if(arr1[j] == num) {
					duplicate = true;
					break;
				}
			}
			
			if(!duplicate) {
				arr1[i] = num;
				System.out.print(arr1[i] + "\t");
				i++;
			}
			
		}
		
		System.out.print("\n");
		
	}

}
