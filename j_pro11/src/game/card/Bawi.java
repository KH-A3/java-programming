package game.card;

public class Bawi extends Hand {

	@Override
	public int compare(Hand otherHand) {
		// -1:패, 0:무, 1:승
		int res = 0;
		if(otherHand instanceof Gawi) {
			res = 1;
		} else if(otherHand instanceof Bawi) {
			res = 0;
		} else if(otherHand instanceof Bo) {
			res = -1;
		}
		return res;
	}

	@Override
	public Hand cheat(Hand otherHand) {
		Hand newHand = null;
		if(otherHand instanceof Gawi) {
			newHand = new Bawi();
		} else if(otherHand instanceof Bawi) {
			newHand = new Bo();
		} else if(otherHand instanceof Bo) {
			newHand = new Gawi();
		}
		return newHand;
	}

}
