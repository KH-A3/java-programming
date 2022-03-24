package exam04;

import java.util.Arrays;

public class GradeList {
	private Grade[] gList;
	
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
	
	
	// 조회
	
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
