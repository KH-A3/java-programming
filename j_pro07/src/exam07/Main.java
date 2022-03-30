package exam07;

public class Main {

	public static void main(String[] args) {
		Employee e1 = new Staff("김사원", 28);
		Employee e2 = new AssistantManager("박대리", 32);
		Employee e3 = new DepartmentManager("이과장", 38);
		Employee e4 = new DeputyGeneralManager("차차장", 43);
		Employee e5 = new Director("곽부장", 48);
		
		Employee[] empArr = new Employee[5];
		empArr[0] = e1;	empArr[1] = e2;	empArr[2] = e3;
		empArr[3] = e4;	empArr[4] = e5;
		
		((DepartmentManager)e3).setTeamManager(true);
		
		for(int i = 0; i < empArr.length; i++) {			
			System.out.println(empArr[i].getName() + "의 연봉은 " + empArr[i].getSalary() + "만원");
			empArr[i].payMonth();
			System.out.println("===============================");
		}
	}

}
