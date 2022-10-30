package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import numberTheory.NumberTheory;

public class ProjectEuler {
	
	public static void main(String args) {
		
		System.out.println("In ProjectEuler.ProjetEuler.main()");
		euler01();		 
		euler02();
		
		//Largest Prime Factor
		long v = 600851475143l; 
		

	}


	public static void euler01() {
		System.out.println("In Euler01():");
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if(i % 5 == 0 || i %3 == 0)
				sum+= i;
		}
		System.out.println(sum);
	}

	public static void euler02() {
		System.out.println("In Euler02():");
		int counter = 0;
		LinkedList<BigInteger> theList = new LinkedList<>();
		BigInteger summary = BigInteger.ZERO;		
		BigInteger theNumber = BigInteger.ZERO;
		BigInteger stopper = BigInteger.valueOf(4_000_000L);
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
	}

}
