package numberTheory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.BooleanSupplier;

/**
 * 
 * @author JeffreySchneider
 *
 */
public class Primes extends NumberTheory {

	/**
	 * Single argument constructor	 * 
	 * @param theNumber the number
	 */
	public Primes(int theNumber) {
		super(theNumber);
	}

	/**
	 * Zero argument constructor
	 */
	public Primes() {
		super();
	}

	/**
	 * In mathematics, a semiprime is a natural number that is the
	 *         product of exactly two prime numbers.
	 * @author JCSchneider
	 * @param v the number
	 * @return boolean this number is semi-prime.
	 * 
	 * @see #getPrimeFactors(int) getPrimeFactors
	 * 
	 */
	public static boolean isSemiPrime(int v) {
		List<Integer> anotherList = Primes.getPrimeFactors(v);
		return (anotherList.size() == 2);
	}

	boolean isSemiPrime() {
		return isSemiPrime(getTheNumber());
	}

	/**
	 * A semiprime 'p * q' for which 'p' and 'q' have the
	 *         same number of digits is called brilliant number.
	 *         
	 * @author JCSchneider
	 * @param v the number
	 * @return Is this number is brilliant?
	 * 
	 * 
	 * @see #getPrimeFactors(int) getPrimeFactors 
	 * @see #isSemiPrime(int) isSemiPrime
	 */
	public static boolean isBrilliant(int v) {
		List<Integer> theList = Primes.getPrimeFactors(v);
		if (isSemiPrime(v)) {
			int count1 = 0, count2 = 0;
			int number = theList.get(0);
			// Here we count digits in the number.
			while (number != 0) {
				number /= 10;
				++count1;
			}
			number = theList.get(1);
			while (number != 0) {
				number /= 10;
				++count2;
			}
			if (count1 == count2) {
				return true;
			}
		}
		return false;
	}

	boolean isBrilliant() {
		return isBrilliant(getTheNumber());
	}

	/**
	 * A number is called emirpimes if it is a semiprime and if its reverse is a
	 * different semiprime, thus excluding palindromic semiprimes.
	 * 
	 * @author JCSchneider
	 * @param v the number
	 * @return Is this number emirpimeses?
	 * 
	 * @see #isSemiPrime(int) isSemiPrime 
	 * @see NumberTheory#getReverseNumber(int) getReverseNumber()
	 * @see #getPrimeFactors(int) getPrimeFactors() 
	 */
	public static boolean isEmirpimeses(int v) {
		return isSemiPrime(v) && isSemiPrime(getReverseNumber(v));
	}

	boolean isEmirpimeses() {
		return isEmirpimeses(getTheNumber());
	}

	/**
	 * A prime number p is called a Chen prime if p + 2 is either a
	 *         prime or a product of two primes (also called a semiprime).
	 * @author JeffreySchneider
	 * @param v the number
	 * @return Is this number a Chen prime?
	 *
	 * @see NumberTheory#isPrime(int) isPrime() 
	 * @see #isSemiPrime(int) isSemiPrime()
	 * @see #getPrimeFactors(int) getPrimeFactors()
	 */
	public static boolean isChenPrime(int v) {
		if (isPrime(v)) {
			return (isPrime(v + 2) || isSemiPrime(v + 2));
		}
		return false;
	}

	boolean isChenPrime() {
		return isChenPrime(getTheNumber());
	}

	/**
	 * <P>
	 * A good prime is a prime number whose square is greater than the product of
	 * any two primes at the same number of positions before and after it in the
	 * sequence of primes. To solve this, create a list of primes from zero to 3x
	 * the number. Iterate pointers forwards and backwards in matching jumps through
	 * list.
	 * </P>
	 * 
	 * @author JeffreySchneider
	 * @param v	the number to check
	 * @return boolean 
	 */
	public static boolean isGoodPrime(int v) {
		List<Integer> thePrimeList = new LinkedList<>();
		if (!isPrime(v)) {
			return false;
		} else {
			// Create a list of prime numbers up to 3 times aNumber.
			for (int i = 2; i <= v * 3; i++) {
				if (isPrime(i)) {
					thePrimeList.add(i);
				}
			}
		}

		int small = 0;
		int large = 0;
		if (thePrimeList.contains(v)) {
			int ndx = thePrimeList.indexOf(v);
			for (int ndxCounter = 1; ndxCounter < ndx; ndxCounter++) {
				small = thePrimeList.get(thePrimeList.indexOf(v) - ndxCounter);
				large = thePrimeList.get(thePrimeList.indexOf(v) + ndxCounter);
				if ((v * v) < (small * large)) {
					return false;
				}
			}
		}
		return true;
	}

