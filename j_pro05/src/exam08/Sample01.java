package exam08;

public class Sample01 {

	public static void main(String[] args) {
		MethodSample m1 = new MethodSample();
		m1.method01();
		m1.method02();
		
		System.out.println(m1.num1);
		System.out.println(MethodSample.num2);
		// MethodSample.method01();
		MethodSample.method02();
		
		int var1 = m1.method03();
		int[] var2 = m1.method04();
		String var3 = m1.method05();
		
		int[] var4 = new int[] {1, 2, 3};
		System.out.println(var4);
		int[] var5 = m1.method06(var4.clone());
		System.out.println(var4[0]);
		
		m1.method07(1, 2, 3, 4);
	}

}
