package exam01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * Date 클래스
		 *     - 시스템으로 부터 현재 날짜, 시간 정보를 가져와서 사용할 수 있게 만들어진 클래스
		 */
		Date date = new Date();
		System.out.println(date);
		
		System.out.println(date.getTime());
		
		String year = String.format("%tY년", date);
		String month = String.format("%tm월", date);
		String day = String.format("%td일", date);
		System.out.printf("%s %s %s ", year, month, day);
		
		String hour = String.format("%tH시", date);
		String minute = String.format("%tM분", date);
		String second = String.format("%tS초", date);
		System.out.printf("%s %s %s\n", hour, minute, second);
		
		/*
		 * Calendar 클래스
		 *     - new 연산자로 객체 생성을 할 수 없음.
		 */
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH) + 1);
		System.out.println(c.get(Calendar.DATE));
		System.out.println(c.get(Calendar.HOUR));
		System.out.println(c.get(Calendar.MINUTE));
		System.out.println(c.get(Calendar.SECOND));
		
		switch(c.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.MONDAY:
				System.out.println("월요일");
				break;
			case Calendar.TUESDAY:
				System.out.println("화요일");
				break;
			case Calendar.WEDNESDAY:
				System.out.println("수요일");
				break;
			case Calendar.THURSDAY:
				System.out.println("목요일");
				break;
			case Calendar.FRIDAY:
				System.out.println("금요일");
				break;
			case Calendar.SATURDAY:
				System.out.println("토요일");
				break;
			case Calendar.SUNDAY:
				System.out.println("일요일");
				break;
		}
		
		System.out.println(c.getTime());
		c.add(Calendar.DATE, 1);
		System.out.println(c.getTime());
		c.add(Calendar.MONTH, -1);
		System.out.println(c.getTime());
		c.add(Calendar.YEAR, -1);
		System.out.println(c.getTime());
		c.add(Calendar.HOUR, 1);
		System.out.println(c.getTime());
		c.add(Calendar.MINUTE, 1);
		System.out.println(c.getTime());
		c.add(Calendar.SECOND, 1);
		System.out.println(c.getTime());
		c.add(Calendar.DATE, 600);
		System.out.println(c.getTime());
		
		
		/*
		 * GregorianCalendar 클래스
		 *     - Calendar 클래스를 상속하여 사용하는 클래스
		 */
		GregorianCalendar g = new GregorianCalendar();
		
		System.out.println(g.get(Calendar.YEAR));
		System.out.println(g.get(Calendar.MONTH) + 1);
		System.out.println(g.get(Calendar.DATE));
		System.out.println(g.get(Calendar.HOUR));
		System.out.println(g.get(Calendar.MINUTE));
		System.out.println(g.get(Calendar.SECOND));
		
		System.out.println("윤년 : " + g.isLeapYear(g.get(Calendar.YEAR) + 2));
		
		
		/*
		 * SimpleDateFormat 클래스
		 *     - 날짜 포멧 형식을 자유롭게 만들기 위해 사용하는 클래스
		 */
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		
		sFormat = new SimpleDateFormat("a hh:mm:dd");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		sFormat.applyPattern("yyyy-MM-dd");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		try {
			date = sFormat.parse("2022-01-01");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}










