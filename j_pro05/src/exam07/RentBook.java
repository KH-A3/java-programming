package exam07;

public class RentBook {

	public String name;			// 도서명
	public String serialNo;		// 도서시리얼번호
	public String rentDate;		// 대여날짜
	public int rentDays;		// 대여기간
	public String returnDate;	// 반납날짜
	public String writer;		// 저자명
	public String rentName;		// 대여자
	public int overDay;			// 연체일
	public String rentPlace;	// 대여장소
	
	public RentBook() {
		this.rentDays = 7;
	}
	
	public RentBook(String name, String serialNo) {
		this();
		this.name = name;
		this.serialNo = serialNo;
	}
	
	public RentBook(String name, String serialNo, String rentDate) {
		this(name, serialNo);
		this.rentDate = rentDate;
	}
	
	public RentBook(String name, String serialNo, String rentDate, int rentDays) {
		this(name, serialNo, rentDate);
		this.rentDays = rentDays;
	}
	
}
