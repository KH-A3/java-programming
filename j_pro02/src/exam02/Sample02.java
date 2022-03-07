package exam02;

public class Sample02 {

	public static void main(String[] args) {
		// printf 활용하여 표형식으로 출력(정렬)
		// 		가급적 영문자로만 작성하세요.
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8s|\n", "name", "age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Hong", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Kim", 28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Park", 19);
		System.out.print("+--------+--------+\n");
		
		System.out.println();	// 위족 출력과 구분하기 위한 개행.
		
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8s|\n", "name", "age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Hong", 34.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Kim", 28.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Park", 19.0);
		System.out.print("+--------+--------+\n");
		
		System.out.println();	// 위족 출력과 구분하기 위한 개행.
		
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8s|\n", "이름", "나이");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "홍길동", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "김스티븐", 28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "박마리아나", 19);
		System.out.print("+--------+--------+\n");
	}

}
