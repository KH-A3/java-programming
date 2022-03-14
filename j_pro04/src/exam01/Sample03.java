package exam01;

public class Sample03 {

	public static void main(String[] args) {
		// 문자열 배열 생성 1
		String[] arr1 = new String[3];
		arr1[0] = "문자열";	arr1[1] = "배열";		arr1[2] = "사용";
		
		// 문자열 배열 생성 2
		String[] arr2 = {"문자열", "배열", "생성"};
		
		for(int i = 0; i < 3; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.print("\n");
		
		// 문자열 배열 생성, 초기화 하지 않음
		String[] arr3 = new String[3];
		
		for(int i = 0; i < 3; i++) {
			System.out.print(arr3[i] + "\t");
			
			// 문자열 배열의 값을 초기화 하지 않으면 문자열 관련 메서드를 사용할 떄 에러 발생
			System.out.println(arr3[i].length());
		}
		System.out.print("\n");
		
		// 정수 배열 생성, 초기화 하지 않음
		int[] arr4 = new int[3];
		
		for(int i = 0; i < 3; i++) {
			System.out.print(arr4[i] + "\t");
		}
		System.out.print("\n");
	}

}
