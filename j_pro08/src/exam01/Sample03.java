package exam01;

public class Sample03 {

	public static void main(String[] args) {
		/*
		 * StringBuilder / StringBuffer
		 *     - String 객체는 불변의 특징을 가지기 때문에 특정 문자 또는 문자열을 기존 객체에
		 *       추가, 수정, 삭제 하는 작업을 할 수 없다.
		 *     - StringBuilder, StringBuffer 는 가변의 특징을 가지며, 특정 문자 똔느 문자열을 기존 객체에
		 *       추가, 수정, 삭제 하는 작업을 할 수 있다.
		 *     - StringBuilder와 StringBuffer 는 동일한 기능을 제공한다. 단, 멀티쓰레드 관련 기능 중 Thread Safe 기능
		 *       을 StringBuffer 만 지원을 한다.
		 *     - Thread Safe 기능은 멀티쓰레드에서 발생할 수 있는 문제중 공유자원에 대한 접근을 하나의 쓰레드만 접근하여
		 *       사용하도록 Lock 을 걸어 다른 쓰레드가 작업을 하지 못하게 막아주는 기능이다.
		 */
		
		// StringBuilder sb = new StringBuilder();
		StringBuffer sb = new StringBuffer();
		
		sb.append("문자열");
		sb.append("을 뒤에");
		sb.append(" 추가하는");
		sb.append(" append 메서드\n");
		System.out.println(sb);
		
		sb.insert(0, "원하는 ");
		sb.insert(4, "위치에 ");
		sb.insert(8, "문자열을 ");
		sb.insert(13, "삽입하는 ");
		sb.insert(18, "insert 메서드\n");
		System.out.println(sb);
		
		sb.setCharAt(13, '추');
		sb.setCharAt(14, '가');
		System.out.println(sb);
		
		sb.replace(25, 28, "Method");
		sb.replace(52, 55, "Method");
		System.out.println(sb);
		
		int idx = sb.indexOf("문자열");
		sb.replace(idx, idx+3, "String");
		idx = sb.indexOf("문자열");
		sb.replace(idx, idx+3, "String");
		System.out.println(sb);
		
		idx = sb.indexOf("을");
		sb.delete(idx, idx + 1);
		System.out.println(sb);
		
		sb.deleteCharAt(sb.indexOf("을"));
		System.out.println(sb);
	}

}
