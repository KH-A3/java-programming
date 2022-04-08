package exam01;

public class MyException {
	public void exceptionThrows() throws Exception {
		exceptionRun();
	}
	
	public void exceptionNonThrows() {
		try {
			exceptionRun();
		} catch(Exception e) {
			System.out.println("에러 처리함.");
			e.printStackTrace();
		}
	}
	
	private void exceptionRun() throws Exception {
		throw new Exception();
	}
}
