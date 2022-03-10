package exam02;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * 		- 프로그램 코드의 실행을 제어하기 위해 사용하는 문법
		 * 		- 반복문은 for, while, do ... while 이 있다.
		 * 		- 반복문은 기본적으로 조건식의 결과에 따라 반복을 진행하느냐 진행하지 않는냐로 설정하지만
		 * 		  0 ~ 무한반복 까지 일정 횟수 반복을 위해 많이 사용을 한다.
		 * 		- 조건을 잘못 설정하는 경우 무한반복에 빠질 수 있기 때문에 이는 주의해야 한다.
		 * 		  만약 이클립스에서 원치 않은 무한반복이 동작한 경우 프로그램을 강제 종료하면 된다.
		 */
		
		/*
		 * for 문 형식
		 * 		for(초기식; 조건식; 증감식) {
		 * 			반복 실행할 코드를 여기에 작성한다.
		 * 		}
		 * 
		 * 초기식 : 반복문에서 반복 횟수를 정할 때 초기에 사용할 값을 설정하기 위해 사용 한다.
		 * 		  생략 가능하며, 반복문 외부에 미리 초기값을 설정해서 사용해야 한다.
		 * 조건식 : 반복문 안의 코드 진행 여부의 조건을 설정하기 위해 사용한다.
		 * 		  생략 가능하다. 단, 조건식을 생략하면 기본적으로 반복을 진행하는 것으로 동작하기 때문에 무한반복에 빠질수 있다.
		 * 		  반복문 내부에 별도의 if 조건문과 break 를 작성하여 종료 조건을 반드시 생성해야 한다.
		 * 		  조건식의 설정도 잘못 설정하는 경우 무한반복에 빠질수 있기 때문에 조건을 반드시 확인해야 한다.
		 * 증감식 : 값의 증감을 통해 반복문의 조건식의 조건을 맞추어 주기위해 사용한다.
		 * 		  생략 가능하다. 단, 생략을 하면 종료 조건에 맞는 값을 설정할 수 없어지기 때문에 무한반복이 될 수 있다.
		 * 		  증감식은 주로 ++, -- 증감연산을 사용하거나 복합할당연산을 사용한다.
		 */
		
		for(int i = 0; i < 5; i++) {
			System.out.println(i + " 번째 반복!!");
		}
		
		System.out.println("----------");
		
		// 초기식 생략
		int i = 0;
		for(; i < 5; i++) {
			System.out.println(i + " 번째 반복!!");
		}
		
		System.out.println("----------");
		
		// 조건식 생략
		for(i = 0;; i++) {
			System.out.println(i + " 번째 반복!!");
			if(i >= 4) {
				break;
			}
		}
		
		System.out.println("----------");
		
		// 증감식 생략
		for(i = 0; i < 5;) {
			System.out.println(i + " 번째 반복!!");
			i++;
		}
		
		System.out.println("----------");
		
		// 전부 생략
		i = 0;
		for(;;) {
			System.out.println(i + " 번째 반복!!");
			if(i >= 4) {
				break;
			}
			i++;
		}
	}

}
