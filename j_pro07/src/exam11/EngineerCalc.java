package exam11;

public class EngineerCalc extends BasicCalculator implements EngineerOper {

	@Override
	public int mod(int n1, int n2) {
		return n1 % n2;
	}

	@Override
	public int sqrd(int n1, int n2) {
		return 0;
	}

	@Override
	public int abs(int n1) {
		return -n1;
	}

	@Override
	public double abs(double n1) {
		return -n1;
	}

}
