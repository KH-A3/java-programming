package exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * Set 컬렉션
		 */
		Set<Integer> aSet = new HashSet<Integer>();
		
		aSet.add(100); aSet.add(200); aSet.add(300);
		aSet.add(400); aSet.add(500); aSet.add(600);
		System.out.println(aSet);
		
		aSet.add(100); aSet.add(200); aSet.add(300);
		System.out.println(aSet);
		
		boolean res1;
		res1 = aSet.add(100);
		System.out.println(res1 + " " + aSet);
		
		res1 = aSet.add(700);
		System.out.println(res1 + " " + aSet);
		
		Set<Integer> bSet = new HashSet<Integer>();
		bSet.add(700); bSet.add(800); bSet.add(900);
		
		res1 = aSet.addAll(bSet);
		System.out.println(res1 + " " + aSet);
		
		res1 = aSet.addAll(bSet);
		System.out.println(res1 + " " + aSet);
		
		res1 = aSet.contains(Integer.valueOf(100));
		System.out.println(res1);
		
		res1 = aSet.contains(Integer.valueOf(150));
		System.out.println(res1);
		
		res1 = bSet.isEmpty();
		System.out.println(res1);
		
		bSet.clear();
		res1 = bSet.isEmpty();
		System.out.println(res1);
		
		res1 = aSet.remove(Integer.valueOf(100));
		System.out.println(res1 + " " + aSet);
		
		res1 = aSet.remove(Integer.valueOf(150));
		System.out.println(res1 + " " + aSet);
		
		Iterator<Integer> iter = aSet.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			System.out.print(i + "\t");
		}
		System.out.println();
		
		for(Integer i: aSet) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		// Set을 List로 변경
		List<Integer> aList = new ArrayList<Integer>(aSet);
		Collections.sort(aList);
		System.out.println(aList);
		
		// List를 Set으로 변경
		Set<Integer> cSet = new HashSet<Integer>(aList);
		System.out.println(cSet);
	}

}
