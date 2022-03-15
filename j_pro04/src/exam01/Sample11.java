package exam01;

import java.util.Arrays;
import java.util.Scanner;

public class Sample11 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성
		 * 		1. 입력한 횟수 만큼 정수 값을 입력 받아서 배열에 저장 한다.
		 * 		2. 배열에 저장된 모든 정수의 합과 평균을 구하여 출력
		 * 		3. -1 입력이 들어오면 더 이상 사용자 입력을 받지 않는 것으로 한다.
		 * 
		 * 예제
		 * 		1 번째 정수값 입력 : 7
		 * 		2 번째 정수값 입력 : 12
		 * 		3 번째 정수값 입력 : 24
		 * 		4 번째 정수값 입력 : -1
		 * 
		 * 		총 합 : 43
		 * 		평 균 : 14.3
		 */
		Scanner sc = new Scanner(System.in);
		int tot = 0;
		double avg;
		
		int[] arr1 = new int[0];
		
		int i = 0;
		for(;;) {
			System.out.printf("%d 번째 정수값 입력 : ", i + 1);
			
			int num = 0;
			String other = "";
			if(sc.hasNextInt()) {
				num = sc.nextInt();	sc.nextLine();
			} else {
				other = sc.nextLine();
				if(other.equals("exit")) {
					break;
				} else {
					System.out.println("정수 값 또는 exit 를 입력하세요.");
					continue;
				}
			}
			
			int[] temp = Arrays.copyOf(arr1, arr1.length + 1);
			arr1 = temp;
			
			arr1[i] = num;
			tot += arr1[i];
			i++;
		}
		
		avg = (double)tot / arr1.length;
		System.out.printf("총 합 : %d\n", tot);
		System.out.printf("평 균 : %.1f", avg);
	}

}
