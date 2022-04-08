package exam01;

public class Sample01 {

	public static void main(String[] args) {
		MyException m = new MyException();
		System.out.println("에러 발생 전");
		// m.exceptionThrows();
		m.exceptionNonThrows();
		System.out.println("에러 발생 후");
	}

}
