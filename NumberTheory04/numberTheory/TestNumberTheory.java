package numberTheory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestNumberTheory {
	public static void main(String[] args) {

		NumberTheory instance = new Primes(19);
		System.out.println(instance.getCollatz());
		instance.setTheNumber(27);
		System.out.println(instance.getCollatz());

		instance.setTheNumber(0);
		System.out.println(instance.getCollatz());

		System.out.println(NumberTheory.isAKeithNumber(917));

		instance.setTheNumber(20);
		System.out.println("Catalan: " + instance.getCatalan());
		System.out.println("Catalan: " + NumberTheory.getCatalan(20));
		System.out.printf("Factorial(52): %,d", NumberTheory.getFactorial(52));
		System.out.println();

		System.out.println("Fibonacci List(17): " + NumberTheory.getFibonacciList(17));
		System.out.println("Fibonacci(17): " + Primes.getFibonacci(17));

		System.out.println("Negative exponent(Math.pow(4.0, -1.0): " + Math.pow(4.0, -1.0));
		System.out.println("Lucas(33) " + NumberTheory.getLucas(33));
		instance.setTheNumber(12);
		System.out.println(instance.getLucas());
		System.out.println(NumberTheory.getJacobsthal(25));

		
		System.out.println("Alternating Factorials");
		System.out.println(NumberTheory.getAlternatingFactorial(15));

		// a_PointerPrimeTest();

		//getAmicableNumbers();
		System.out.println(NumberTheory.getApocolyptic(192));
		System.out.println(instance.getApocolyptic(0));
		
		instance.setTheNumber(6601);
		System.out.println(NumberTheory.isCarmichael(561));
		System.out.println(NumberTheory.isCarmichael(1105));
		System.out.println(NumberTheory.isCarmichael(15841));
		System.out.println(instance.isCarmichael());
		
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
			 System.out.println(x + " == " + NumberTheory.getPell(x));
		 }
		 
		 
		 int[] n4 = { 5, 53, 153, 157};		 
		 for (int j : n4) {
			 System.out.printf("\nIs %d a balanced prime? %b",j,   NumberTheory.isBalancedPrime(j));
		 }
		 
		 
		 System.out.println();		 
		 int[] n5 = { 4, 6, 9, 12, 15, 18, 21, 26, 30, 34, 39, 42, 45, 50, 56, 60, 64, 69, 72, 76, 81, 86, 93, 99, 102, 105, 108, 111, 120, 121}; 
		 for (int j : n5) {
			 System.out.printf("\nIs %d a interprime? %b",j,   Primes.isInterPrime(j));
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
		 System.out.println();
		 
		 
		 
		 System.out.println("Polygonal Numbers.");
		 for(int outer = 2; outer <= 24; outer++) {	
			 System.out.printf(" %d ", outer);
			 for(int inner = 1; inner <= 10; inner++) {
				 System.out.printf(" %.0f ", NumberTheory.getPolygonalNumber(outer, inner));
			 }
			 System.out.println();
		 }
		 
		 		 
		 
		
		 
		 
		 
		 System.out.println("Number -> Factorials -> Primorials");
		 for(i = 0; i <= 25; i++) {
			 System.out.printf("%d -> %,d / %,d\n" , i, NumberTheory.getFactorial(i), NumberTheory.getPrimorials(i));
		 }

		 
		 System.out.println("Co primes. ");
		 System.out.println("Are 18 and 35 CoPrimes? " + NumberTheory.isCoPrime(18, 35));

		 System.out.println("Cubic Numbers");
		 for(i = 0; i <= 25; i++) {
			 System.out.printf(" %d ", NumberTheory.getCube(i));
		 }
		 
		 System.out.println("\nCullen Numbers");
		 for(i = 0; i <= 100; i++) {
			 System.out.printf(" %d ", NumberTheory.getCullen(i));
		 }
		 
		 
		 System.out.println("\nCurzon numbers");
		 List<Integer> curzonList = new LinkedList<>();  //LinkedList? Why not?
		 for(i = 1; i <= 300; i++) {
			 if(NumberTheory.isCurzon(i)) {
				 curzonList.add(i);
			 }
		 }
		 System.out.println(curzonList);
		
		 System.out.println("Euler's totient Function for 75");
		  i = 75;		 
		 System.out.println("GetTotatives(i): " + NumberTheory.getTotatives(i));
		 System.out.println("Eulers Totient(i): " + NumberTheory.getEulersTotient(i));
		 
		 
		 System.out.println("Cyclic Numbers:");
		 for(i = 1; i <= 150; i++) {
			 if(NumberTheory.isCyclic(i)) {
				 System.out.printf("%d ", i);
			 }
		 }
		 System.out.println();
		 
		 System.out.println("de Polignac Numbers:");
		 for(i = 1; i<= 1000; i++) {
			if(NumberTheory.isDePolignac(i)) {
				System.out.printf("%d ", i);
			}
		 }
		 System.out.println();
		 
		 System.out.println("Prime factors for 718848" + NumberTheory.getPrimeFactors(718848));
		 System.out.println("Prime factors for 1024" + NumberTheory.getPrimeFactors(1024));
		 
		 
		 System.out.println("Is droll?");
		 System.out.println(NumberTheory.isDroll(48384));
		 System.out.println(NumberTheory.isDroll(72));
		 
		 System.out.println("GetCompositorial(11)");
		 System.out.println(NumberTheory.getCompositorial(11));
		 
		
		 
		 System.out.println("Is Emirp(): " + Primes.isEmirp(13));
		 System.out.println("Is Emirp(): " + Primes.isEmirp(158));
		 
		 
		 System.out.println("=======================");
		 System.out.println("Prime factorization.");
		 int[] a = { 125, 128, 243, 256, 142340};
		 for (int j : a) {			 
			System.out.printf("%d ", j);
			for(int k : NumberTheory.getPrimeFactors(j)) {
				System.out.printf(" %d ", k);
			}
			System.out.println();
		}

		 for(int j: a) {
			System.out.printf("%d %d", NumberTheory.getFirstAndLastDigits(j)[0],
					NumberTheory.getFirstAndLastDigits(j)[1]);			
			System.out.println();
		 }
		 
		int[] b = { 100, 180, 286, 462, 770, 771};
		 for (int j = 0; j < b.length; j++) {
			System.out.printf(" is %d gapful? %b\n", b[j], NumberTheory.isGapful(b[j]));
		}
		 

		 BigInteger f = BigInteger.TWO.pow(2048).add(BigInteger.ONE);
		 System.out.println("biginteger: " + f);
		 
		
//		//int[] c = {1, 2, 6, 28, 140, 270, 496, 672, 1638, 2970, 6200, 8128, 8190, 18600, 18620, 27846, 30240, 32760, 55860, 105664, 117800, 167400, 173600, 237510};
//		 int[] c = {1, 2, 3, 4, 5, 6, 28, 140, 270, 496, 672, 1638, 2970, 6200, 8128, 8190, 18600, 
//				 18620, 27846, 30240, 32760, 55860, 105664, 117800, 167400, 173600, 237510, 242060, 
//				 332640, 360360, 539400, 695520, 726180, 753480, 950976, 1089270, 1421280, 1539720, 
//				 2178540, 2229500, 2290260, 2457000, 2845800, 4358600, 4713984, 4754880, 5772200, 
//				 6051500, 8506400, 8872200, 11981970, 14303520, 15495480, 16166592, 17428320, 18154500, 
//				 23088800, 23569920, 23963940, 27027000, 29410290, 32997888, 33550336, 37035180, 
//				 44660070, 45532800, 46683000, 50401728, 52141320, 56511000, 69266400, 71253000, 
//				 75038600, 80832960, 81695250, 90409410, 108421632, 110583200, 115048440, 115462620, 137891520};
//		for( i = 0; i < c.length; i++) {
//			System.out.printf("%d  %b\n", c[i], NumberTheory.isHarmonicDivisorNumber(c[i]));	
//		}
		
		
//		for (int abc = 1; abc < 20; abc++) {
//			System.out.println(NumberTheory.getHogben(abc));
//		}
		
		

		

		
//		System.out.println("Fibodiv");
//		List<Integer> aList = NumberTheory.getFibonacciLike(549, 54, 9);
//		for (Integer integer : aList) {
//			System.out.println(integer);
//		}
				
//		System.out.println("Is 144 hungry? " + NumberTheory.isHungry(144));
		
		//ProjectEuler.ProjectEuler.main(null);

		System.out.println(LocalMath.BigPI());	
		System.out.println();
		System.out.println(LocalMath.StringPI());
		System.out.println();
		
		System.out.println(NumberTheory.isHungry(240));
		System.out.println(NumberTheory.getReverseNumber(12345));
		
		for (int j = 1; j <= 30; j++) {
			System.out.printf("Motzkin %d %d\n ", j, NumberTheory.getMotzkin(j));	
		}
		
		

		System.out.println("Prime Factors Loop");
		for(int j=10;j<=20; j++) {
			instance.setTheNumber(j);
			System.out.println(j + " " + instance.getPrimeFactors());
		}
		System.out.println();
		
		System.out.println("Lets play with prime factors.");
		System.out.println("60 " + NumberTheory.getPrimeFactors(60));
		
		int[] jArray = {60, 3072, 1029};
		for (int j2 : jArray) {
			System.out.print("simplifiedPrimeFactor(" + j2 + "): ");
			System.out.println(NumberTheory.simplifiedPrimeFactor(NumberTheory.getPrimeFactors(j2)));
		}
		
		System.out.println("IsFrugal: " + NumberTheory.isFrugal(1205));
		
		System.out.println();
		

		
		
		
		System.out.println("Greatest Common Divisor:");
		System.out.println("GCD of 10 and 15: " + NumberTheory.gcd(10, 15));
		System.out.println("GCD of 100 and 15: " + NumberTheory.gcd(100, 15));
		System.out.println("GCD of 100 and 52: " + NumberTheory.gcd(100, 52));
		instance.setTheNumber(100);
		System.out.println("GCD of 100 and 54: " + instance.gcd(54));
		
		System.out.println("LCM of 21 and 6: " + NumberTheory.lcm(21, 6));
		System.out.println("LCM of 4 and 6: " + NumberTheory.lcm(4, 6));
		instance.setTheNumber(13);
		System.out.println("LCM of 3 and 22: " + instance.lcm(22));
		
		BigInteger v = BigInteger.valueOf(9981234567890L);
		System.out.println("GetListOfDigits02");
		System.out.println(NumberTheory.getListOfDigits(v));

		


	/*
	 * Scanner sc = new Scanner(System.in);
	 
	int number2;
	do {
	    System.out.println("Please enter a positive integer!");
	    while (!sc.hasNextInt()) {
	        System.out.println("That's not a positive integer-!");
	        sc.next(); // this is important!
	    }
	    number2 = sc.nextInt();
	} while (number2 <= 0);
	System.out.println("Thank you! Got " + number2);
	}
*/
		System.out.println("Happy Numbers!!!");
		System.out.println("Is 19 happy?" + NumberTheory.isHappy(19));
		System.out.println("Is 2 happy? " + NumberTheory.isHappy(2));
		
		System.out.println("Harmonic Mean");
		System.out.println(LocalMath.harmonicMean(Primes.getFactors(6)));
		System.out.println(LocalMath.harmonicMean(Primes.getFactors(141)));
		
		System.out.println("Powerful Number");
		System.out.println(Primes.isPowerful(20));
		System.out.println(Primes.isPowerful(972));
		for (int j = 1; j < 1001; j++) {
			if(Primes.isPowerful(j)) {
				System.out.printf("%d, ", j);
			}
		}
		
		
		System.out.println("Binary Numbers");
		System.out.println(NumberTheory.getBinary(23));
		
		System.out.println(NumberTheory.isEvil(134));
		System.out.println(NumberTheory.isEvil(23));
		
		
		System.out.println("Highly Composite");
		System.out.println(NumberTheory.isHighlyComposite(7560));
		
		System.out.println("Pernicious");
		
		for (int j = 0; j < 30; j++) {
			//NumberTheory.isPernicious(j);
			if(NumberTheory.isPernicious(j))
				System.out.printf("Is %d\n", j);	
		}
		
		
	
		
//		System.out.println("PerfectPower");
//		for(int j = 0; j < 1000; j++) {
//			if(NumberTheory.isPerfectPower(j))
//				System.out.println(j );
//		}
		
		System.out.println("getAlternatingFactorial");
		System.out.println(NumberTheory.getAlternatingFactorial(50));
		
		System.out.println("Semiprime");
		System.out.println(Primes.isSemiPrime(57));
		System.out.println(Primes.isSemiPrime(73));
		
		System.out.println("DNumber");
		for (int j = 9; j < 11; j++) {
			System.out.printf("%d %b\n", j, NumberTheory.isDNumber(j));	
		}
		
		
}	

	

	
	
	


	
	
}

