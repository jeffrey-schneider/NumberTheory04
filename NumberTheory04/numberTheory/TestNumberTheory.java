package numberTheory;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestNumberTheory {
	public static void main(String[] args) {

		NumberTheory instance = new Primes(19);
		System.out.println("Collatz section");
		System.out.println(instance.getCollatz());
		instance.setTheNumber(27);
		System.out.println(instance.getCollatz());

		instance.setTheNumber(0);
		System.out.println(instance.getCollatz());

		System.out.println("Keith Number");
		System.out.println(NumberTheory.isAKeithNumber(917));

		System.out.println("Catalan Section");
		instance.setTheNumber(20);
		System.out.println("Catalan: " + instance.getCatalan());		
		System.out.println("Catalan: " + NumberTheory.getCatalan(20));
		instance.setTheNumber(52);
		System.out.println("!!!!Factorial of instance " + instance.getFactorial());
		
		
		System.out.printf("Factorial(52): %,d", NumberTheory.getFactorial(52));
		System.out.println();

		System.out.println("Let's do the Fibonacci List");
		System.out.println("Fibonacci List(17): " + NumberTheory.getFibonacciList(17));
		System.out.println("Fibonacci(17): " + Primes.getFibonacci(17));
		
		
		System.out.println("Let's do the Tribonacci List");
		System.out.println("Tribonacci List(56): " + NumberTheory.getTribonacciList(56));
		instance.setTheNumber(15);
		System.out.println("Tribonacci List(): " + instance.getTribonacciList());
		

		System.out.println("Lucas numbers");
		System.out.println("Negative exponent(Math.pow(4.0, -1.0): " + Math.pow(4.0, -1.0));
		System.out.println("Lucas(33) " + NumberTheory.getLucas(33));
		instance.setTheNumber(12);
		System.out.println(instance.getLucas());
		System.out.println(NumberTheory.getJacobsthal(25));

		System.out.println("Alternating Factorials");
		System.out.println(NumberTheory.getAlternatingFactorial(15));

		// a_PointerPrimeTest();

		// getAmicableNumbers();
		System.out.println("Apocalyptic Numbers");
		System.out.println(NumberTheory.isApocalyptic(192));
		System.out.println(NumberTheory.isApocalyptic(0));

		System.out.println("Cake Numbers:");
		int n = 0;
		while (n < 25) {
			System.out.printf("Cake: %d  %d\n", n, NumberTheory.getCakeNumber(n++));
		}

		System.out.println("Lazy Caterer's Numbers:");
		n = 0;
		while (n < 25) {
			System.out.printf("Lazy: %d  %d\n", n, NumberTheory.getLazyCaterer(n++));
		}

		System.out.println("Primitive Abundant");
		n = 12;
		System.out.printf("Is Primitive Abundant? %d %b\n", n, NumberTheory.isPrimitiveAbundant(n));
		n = 10;
		System.out.printf("Is Primitive Abundant? %d %b\n", n, NumberTheory.isPrimitiveAbundant(n));
		
		System.out.println("Bell's numbers");
		n = 0;
		while (n <= 50) {
			System.out.printf("%d  %d\n", n, NumberTheory.getBellNumber(n));
			n++;
		}

		System.out.println("First 50 Admirable Numbers");
		n = 0;
		int counter = 50;
		while (counter > 0) {
			++n;
			if (NumberTheory.isAdmirable(n)) {
				System.out.printf("%d  %d\n", 50 - counter, n);
				counter--;
			}
		}

		System.out.println("First 25 Amenable Numbers");
		n = 0;
		counter = 25;
		while (counter > 0) {
			++n;
			if (NumberTheory.isAmenable(n)) {
				System.out.printf("%d %d\n", 25 - counter, n);
				counter--;
			}
		}

		System.out.println("First 25 Super D Numbers");
		int i = 1;
		counter = 25;
		while (i < 1000) {
			if (NumberTheory.isSuperD(i)) {
				System.out.println(i + " is SuperD. ");
				counter--;
			}
			i++;
			if (counter == 0) {
				break;
			}
		}

		System.out.println("Alternating Numbers");
		for (int N = 129; N < 150; N++) {
			System.out.printf("Is %d alternating? %b\n", N, NumberTheory.isAlternating(N));
		}

		System.out.println("AntiPerfect Numbers");
		int N = 133857;
		System.out.printf("Is %d anti-perfect? %b\n", N, NumberTheory.isAntiPerfect(N));

		System.out.println("Arithmetic Numbers");
		for (int r = 47; r <= 70; r++) {
			System.out.printf("Is %d arithmetic? %b\n", r, NumberTheory.isArithmetic(r));
		}

		System.out.println("Astonishing Numbers");
		int[] n1 = { 15, 429, 428 };
		for (Integer integer : n1) {
			System.out.printf("Is %d astonishing? %b\n", integer, NumberTheory.isAstonishing(integer));
		}

		System.out.println("Automorphic Numbers");
		long[] n2 = { 1, 5, 6, 25, 76, 376, 625, 9376, 90625, 109376, 890625, 2890625, 7109376, 12890625 };
		for (Long longNumber : n2) {
			System.out.printf("Is %d automorphic? %b\n", longNumber, NumberTheory.isAutomorphic(longNumber));
		}

		System.out.println("Non Trivial Divisors");
		List<Integer> theList = NumberTheory.getNonTrivialDivisors(60);
		for (Integer integer : theList) {
			System.out.println(integer);
		}

		System.out.println("Canadian Numbers");
		int[] n3 = { 125, 581, 8549, 16999 };
		for (int j : n3) {
			System.out.printf("%d is Canada number? %b\n", j, NumberTheory.isCanadaNumber(j));
		}
		n3 = null;

		System.out.println("Pell List ");
		int x = 100;
		System.out.println("NumberTheory.getPellList()" + NumberTheory.getPellList(x));

		for (x = 1; x <= 100; x++) {
			System.out.println(x + " == " + NumberTheory.getPell(x));
		}

		System.out.println("Balanced Prime");
		int[] n4 = { 5, 53, 153, 157 };
		for (int j : n4) {
			System.out.printf("\nIs %d a balanced prime? %b", j, NumberTheory.isBalancedPrime(j));
		}

		System.out.println("Interprime Number");
		System.out.println();
		int[] n5 = { 4, 6, 9, 12, 15, 18, 21, 26, 30, 34, 39, 42, 45, 50, 56, 60, 64, 69, 72, 76, 81, 86, 93, 99, 102,
				105, 108, 111, 120, 121 };
		for (int j : n5) {
			System.out.printf("\nIs %d a interprime? %b", j, Primes.isInterPrime(j));
		}

		System.out.println("\nCentered Polygonal Numbers: ");
		for (int j = 3; j < 50; j++) {
			System.out.printf("Sides: %d -> ", j);
			for (i = 0; i <= 20; i++) {
				System.out.printf(" %2d ", NumberTheory.getCenteredPolygonalNumber(j, i));
			}
			System.out.println();
		}

		System.out.printf(" %2d ", NumberTheory.getCenteredPolygonalNumber(3, 2));
		System.out.printf(" %2d ", NumberTheory.getCenteredPolygonalNumber(14, 20));
		System.out.println();

		System.out.println("---Polygonal Numbers.");
		for (int outer = 2; outer <= 24; outer++) {
			System.out.printf(" %d ", outer);
			for (int inner = 1; inner <= 10; inner++) {
				System.out.printf(" %.0f ", NumberTheory.getPolygonalNumber(outer, inner));
			}
			System.out.println();
		}

		System.out.println("---Number -> Factorials -> Primorials");
		for (i = 0; i <= 25; i++) {
			System.out.printf("%d -> %,d / %,d\n", i, NumberTheory.getFactorial(i), NumberTheory.getPrimorials(i));
		}

		System.out.println("---Co primes. ");
		System.out.println("Are 18 and 35 CoPrimes? " + Primes.isCoPrime(18, 35));

		System.out.println("---Cubic Numbers");
		for (i = 0; i <= 25; i++) {
			System.out.printf(" %d ", NumberTheory.getCube(i));
		}

		System.out.println("\n---Cullen Numbers");
		for (i = 0; i <= 100; i++) {
			System.out.printf(" %d ", NumberTheory.getCullen(i));
		}

		System.out.println("\n---Curzon numbers");
		List<Integer> curzonList = new LinkedList<>(); // LinkedList? Why not?
		for (i = 1; i <= 300; i++) {
			if (NumberTheory.isCurzon(i)) {
				curzonList.add(i);
			}
		}
		System.out.println(curzonList);

		System.out.println("---Euler's totient Function for 75");
		i = 75;
		System.out.println("GetTotativesList(i): " + NumberTheory.getTotativesList(i));
		System.out.println("Eulers Totient(i): " + NumberTheory.getEulersTotient(i));

		System.out.println("---Cyclic Numbers:");
		for (i = 1; i <= 150; i++) {
			if (NumberTheory.isCyclic(i)) {
				System.out.printf("%d ", i);
			}
		}
		System.out.println();

		System.out.println("---de Polignac Numbers:");
		for (i = 1; i <= 1000; i++) {
			if (NumberTheory.isDePolignac(i)) {
				System.out.printf("%d ", i);
			}
		}
		System.out.println();

		System.out.println("Prime factors for 718848" + Primes.getPrimeFactors(718848));
		System.out.println("Prime factors for 1024" + Primes.getPrimeFactors(1024));

		System.out.println("Is droll?");
		System.out.println("48384 "+ NumberTheory.isDroll(48384));
		System.out.println("72 " + NumberTheory.isDroll(72));
		System.out.println("720 " +  NumberTheory.isDroll(720));

		System.out.println("GetCompositorial(11)");
		System.out.println(NumberTheory.getCompositorial(11));

		System.out.println("Is Emirp(): " + Primes.isEmirp(13));
		System.out.println("Is Emirp(): " + Primes.isEmirp(158));

		System.out.println("=======================");
		System.out.println("Prime factorization.");
		int[] a = { 125, 128, 243, 256, 142340 };
		for (int j : a) {
			System.out.printf("%d ", j);
			for (int k : Primes.getPrimeFactors(j)) {
				System.out.printf(" %d ", k);
			}
			System.out.println();
		}

		for (int j : a) {
			System.out.printf("%d %d", NumberTheory.getFirstAndLastDigits(j)[0],
					NumberTheory.getFirstAndLastDigits(j)[1]);
			System.out.println();
		}

		int[] b = { 100, 180, 286, 462, 770, 771 };
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


		// ProjectEuler.ProjectEuler.main(null);

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

		Primes thePrimeInstance = new Primes();

		for (int j = 10; j <= 20; j++) {

			thePrimeInstance.setTheNumber(j);
			System.out.println(j + " " + thePrimeInstance.getPrimeFactors());
		}
		System.out.println();

		System.out.println("Lets play with prime factors.");
		System.out.println("60 " + Primes.getPrimeFactors(60));

		int[] jArray = { 60, 3072, 1029 };
		for (int j2 : jArray) {
			System.out.print("simplifiedPrimeFactor(" + j2 + "): ");
			System.out.println(NumberTheory.simplifiedPrimeFactor(Primes.getPrimeFactors(j2)));
		}

		System.out.println("IsFrugal: " + NumberTheory.isFrugal(1205));

		System.out.println();

		System.out.println("Greatest Common Divisor:");
		long bb = Long.valueOf(20);
		long cc = Long.valueOf(33);
		
		System.out.println("GCD of 20 and 33: " + NumberTheory.gcd(bb, cc));
		System.out.println("GCD of 10 and 15: " + NumberTheory.gcd(10, 15));
		System.out.println("GCD of 100 and 15: " + NumberTheory.gcd(100, 15));
		System.out.println("GCD of 100 and 52: " + NumberTheory.gcd(100, 52));
		instance.setTheNumber(100);
		System.out.println("GCD of 100 and 54: " + instance.gcd(54));
		
		
		List<Integer> theList1 = new ArrayList<>(Arrays.asList(10, 15, 50, 8));
		int gcdList = NumberTheory.findGCD(theList1);
		for (Integer integer : theList1) {
			System.out.print(integer + " ");
		}
		System.out.println(" GCD of list: " + gcdList);

		System.out.println("LCM of 21 and 6: " + NumberTheory.lcm(21, 6));
		System.out.println("LCM of 4 and 6: " + NumberTheory.lcm(4, 6));
		instance.setTheNumber(13);
		System.out.println("LCM of 3 and 22: " + instance.lcm(22));

		BigInteger v = BigInteger.valueOf(9981234567890L);
		System.out.println("GetListOfDigits02");
		System.out.println(NumberTheory.getListOfDigits(v));

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * int number2; do { System.out.println("Please enter a positive integer!");
		 * while (!sc.hasNextInt()) {
		 * System.out.println("That's not a positive integer-!"); sc.next(); // this is
		 * important! } number2 = sc.nextInt(); } while (number2 <= 0);
		 * System.out.println("Thank you! Got " + number2); }
		 */
		System.out.println("---Happy Numbers!!!");
		System.out.println("Is 19 happy?" + NumberTheory.isHappy(19));
		System.out.println("Is 2 happy? " + NumberTheory.isHappy(2));

		System.out.println("---Harmonic Mean");
		System.out.println(LocalMath.harmonicMean(Primes.getFactors(6)));
		System.out.println(LocalMath.harmonicMean(Primes.getFactors(141)));

		System.out.println("---Powerful Number");
		System.out.println(Primes.isPowerful(20));
		System.out.println(Primes.isPowerful(972));
		for (int j = 1; j < 1001; j++) {
			if (Primes.isPowerful(j)) {
				System.out.printf("%d, ", j);
			}
		}

		System.out.println("---Binary Numbers");
		System.out.println(NumberTheory.getBinary(23));

		System.out.println(NumberTheory.isEvil(134));
		System.out.println(NumberTheory.isEvil(23));

		System.out.println("---Highly Composite");
		System.out.println(NumberTheory.isHighlyComposite(7560));

		System.out.println("---Pernicious");

		for (int j = 0; j < 30; j++) {
			// NumberTheory.isPernicious(j);
			if (NumberTheory.isPernicious(j))
				System.out.printf("Is %d\n", j);
		}

//		System.out.println("PerfectPower");
//		for(int j = 0; j < 1000; j++) {
//			if(NumberTheory.isPerfectPower(j))
//				System.out.println(j );
//		}

		System.out.println("---getAlternatingFactorial");
		System.out.println(NumberTheory.getAlternatingFactorial(50));

		System.out.println("---Semiprime");
		System.out.println(Primes.isSemiPrime(57));
		System.out.println(Primes.isSemiPrime(73));

		System.out.println(Math.abs(-324.0));

		System.out.println("---Hungry Numbers");
		System.out.println("Is 144 hungry? " + NumberTheory.isHungry(144));

		economicalTest();

//		//if( v == 250 || v == 25600 || v == 262144)
//		System.out.println("Enlightened: 250    " + NumberTheory.isEnlightened(250));
//		System.out.println("Enlightened: 25600  " + NumberTheory.isEnlightened(25600));
//		
//		
//		System.out.println("---Amicable Numbers");
//		System.out.println("Is 220 Amicable? " + NumberTheory.getAmicableNumber(220));
//		System.out.println("Is 284 Amicable? " + NumberTheory.getAmicableNumber(284));		

//		navigationTest();
//		fiboDiv();
		isCarmichaelNumbers(instance);
		dNumberTest();
		dPowerfulTest();
		isGildaTest(instance);
		isGiugaTest();

		someWorkInProgress(BigInteger.TWO);

		
		System.out.println("Saint Exupery");
		List<Long> SaintExuperyList = NumberTheory.getSaintExupery(20);
		for (Long long1 : SaintExuperyList) {
			System.out.print(long1 + " " );
		}
		
		
		
		
		
		System.out.println("Perrin Numbers");
		for (int a1 = 0; a1 < 20; a1++) {
			System.out.printf("%d ", NumberTheory.getPerrin(a1));
		}

		System.out.println("\nCunningham numbers");
		for (int a1 = 0; a1 < 50; a1++) {
			if (NumberTheory.isCunningham(a1))
				System.out.printf("%d ", a1);
		}

		System.out.println("\nEnlightened Numbers");
		x = 2500;
		long xx = 2377970784L;
		xx = 119911L;
		System.out.println("Is " + xx + " enlightened? " + NumberTheory.isEnlightened(xx));

//		System.out.println("\nEsthetic");
//		for( i = 0; i <= 10000; i++) {
//			if( NumberTheory.isEsthetic(i)) {
//				System.out.printf(" %d, ", i);
//			}
//		}

		System.out.println("\nEulerian");
		n = 9;
		for (n = 1; n <= 10; n++) {
			for (int m = 0; m <= n; m++) {
				System.out.printf("%d %d %d\n", n, m, NumberTheory.getEulerian(n, m));
			}
			System.out.println();
		}

		System.out.println("\nHoax Numbers ");
		for (n = 1; n <= 1200; n++) {
			if (NumberTheory.isHoaxNumber(n)) {
				System.out.println(n);
			}
		}
		
		System.out.println("\nReverse BigInteger ");
		BigInteger test = BigInteger.valueOf(123456);
		System.out.println(NumberTheory.reverseBigInteger(test));
		
		System.out.println("Let's do the iccanobiF");				
	     
        List<BigInteger> theFibList = NumberTheory.iccanobiFNumbers(30);
        for (BigInteger bigInteger : theFibList) {
			System.out.printf("%d ", bigInteger);
		}
        System.out.println();
				
        
        System.out.println("Betrothed: ");
        x = 48;
        System.out.println(NumberTheory.getBetrothedNumber(x)); 
        
        System.out.println("\nPolite: ");
        x = 256;
        System.out.println(NumberTheory.getPoliteness(x));
        System.out.println(NumberTheory.isImpolite(x));
        
        System.out.println("Honaker numbers:");        
        System.out.println(NumberTheory.isHonakerPrime(1041));
        int[] integerArray = { 131, 263, 457, 1039, 1049, 1091, 1301, 1361, 1433, 1571, 1913, 1933, 2141, 2221, 2273, 2441, 2591, 2663, 2707, 2719, 2729, 2803, 3067, 3137, 3229, 3433, 3559, 3631, 4091, 4153, 4357, 4397, 4703, 4723, 4903, 5009, 5507, 5701, 5711, 5741, 5801, 5843, 5927, 6301, 6311, 6343, 6353, 6553, 6563, 6653, 6737, 6827, 6971, 7013, 7213, 7283, 7411, 7481, 7523, 7741, 8011, 8821, 9103, 10247, 10429, 10559};
        for (Integer j : integerArray) {
			System.out.printf("%d %b\n", j , NumberTheory.isHonakerPrime(j));
		}      
        
        System.out.println("Inconsummate numbers");
        NumberTheory.getInconsummate();
        
        
        int[] vv = {796, 805};
        
        for (int j : vv) {
        	System.out.printf("%d %d\n", j, NumberTheory.getGenerator(j));	
		}
        
        
        System.out.println("Junction Numbers ");
        List<Integer> junctionNumbers = NumberTheory.getJunctionNumbers(109);
        for (Integer integer : junctionNumbers) {
			System.out.println(integer);
		}
		
		       
        
		System.out.println("Kaprekar Number");
		for(int j = 1; j <= 1000; j++) {
			if(NumberTheory.isKaprekar(j)) {
				System.out.println(j);
			}
		}
		
		System.out.println("Leyland: ");
		List<Long> leyland = NumberTheory.getLeyland(10);
		for (Long longN : leyland) {
			System.out.printf("%d ", longN);
		}
		System.out.println();
	 
		System.out.println("Lonely Number");
		List<Integer> lonelyNumberList = new LinkedList<>();
		lonelyNumberList.addAll(Primes.getLonelyNumber(20000));
		
		for (Integer integer : lonelyNumberList) {
			System.out.println(integer);
		}
		
		
		System.out.println("Hyperperfect Numbers");
		int k = 1;
		for(int cnt = 1; cnt <= 1000; cnt++) {			
			if(NumberTheory.isHyperPerfect(cnt, k)) {
				System.out.println(cnt);
			}
		}
		
		
		System.out.println("Lucky Numbers:");
		List<Integer> luckyList = NumberTheory.getLuckyNumber(250);
		for (Integer integer : luckyList) {
			System.out.printf("%d, ", integer);
		}
		System.out.println();
		
		
		System.out.println("getTotativesList(24)");
		System.out.println(NumberTheory.getTotativesList(24));
		instance.setTheNumber(24);
		System.out.println(instance.getTotativesList());
		
		System.out.println("getTotatives(24)");
		System.out.println(NumberTheory.getTotatives(24));
		System.out.println(instance.getTotatives());	
		
		
		
		//Smooth number
		System.out.println("Smooth Number Methods:");
		// https://en.wikipedia.org/wiki/Smooth_number
		// 15750 is 7 smooth
		System.out.println(Primes.getPrimeFactors(15750));
		
		// 702 is 13 smooth
		System.out.println(Primes.getPrimeFactors(702));
		
		System.out.println(Primes.getPrimeFactors(1620));
		
		int testSmooth = 13;
		int testVal = 702;
		System.out.println("Is " + testVal + " "+ testSmooth + "-smooth "+ Primes.isNSmooth(testVal, testSmooth));
		
		int testV = 104;
		int testN = 13;
		System.out.printf("Is %,d divisible by %d?  %b\n", testV, testN, NumberTheory.isDivisibleBy(testV, testN));
		instance.setTheNumber(18);
		System.out.printf("Is %,d divisible by %d?  %b\n", testV, instance.getTheNumber(), instance.isDivisibleBy(testN));
		
		//How many 3 digit numbers are divisible by 13?		
		
		testV = 17;
		System.out.printf("Is %,d a Pierpont Prime? %b\n", testV, Primes.isPierpontPrime(testV));
		Primes primeTest = new Primes(9);
		System.out.println(primeTest.isPierpontPrime());
		primeTest.setTheNumber(13);
		System.out.println(primeTest.isPierpontPrime());
		
		for(i = 3; i< 10_000; i++)
		{
			if(Primes.isPierpontPrime(i))
				System.out.print(i + " ");		
		}
		System.out.println();
			
		
		System.out.println("Katadrome");
		int[] array = { 43210, 76521, 9630, 5465};
		for (int j : array) {
			System.out.println(j + " " + NumberTheory.isKatadrome(j));
		}
		
		for( i = 1; i <= 50; i++) {
			if(NumberTheory.isKatadrome(i))
				System.out.println(i);
		}	
		
		instance.setTheNumber(76521);
		System.out.println(instance.getTheNumber() + " " + instance.isKatadrome());
		
		System.out.println("Metadrome");
		int[] array2 = { 28, 29, 34, 234579, 345687 };
		for(int j : array2) {
			System.out.println(j + " " + NumberTheory.isMetadrome(j));	
		}
		
		
		
		
		System.out.println("Lynch-Bell Numbers");
		
		array = new int[] { 12,15,24,36,48, 136, 9867312};
		for(int j : array) {
			System.out.println(j + " " + NumberTheory.isLynchBell(j));	
		}
		
		System.out.println("Magic Square Constants");
		System.out.println(NumberTheory.getMagicSquareConstant(3));
		System.out.println(NumberTheory.getMagicSquareConstant(4));
		
		
		System.out.println("Magnanimous Numbers");
		System.out.println(NumberTheory.isMagnanimous(4001));
		System.out.println(NumberTheory.isMagnanimous(22));
		
		System.out.println("Testing for modest numbers: 2851111  % 1111 = " + (2851111 % 1111));
		System.out.println("Testing for modest numbers: 46  % 6 = " + (46 % 6));
		
		
		System.out.println("Testing for Moran numbers");
		System.out.println(NumberTheory.isMoran(21036));
		
		System.out.println("Testing for Narcissistic numbers");
		System.out.println(NumberTheory.isNarcissistic(912985153));
		
		
		System.out.println("Testing for Nude numbers.");
		System.out.println(NumberTheory.isNude(672));
		System.out.println(NumberTheory.isNude(883416));
		System.out.println(NumberTheory.isNude(883417));		
		
		
		System.out.println("Testing for Poulet numbers.");
		int[] abc = {341, 561, 1105, 6601, 4681, 4682, 6135585, 612};
		for (int j : abc) {
			System.out.println(j + " " + NumberTheory.isPoulet(j));
		}
		
		System.out.println("Testing Perfect Primes");
		System.out.println("In process");
		//NumberTheory.getPerfectPowers(20,30);
		
		List<Integer> pronicList = NumberTheory.getPronic(100, 40);
		for (Integer integer : pronicList) {
			System.out.println(integer);
		}
		
		int pronicInt = NumberTheory.getPronic(100);
		System.out.println(pronicInt);
		
		
		System.out.println("Testing Deceptive:");
		x = 259;
		System.out.println(x + " " + NumberTheory.isDeceptive(x));
		
		
		System.out.println("Testing Pronic Numbers");
		x = 600;  //650  355812, 357006  are pronic
		
		int[] xArray = {6, 650, 355812, 357006, 620 }; //620 is not pronic
		for (int j : xArray) {
			System.out.println(+ j + " " + NumberTheory.getFactors(j) + " " + NumberTheory.isPronic(j));	
		}
		xArray = null;
		
		
		System.out.println("Testing Proth Numbers");
		List<Integer> xList = Arrays.asList(3, 4, 6, 8, 5, 9, 12, 13, 17, 25, 33, 417,448, 449,481,513,801);
		for (Integer integer : xList) {			
			System.out.println(integer + " " + NumberTheory.isProthNumber(integer));
		}
		
		
		System.out.println();
		System.out.println("Testing Sphenic Numbers");
		List<Integer> xList2 = Arrays.asList(30,42,66,70,78,282,285,286,287);
		for (Integer integer : xList2) {			
			System.out.println(integer + " " + NumberTheory.isSphenic(integer));
		}
		
		
		System.out.println("Sastry Numbers");
		System.out.println(NumberTheory.isSastry(184L));		
		System.out.println(NumberTheory.isSastry(996225356413048L));
		
		System.out.println("IsRare");
		List<Long> longList = Arrays.asList(65L, 621770L, 66L, 281089082L);
		for(Long longNumber : longList) {
			System.out.print(longNumber + " " );
			System.out.println(NumberTheory.isRare(longNumber));
		}		
		
		System.out.println(NumberTheory.getRepUnit(10));
		System.out.println(NumberTheory.isPalindromic(7821287l));
		System.out.println(NumberTheory.isPalPrime(1114111));
		
		
		
		System.out.println("\n\nisOrmiston");
		List<Integer> intList = Arrays.asList(1913, 1931, 18379, 18397, 19013, 19031, 25013, 25031, 34613, 34631, 35617);
		HashMap<Integer, Integer> theAnswers = new HashMap<>();		
		for(Integer intNumber : intList) {
			theAnswers.putAll(NumberTheory.getOrmiston(intNumber));			
		}
		
		Iterator<Map.Entry<Integer, Integer>> itr2 = theAnswers.entrySet().iterator();
		while(itr2.hasNext()) {
			Map.Entry<Integer, Integer> entry = itr2.next();
			if(entry.getValue() != null)
				System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
	
		
		String convertMe = "1200";
		String converted = "";
		int baseFrom = 10;
		int baseTo = 2;
		
		for(int abcd = 2; abcd <= 18; abcd++) {
			converted = NumberTheory.convertFromBaseToBase(convertMe, baseFrom, abcd);
			System.out.printf("%s converted from base: %d to base: %d is %s\n", convertMe, baseFrom, abcd, converted);
		}
	
		//Friedman numbers:
		int limit = 1000; // Change this to the desired limit
        List<Integer> friedmanNumbers = NumberTheory.findFriedmanNumbers(limit);
        System.out.println("Friedman numbers up to " + limit + ":");
        for (Integer number : friedmanNumbers) {
            System.out.println(number);
        }	
        
        System.out.println(NumberTheory.isFriedmanNumber(25));
        
        
        System.out.println("Is 99 a trimorphic number?");
        System.out.println(NumberTheory.isTrimorphic(759918212890625L));
        
        System.out.println(NumberTheory.isTruncatablePrime(1825711, "both"));
        
        System.out.println(NumberTheory.parseNumberToList(123456));
        
        int count = 40;
        System.out.printf("Is %,d semiperfect? %b", count, NumberTheory.isSemiPerfect(count));
        
        
		System.out.println("\nFin");
		
	}//end of main







	



	

	

	/**
	 * @param v
	 */
	static void someWorkInProgress(BigInteger v) {
		int x;
		// In progress
		x = 5464;
		List<Integer> thisList = Primes.getListOfDigits(v);
		int summaryDigits = NumberTheory.getSumOfDigits(Primes.getListOfDigits(x));

		HashSet<Integer> thisSet = Primes.getDistinctPrimeFactors(x);
		List<Integer> anotherList = new LinkedList<Integer>();
		anotherList.addAll(thisSet);
		int summaryPrimeFactors = NumberTheory.getSumOfDigits(anotherList);

		System.out.printf("Summary: %d  %d ", summaryDigits, summaryPrimeFactors);
		System.out.println();
	}

	/**
	 * 
	 */
	static void isGiugaTest() {
		System.out.println("Giuga Test One");
		int[] theArray = { 30, 858, 1722, 1723, 66198 };
		for (int i1 = 0; i1 < theArray.length; i1++) {
			System.out.println(theArray[i1] + " " + NumberTheory.isGiuga(theArray[i1]));
		}

		System.out.println("Giuga Test Two");
		for (int j = 850; j < 870; j++) {
			if (NumberTheory.isGiuga(j))
				System.out.println(j);
		}
		System.out.println();
	}

	/**
	 * @param instance
	 */
	static void isGildaTest(NumberTheory instance) {
		System.out.println("---Gilda Numbers:");
		int[] i1 = { 29, 30, 49, 78, 110, 152, 220, 314, 38006, 933138 };
		for (int j : i1) {
			System.out.println("Is " + j + " Gilda?" + NumberTheory.isGilda(j));
		}
		instance.setTheNumber(35422);
		System.out.println("\nIs " + instance.getTheNumber() + " Gilda?" + instance.isGilda());
	}

	/**
	 * @param instance
	 */
	static void isCarmichaelNumbers(NumberTheory instance) {
		System.out.println("Carmichael Numbers");
		instance.setTheNumber(6601);
		System.out.println(NumberTheory.isCarmichael(561));
		System.out.println(NumberTheory.isCarmichael(1105));
		System.out.println(NumberTheory.isCarmichael(15841));
		System.out.println(instance.isCarmichael());
	}

	/**
	 * 
	 */
	static void dNumberTest() {
		System.out.println("---DNumber");
		for (int i = 9; i < 500; i++) {
			if (NumberTheory.isDNumber(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	static void dPowerfulTest() {
		System.out.println("---DPowerful");
		int i = 3459872;
		System.out.println(i + " " + NumberTheory.isDPowerful(i));
	}

	/**
	 * 
	 */
	static void economicalTest() {
		System.out.println("---isEconomical");
		System.out.println("1655 " + NumberTheory.isEconomical(1655));
		System.out.println("3072 " + NumberTheory.isEconomical(3072));
		System.out.println("12 " + NumberTheory.isEconomical(12));
		System.out.println("13 " + NumberTheory.isEconomical(13));
		System.out.println("14 " + NumberTheory.isEconomical(14));
		System.out.println("997 " + NumberTheory.isEconomical(997));
		System.out.println("108749 " + NumberTheory.isEconomical(108749));
	}

	static void esthetic() {
		System.out.println("--isEsthetic");
		System.out.println("76 " + NumberTheory.isEsthetic(76));
	}

	
	
	

	
	
	
	/**
	 * 
	 */
	static void navigationTest() {
		System.out.println("\nLet's play with Navigation!");
		Point KansasCity = new Point(-94.581213, 39.099912, "Kansas City");
		Point StLouis = new Point(-90.200203, 38.627089, "St. Louis");
		System.out.print(KansasCity.getLocation() + " to " + StLouis.getLocation() + " Distance: ");
		System.out.print(KansasCity.distance(StLouis) + " kilometers. ");
		System.out.println(" Initial Bearing: " + KansasCity.initialBearing(StLouis));

		System.out.println();
		Point source = new Point(-85.3094, 35.0458, "Chattanooga");
		Point target = new Point(-86.7816, 36.1627, "Nashville");
		System.out.print(source.getLocation() + " to " + target.getLocation() + " Distance: ");
		System.out.println(source.distance(target));
		System.out.println("Initial Bearing: " + source.initialBearing(target));
		System.out.println("Final Bearing: " + source.finalBearing(target));
		Point midPoint = source.midpoint(target);
		System.out.println(midPoint.getLocation() + " " + midPoint.getLongitude() + " " + midPoint.getLatitude());

		Point endPoint = source.getEndPoint(313.0, 182.0);
		System.out.println("End point " + endPoint);
	}

	/**
	 * 
	 */
	static void fiboDiv() {
		System.out.println("Fibodiv");
		int v = 549;
		System.out.println(NumberTheory.isFiboDiv(v));
		v = 23418;
		System.out.println(NumberTheory.isFiboDiv(v));
	}
	
	

}
