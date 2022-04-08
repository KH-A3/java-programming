package exam01;

public class MyException {
	public void exceptionThrows() throws UserDefineException {
		exceptionRun();
	}
	
	public void exceptionNonThrows() {
		try {
			exceptionRun();
		} catch(UserDefineException e) {
			System.out.println("에러 처리함.");
			e.printStackTrace();
		}
	}
	
	private void exceptionRun() throws UserDefineException {
		throw new UserDefineException("사용자 정의 예외 에러가 발생하였습니다.");
	}
}
