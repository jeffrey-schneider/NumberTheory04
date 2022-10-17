package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import numberTheory.NumberTheory;

public class ProjectEuler {
	
	public static void main(String args) {
		
		System.out.println("In ProjectEuler.ProjetEuler.main()");
		
		
		//This is incorrect. 
		int counter = 1;
		LinkedList<BigInteger> theList = new LinkedList<>();
		BigInteger summary = BigInteger.ONE;
		
		BigInteger theNumber = BigInteger.ZERO;
		BigInteger stopper = BigInteger.valueOf(4_000_000_000L);
		do {
			theNumber = NumberTheory.getFibonacci(counter);
			theList.add(theNumber);
			counter++;
		}while(theNumber.compareTo(stopper) == -1);
		
		//Since the do loop contains a value greater than the stopper, remove the final entry.
		theList.removeLast();
		
		//Summarize the even-valued terms.
		for (BigInteger bigInteger : theList) {
			if(bigInteger.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
				summary = summary.add(bigInteger);
			}
		}
		System.out.println("Even fib values: " + summary);
		
			
		
		
		
		//euler01();
	}

	private static void euler01() {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if(i % 5 == 0 || i %3 == 0)
				sum+= i;
		}
		System.out.println(sum);
	}

}
