package exam03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * Map 컬렉션
		 */
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		
		aMap.put("가", 100); aMap.put("나", 200); aMap.put("다", 300);
		System.out.println(aMap);
		
		Integer res1;
		res1 = aMap.put("가", 400);
		System.out.println(res1 + " " + aMap);
		
		res1 = aMap.put("라", 500);
		System.out.println(res1 + " " + aMap);
		
		boolean res2;
		res2 = aMap.containsKey("가");
		System.out.println(res2);
		
		res2 = aMap.containsKey("마");
		System.out.println(res2);
		
		res2 = aMap.containsValue(Integer.valueOf(200));
		System.out.println(res2);
		
		res2 = aMap.containsValue(Integer.valueOf(100));
		System.out.println(res2);
		
		res1 = aMap.get("가");
		System.out.println(res1);
		
		res1 = aMap.get("바");
		System.out.println(res1);
		
		res1 = aMap.getOrDefault("바", Integer.valueOf(0));
		System.out.println(res1);
		
		Set<String> keys = aMap.keySet();
		System.out.println(keys);
		for(String k: aMap.keySet()) {
			System.out.print(k + "\t");
		}
		System.out.println();
		
		Set<Integer> values1 = new HashSet<Integer>(aMap.values());
		System.out.println(values1);
		
		List<Integer> values2 = new ArrayList<Integer>(aMap.values());
		System.out.println(values2);
		
		for(Integer i: aMap.values()) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		Set<Entry<String, Integer>> entrys = aMap.entrySet();
		System.out.println(entrys);
		
		for(Entry<String, Integer> entry: entrys) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
		}
		System.out.println();
		
		for(Entry<String, Integer> entry: aMap.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
		}
		System.out.println();
	}

}
