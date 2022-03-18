package exam09;

public class Circle {

	private final static double _PI = 3.14;
	private double radius;
	private double area;
	private double round;
	
	public Circle() {}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	// setter
	public void setRadius(double radius) {
		this.radius = radius;
		_area();	_round();
	}
	
	// getter
	public double getRadius() {
		return radius;
	}
	
	public double getDiamiter() {
		return radius * 2;
	}
	
	// getter
	public double getArea() {
		return area;
	}
	
	// getter
	public double getRound() {
		return round;
	}
	
	private void _area() {
		area = _PI * radius * radius;
	}
	
	private void _round() {
		round = 2 * _PI * radius;
	}
}
