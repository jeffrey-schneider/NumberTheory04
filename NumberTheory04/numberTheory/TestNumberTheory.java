package numberTheory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestNumberTheory {
	public static void main(String[] args) {

		NumberTheory theTheory = new NumberTheory(19);
		System.out.println(theTheory.getCollatz());
		theTheory.setTheNumber(27);
		System.out.println(theTheory.getCollatz());

		theTheory.setTheNumber(0);
		System.out.println(theTheory.getCollatz());

		System.out.println(NumberTheory.isAKeithNumber(917));

		theTheory.setTheNumber(20);
		System.out.println("Catalan: " + theTheory.getCatalan());
		System.out.println("Catalan: " + NumberTheory.getCatalan(20));
		System.out.printf("Factorial(52): %,d", NumberTheory.getFactorial(52));
		System.out.println();

		System.out.println("Fibonacci(17): " + NumberTheory.getFibonacci(17));

		System.out.println("Negative exponent(Math.pow(4.0, -1.0): " + Math.pow(4.0, -1.0));
		System.out.println("Lucas(33) " + NumberTheory.getLucas(33));
		theTheory.setTheNumber(12);
		System.out.println(theTheory.getLucas());
		System.out.println(NumberTheory.getJacobsthal(25));

		System.out.println(NumberTheory.getAlternatingFactorial(5));

		// a_PointerPrimeTest();

		//getAmicableNumbers();
		System.out.println(NumberTheory.getApocolyptic(192));
		System.out.println(theTheory.getApocolyptic(0));
		
		theTheory.setTheNumber(6601);
		System.out.println(NumberTheory.isCaramichael(561));
		System.out.println(NumberTheory.isCaramichael(1105));
		System.out.println(NumberTheory.isCaramichael(15841));
		System.out.println(theTheory.isCarmichael());
		
		System.out.println("Cake Numbers:");
		int n = 0;
		while(n < 25) {			
			System.out.printf("Cake: %d  %d\n", n, NumberTheory.getCakeNumber(n++));
		}
		
		System.out.println("Lazy Caterer's Numbers:");
		n =0;
		while(n < 25) {
			System.out.printf("Lazy: %d  %d\n", n, NumberTheory.getLazyCaterer(n++));
		}
		
		System.out.println("Bell's numbers");
		
		n = 0;
		while(n <= 50) {
			System.out.printf("%d  %d\n", n, NumberTheory.getBellNumber(n));
			n++;		
		}
		
		System.out.println("First 50 Admirable Numbers");
		n = 0;
		int counter = 50;
		while(counter > 0) {		
			++n;		
			if(NumberTheory.isAdmirable(n)) {
				System.out.printf("%d  %d\n", 50-counter, n);
				counter--;
			}
		}
		
		System.out.println("First 25 Amenable Numbers");
		n = 0;
		counter = 25;
		while(counter > 0) {
			++n;
			if(NumberTheory.isAmenable(n)) {
				System.out.printf("%d %d\n", 25 - counter, n);
				counter--;
			}
		}
		
		System.out.println("First 25 Super D Numbers");
		int i = 1;
		counter = 25;
		while(i < 1000) {
				if(NumberTheory.isSuperD(i)) {
					System.out.println(i + " is SuperD. " );
					counter--;
				}
				i++;			
			if(counter == 0) {
				break;
			}
		}
		
		for(int N = 129; N < 150; N++){
			System.out.printf("Is %d alternating? %b\n", N, NumberTheory.isAlternating(N));
		}
		
		 int N = 133857 ;
		 System.out.printf("Is %d anti-perfect? %b\n", N, NumberTheory.isAntiPerfect(N));
		 
		 
		 
		 for(int r = 47; r <= 70; r++) {
			 System.out.printf("Is %d arithmetic? %b\n", r, NumberTheory.isArithmetic(r));
		 }
		 
		 int[] n1 = {15, 429, 428};
		 for (Integer integer : n1) {
			 System.out.printf("Is %d astonishing? %b\n", integer, NumberTheory.isAstonishing(integer));	
		}
		 
		 long[] n2 = {1, 5, 6, 25, 76, 376, 625, 9376, 90625, 109376, 890625, 2890625, 7109376, 12890625};
		 for(Long longNumber: n2) {
			 System.out.printf("Is %d automorphic? %b\n", longNumber, NumberTheory.isAutomorphic(longNumber));
		 }
		 
		 List<Integer> theList = NumberTheory.getNonTrivialDivisors(60);
		 for (Integer integer : theList) {
			System.out.println(integer);
		}
		 
		 int[] n3 = { 125, 581, 8549, 16999};
		 for (int j : n3) {
			System.out.printf("%d is Canada number? %b\n", j, NumberTheory.isCanadaNumber(j));
		}
		 n3 = null;
		 
		 int x = 100;
		 System.out.println("NumberTheory.getPellList()" + NumberTheory.getPellList(x));

		 for(x = 1; x <= 100; x++) {
			 System.out.println(x + " " + NumberTheory.getPell(x));
		 }
		 
		 
		 int[] n4 = { 5, 53, 153, 157};		 
		 for (int j : n4) {
			 System.out.printf("\nIs %d a balanced prime? %b",j,   NumberTheory.isBalancedPrime(j));
		 }
		 
		 
		 System.out.println();		 
		 int[] n5 = { 4, 6, 9, 12, 15, 18, 21, 26, 30, 34, 39, 42, 45, 50, 56, 60, 64, 69, 72, 76, 81, 86, 93, 99, 102, 105, 108, 111, 120, 121}; 
		 for (int j : n5) {
			 System.out.printf("\nIs %d a interprime? %b",j,   NumberTheory.isInterPrime(j));
		 }
		 
		 
		 
		 System.out.println("\nCentered Polygonal Numbers: ");		 
		 for (int j = 3; j < 50; j++) {
			 System.out.printf("Sides: %d -> ", j);
			 for( i = 0; i <= 20; i++) {
				 System.out.printf(" %2d ", NumberTheory.getCenteredPolygonalNumber(j, i));
			 }
			 System.out.println();
		 }
		 
		 System.out.printf(" %2d ", NumberTheory.getCenteredPolygonalNumber(3, 2));
		 System.out.printf(" %2d ", NumberTheory.getCenteredPolygonalNumber(14, 20));
		 
		 System.out.println("Something is wrong here.");		 
		 for(int outer = 2; outer <= 5; outer++) {
			 System.out.print(outer + " " );
			 for(int inner = 1; inner <= 10; inner++) {
				 System.out.printf(" %.0f ", NumberTheory.getPolygonalNumber(inner, outer));
			 }
			 System.out.println();
		 }
		 
		 
		 
		 
	}
}
