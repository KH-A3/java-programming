package exam01;

public class Sample05 {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 *     - 기본 자료형을 객체로 만들어서 객체로 다룰수 있게 해주는 클래스
		 *     - 문자열 값을 기본 자료형으로 변환할 수 있는 기능을 제공
		 *     
		 * Boolean, Byte, Character, Short, Integer, Long, Float, Double 이 Wrapper 클래스이다.
		 */
		
		// 문자열을 기본 자료형으로 변경(Wrapper 사용)
		boolean bool = Boolean.parseBoolean("true");
		byte b1 = Byte.parseByte("100");
		short s1 = Short.parseShort("100");
		char c1 = "문자열".charAt(0);
		char[] cArr = "문자열".toCharArray();
		int i1 = Integer.parseInt("100");
		long l1 = Long.parseLong("100");
		float f1 = Float.parseFloat("100");
		double d1 = Double.parseDouble("100");
	}

}
