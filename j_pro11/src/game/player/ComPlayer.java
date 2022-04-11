package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;

public class ComPlayer implements Player {

	private Random rand = new Random();
	private Hand hand;
	
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
	public int versus(Hand h1) {
		return hand.compare(h1);
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand h) {
		hand = h;
	}

}
