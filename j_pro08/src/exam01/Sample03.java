package exam01;

public class Sample03 {

	public static void main(String[] args) {
		/*
		 * StringBuilder / StringBuffer
		 *     - String 객체는 불변의 특징을 가지기 때문에 특정 문자 또는 문자열을 기존 객체에
		 *       추가, 수정, 삭제 하는 작업을 할 수 없다.
		 *     - StringBuilder, StringBuffer 는 가변의 특징을 가지며, 특정 문자 똔느 문자열을 기존 객체에
		 *       추가, 수정, 삭제 하는 작업을 할 수 있다.
		 */
		
		StringBuilder sb = new StringBuilder();
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
