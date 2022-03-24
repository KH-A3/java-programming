package exam04;

public class Main {

	public static void main(String[] args) {
		/*
		 * Grade 에는 과목에 대한 성적 정보가 있는 객체
		 * 
		 * GradeList 에는 Grade 를 배열로 관리하는 객체
		 * 		- 과목에 대한 성적 관리를 위해 Grade 객체를 추가/수정/삭제/조회
		 *        할 수 있는 기능을 만든다.
		 *      - 가능하면 가장 높은 점수를 가지는 과목으로 정렬 할 수 있는 기능을
		 *        만든다. 
		 */
		GradeList datas = new GradeList();
		datas.add(new Grade("국어", 67.8));
		System.out.println("국어 : " + datas.getScore("국어"));
		
		Grade g = datas.getGrade(0);
		g.setName("영어");	g.setScore(78.7);
		System.out.println("영어 : " + g.getScore());
	}

}
