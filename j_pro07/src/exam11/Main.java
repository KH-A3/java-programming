package exam11;

public class Main {

	public static void main(String[] args) {
		BasicCalculator calc1 = new Calculator();
		System.out.println(calc1.add(4, 2));
		System.out.println(calc1.sub(4, 2));
		System.out.println(calc1.mul(4, 2));
		System.out.println(calc1.div(4, 2));
		
		EngineerCalc calc2 = new EngineerCalc();
		System.out.println(calc2.add(4, 2));
		System.out.println(calc2.sub(4, 2));
		System.out.println(calc2.mul(4, 2));
		System.out.println(calc2.div(4, 2));
		
		System.out.println(calc2.mod(4, 2));
		System.out.println(calc2.sqrd(4, 2));
		System.out.println(calc2.abs(4));
		
		ProgrammerCalc calc3 = new ProgrammerCalc();
		System.out.println(calc3.add(4, 2));
		System.out.println(calc3.sub(4, 2));
		System.out.println(calc3.mul(4, 2));
		System.out.println(calc3.div(4, 2));
		
		System.out.println(calc3.binary(4));
		System.out.println(calc3.octal(4));
		System.out.println(calc3.hexa(4));
	}

}
