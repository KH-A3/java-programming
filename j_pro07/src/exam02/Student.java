package exam02;

public class Student extends Person {
	private int classLevel;	// 학년
	private int classRoom;	// 반
	
	public Student(String name) {
		super(name);
	}
	
	public int getClassLevel() {
		return classLevel;
	}
	
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	@Override
	public String getGender() {
		return super.getGender() + "학생";
	}

	@Override
	public String toString() {
		return "Student [name=" + getName() + ", age=" + getAge() + ", gender=" + getGender()
				+ ", classLevel=" + classLevel + ", classRoom=" + classRoom + "]";
	}
	
}
