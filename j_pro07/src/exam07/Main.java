package exam07;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		
		Employee e1 = new Staff("김사원", 28);
		Employee e2 = new AssistantManager("박대리", 32);
		Employee e3 = new DepartmentManager("이과장", 38);
		Employee e4 = new DeputyGeneralManager("차차장", 43);
		Employee e5 = new Director("곽부장", 48);
		
		Employee[] empArr = new Employee[5];
		empArr[0] = e1;	empArr[1] = e2;	empArr[2] = e3;
		empArr[3] = e4;	empArr[4] = e5;
		
		((DepartmentManager)e3).setTeamManager(true);
		((DeputyGeneralManager)e4).setHeadManager(true);
		((Director)e5).setHeadManager(true);
		
		for(int m = 1; m <= 30; m++) {
			int month = m % 12 == 0 ? 12 : m % 12;
			System.out.printf("%d 월 급여 지급 내역\n", month);
			System.out.println("-------------------------------");
			for(int i = 0; i < empArr.length; i++) {
				empArr[i].payMonth();
				empArr[i].bonus(month);
				
				if(empArr[i] instanceof TeamManager) {
					((TeamManager)empArr[i]).teamPayBonus();
				}
				if(empArr[i] instanceof HeadManager) {
					((HeadManager)empArr[i]).headPayBonus();
				}
				
				System.out.println("-------------------------------");
			}
			
			if((rand.nextInt(9) + 1) % 4 == 0) {
				int idx = rand.nextInt(4) + 1;
				System.out.println(empArr[idx].getName() + "가(이) 법카 쏜다~");
				((AssistantManager)empArr[idx]).corpCard(100000);
			}
			
			System.out.println("===============================");
		}
	}

}
