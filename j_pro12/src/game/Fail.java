package game;

import java.util.Random;

public class Fail extends Result {

	private String[] penalty = new String[] {
			"소주 1잔 마시기", "소주 2잔 마시기",
			"옆자리에 가서 소주 1잔 받아 먹기"
	};
	private Random rand = new Random(); 
	
	@Override
	public String toString() {
		return "실패 " + penalty[rand.nextInt(penalty.length)];
	}
}
