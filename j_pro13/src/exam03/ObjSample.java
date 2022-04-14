package exam03;

import java.io.Serializable;

public class ObjSample implements Serializable {
	private int num;
	private double point;
	private boolean yn;
	private String s;
	
	public ObjSample(int n, double d, boolean b, String s) {
		num = n;
		point = d;
		yn = b;
		this.s = s;
	}

	@Override
	public String toString() {
		return "ObjSample [num=" + num + ", point=" + point + ", yn=" + yn + ", s=" + s + "]";
	}
	
}
