package exam01;

import java.util.Scanner;

public class Sample07 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성
		 * 		1. 사용자 입력을 사용 할 횟수를 먼저 입력 받는다.
		 * 		2. 입력한 횟수 만큼 정수 값을 입력 받아서 배열에 저장 한다.
		 * 		3. 배열에 저장된 모든 정수의 합과 평균을 구하여 출력
		 * 
		 * 예제
		 * 		총 입력 횟수 : 3
		 * 		1 번째 정수값 입력 : 7
		 * 		2 번째 정수값 입력 : 12
		 * 		3 번째 정수값 입력 : 24
		 * 
		 * 		총 합 : 43
		 * 		평 균 : 14.3
		 */
		Scanner sc = new Scanner(System.in);
		double avg;
		
		System.out.print("총 입력 횟수 : ");
		int count = sc.nextInt();
		
		int[] arr1 = new int[count + 1];
		
		for(int i = 0; i < arr1.length - 1; i++) {
			System.out.printf("%d 번째 정수값 입력 : ", i + 1);
			arr1[i] = sc.nextInt();
			arr1[arr1.length - 1] += arr1[i];
		}
		
		avg = (double)arr1[arr1.length - 1] / arr1.length;
		System.out.printf("총 합 : %d\n", arr1[arr1.length - 1]);
		System.out.printf("평 균 : %.1f", avg);
	}

}
