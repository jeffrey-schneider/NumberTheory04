package numberTheory;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inconsummate {

	public static void main(String[] args) {
		int stopCount = 2000;
		
		Set<Integer> allNumbersSet = new HashSet<>();
		for(int i = 0; i < stopCount; i++) {
			if(!allNumbersSet.contains(i)) {
				allNumbersSet.add(i);
			}
		}
		
		for (Integer integer : allNumbersSet) {
			System.out.println(integer);
		}
		
		System.out.println("====");
		HashMap<Integer, Integer> consummateList = isConsummate(stopCount);
		Set<Integer> consummateSet = new HashSet<>();
		for(Map.Entry<Integer,Integer> e: consummateList.entrySet()) {
			if(!consummateSet.contains(e.getValue())) {
				consummateSet.add(e.getValue());				
			}
		}
		for (Integer integer : consummateSet) {
			System.out.println(integer);
		}
		System.out.println("====");
		allNumbersSet.removeAll(consummateSet);
		for (Integer integer : allNumbersSet) {
			System.out.println(integer);
		}	
				
	}
	
	private static Map<Integer, Integer> findDuplicatesUsingHashMap(List<Integer> inputList) {
		Map<Integer,Integer> hm = new HashMap<>();
		for(int x: inputList) {
			if(!hm.containsKey(x)) {
				hm.put(x,1);
			}else {
				hm.put(x, hm.get(x)+1); 
			}
		}
		return hm;
	}





	/**
	 * Find all numbers that are Consummate 
	 * @param v
	 * @return
	 */
	public static HashMap<Integer, Integer> isConsummate(int v) {
		HashMap<Integer, Integer> theMap = new HashMap<>();
		for(int i = 1; i <= v; i++) {
			int sod = NumberTheory.getSumOfDigits(NumberTheory.getListOfDigits(i));
			int theFactor = i / sod;
			//System.out.println(i + "/" + sod + " " + theFactor);
			theMap.put(i, theFactor );	
		}
		return theMap;
	}
	
	

}