	boolean isGoodPrime() {
		return isGoodPrime(getTheNumber());
	}

	/**
	 * An emirp (prime spelled backwards) is a prime number that
	 *         results in a different prime when its decimal digits are reversed.
	 *         This definition excludes this related palindrome primes.
	 * @author JeffreySchneider
	 * @param v the number
	 * @return Is number an emirp?
	 * 
	 * @see #isPrime() isPrime
	 * @see NumberTheory#getReverseNumber() getReverseNumber()
	 * @see #getPrimeFactors(int) getPrimeFactors()
	 */
	public static boolean isEmirp(int v) {
		return (NumberTheory.isPrime(v) && NumberTheory.isPrime(NumberTheory.getReverseNumber(v)));
	}

	boolean isEmirp() {
		return isEmirp(getTheNumber());
	}

	/**
	 * {@code A prime number  'p'  is called a-pointer if the next prime number can be obtained 
	 * adding  'p'  to its sum of digits (here the 'a' stands for additive).
	 * For example, 293 is an a-pointer prime since the next prime is equal to 293 + 2 + 9 + 3 = 307.}
	 * @param v the number
	 * @return Is this number an A-Pointer prime?
	 * 
	 * @see NumberTheory#isPrime() isPrime()
	 * @see #getPrimeFactors(int) getPrimeFactors
	 */
	public static boolean isA_PointerPrime(int v) {
		if (!NumberTheory.isPrime(v)) {
			return false;
		} else {
			Stack<Integer> theStack = new Stack<>();
			int number = v;
			theStack.push(v);
			while (number > 0) {
				theStack.push(number % 10);
				number /= 10;
			}
			int nextNumber = 0;
			while (!theStack.isEmpty()) {
				nextNumber += theStack.pop();
			}
			if (NumberTheory.isPrime(nextNumber))
				return true;
			return false;
		}
	}

	boolean isA_PointerPrime() {
		return Primes.isA_PointerPrime(getTheNumber());
	}

	
	/**
	 * {@code A prime number  'p'  is called m-pointer if the next prime number can be obtained 
	 * adding  'p'  to its product of digits (here the 'm' stands for multiplicative).
	 * For example, 1231 is a m-pointer prime since the next prime is equal to 1231 + 1 ⋅ 2 ⋅ 3 ⋅ 1= 1237.}
	 * @param v  the number
	 * @return Is this number an M-Pointer prime?
	 * 
	 * @see NumberTheory#isPrime() isPrime()
	 */
	public static boolean isM_PointerPrime(int v) {
		if (!NumberTheory.isPrime(v)) {
			return false;
		} else {
			Stack<Integer> theStack = new Stack<>();
			int number = v;
			theStack.push(v);
			while (number > 0) {
				theStack.push(number % 10);
				number /= 10;
			}
			int nextNumber = 0;
			while (!theStack.isEmpty()) {
				nextNumber *= theStack.pop();
			}
			if (NumberTheory.isPrime(nextNumber))
				return true;
			return false;
		}
	}

	boolean isM_PointerPrime() {
		return Primes.isM_PointerPrime(getTheNumber());
	}

