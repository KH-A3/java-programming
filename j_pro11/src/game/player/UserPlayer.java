package game.player;

import java.util.Random;

import game.card.Bawi;
import game.card.Bo;
import game.card.Gawi;
import game.card.Hand;

public class UserPlayer implements Player {
	
	private Random rand = new Random();

	@Override
	public Hand randomCardHand() {
		Hand hand = null;
		int r = rand.nextInt(3);
		switch(r) {
			case 0:
				hand = new Gawi(); break;
			case 1:
				hand = new Bawi(); break;
			case 2:
				hand = new Bo(); break;
		}
		return hand;
	}

	@Override
	public int versus(Hand h1, Hand h2) {
		return h1.compare(h2);
	}

}
