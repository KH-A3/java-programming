package exam06;

/*
 * 스탑 워치 프로그램 개발을 위해 사용할 시간 객체를 추상화하여 클래스 다이어그램으로
 * 만들고 클래스로 정의 하시오.
 * 
 * 멤버 변수는 변수명, 접근제한, 타입과 필요한 경우 초기값 까지 정의한다.
 * 메서드(기능)의 경우에는 기능명만 작성.
 */
public class StopWatch {
	private int hour;
	private int minute;
	private int second;
	
	public void setHour(int h) {	// setter
		hour = h;
	}
	
	public int getHour() {	// getter
		return hour;
	}
	
	public void start() {}
	public void stop() {}
	public void pause() {}
	public void reset() {}
}
