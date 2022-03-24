package exam03;

// 실행용 클래스.
public class Main {

	public static void main(String[] args) {
		Person[] pArr = new Person[4];
		
		Person p1 = new Person();
		p1.setName("홍길동");
		System.out.println(p1.getName());
		
		Person p2 = new Person();
		p2.setName("박지수");
		System.out.println(p2.getName());
		
		Person p3 = new Person();
		p3.setName("김주언");
		System.out.println(p3.getName());
		
		pArr[0] = p1;	// 얕은 복사
		pArr[1] = p2;
		pArr[2] = p3;
		pArr[3] = new Person();
		pArr[3].setName("이수연");
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
		
		PersonList pList = new PersonList(pArr);
		
		for(int i = 0; i < pList.length(); i++) {
			Person p = pList.get(i);
			System.out.println(p.getName());			
		}
		
		// 이름으로 위치 찾기.
		int idx = pList.findIndex("박지수");
		
		// 해당 이름이 있는지 확인하기.
		boolean isExisted = pList.existsName("박지수");
		
		// 새로운 Person 객체를 PersonList에 추가하기
		pList.add(new Person(""));	// 마지막 인덱스에 추가.
		pList.add(new Person("곽도운"));
		pList.addFirst(new Person("강지원"));	// 0번 인덱스에 추가 될 수 있게 한다.
		
		System.out.println(pList.length());
		System.out.println(pList.findIndex("곽도운"));
		System.out.println(pList.findIndex("강지원"));
		
		// PersonList에 저장된 Person 객체를 삭제
		// pList.remove(1);	// 1번 인덱스에 있는 객체 삭제
		// pList.remove("박지수");	// 박지수 이름을 찾아서 삭제
		
	}

}
