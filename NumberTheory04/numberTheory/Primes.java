package numberTheory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Primes extends NumberTheory {

	public Primes(int theNumber) {
		super(theNumber);
	}

	public Primes() {
		super();
	}

	/**
	 * @author JCSchneider
	 * @param v
	 * @return boolean In mathematics, a semiprime is a natural number that is the
	 *         product of exactly two prime numbers.
	 */
	public static boolean isSemiPrime(int v) {
		List<Integer> anotherList = Primes.getPrimeFactors(v);
		return (anotherList.size() == 2);
	}

	boolean isSemiPrime() {
		return isSemiPrime(getTheNumber());
	}

	/**
	 * @author JCSchneider
	 * @param v
	 * @return boolean {@code}A semiprime 'p * q' for which 'p' and 'q' have the
	 *         same number of digits is called brilliant number.
	 * 
	 */
	public static boolean isBrilliant(int v) {
		List<Integer> theList = Primes.getPrimeFactors(v);
		if (isSemiPrime(v)) {
			int count1 = 0, count2 = 0;
			int number = theList.get(0);
			// Here we count digits in an integer.
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
	 * @param v
	 * @return
	 */
	public static boolean isEmirpimeses(int v) {
		return isSemiPrime(v) && isSemiPrime(getReverseNumber(v));
	}

	boolean isEmirpimeses() {
		return isEmirpimeses(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean A prime number p is called a Chen prime if p + 2 is either a
	 *         prime or a product of two primes (also called a semiprime).
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
	 * A good prime is a prime number whose square is greater than the product of
	 * any two primes at the same number of positions before and after it in the
	 * sequence of primes. To solve this, create a list of primes from zero to 3x
	 * the number. Iterate pointers forwards and backwards in matching jumps through
	 * list.
	 * 
	 * @author JeffreySchneider
	 * @param v
	 * @return
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
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean An emirp (prime spelled backwards) is a prime number that
	 *         results in a different prime when its decimal digits are reversed.
	 *         This definition excludes the related palindrome primes.
	 */
	public static boolean isEmirp(int v) {
		return (NumberTheory.isPrime(v) && NumberTheory.isPrime(NumberTheory.getReverseNumber(v)));
	}

	boolean isEmirp() {
		return isEmirp(getTheNumber());
	}

	/**
	 * 
	 * @param v
	 * @return
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
	 * @param v
	 * @return
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
	 * 
	 * @param v
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

	public List<Integer> getPrimeFactors() {
		// TODO Auto-generated method stub
		return getPrimeFactors(getTheNumber());
	}
	
	public static HashSet<Integer> getDistinctPrimeFactors(int v){
		List<Integer> theList = getPrimeFactors(v);
		Set<Integer> theSet = new HashSet<Integer>();
		theSet.addAll(theList);
		return (HashSet<Integer>) theSet;
	}
	
	
	public static boolean isCoPrime(int v, int bNumber) {
		return isCoPrime((long) v, (long) bNumber);
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @param bNumber
	 * @return boolean is the gcd of both numbers 1?
	 */
	public static boolean isCoPrime(long v, long bNumber) {
		if (NumberTheory.gcd(v, bNumber) == 1) {
			return true;
		}
		return false;
	}

	

}