	/**
	 * An interprime number is a composite that is the average of two consecutive
	 * primes.
	 * 
	 * For example, 21 is an interprime since it is the average of the two
	 * consecutive primes 19 and 23.
	 * 
	 * @author JeffreySchneider
	 * @param v the number
	 * @return  Is this number an interprime?
	 * 
	 * @see NumberTheory#isPrime() isPrime()
	 */
	public static boolean isInterPrime(int v) {
		if (isPrime(v)) {
			return false;
		}
		int theArray[] = { 0, 0 };
		int counter = v - 1;
		while (counter > 0) {
			if (isPrime(counter)) {
				theArray[0] = counter;
				break;
			}
			counter--;
		}
		counter = v;
		while (counter < v * 2) {
			if (isPrime(counter)) {
				theArray[1] = counter;
				break;
			}
			counter++;
		}
		return (theArray[0] + theArray[1]) / 2 == v;
	}

	boolean isInterPrime() {
		return Primes.isInterPrime(getTheNumber());
	}

	/**
	 * Returns an integer list of a number's prime factors.
	 * 
	 * @param v the number
	 * @return List of Prime Factors
	 */
	public static List<Integer> getPrimeFactors(int v) {
		List<Integer> retVal = new ArrayList<>();
		int ourNumber = v;
		for (int i = 2; i <= v; i++) {
			while (ourNumber % i == 0) {
				retVal.add(i);
				ourNumber /= i;
			}
		}
		return retVal;
	}

	
	/**
	 * Returns an long list of a number's prime factors.
	 * @param v a long
	 * @return List of long prime factors 
	 */
	public static List<Long> getPrimeFactors(long v) {
		List<Long> retVal = new ArrayList<>();
		long ourNumber = v;
		for (long i = 2; i <= v; i++) {
			while (ourNumber % i == 0) {
				retVal.add(i);
				ourNumber /= i;
			}
		}
		return retVal;
	}

	List<Integer> getPrimeFactors() {
		return getPrimeFactors(getTheNumber());
	}

	/**
	 * Returns a HashSet of integers, a number's distinct prime factors.
	 * @param v the number
	 * @return List of distinct integer prime factors.
	 * @see #getPrimeFactors() getPrimeFactors()
	 */
	public static HashSet<Integer> getDistinctPrimeFactors(int v) {
		List<Integer> theList = getPrimeFactors(v);
		Set<Integer> theSet = new HashSet<Integer>();
		theSet.addAll(theList);
		return (HashSet<Integer>) theSet;
	}

	
	/**
	 * Returns a HashSet of longs, a number's distinct prime factors.
	 * @param v an long
	 * @return List of distinct long prime factors.
	 * @see #getPrimeFactors() getPrimeFactors()
	 */
	public static HashSet<Long> getDistinctPrimeFactors(long v) {
		List<Long> theList = getPrimeFactors(v);
		Set<Long> theSet = new HashSet<Long>();
		theSet.addAll(theList);
		return (HashSet<Long>) theSet;
	}

	
	/**
	 * Co-prime numbers are pairs of numbers that do not have any common factor 
	 * other than 1. There should be a minimum of two numbers to form a set of 
	 * co-prime numbers. They do not have to be prime numbers.
	 * 
	 * @author JeffreySchneider
	 * @param v an int
	 * @param bNumber the second int number used to calculate Greatest Common Divisor  
	 * @return Are the two numbers co-prime?
	 */
	public static boolean isCoPrime(int v, int bNumber) {
		return isCoPrime((long) v, (long) bNumber);
	}

