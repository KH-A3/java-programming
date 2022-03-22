package exam10.model.vo;

public class Product {
	private String pName = "키보드";
	private int price = 250000;
	private String brand = "X오X드";
	
	// 기본 생성자는 생략하여 쓰는 것으로 한다.
	
	public void information() {
		System.out.println(pName);
		System.out.println(price);
		System.out.println(brand);
	}
}
