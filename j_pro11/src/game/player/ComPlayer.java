package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;
import game.record.Record;

public class ComPlayer implements Player {

	private Random rand = new Random();
	private Hand hand;
	private Record record = new Record();
	private int loseCont;
	private int cheatCnt;
	
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
				record.addLose();
				loseCont++;
				break;
			case 0:
				res = "무승부";
				record.addDraw();
				loseCont = 0;
				break;
			case 1:
				res = "승리";
				record.addWin();
				loseCont = 0;
				break;
		}
		if(loseCont == 3) {
			cheatCnt++;
		}
		return res;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand h) {
		hand = h;
	}
	
	public int getCheatCnt() {
		return cheatCnt;
	}

}