	/**
	 * Co-prime numbers are pairs of numbers that do not have any common factor 
	 * other than 1. There should be a minimum of two numbers to form a set of 
	 * co-prime numbers. They do not have to be prime numbers.
	 * 
	 * @author JeffreySchneider
	 * @param v a long
	 * @param bNumber the second long number used to calculate Greatest Common Divisor  
	 * @return Are the two numbers co-prime? 
	 * @see NumberTheory#gcd(long, long) gcd
	 */
	public static boolean isCoPrime(long v, long bNumber) {
		if (NumberTheory.gcd(v, bNumber) == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Returns HashMap of prime numbers from 1 to v
	 * @author JCSchneider
	 * @param v	End number of primes for list.
	 *  	  
	 * @return HashMap of primes
	 * 
	 */
	public static HashMap<Integer, Integer> getPrimeList(int v) {
		HashMap<Integer, Integer> retVal = new HashMap<>();
		int counter = 0;
		for (int i = 1; i <= v; i++) {
			if (isPrime(i)) {
				retVal.put(counter++, i);
			}
		}
		return retVal;
	}

	
	/**
	 * Returns a list of lonely numbers:
	 * 
	 * {@code A number  <i>n</i>  is called lonely if its distance to closest prime sets a new record. 
	 * For example, 0 is the first lonely number and has distance 2 from the first prime. 
	 * The second lonely number is 23, which has a minimal distance 4, since the surrounding 
	 * primes are 17 and 29. 
	 * The third is 120 which has minimal distance 7, being sandwiched between the primes 113 and 127.}
	 * @param endNumber the number to end on
	 * @return integer list of lonely numbers
	 * 
	 * @see #getPreviousPrime(int) getPreviousPrime
	 * @see #getNextPrime(int) getNextPrime
	 */
	public static List<Integer> getLonelyNumber(int endNumber) {
		List<Integer> retVal = new LinkedList<>();
		retVal.add(0);
		int v = 23;
		int newRecord = 0;
		int diff = 0;
		while (v <= endNumber) {
			int prevPrime = getPreviousPrime(v);
			int nextPrime = getNextPrime(v);
			diff = Math.min(v - prevPrime, nextPrime - v);
			if (diff > newRecord) {
				newRecord = diff;
				retVal.add(v);
			}
			v++;
		}
		return retVal;
	}
	
	

	/**
	 * <p>
	 * Finds the prime number <b><i>before</i> v</b>.  
	 * Will not return <b>v</b> whether it is prime or not.
	 * </p>
	 * @author JCSchneider
	 * @param v The number.
	 * @return finds the prime number <b><i>before</i> v</b>.  Will not return <b>v</b> whether it is prime or not.
	 *  
	 */
	public static int getPreviousPrime(int v) {
		return getNeighborPrime(v, false, false);
	}
	
	/**
	 * <p>
	 * Finds the prime number <b><i>after</i> v</b>. Will not return <b>v</b> whether it is prime or not.
	 * </p>
	 * @author JCSchneider
	 * @param v The number.
	 * @return find the prime number <b><i>after</i> v</b>.  Will not return <b>v</b> whether it is prime or not.
	 * 
	 * @see #getNeighborPrime(int, boolean, boolean) getNeighborPrime() 
	 */
	public static int getNextPrime(int v) {
		return getNeighborPrime(v, true, false);
	}
	
	/**
	 * <p>
	 * Find the prime number before <b>v</b>. Returns <b>v</b> if prime. 
	 * 
	 * </p>
	 * 
	 * @author JCSchneider
	 * @param v The number from which to start.
	 * @return Previous Prime Number, or <b>v</b> if prime
	 * @see #getNeighborPrime(int, boolean, boolean) getNeighborPrime()
	 */
	public static int getPreviousPrimeInclusive(int v) {
		return getNeighborPrime(v, false, true);
	}
	
	/**
	 * <p>
	 * Find the prime number after <b>v</b>. Returns <b>v</b> if prime.
	 * 
	 * </p>
	 * Find the prime number after <b>v</b>. Returns <b>v</b> if prime.
	 * 
	 * @author JCSchneider
	 * @param v The number from which to start.
	 * @return Next prime number, v if prime
	 * @see #getNeighborPrime(int, boolean, boolean) getNeighborPrime
	 * 
	 * 
	 */
	public static int getNextPrimeInclusive(int v) {
		return getNeighborPrime(v, true, true);
	}
	


	/**
	 * 
		 * @author JeffreySchneider
		 * @param v The number from which to start.
		 * @param returnNextPrime   Boolean - True: Return the next prime  False: Return the previous prime
		 * @param returnNumberIfPrime Boolean - True: Return v if prime   False: look for next number
		 * @return
		 * The previous or next prime number. 
		 * 
		 * Leave private - base program for getNextPrime(), getPreviousPrime(), getNextPrimeInclusive(), getPreviousPrimeInclusive()
		 */
		private static int getNeighborPrime(int v, boolean returnNextPrime, boolean returnNumberIfPrime) {
			if(returnNumberIfPrime) {
					if(isPrime(v))
						return v;
			}
			while(true) {
				if(returnNextPrime) {
					v++;
					if(isPrime(v)) {
						return v;
					}
				}else {
					v--;
					if(v == 0) {
						return 0;
					}
					if(isPrime(v)) {
						return v;
					}
				}
			}
		}
		
		/**
		 * <P>
		 * List of lucky numbers that are prime.
		 * 
		 * The first number greater than 1 is 3, so we declare 3 lucky and we delete from the 
		 * sieve all the numbers in a position which is a multiple of 3, i.e., 5, 11, 17, 23, 
		 * and so on.
		 * 
		 * https://www.numbersaplenty.com/set/lucky_number/
		 * 
		 * </p>
		 * @author JeffreySchneider
		 * @param v integer stop number
		 * @return List of lucky numbers that are prime.
		 * 
		 * @see NumberTheory#getLuckyNumber()
		 * @see NumberTheory#isPrime()
		 * 
		 * 
		 */
		public static List<Integer> getPrimeLuckyNumbers(int v){			
			List<Integer> luckyList = NumberTheory.getLuckyNumber(v);
			List<Integer> retVal = new ArrayList<>();
			for (Integer integer : luckyList) {
				if(isPrime(integer)) {
					retVal.add(integer);
				}
			}
			return retVal;
		}
		
		List<Integer> getPrimeLuckyNumbers(){			
			return getPrimeLuckyNumbers(getTheNumber());			
		}
		
		
		/**
		 * <p>
		 * https://en.wikipedia.org/wiki/Fortunate_number
		 * To find the seventh Fortunate number, one would first calculate the product of the
		 *  first seven primes (2, 3, 5, 7, 11, 13, 17) which is 510510. Adding 2 to that gives
		 *  another even number while adding 3 would give another multiple of 3, ergo adding two
		 *  gives a non-prime value.
		 *  
		 *  https://www.geeksforgeeks.org/find-n-th-fortunate-number/
		 *  </p>
		 * @param v The Number
		 * @return list of fortunate numbers - in progress -
		 * 
		 */
		public static int getFortunateNumbers(int v){
			//TODO			
			return 0;
		}

		

		/**
		 * <P>
		 * In number theory, an n-smooth (or n-friable) number is the number 
		 * whose prime factors are all less than or equal to n.
		 * For example, a 7-smooth number is a number whose every prime 
		 * factor is at most 7, so 49 = 72 and 
		 * 15750 = 2 × 32 × 53 × 7 are both 7-smooth, 
		 * while 11 and 702 = 2 × 33 × 13 are not 7-smooth.
		 * </P>
		 * @param v the integer
		 * @param n the n-smooth integer
		 * @return Boolean
		 * 
		 * 
		 * @see #getPrimeFactors()
		 */
		public static boolean isNSmooth(int v, int n) {	
			if(v < 2)
				return false;
			else
				return Collections.max(getPrimeFactors(v)) <= n;
		}
		
		
		/**
		 * 
		 * @param v The number
		 * @return Boolean 
		 * 
		 * TODO:
		 * 	check if number is 1 modulo 6.
		 */
		public static boolean isPierpontPrime(int v) {
			if(v < 1)
				return false;
			if(isPrime(v) && isNSmooth(v-1,3)) {
				return true;
			}
			return false;
		}
		
		boolean isPierpontPrime() {			
			return isPierpontPrime(getTheNumber());
		}

		public static boolean isPrimeList(List<Integer> testList) {
			// TODO Auto-generated method stub
			for (Integer integer : testList) {
				if(!isPrime(integer))
					return false;
			}
			return true;
		}

		
		
		
		
		
}

		
		
