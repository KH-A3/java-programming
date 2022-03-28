package exam03;

import java.util.Objects;

public class Grade extends Score {
	// 점수와 등급 정보를 가지는 객체
	private char level;
	
	public Grade() {}
	
	public Grade(double point) {
		this.setPoint(point);
	}
	
	// 점수를 설정할 때 0 ~ 100 사이의 점수만 설정할 수 있게
	// 만드려고 한다.
	@Override
	public void setPoint(double point) {
		char[] rank = new char[] {'F', 'F', 'F', 'F', 'E', 'E', 'D', 'C', 'B', 'A', 'A'};
		if(point >= 0 && point <= 100) {
			super.setPoint(point);
		}
		this.level = rank[(int)(this.getPoint() / 10)];
	}
	
	public char getLevel() {
		return this.level;
	}

	@Override
	public String toString() {
		return "Grade [point=" + getPoint() + ", level=" + level + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(level);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		return level == other.level;
	}
	
}
