package exam02;

import java.util.Arrays;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 2차 배열
		 * 		- 배열 안에 배열을 만들어서 사용하는 형태
		 * 		- 표(테이블) 형식의 데이터를 사용할 때 많이 사용됨.
		 */
		int[][] arr1 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		// arr1[0][0] = 1;	arr1[0][1] = 2; arr1[0][2] = 3;
		// arr1[1][0] = 4;	arr1[2][1] = 5; arr1[1][2] = 6;
		// arr1[2][0] = 7;	arr1[1][1] = 8; arr1[2][2] = 9;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {				
				System.out.print(arr1[i][j] + "\t");
			}
			System.out.print("\n");
		}
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.println(Arrays.toString(arr1[i]));
		}
		
		
		int[][] arr2 = new int[3][];
		arr2[0] = new int[4];
		arr2[1] = new int[4];
		arr2[2] = new int[4];
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(Arrays.toString(arr2[i]));
		}
		
		
		// 가변 길이 2차 배열
		int[][] arr3 = new int[3][];
		arr3[0] = new int[5];
		arr3[1] = new int[3];
		arr3[2] = new int[7];
		
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(Arrays.toString(arr3[i]));
		}
		
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < arr3[i].length; j++) {
				System.out.print(arr3[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

}
