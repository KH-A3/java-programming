package exam05;

import java.util.Arrays;

public class StudentList {
	/*
	 * Stduent 클래스를 배열 형식으로 관리할 수 있게 만드는 클래스
	 * 이 클래스로 다음의 기능을 제공하도록 한다.
	 *     - 학생 정보를 추가 할 수 있는 기능
	 *       (반드시 이름, 나이, 학년, 반 정보가 저장되도록 한다.)
	 *     - 학생 정보를 수정 할 수 있는 기능
	 *       (학생 이름으로 학년, 반 정보를 수정할 수 있게 한다.)
	 *     - 학생 정보를 삭제 할 수 있는 기능
	 *       (학생 이름 뿐만아니라 학년 정보로도 삭제할 수 있게 한다.
	 *        예로 3학년에 해당하는 학생 정보를 모두 삭제할 수 있게 하는 기능) 
	 *     - 학생 이름으로 학년, 반 정보를 제공하는 기능
	 *     - 학년 정보로 모든 학생의 이름을 제공하는 기능
	 *     - 학년, 반 정보로 모든 학생의 이름을 제공하는 기능
	 */
	private Student[] sArr;
	
	public StudentList(String name, int age, int classLevel, int classRoom) {
		sArr = new Student[1];
		sArr[0] = new Student(name, age, classLevel, classRoom);
	}
	
	public void add(String name, int age, int classLevel, int classRoom) {
		sArr = Arrays.copyOf(sArr, sArr.length + 1);
		sArr[sArr.length - 1] = new Student(name, age, classLevel, classRoom);
	}
	
	public void add(Student student) {
		sArr = Arrays.copyOf(sArr, sArr.length + 1);
		sArr[sArr.length - 1] = student;
	}
	
	public void update(String findName, int classLevel, int classRoom) {
		int idx = this._findIndex(findName);
		if(idx == -1) {
			return;
		}
		sArr[idx].setClassLevel(classLevel);
		sArr[idx].setClassRoom(classRoom);
	}
	
	public void remove(String findName) {
		int idx = this._findIndex(findName);
		Student[] temp = new Student[sArr.length - 1];
		System.arraycopy(sArr, 0, temp, 0, idx);
		System.arraycopy(sArr, idx + 1, temp, idx, sArr.length - (idx + 1));
		sArr = temp;
	}
	
	public int length() {
		return sArr.length;
	}
	
	public int findIndex(String name) {
		return this._findIndex(name);
	}
	
	private int _findIndex(String name) {
		for(int i = 0; i < sArr.length; i++) {
			if(name.equals(sArr[i].getName())) {
				return i;
			}
		}
		return -1;
	}
}
