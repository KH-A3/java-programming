package exam04;

public class Sample03 {

	public static void main(String[] args) {
		/*
		 * 복합 대입 연산
		 * 		대입(할당) 연산자와 산술연산이 결합되어 사용되는 연산자
		 * 		산술연산을 수행 후 대입 연산이 수행하는 형태로 실행된다.
		 */
		int num1 = 1;
		
		num1 += 1;	// num1 = num1 + 1;
		System.out.println(num1);
		
		num1 += 2;	// num1 = num1 + 2;
		System.out.println(num1);
		
		num1 -= 3;	// num1 = num1 - 3;
		System.out.println(num1);
		
		num1 *= 4;	// num1 = num1 * 4;
		System.out.println(num1);
		
		num1 /= 2;	// num1 = num1 / 2;
		System.out.println(num1);
		
		num1 %= 2;	// num1 = num1 % 2;
		System.out.println(num1);
		
		/*
		 * 삼항 연산
		 * 		조건식 ? 식1 : 식2;
		 * 
		 * 조건식 : true, false 가 나올 수 있는 식을 작성해야 한다.
		 * 식1 : 조건식의 결과가 참(true)일 때 수행할 식을 작성 한다.
		 * 식2 : 조건식의 결과가 거짓(false)일 때 수행할 식을 작성 한다.
		 */
		int age = 21;
		
		String result = age >= 20 ? "성인 입니다." : "미성년자 입니다.";

		System.out.println(result);
		
		int num2 = 15;
		
		result = num2 % 2 == 0 ? "짝수" : "홀수";
		
		System.out.printf("%d 는 %s 입니다.", num2, result);
	}

}
