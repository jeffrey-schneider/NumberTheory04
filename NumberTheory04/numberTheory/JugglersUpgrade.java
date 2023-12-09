package numberTheory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class JugglersUpgrade {

	public static void main(String[] args) {
		NumberTheory instance = new NumberTheory(9);
		System.out.println(instance.getJugglers());
		System.out.println(instance.getJugglersBigInteger());
		instance.setTheNumber(3);
		System.out.println(instance.getJugglers());
		System.out.println(instance.getJugglersBigInteger());
		
		System.out.println(NumberTheory.getJugglersBigInteger(37));
		System.out.println(NumberTheory.getJugglersBigInteger(327));
		
//		System.out.println(NumberTheory.getJugglersBigInteger(48443));
		
		List<BigInteger> theList = new ArrayList<>();
		
		System.out.println("Starting loop: ");
		for(int i = 2; i <= 150; i++) {
			for (BigInteger jeff : NumberTheory.getJugglersBigInteger(i)) {
				System.out.print(jeff + " ");
				theList.add(jeff);
			}
			System.out.println();
		}
		for (BigInteger penni : theList) {
			System.out.print(penni + " ");
		}
		System.out.println();
		
		HashMap<BigInteger, Integer> hm = new HashMap<>();
		for(BigInteger penni: theList) {
			if(hm.containsKey(penni)) {
				hm.put(penni, hm.get(penni)+1);
			}else {
				hm.put(penni, 1);
			}
		}
		System.out.println("Size of hm " + hm.size());		
		
		for (var entry : hm.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		
			
		
			
		
	}
	
	

}

