package exam01;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * 		- 프로그램 코드의 실행을 제어하기 위한 제어문 중 하나이다.
		 * 		- 조건에 따라 코드를 실행하거나 실행하지 않게 제어를 한다.
		 * 		  (true:실행, false:실행하지 않고 다음 코드로 진행)
		 * 		- 조건문의 종류는 if 문, switch 문이 있다.
		 */
		
		/*
		 * if 문
		 * 		if(조건식) {
		 * 			조건식의 결과가 참일 때 실행할 코드는 여기에 작성한다.
		 * 		}
		 */
		int num1 = 9;
		
		if(num1 > 10) {
			System.out.println("num1에 저장된 값은 10 보다 큽니다.");
		}
		
		/*
		 * if ... else
		 * 		if(조건식) {
		 * 			조건식의 결과가 참일 때 실행할 코드는 여기에 작성한다.
		 * 		} else {
		 * 			조건식의 결과가 거짓일 때 실행할 코드는 여기에 작성한다.
		 * 		}
		 */
		int num2 = 8;
		
		if(num2 % 2 == 0) {
			System.out.println("num2의 값은 짝수입니다.");
		} else {
			System.out.println("num2의 값은 홀수입니다.");
		}
		
		/*
		 * if ... else if
		 * 		if(조건식1) {
		 * 			조건식1의 결과가 참일 때 실행할 코드는 여기에 작성한다.
		 * 		} else if(조건식2) {
		 * 			조건식1의 결과가 거짓이고 대신 조건식2의 결과가 참일 때 실행할 코드는 여기에 작성한다.
		 * 		} else if(조건식3) {
		 * 			조건식2의 결과가 거짓이고 대신 조건신3의 결과가 참일 때 실행할 코드는 여기에 작성한다.
		 * 		} else {
		 * 			모든 조건식의 결과가 거짓일 때 실행할 코드를 여기에 작성한다.(옵션)
		 * 		}
		 */
		int num3 = 48;
		
		if(num3 <= 39) {
			System.out.println("과락입니다.");
		} else if(num3 <= 59) {
			System.out.println("E 등급입니다.");
		} else if(num3 <= 69) {
			System.out.println("D 등급입니다.");
		} else if(num3 <= 79) {
			System.out.println("C 등급입니다.");
		} else if(num3 <= 89) {
			System.out.println("B 등급입니다.");
		} else {
			System.out.println("A 등급입니다.");
		}
		
		/*
		 * 중첩 if 문
		 * 		- 문장 안에 또 다른 문장이 중첩되어 작성되는 형태
		 * 		- 중첩은 원하는 만큼 반복하여 중첩시킬 수 있다.
		 * 
		 * 		if(조건식1) {
		 * 			if(조건식2) {
		 * 				...
		 * 			} else {
		 * 				if(조건식3) {
		 * 					...
		 * 				}
		 * 			}
		 * 		}
		 */
		
		num3 = 100;
		
		if(num3 <= 39) {
			System.out.println("과락입니다.");
		} else if(num3 <= 59) {
			System.out.println("E 등급입니다.");
		} else if(num3 <= 69) {
			System.out.println("D 등급입니다.");
		} else if(num3 <= 79) {
			System.out.println("C 등급입니다.");
		} else if(num3 <= 89) {
			System.out.println("B 등급입니다.");
		} else {
			if(num3 == 100) {
				System.out.println("만점입니다.");
			} else {
				System.out.println("A 등급입니다.");
			}
		}
		
	}

}
