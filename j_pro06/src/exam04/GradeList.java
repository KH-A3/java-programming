package exam04;

import java.util.Arrays;

public class GradeList {
	private Grade[] gList;
	
	public GradeList() {
		this.gList = new Grade[0];
	}
	
	// 추가
	public void add(Grade grade) {
		this.gList = Arrays.copyOf(this.gList, length() + 1);
		this.gList[length() - 1] = grade;
	}
	
	public void add(String name) {
		Grade g = new Grade(name);
		this.add(g);
	}
	
	public void add(String name, double score) {
		Grade g = new Grade(name, score);
		this.add(g);
	}
	
	// 수정
	//     - 수정 할 과목을 찾아서 과목명을 수정 -> 변경전 과목명, 변경후 과목명
	//     - 수정 할 과목을 찾아서 점수를 수정 -> 찾을 과목명, 수정할 점수
	//     - 수정 할 과목을 찾아서 과목과 점수를 수정 -> 변경전 과목명, 변경후 과목명, 수정할 점수
	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 과목명을 수정
	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 점수를 수정
	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 과목명과 점수를 수정
	public void update(String src, String dest) {
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx].setName(dest);
		}
	}
	
	public void update(String src, double score) {
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx].setScore(score);
		}
	}
	
	public void update(String src, String dest, double score) {
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx].setName(dest);
			this.gList[idx].setScore(score);
		}
	}
	
	public void update(String src, Grade dest) {
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx] = dest;
		}
	}
	
	public void update(int index, String name) {
		if(_validIndex(index)) {
			this.gList[index].setName(name);
		}
	}
	
	public void update(int index, double score) {
		if(_validIndex(index)) {
			this.gList[index].setScore(score);
		}
	}
	
	public void update(int index, String name, double score) {
		if(_validIndex(index)) {
			this.gList[index].setName(name);
			this.gList[index].setScore(score);
		}
	}
	
	public void update(int index, Grade grade) {
		if(_validIndex(index)) {
			this.gList[index] = grade;
		}
	}
	
	// 삭제
	public void remove(String name) {
		int index = findIndex(name);
		if(index >= 0) {
			_remove(index);
		}
	}
	
	public void remove(int index) {
		if(_validIndex(index)) {
			_remove(index);
		}
	}
	
	private void _remove(int index) {
		int idx = 0;
		Grade[] temp = new Grade[length() - 1];
		for(int i = 0; i < length(); i++) {
			if(i != index) {
				temp[idx++] = this.gList[i];
			}
		}
		this.gList = temp;
	}
	
	// 조회
	//     - 과목명으로 점수 조회
	//     - 인덱스로 과목명 조회
	//     - 인덱스로 과목명, 점수 조회
	public double getScore(int index) {
		return 0;
	}
	
	public double getAvg() {
		// 과목 배열에 있는 점수들의 평균
		return 0;
	}
	
	public double getTotal() {
		// 과목 배열에 있는 모든 점수들의 합
		return 0;
	}
	
	public String[] getUnder() {
		// 100점 만점을 기준으로 40점 미만에 해당하는 과목 정보를 구함
		return null;
	}
	
	public String[] getUnder(double score) {
		// 제시한 score 미만에 해당하는 과목 정보를 구함
		return null;
	}
	
	public String getTop() {
		// 최고 득점 과목을 구함
		return null;
	}
	
	public String[] getTop(int count) {
		// 최고 득점 과목을 count 만큼 구함
		return null;
	}
	
	public String getBottom() {
		// 최저 득점 과목을 구함
		return null;
	}
	
	public String[] getBottom(int count) {
		// 최저 득점 과목을 count 만큼 구함
		return null;
	}
	
	public double getScore(String name) {
		int idx = findIndex(name);
		if(idx >= 0) {
			return this.gList[idx].getScore();
		}
		return 0;
	}
	
	public String getName(int index) {
		if(_validIndex(index)) {
			return this.gList[index].getName();
		}
		return null;
	}
	
	public Grade getGrade(int index) {
		if(_validIndex(index)) {
			Grade data = new Grade(this.gList[index].getName(), this.gList[index].getScore());
			return data;
		}
		return null;
	}
	
	public int findIndex(String name) {
		for(int i = 0; i < length(); i++) {
			Grade data = this.gList[i];
			if(data.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public int length() {
		return this.gList.length;
	}
	
	
	
	// 유효한 범위의 인덱스 인지 확인하는 메서드
	private boolean _validIndex(int index) {
		return (index >= 0 && index < length());
	}
}
