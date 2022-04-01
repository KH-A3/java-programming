package exam01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sample07 {
	
	public void ex01() {
		/*
		 * 현재 날짜를 구하고 다음 형식에 맞추어 출력하시오.
		 *     1. 2022/01/01
		 *     2. 2022년 01월 01일
		 *     3. 1월 1일
		 *     4. 오전 12시 00분 월요일
		 */
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		sFormat.applyPattern("yyyy년 MM월 dd일");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		sFormat.applyPattern("M월 d일");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
		
		sFormat.applyPattern("a hh시 mm분 E요일");
		strDate = sFormat.format(new Date());
		System.out.println(strDate);
	}
	
	public void ex02() {
		/*
		 * 사용자 입력을 이용하여 현재 날짜에서 n일 을 추가하거나 뺐을 때의
		 * 날짜가 언제인지를 확인할 수 있게 출력하시오.
		 *     예)
		 *         일자 : 10
		 *         현재 날짜에서 10일 후 날짜는 2022년 04월 11일 입니다.
		 *         
		 *         일자 : -10
		 *         현재 날짜에서 10일 전 날짜는 2022년 03월 22일 입니다.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("일자 : ");
		String input = sc.nextLine();
		int addDay = Integer.parseInt(input);
		
		GregorianCalendar g = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		g.add(Calendar.DATE, addDay);
		
		String strDate = sFormat.format(g.getTime());
		String result = "";
		if(addDay > 0) {
			result = String.format("현재 날짜에서 %d일 후 날짜는 %s 입니다.", addDay, strDate);
		} else {
			result = String.format("현재 날짜에서 %d일 전 날짜는 %s 입니다.", -addDay, strDate);
		}
		System.out.println(result);
	}
	
	public void ex03() {
		/*
		 * 주민등록 앞 번호의 생년월일을 입력하면 날짜로 변환되어 출력할 수
		 * 있도록 하시오.
		 */
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(true) {
			System.out.print("주민번호 앞자리만 입력 : ");
			input = sc.nextLine();
			if(input.matches("\\d{6}")) {
				break;
			}
			System.out.println("주민번호 앞자리 6자만 입력하세요.");
		}
		
		SimpleDateFormat sFormat = new SimpleDateFormat("yyMMdd");
		try {
			Date d = sFormat.parse(input);
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void ex04() {
		/*
		 * 자신의 올해 생일이 몇일 남았는지 알 수 있도록 해주는 코드를 작성하시오.
		 */
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar birthDay = new GregorianCalendar();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy.MM.dd");
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		while(true) {
			System.out.print("자신의 생일을 \"월.일\" 형식으로 입력하세요 : ");
			input = sc.nextLine();
			
			if(input.matches("\\d{1,2}\\.\\d{1,2}")) {
				break;
			}
			System.out.println("입력 형식을 다시 확인하세요.");
		}
		
		try {
			birthDay.setTime(sFormat.parse(now.get(Calendar.YEAR) + "." + input));
			System.out.println(birthDay.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(now.after(birthDay));
		System.out.println(now.before(birthDay));
	}

	public static void main(String[] args) {
		Sample07 sample = new Sample07();
		// sample.ex01();
		// sample.ex02();
		// sample.ex03();
		sample.ex04();
		
		/*
		 * 프로그램이 동작한 후 부터 종료할 때까지의 시간 기록을 남기기 위한 코드를 작성하시오.
		 * 기록을 남기기 위한 프로그램은 1 ~ 100,000 까지의 누적합을 구하는 코드로 한다.
		 */
		
		/*
		 * 2020년 부터 2099년 까지의 년도 중 윤년에 해당하는 년도를 정수 배열에 담아 출력하시오.
		 */
		
		/*
		 * 2022년 04월 에서 주말에 해당하는 날짜만 날짜 배열에 저장하시오.
		 */
		
		/*
		 * 유튜브에서는 영상 업로드가 언제 이루어졌는지를 보여주는 형식이 x초 전 또는 x분 전, x시간 전
		 * x일 전, x주 전, x개월 전, y년 전 으로만 출력이 이루어지는데. 이를 동일하게 모방하여 사용자가
		 * 입력한 날짜가 현재 시간과 얼만큼의 차이가 있는지 출력하시오.
		 */
		
		/*
		 * D-Day 계산기를 만들어 보시오.
		 *     1. 현재 시간보다 과거의 시간을 입력한 경우 "D-Day n일 지남" 으로 출력
		 *     2. 현재 시간보다 미래의 시간을 입력한 경우 "D-Day n일 남음" 으로 출력
		 */
		
	}

}
