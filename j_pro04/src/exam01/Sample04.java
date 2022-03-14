package exam01;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * 변수에 저장된 값을 복사하여 사용
		 */
		int n1 = 10;
		int n2 = n1;	// n1에 저장된 값을 n2에 복사
		
		System.out.printf("n1 -> %d, n2 -> %d\n", n1, n2);
		
		n1 = 15;
		n2 = 100;
		System.out.printf("n1 -> %d, n2 -> %d\n", n1, n2);
		
		/*
		 * 배열 복사 -> 얕은 복사
		 */
		int[] arr1 = new int[] {1, 2, 3, 4, 5};
		int[] arr2 = arr1;
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("arr1[%d] -> %d, arr2[%d] -> %d\n", i, arr1[i], i, arr2[i]);
		}
		
		arr1[0] = 15;
		arr2[1] = 100;
		for(int i = 0; i < 5; i++) {
			System.out.printf("arr1[%d] -> %d, arr2[%d] -> %d\n", i, arr1[i], i, arr2[i]);
		}
		
		/*
		 * 배열 복사 -> 깊은 복사
		 */
		int[] arr3 = new int[] {1, 2, 3, 4, 5};
		int[] arr4 = new int[5];
		
		// 배열을 복사하는 것이 아닌 배열에 저장된 값을 복사한다.
		for(int i = 0; i < 5; i++) {
			arr4[i] = arr3[i];
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("arr3[%d] -> %d, arr4[%d] -> %d\n", i, arr3[i], i, arr4[i]);
		}
		
		arr3[0] = 15;
		arr4[1] = 100;
		for(int i = 0; i < 5; i++) {
			System.out.printf("arr3[%d] -> %d, arr4[%d] -> %d\n", i, arr3[i], i, arr4[i]);
		}
	}

}
