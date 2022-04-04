package model.vo;

public class Grade extends Subject {
	private double score;
	private char level;
	
	public Grade(String name) {
		super(name);
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
	}

	public char getLevel() {
		return level;
	}

	public void setLevel(char level) {
		this.level = level;
	}
	
}
