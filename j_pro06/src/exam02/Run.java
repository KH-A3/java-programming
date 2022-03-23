package exam02;

import java.util.Arrays;

public class Run {

	public static void main(String[] args) {
		ReportGrade report = new ReportGrade("홍길동");
		String[] subjects = new String[] {
				"국어", "영어", "수학", "과학"
		};
		double[] grades = new double[] {
				76.8, 84.2, 93.3, 87.8
		};
		report.setSubjects(subjects);
		report.setGrades(grades);
		
		report.setGrades("영어", 88.5);
		
		String[] s = report.getSubjects();
		double[] g = report.getGrades();
		
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i] + ": " + g[i] + " 점");
		}
		
		System.out.println(report.getGrade("국어"));
		System.out.println(report.getGrade("수학"));
		System.out.println(report.getGrade("과학"));
		
		report.add("사회", 92.4);	// 배열에 해당 정보를 추가
		System.out.println(report.getGrade("사회"));
		
		System.out.println(Arrays.toString(report.getSubjects()));
		report.remove(2);
		System.out.println(Arrays.toString(report.getSubjects()));
		report.remove("과학");
		System.out.println(Arrays.toString(report.getSubjects()));
	}

}
