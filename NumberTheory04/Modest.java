import java.util.HashMap;
import java.util.Map;

import numberTheory.NumberTheory;

public class Modest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int v = 7899;
		//v = 2851111;
		HashMap<Integer, Integer> theNumbersToAdd =  NumberTheory.splitTheNumberIntoTwo(v);
		for(Map.Entry<Integer, Integer> e: theNumbersToAdd.entrySet()) {			
			if ( v % e.getValue() == e.getKey()) {
				System.out.println(e.getKey() + " "  + e.getValue() + " " +  (v % e.getValue()));
			}
		}
	}

}
