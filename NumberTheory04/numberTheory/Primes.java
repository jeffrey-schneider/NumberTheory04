/**
 * 
 */
package numberTheory;

import java.util.List;

/**
 * @author JeffreySchneider
 *
 */
public class Primes extends NumberTheory {

	public Primes() {
		super();
	}

	public Primes(int theNumber) {
		super(theNumber);
	}

	/**
	 * @author JCSchneider
	 * @param aNumber
	 * @return boolean In mathematics, a semiprime is a natural number that is the
	 *         product of exactly two prime numbers.
	 */
	public static boolean isSemiPrime(int aNumber) {
		List<Integer> anotherList = NumberTheory.getPrimeFactors(aNumber);
		return (anotherList.size() == 2);
	}

	boolean isSemiPrime() {
		return isSemiPrime(getTheNumber());
	}

	public static boolean isEmirpimeses(int aNumber) {
		return isSemiPrime(aNumber) && isSemiPrime(getReverseNumber(aNumber));
	}

	boolean isEmirpimeses() {
		return isEmirpimeses(getTheNumber());
	}

	/**
	 * 
	 * @param aNumber
	 * @return boolean A prime number p is called a Chen prime if p + 2 is either a
	 *         prime or a product of two primes (also called a semiprime).
	 */
	public static boolean isChenPrime(int aNumber) {
		if (isPrime(aNumber)) {
			return (isPrime(aNumber + 2) || isSemiPrime(aNumber + 2));
		}
		return false;
	}

	boolean isChenPrime() {
		return isChenPrime(getTheNumber());
	}

}
