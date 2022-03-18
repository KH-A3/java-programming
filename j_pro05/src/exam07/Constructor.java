package exam07;

public class Constructor {
	public int num1;
	public int num2;
	public int num3;
	public int num4;
	
	public Constructor() {}
	
	public Constructor(int num1) {
		this.num1 = num1;
	}
	
	public Constructor(int num1, int num2) {
		this(num1);
		this.num2 = num2;
	}
	
	public Constructor(int num1, int num2, int num3) {
		this(num1, num2);
		this.num3 = num3;
	}
	
	public Constructor(int num1, int num2, int num3, int num4) {
		this(num1, num2, num3);
		this.num4 = num4;
	}
}
