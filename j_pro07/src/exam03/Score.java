package exam03;

import java.util.Objects;

public class Score {
	// 점수만을 가지는 객체
	private double point;

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public int hashCode() {
		return Objects.hash(point);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Double.doubleToLongBits(point) == Double.doubleToLongBits(other.point);
	}

	@Override
	public String toString() {
		return "Score [point=" + point + "]";
	}
	
}
