package model.vo;

public class Grade extends Subject {
	private double score;
	private char level;
	private char[] levelArr = new char[] {
			'F', 'F', 'F', 'F', 'E', 'E', 'D', 'C', 'B', 'A', 'A'
	};
	
	public Grade(String name) {
		super(name);
		this.level = 'F';
	}
	
	public Grade(String name, double score) {
		super(name);
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
		this.level = levelArr[(int)(score / 10)];
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}
	
}
