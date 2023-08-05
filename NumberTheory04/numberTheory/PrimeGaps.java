package numberTheory;

import java.util.HashMap;
import java.util.Map;

public class PrimeGaps {

	public static void main(String[] args) {
		/**
		 * Lets find the
		 *  1) maximum prime gap
		 *  2) what is the most common prime number gap?
		 *   
		 */		
		int theNumber = 2;
		int theNextPrime = 0;
		int theDifference = 0;
		HashMap<Integer, Integer> theMap = new HashMap<>();
		int checkSum = 0;
		
		while(theNextPrime < 1_000_000) {			
			theNextPrime = Primes.getNextPrime(theNumber);
			theDifference = theNextPrime - theNumber; 
			//System.out.printf("The Number: %d  Next Prime %d =  Prime Gap %d\n", theNumber, theNextPrime, theDifference);
			theNumber = theNextPrime;
			Integer j = theMap.get(theDifference);
			theMap.put(theDifference, (j==null)?1:j+1);			
		}
		System.out.println(theMap.size());
		
		for(Map.Entry<Integer, Integer>entry : theMap.entrySet()) {
			System.out.println("Gap: " + entry.getKey() + " Repetitions: " + entry.getValue());
			checkSum += entry.getValue();
		}
		System.out.println("Check total: " + checkSum);
		
			
	

	}
	
	

}
