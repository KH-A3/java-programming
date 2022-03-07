package exam02;

public class Sample03 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 이스케이프 문자
		 * 		- 문자열에 작성하는 문자들 중 일부 문자에 대해 다른 기능을 부여하기 위해 사용.
		 * 		- \n, \r, \t, \', \", \\, ... 등의 이스케이프 문자가 있다.
		 */
		System.out.println("이 다음 문자에 개행을\n합니다.");
		System.out.print("이 다음 문자에 캐리지 리턴을\r합니다.");		// 이클립스에서 추가 설정 변경을 해야 확인 가능
		System.out.println("이 다음 문자에 탭 공백을\t합니다.");
		System.out.println("이 다음 문자에 작은 따옴표를 \'\' 작성합니다.");
		System.out.println("이 다음 문자에 큰 따옴표를 \"\" 작성합니다.");
		System.out.println("이 다음 문자에 역슬래쉬를 \\ 작성합니다.");
		
		System.out.println();
		
		System.out.print("진행도를 나타내기 위한 프로그래스 바\n");
		System.out.print("프로그램 로딩 중 - [                     -   0%]\r");
		Thread.sleep(1000);		// 코드의 실행을 일시정지 시킨다. 1000 = 1초
		System.out.print("프로그램 로딩 중 - [                  ## -  10%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [                #### -  20%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [              ###### -  30%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [            ######## -  40%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [          ########## -  50%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [        ############ -  60%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [      ############## -  70%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [    ################ -  80%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [  ################## -  90%]\r");
		Thread.sleep(1000);
		System.out.print("프로그램 로딩 중 - [#################### - 100%]\r");
	}

}
