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
		this._remove(idx);
	}
		
	public void remove(int classLevel) {
		while(_findIndex(classLevel) != -1) {
			int idx = _findIndex(classLevel);
			this._remove(idx);
		}
	}
	
	public int[] getClassLevelRoom(String name) {
		int idx = _findIndex(name);
		return new int[] {sArr[idx].getClassLevel(), sArr[idx].getClassRoom()};
	}
	
	public String[] getNames(int classLevel) {
		String[] result = null;
		for(int i = 0; i < sArr.length; i++) {
			if(classLevel == sArr[i].getClassLevel()) {
				if(result == null) {
					result = new String[0];
				}
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = sArr[i].getName();
			}
		}
		
		return result;
	}
	
	public String[] getNames(int classLevel, int classRoom) {
		String[] result = null;
		for(int i = 0; i < sArr.length; i++) {
			if(classLevel == sArr[i].getClassLevel() &&
					classRoom == sArr[i].getClassRoom()) {
				if(result == null) {
					result = new String[0];
				}
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = sArr[i].getName();
			}
		}
		
		return result;
	}
	
	public int length() {
		return sArr.length;
	}
	
	public int findIndex(String name) {
		return this._findIndex(name);
	}
	
	private void _remove(int index) {
		Student[] temp = new Student[sArr.length - 1];
		System.arraycopy(sArr, 0, temp, 0, index);
		System.arraycopy(sArr, index + 1, temp, index, sArr.length - (index + 1));
		sArr = temp;
	}
	
	private int _findIndex(String name) {
		for(int i = 0; i < sArr.length; i++) {
			if(name.equals(sArr[i].getName())) {
				return i;
			}
		}
		return -1;
	}
	
	private int _findIndex(int classLevel) {
		for(int i = 0; i < sArr.length; i++) {
			if(classLevel == sArr[i].getClassLevel()) {
				return i;
			}
		}
		return -1;
	}
}
