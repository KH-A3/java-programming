package game.card;

public abstract class Hand {
	// 가위, 바위, 보를 비교하여 승,패를 가리기 위한 메서드
	public abstract int compare(Hand otherHand);
	
	// 상대방의 패를 보고 이길 수 있는 패를 반환하기 위한 메서드
	public abstract Hand cheat(Hand otherHand);
}
