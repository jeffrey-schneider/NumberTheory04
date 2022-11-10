package numberTheory;
import java.util.*;
import java.util.function.BooleanSupplier;

public class Primes extends NumberTheory {

	public Primes(int theNumber) {
		super(theNumber);
		// TODO Auto-generated constructor stub
	}

	public Primes() {
		super();// TODO Auto-generated constructor stub
	}

	/**
	 * @author JCSchneider
	 * @param aNumber
	 * @return boolean In mathematics, a semiprime is a natural number that is the
	 *         product of exactly two prime numbers.
	 */
	public static boolean isSemiPrime(int aNumber) {
		List<Integer> anotherList = Primes.getPrimeFactors(aNumber);
		return (anotherList.size() == 2);
	}

	boolean isSemiPrime() {
		return isSemiPrime(getTheNumber());
	}

	
/**
 * @author JCSchneider	
 * @param v
 * @return
 * {@code}A semiprime  $p\cdot q$  for which  $p$  and  $q$  have the same number of digits is called brilliant number.
 * 
 */
public static boolean isBrilliant(int v) {
		List<Integer> theList = Primes.getPrimeFactors(v);		
		if(isSemiPrime(v)) {
			int count1 = 0, count2 = 0;
			int number = theList.get(0);
			//Here we count digits in an integer.
			while(number != 0) {
				number /= 10;
				++count1;
			}
			number = theList.get(1);
			while(number != 0) {
				number /= 10;
				++count2;
			}
			if(count1 == count2) {
				return true;
			}		
		}
		return false;
	}

boolean isBrilliant() {
	return isBrilliant(getTheNumber());
}
	
	
	/**
	 * A number is called emirpimes if it is a semiprime and if its reverse is a different
	 * semiprime, thus excluding palindromic semiprimes.
	 * @author JCSchneider
	 * @param aNumber
	 * @return
	 */
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
	
	
	/**
	 * A good prime is a prime number whose square is greater than the product of any two primes 
	 * 		at the same number of positions before and after it in the sequence of primes.
	 * 
	 * @param aNumber
	 * @return
	 */
	public static boolean isGoodPrime(int aNumber) {
		boolean retVal = true;
		
		List<Integer> thePrimeList = new LinkedList<>();
		if(!isPrime(aNumber)) {
			return false;
		}else {
			//Create a list of prime numbers up to 3 times aNumber.
			for(int i = 2; i <= aNumber*3; i++) {
				if(isPrime(i)) {
					thePrimeList.add(i);
				}
			}
		}
		
		int small = 0;
		int large = 0;		
		if(thePrimeList.contains(aNumber)) {
			int ndx = thePrimeList.indexOf(aNumber);
			//System.out.println("n: " + aNumber);
			for (int ndxCounter = 1; ndxCounter < ndx; ndxCounter++) {
				small = thePrimeList.get(thePrimeList.indexOf(aNumber) - ndxCounter);
				large = thePrimeList.get(thePrimeList.indexOf(aNumber) + ndxCounter);
				if((aNumber*aNumber) < (small*large)) {
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
	 * @param aNumber
	 * @return boolean	An emirp (prime spelled backwards) is a prime number 
	 * 					that results in a different prime when its decimal digits 
	 * 					are reversed. This definition excludes the related 
	 * 					palindrome primes.
	 */
	public static boolean isEmirp(int aNumber) {
		return (NumberTheory.isPrime(aNumber) && NumberTheory.isPrime(NumberTheory.getReverseNumber(aNumber)));
	}
	
	boolean isEmirp() {
		return isEmirp(getTheNumber());
	}
	
	

	/**
	 * 
	 * @param aNumber
	 * @return
	 */
	public static boolean getA_PointerPrime(int aNumber){
		if (!NumberTheory.isPrime(aNumber)) {
			return false;
		} else {
			Stack<Integer> theStack = new Stack<>();
			int number = aNumber;
			theStack.push(aNumber);
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
	
	boolean getA_PointerPrime() {
		return getA_PointerPrime(getTheNumber());
	}

	public static boolean isInterPrime(int aNumber) {
		List<Integer> theList = new ArrayList<>();
		// Find the first prime number less than aNumber.
		// Add it to a list, then break out of the discovery loop.
		int counter = aNumber - 1;
		while (counter > 0) {
			if (NumberTheory.isPrime(counter)) {
				theList.add(counter);
				break;
			} else {
				counter--;
			}
		}
		// Find the first prime number greater than aNumber.
		// Add it to a list, then break out of the discovery loop.
		counter = aNumber + 1;
		while (counter >= aNumber) {
			if (NumberTheory.isPrime(counter)) {
				theList.add(counter);
				break;
			} else {
				counter++;
			}
		}
		// If aNumber is the same distance between the upper and lower numbers,
		// you have a balanced prime.
		int up = theList.get(0);
		int dn = theList.get(1);
		if (aNumber - up == dn - aNumber) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isInterPrime() {
		return Primes.isInterPrime(getTheNumber());
	}

	
	
	
	
	
	
	
}