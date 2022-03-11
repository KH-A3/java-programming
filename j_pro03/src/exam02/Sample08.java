package exam02;

public class Sample08 {

	public static void main(String[] args) {
		/*
		 * while 문
		 * 		while(조건식) {
		 * 			반복 수행할 코드 작성
		 * 		}
		 * for 문과 다르게 초기식, 증감식에 대한 형식이 없지만 일정 횟수 반복을 위해서는
		 * for 문과 동일하게 초기식, 증감식에 대한 작성 필요하다.
		 */
		int i = 0;
		while(i < 5) {
			System.out.println("i -> " + i);
			i++;
		}
		
		/*
		 * do ... while 문
		 * 		do {
		 * 			반복 수행할 코드 작성
		 * 		} while(조건식);
		 * 일단 최초 1회는 무조건 실행됨.
		 * 2번째 실행부터는 조건식의 결과가 참일 때 실행이 된다.
		 */
		i = 0;
		do {
			System.out.println("i -> " + i);
			i++;
		} while(i < 5);
		
		/*
		 * break 문
		 * 		- 반복문을 강제로 종료시키기 위해 사용하는 구문
		 * 
		 * continue 문
		 * 		- 반복문 안에서 다음에 실행할 코드의 진행을 막고 다시 반복문의 처음으로 돌려보내주는 구문
		 */
		i = 0;
		while(i < 10) {
			i += 1;
			if(i % 3 == 0) {
				System.out.println("i -> " + i);
			} else {
				continue;
			}
			System.out.println("이 출력은 i의 값이 3의 배수일 때만 실행 됩니다.");
		}
	}

}
