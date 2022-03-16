package exam03;

import java.util.Arrays;
import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 1. 배열의 크기가 10 인 정수 배열을 2개 생성 후 각 배열에 10 ~ 99 사이의 난수값으로
		 *    초기화 시키고 출력한다.
		 */
		Random rand = new Random();
		
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		
		for(int i = 0; i < arr1.length; i++) {
			int num = rand.nextInt(90) + 10;
			arr1[i] = num;
			
			num = rand.nextInt(90) + 10;
			arr2[i] = num;
		}
		
		System.out.println("1. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr1));
		System.out.println("\t" + Arrays.toString(arr2));
		
		/*
		 * 2. 1번 문제에서 생성한 첫번째 배열과 두번째 배열의 합을 구하여 새로운 세번째 배열을 만들고
		 *    출력한다.
		 */
		int[] arr3 = arr1.clone();
		
		for(int i = 0; i < arr3.length; i++) {
			arr3[i] += arr2[i];
		}
		
		System.out.println("2. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr3));
		
		/*
		 * 3. 2번 문제까지 진행하여 만들어진 3개의 배열을 이용하여 짝수값만 저장되어 있는 배열과 홀수값만 저장
		 *    되어 있는 배열을 만들고 짝수 배열과 홀수 배열을 출력한다.
		 */
		
		// 첫번째 방법
		/*
		int[] arr4 = new int[30];
		int[] arr5 = new int[30];
		int idx1 = 0, idx2 = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 == 0) {
				arr4[idx1] = arr1[i];
				idx1++;
			} else {
				arr5[idx2] = arr1[i];
				idx2++;
			}
		}
		
		for(int i = 0; i < arr2.length; i++) {
			if(arr2[i] % 2 == 0) {
				arr4[idx1] = arr2[i];
				idx1++;
			} else {
				arr5[idx2] = arr2[i];
				idx2++;
			}
		}
		
		for(int i = 0; i < arr3.length; i++) {
			if(arr3[i] % 2 == 0) {
				arr4[idx1] = arr3[i];
				idx1++;
			} else {
				arr5[idx2] = arr3[i];
				idx2++;
			}
		}
		
		arr4 = Arrays.copyOf(arr4, idx1);
		arr5 = Arrays.copyOf(arr5, idx2);
		*/
		
		// 두번째 방법
		/*
		int[] arr4;
		int[] arr5;
		int cnt1 = 0, cnt2 = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
			
			if(arr2[i] % 2 == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
			
			if(arr3[i] % 2 == 0) {
				cnt1++;
			} else {
				cnt2++;
			}
		}
		
		arr4 = new int[cnt1];
		arr5 = new int[cnt2];
		int idx1 = 0, idx2 = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] % 2 == 0) {
				arr4[idx1] = arr1[i];
				idx1++;
			} else {
				arr5[idx2] = arr1[i];
				idx2++;
			}
			
			if(arr2[i] % 2 == 0) {
				arr4[idx1] = arr2[i];
				idx1++;
			} else {
				arr5[idx2] = arr2[i];
				idx2++;
			}
			
			if(arr3[i] % 2 == 0) {
				arr4[idx1] = arr3[i];
				idx1++;
			} else {
				arr5[idx2] = arr3[i];
				idx2++;
			}
		}
		*/
		
		System.out.println("3. 출력 결과");
		System.out.println("\t" + Arrays.toString(arr4));
		System.out.println("\t" + Arrays.toString(arr5));
	}

}
