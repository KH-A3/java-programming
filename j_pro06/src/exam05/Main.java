package exam05;

public class Main {

	public static void main(String[] args) {
		/*
		 * StduentList 클래스를 여기에서 생성하고 실행한다.
		 */
		StudentList sList = new StudentList("홍길동", 16, 1, 2);
		sList.add("박지원", 16, 1, 2);
		sList.add("김주원", 17, 2, 1);
		sList.add("최정수", 18, 3, 2);
		sList.add("강나은", 16, 1, 4);
		sList.add("주지언", 18, 3, 1);
		
		System.out.println(sList.findIndex("김주원"));
		sList.remove("김주원");
		System.out.println(sList.findIndex("김주원"));
	}

}
