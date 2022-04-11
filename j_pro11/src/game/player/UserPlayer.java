package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.record.Record;

public class UserPlayer implements Player {
	
	private Random rand = new Random();
	private Hand hand;
	private Record record = new Record();

	@Override
	public void randomCardHand() {
		int r = rand.nextInt(3);
		switch(r) {
			case 0:
				hand = new Gawi(); break;
			case 1:
				hand = new Bawi(); break;
			case 2:
				hand = new Bo(); break;
		}
	}

	@Override
	public String versus(Hand h1) {
		String res = "";
		switch(hand.compare(h1)) {
			case -1:
				res = "패배";
				record.addLose(); break;
			case 0:
				res = "무승부";
				record.addDraw(); break;
			case 1:
				res = "승리";
				record.addWin(); break;
		}
		return res;
	}
	
	public String getTotalRecord() {
		String res = String.format("총 전적 : %d 전\n", record.getRecordCount());
		res += String.format("%d 승 %d 패 %d 무\n", record.getWin(), record.getLose(), record.getDraw());
		res += String.format("승률 : %.1f %%", record.getWinRate());
		return res;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(String handName) {
		if(handName.equals("가위")) {
			hand = new Gawi();
		} else if(handName.equals("바위")) {
			hand = new Bawi();
		} else if(handName.equals("보")) {
			hand = new Bo();
		} else {
			this.randomCardHand();
		}
	}

}
