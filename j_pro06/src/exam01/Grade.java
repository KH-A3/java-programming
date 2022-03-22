package exam01;

public class Grade {
	private String name;
	private double score;
	private char rank;
	private char[] rankArr =
			new char[] {'F', 'F', 'F', 'F', 'E', 'E', 'D', 'C', 'B', 'A', 'A'};
	
	public Grade(String name) {
		this.name = name;
	}
	
	public Grade(String name, double score) {
		this.name = name;
		this.setScore(score);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		this.score = score;
		this._setRank(score);
	}
	
	public char getRank() {
		return this.rank;
	}
	
	private void _setRank(double score) {
		this.rank = this.rankArr[(int)(this.score / 10)];
	}
}
