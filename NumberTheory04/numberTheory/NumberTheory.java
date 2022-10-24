//http://www.numbergossip.com/
// http://www.numbersaplenty.com

package numberTheory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NumberTheory {
	/**
	 * The number.
	 */
	private int theNumber;

	public NumberTheory(int theNumber) {
		setTheNumber(theNumber);
	}

	public NumberTheory() {
	}

	/**
	 * 
	 * @return int theNumber
	 * 
	 * @see #theNumber
	 */
	public int getTheNumber() {
		return theNumber;
	}

	/**
	 * Sets theNumber.
	 * 
	 * @param theNumber theNumber
	 */
	public void setTheNumber(int theNumber) {
		this.theNumber = theNumber;
	}


	/**
	 * 
	 * @param aNumber the number to square
	 * @return the square of a number
	 */
	public static int getSquare(int aNumber) {
		return aNumber * aNumber;
	}
	int getSquare() {
		return getSquare(getTheNumber());
	}

	
	
	
	/**
	 * 
	 * @param aNumber the number to cube
	 * @return int the cube of the number
	 */
	public static int getCube(int aNumber) {
		return (int) Math.pow(aNumber, 3);
	}
	int getCube() {
		return getCube(getTheNumber());
	}
	
	

	/**
	 * 
	 * @param aNumber the number to test for primality
	 * @return boolean is number prime?
	 */
	public static boolean isPrime(int aNumber) {
		int stopVal = (int) Math.sqrt(aNumber);
		int i = 2;
		while (i <= stopVal) {
			if (aNumber % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
	boolean isPrime() {
		return isPrime(getTheNumber());
	}
	
	


	/**
	 * 
	 * @param aNumber the number to generate collatz sequence from
	 * @return list of collatz sequence.
	 * @see https://en.wikipedia.org/wiki/Collatz_conjecture#:~:text=The%20Collatz%20conjecture%20is%20one,every%20positive%20integer%20into%201.
	 */
	public static List<Integer> getCollatz(int aNumber) {
		List<Integer> retVal = new ArrayList<>();
		retVal.add(aNumber);
		int counter = aNumber;
		while (counter > 1) {
			if (counter % 2 == 0) {
				counter /= 2;
			} else {
				counter = (int) Math.floor(3.0 * counter + 1);
			}
			retVal.add(counter);
		}
		return retVal;
	}
	/**
	 * @see #getCollatz(int aNumber)
	 */
	List<Integer> getCollatz() {
		return getCollatz(getTheNumber());
	}

	

	

	/**
	 * 
	 * @param aNumber
	 * @return list of jugglers sequence for the number
	 * @see https://en.wikipedia.org/wiki/Juggler_sequence
	 */
	public static List<Integer> getJugglers(int aNumber) {
		double factr = 0.0;
		List<Integer> retVal = new ArrayList<>();
		retVal.add(aNumber);
		int counter = aNumber;
		while (counter > 1) {
			if (counter % 2 == 0)
				factr = .5;
			else
				factr = 1.5;
			counter = (int) Math.floor(Math.pow(counter, factr));
			retVal.add(counter);
		}
		return retVal;
	}
	List<Integer> getJugglers() {
		return getJugglers(getTheNumber());
	}
	
	

	

	public static List<Integer> getFactors(int aNumber) {
		List<Integer> retVal = new ArrayList<>();
		for (int i = 1; i < aNumber; i++) {
			if (aNumber % i == 0)
				retVal.add(i);
		}
		retVal.add(aNumber);
		return retVal;
	}
	List<Integer> getFactors() {
		return getFactors(getTheNumber());
	}

	

	public static List<Integer> getPrimeFactors(int aNumber) {
		List<Integer> retVal = new ArrayList<>();
		int ourNumber = aNumber;
		for (int i = 2; i < aNumber; i++) {
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

	

	public static int getAliquotSum(int aNumber) {
		int retVal = 0;
		for (Integer factor : getFactors(aNumber)) {
			retVal += factor;
		}
		return retVal - aNumber;
	}
	int getAliquotSum() {
		return getAliquotSum(getTheNumber());
	}

	
	public static int getFactorSum(int aNumber) {
		int retVal = 0;
		for (Integer factor : getFactors(aNumber)) {
			retVal += factor;
		}
		return retVal;
	}
	int getFactorSum() {
		return getFactorSum(getTheNumber());
	}
	
	

	public static List<Integer> getProperDivisors(int aNumber) {
		List<Integer> retVal = new ArrayList<>();
		for (int i = 1; i < aNumber; i++) {
			if (aNumber % i == 0)
				retVal.add(i);
		}
		return retVal;
	}
	List<Integer> getProperDivisors() {
		return getProperDivisors(getTheNumber());
	}
	

	

	public static int getAbundance(int aNumber) {
		return getAliquotSum(aNumber) - aNumber;
	}
	int getAbundance() {
		return getAbundance(getTheNumber());
	}

	
	
	

	public static boolean isAbundant(int aNumber) {
		return getAliquotSum(aNumber) > aNumber;
	}
	boolean isAbundant() {
		return isAbundant(getTheNumber());
	}
	

	

	/**
	 * 
	 * @param aNumber
	 * @return boolean is number perfect?
	 */
	public static boolean isPerfect(int aNumber) {
		return getAbundance(aNumber) == 0;
	}
	/**
	 * @see #isPerfect(int)
	 */
	boolean isPerfect() {
		return isPerfect(getTheNumber());
	}
	


	/**
	 * 
	 * @param aNumber
	 * @return int the number reversed
	 */
	public static int getReverseNumber(int aNumber) {
		int num = aNumber;
		int rev = 0;
		int digit = 0;
		while (num > 0) {
			digit = num % 10;
			rev = rev * 10 + digit;
			num /= 10;
		}
		return rev;
	}
	
	/**
	 * @see #getReverseNumber(int)
	 */
	int getReverseNumber() {
		return getReverseNumber(getTheNumber());
	}



	public static double getReciprocalNumber(int aNumber) {
		return 1.0 / aNumber;
	}
	double getReciprocalNumber() {
		return getReciprocalNumber(getTheNumber());
	}



	public static String getHex(int aNumber) {
		String retVal = "";
		String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		int rem = 0;
		int buffer = aNumber;
		while (buffer > 0) {
			rem = buffer % 16;
			retVal = hex[rem] + retVal;
			buffer = buffer / 16;
		}
		return retVal;
	}
	String getHex() {
		return getHex(getTheNumber());
	}



	public static String getOctal(int aNumber) {
		String retVal = "";
		String[] dig = { "0", "1", "2", "3", "4", "5", "6", "7" };
		int rem = 0;
		int buffer = aNumber;
		while (buffer > 0) {
			rem = buffer % 8;
			retVal = dig[rem] + retVal;
			buffer = buffer / 8;
		}
		return retVal;
	}
	String getOctal() {
		return getOctal(getTheNumber());
	}



	public static String getBinary(int aNumber) {
		return Integer.toBinaryString(aNumber);
	}
	String getBinary() {
		return getBinary(getTheNumber());
	}



	public static int getSigma(double aNumber) {
		if (aNumber == 1) {
			return 1;
		}
		int result = 0;
		for (int i = 1; i <= aNumber; i++) {
			if (aNumber % i == 0) {
				result += i;
			}
		}
		return result;
	}
	int getSigma() {
		return getSigma(getTheNumber());
	}

	

	
	/**
	 * 
	 * @param aNumber number to check for superabundancy
	 * @return boolean is number superabundant?
	 */
	public static boolean isSuperabundant(int aNumber) {
		double M = 0.0;
		double theNumberDouble = Double.parseDouble(String.valueOf(aNumber));
		double N = getSigma(theNumberDouble) / theNumberDouble;
		for (double i = 0.0; i < aNumber; i++) {
			M = getSigma(i) / i;
		}
		if (M >= N) {
			return false;
		}
		return true;
	}
	boolean isSuperabundant() {
		return isSuperabundant(getTheNumber());
	}



	/**
	 * 
	 * @param aNumber
	 * @return boolean is number primative abundant?
	 */
	public static boolean isPrimativeAbundant(int aNumber) {
		// 20, 70, True
		// 87 False
		if (isAbundant(aNumber)) {
			// List<Integer> FactorArray = new ArrayList<>();
			List<Integer> FactorArray = getProperDivisors(aNumber);
			for (int i = 0; i < FactorArray.size(); i++) {
				if (getAliquotSum(FactorArray.get(i)) > 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @see #isPrimativeAbundant(int)
	 */
	boolean isPrimativeAbundant() {
		return isPrimativeAbundant(getTheNumber());
	}



	/**
	 * See https://mathworld.wolfram.com/KeithNumber.html For example, 197 is a
	 * Keith number since it generates the sequence 1, 9, 7, 1+9+7=17, 9+7+17=33,
	 * 7+17+33=57, 17+33+57=107, 33+57+107=197, ... (Keith). Keith numbers are also
	 * called repfigit (repetitive fibonacci-like digit) numbers.
	 * 
	 * @return boolean: is the number a Keith number?
	 */
	public static boolean isAKeithNumber(Integer aNumber) {
		if (aNumber > Integer.MAX_VALUE) {
			throw new ArithmeticException("Integer Overflow");
		}
		Deque<Integer> theDeque = new LinkedList<>();
		int number = aNumber;
		while (number > 0) {
			theDeque.addFirst(number % 10);
			number /= 10;
		}
		int nextNumber = 0;

		while (nextNumber < aNumber) {
			nextNumber = 0;
			for (Integer item : theDeque) {
				nextNumber += item;
			}
			theDeque.remove();
			theDeque.add(nextNumber);

			if (nextNumber == aNumber) {
				return true;
			}
		}
		return false;
	}
	boolean isAKeithNumber() {
		return isAKeithNumber(getTheNumber());
	}



	public static int getKynea(Integer aNumber) {
		double kyneaA = Math.pow(4.0, Double.valueOf(aNumber));
		double kyneaB = Math.pow(2.0, (Double.valueOf(aNumber) + 1.0));
		double kyneaFinal = kyneaA + kyneaB - 1.0;
		return (int) kyneaFinal;
	}
	int getKynea() {
		return getKynea(getTheNumber());
	}



	public static int getCarol(int aNumber) {
//		System.out.println(aNumber);
		double carolA = Math.pow(4.0, Double.valueOf(aNumber));
		double carolB = Math.pow(2.0, (Double.valueOf(aNumber) + 1.0));
		double carolFinal = carolA - carolB - 1.0;
		return (int) carolFinal;
	}
	int getCarol() {
		return getCarol(getTheNumber());
	}



	public static BigInteger getFactorial(int aNumber) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= aNumber; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}
	BigInteger getFactorial() {
		return getFactorial(getTheNumber());
	}



	public static BigInteger getCatalan(int aNumber) {
		BigInteger catA = NumberTheory.getFactorial(2 * aNumber);
		BigInteger catB = NumberTheory.getFactorial(aNumber + 1);
		BigInteger catC = NumberTheory.getFactorial(aNumber);
		BigInteger catFinal = catA.divide(catB.multiply(catC));
		return catFinal;
	}
	BigInteger getCatalan() {
		return getCatalan(getTheNumber());
	}




	public static List<BigInteger> getFibonacciList(int aNumber) {
		BigInteger num1 = BigInteger.ZERO;
		BigInteger num2 = BigInteger.ONE;
		int counter = 0;
		List<BigInteger> retList = new ArrayList<>();

		// Iterate until counter == aNumber
		while (counter < aNumber) {
			retList.add(num1);
			BigInteger num3 = num2.add(num1);
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}
	List<BigInteger> getFibonacci() {
		return getFibonacciList(getTheNumber());
	}
	
	
	/**
	 * From: https://www.geeksforgeeks.org/motzkin-number/
	 * @param v
	 * @return
	 */
	public static BigInteger getMotzkin(int n) {
		Map<Integer, BigInteger> memo = new HashMap<>();
		if(n==0 || n == 1)
			return BigInteger.ONE;
		
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		BigInteger BigN = BigInteger.valueOf(n);
		BigInteger Two = BigInteger.TWO;
		BigInteger Three = BigInteger.valueOf(3);
		BigInteger One = BigInteger.ONE;
		BigInteger m1 = getMotzkin(n - 1);
		BigInteger m2 = getMotzkin(n-2);
		
		BigInteger firstPart = Two.multiply(BigN).add(One).multiply(m1);		
		BigInteger secondPart = Three.multiply(BigN).subtract(Three).multiply(m2); 
		BigInteger lastPart = BigN.add(BigInteger.TWO);
		BigInteger retVal = (firstPart.add(secondPart)).divide(lastPart) ;
		memo.put(n, retVal);
		
		return (retVal);
	}

	BigInteger getMotzkin() {
		return getMotzkin(getTheNumber());
	}
	
	
	
	
	public static int motzkin(int n)
    {
        // Base Case
        if (n == 0 || n == 1)
            return 1;
   
        // Recursive step
        return ((2 * n + 1) * motzkin(n - 1) +
                (3 * n - 3) * motzkin(n - 2)) / (n + 2);
    }
       
	
	/*
	 * Returns the aNumber-th fibonacci number.
	 */
	public static BigInteger getFibonacciBkup(int aNumber) {
		BigInteger num1 = BigInteger.ZERO;
		BigInteger num2 = BigInteger.ONE;
		BigInteger num3 = BigInteger.ZERO;
		int counter = 1;

		// Iterate until counter == aNumber
		while(num3.compareTo(BigInteger.valueOf(counter)) < aNumber){
			num3 = num2.add(num1);
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return num3;
	}
	
	
	private static Map<Integer, BigInteger> memo = new HashMap<>();
	
	//https://www.interviewcake.com/concept/java/memoization
	public static BigInteger getFibonacci(int n) {
		if(n < 0) {
			throw new IllegalArgumentException(
					"Enter a positive number.");
		}
		else if(n==0 || n == 1) {
			return BigInteger.valueOf(n);
		}
		
		//Have we already calculated this?
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		BigInteger fib1 = getFibonacci(n-1);
		BigInteger fib2 = getFibonacci(n-2);
		BigInteger result = fib1.add(fib2);
		memo.put(n, result);
		
		return result;
		
	}
	
	/**
	 * Not working yet - this is part of the fibodiv number solution
	 * @param aNumber
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static List<Integer> getFibonacciLike(int aNumber, int number1, int number2){
		int num1 = number1;
		int num2 = number2;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();
		
		//Iterate until counter == aNumber
		while(counter < aNumber) {
			retList.add(num1);
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}

	public static List<Integer> getLucas(int aNumber) {
		int num1 = 2;
		int num2 = 1;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();

		// Iterate until counter == aNumber
		while (counter < aNumber) {
			retList.add(num1);
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}
	List<Integer> getLucas() {
		return getLucas(getTheNumber());
	}

	

	/**
	 * @author JCSchneider The sequence of Pell numbers starts with 0 and 1, and
	 *         then each Pell number is the sum of twice the previous Pell number
	 *         and the Pell number before that.
	 * @param aNumber
	 * @return
	 */
	public static List<Integer> getPellList2(int aNumber) {
		int num1 = 0;
		int num2 = 1;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();
		// Iterate until counter == aNumber
		while (counter < aNumber) {
			retList.add(num1);
			int num3 = 2 * num2 + num1;
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}

	public static List<BigInteger> getPellList(int aNumber) {
		BigInteger num1 = BigInteger.ZERO;
		BigInteger num2 = BigInteger.ONE;
		int counter = 0;
		List<BigInteger> retList = new ArrayList<>();
		// Iterate until counter == aNumber
		while (counter < aNumber) {
			retList.add(num1);
			BigInteger num3 = BigInteger.TWO.multiply(num2).add(num1);
			// int num3 = 2 * num2 + num1;
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}

	public static BigInteger getPell(int aNumber) {
		List<BigInteger> theList = getPellList(aNumber);
		Stack<BigInteger> theStack = new Stack<>();
		for (BigInteger bigInteger : theList) {
			theStack.push(bigInteger);
		}
		return theStack.pop();
	}
	

	public static List<Integer> getJacobsthal(int aNumber) {
		int num1 = 0;
		int num2 = 1;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();
		// Iterate until counter == aNumber
		while (counter < aNumber) {
			retList.add(num1);
			int num3 = num2 + 2 * num1;
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}
	
	List<Integer> getJacobsthal() {
		return getJacobsthal(getTheNumber());
	}
	
	

	public static boolean getAlternatingFactorial(int i) {
		return false;
	}


	public static boolean getA_PointerPrime(int aNumber) {
		if (!isPrime(aNumber)) {
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
			if (isPrime(nextNumber))
				return true;

			return false;
		}
	}
	boolean getA_PointerPrime() {
		return getA_PointerPrime(getTheNumber());
	}



	public static int getAmicableNumber(int aNumber) {
		int bla = NumberTheory.getAliquotSum(aNumber);
		int blin = NumberTheory.getAliquotSum(bla);
		if (blin == aNumber && bla > blin) {
			return bla;
		}
		return -1;
	}
	int getAmicableNumber() {
		return getAmicableNumber(getTheNumber());
	}


	public static String getBigIntegerPower(int base, int exponent) {
		BigInteger biggie = BigInteger.valueOf(base);
		String retVal = biggie.pow(exponent).toString();
		return retVal;
	}


	public static String getApocolyptic(int exponent) {
		String getTestNumber = getBigIntegerPower(2, exponent);
//		System.out.println();
		return "NOPE";
	}
	String getApocolyptic() {
		return getApocolyptic(getTheNumber());
	}


	public static int gcd(int b, int n) {
		if (n == 0)
			return b;
		return gcd(n, b % n);
	}

	/**
	 * 
	 * @param b   first number
	 * @param exp exponent
	 * @param n   third number
	 * @return
	 */
	public static int power(int b, int exp, int n) {
		if (exp == 0)
			return 1;
		int result = power(b, exp / 2, n) % n;
		result = (result * result) % n;
		if (exp % 2 == 1)
			result = (result * b) % n;
		return result;
	}


	// https://www.javatpoint.com/carmichael-numbers-in-java
	public static boolean isCaramichael(int aNumber) {
		for (int b = 2; b <= aNumber; b++) {
			if (gcd(b, aNumber) == 1 && power(b, aNumber - 1, aNumber) != 1)
				return false;
		}
		return true;
	}
	boolean isCarmichael() {
		return isCaramichael(getTheNumber());
	}



	// Wikipedia
	public static int getCakeNumber(int aNumber) {
		return (int) ((1.0 / 6.0) * (Math.pow(aNumber, 3) + 5 * aNumber + 6));
	}
	int getCakeNumber() {
		return getCakeNumber(getTheNumber());
	}



	public static int getLazyCaterer(int aNumber) {
		return (aNumber * aNumber + aNumber + 2) / 2;
	}
	int getLazyCaterer() {
		return getLazyCaterer(getTheNumber());
	}



	public static BigInteger getBellNumber(int aNumber) {
		BigInteger[][] bell = new BigInteger[aNumber + 1][aNumber + 1];
		bell[0][0] = BigInteger.ONE;
		for (int i = 1; i <= aNumber; i++) {
			bell[i][0] = bell[i - 1][i - 1];
			for (int j = 1; j <= i; j++)
				bell[i][j] = bell[i - 1][j - 1].add(bell[i][j - 1]);
		}
		return bell[aNumber][0];
	}
	BigInteger getBellNumber() {
		return getBellNumber(getTheNumber());
	}

	

	/**
	 * https://www.geeksforgeeks.org/admirable-numbers/
	 * 
	 * @return is the number admirable?
	 */

	public static boolean isAdmirable(int aNumber) {
		int sigmaN = getSigma(aNumber);
		for (int i = 2; i <= Math.sqrt(aNumber); i++) {
			// if 'i' is a divisor of 'num'
			if (aNumber % i == 0) {
				// if both divisors are the same, then add
				// it only once else add both
				if (i == (aNumber / i)) {
					if (sigmaN - 2 * i == 2 * aNumber)
						return true;
				} else {
					if (sigmaN - 2 * i == 2 * aNumber)
						return true;
					if (sigmaN - 2 * (aNumber / i) == 2 * aNumber)
						return true;
				}
			}
		}
		// Check 1 since 1 is also a divisor
		if (sigmaN - 2 * 1 == 2 * aNumber)
			return true;
		return false;
	}
	boolean isAdmirable() {
		return isAdmirable(getTheNumber());
	}



	/**
	 * https://www.geeksforgeeks.org/amenable-numbers/
	 * 
	 * @param aNumber
	 * @return is number Amenable
	 */
	public static boolean isAmenable(int aNumber) {
		// return true if N is of the form
		// 4K or 4K+1
		return (aNumber % 4 == 0 || (aNumber - 1) % 4 == 0);
	}
	boolean isAmenable() {
		return isAmenable(getTheNumber());
	}

	
	/**
	 * 
	 * @param d
	 * @return if d = 2 return 22 if d = 3 return 333 if d = 4 return 4444
	 */
	private static String intToString(int d) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d; i++) {
			sb.append(String.valueOf(d));
		}
		return sb.toString();
	}

	
	/**
	 * https://www.geeksforgeeks.org/super-d-numbers/
	 * 
	 * @param aNumber
	 * @return boolean - is number SuperD?
	 */
	public static boolean isSuperD(int aNumber) {
		for (int d = 2; d < 10; d++) {
			String subString = intToString(d);
			if (String.valueOf((d * Math.pow(aNumber, d))).contains(subString)) {
				return true;
			}
		}
		return false;
	}
	boolean isSuperD() {
		return isSuperD(getTheNumber());
	}


	/**
	 * Used for Alternating Numbers
	 * 
	 * @param s
	 * @return boolean
	 * @see #isAlternating()
	 */
	static boolean isEvenOddForm(String s) {
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0 && s.charAt(i) % 2 != 0)
				return false;
			if (i % 2 == 1 && s.charAt(i) % 2 != 1)
				return false;
		}
		return true;
	}

	/**
	 * Used for Alternating Numbers
	 * 
	 * @param s
	 * @return boolean
	 * @see #isAlternating()
	 */
	static boolean isOddEvenForm(String s) {
		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0 && s.charAt(i) % 2 != 1)
				return false;
			if (i % 2 == 1 && s.charAt(i) % 2 != 0)
				return false;
		}
		return true;
	}


	/**
	 * https://www.geeksforgeeks.org/alternating-numbers/
	 * 
	 * @param aNumber
	 * @return boolean
	 */
	public static boolean isAlternating(int aNumber) {
		String str = Integer.toString(aNumber);
		return (isEvenOddForm(str) || isOddEvenForm(str));
	}
	/**
	 * @see #isAlternating()
	 */
	boolean isAlternating() {
		return isAlternating(getTheNumber());
	}

	
	

	

	/**
	 * A number n is said to be anti-perfect if it is equal to the sum of the
	 * reverses of its proper divisors.
	 * 
	 * @param aNumber
	 * @return boolean
	 */
	public static boolean isAntiPerfect(int aNumber) {
		List<Integer> list = getFactors(aNumber);
		int lastElement = list.size() - 1;
		list.remove(lastElement);
		int sum = 0;
		for (Integer integer : list) {
			sum += getReverseNumber(integer);
//			System.out.println(getReverseNumber(integer));
		}
		if (sum == aNumber) {
			return true;
		}
		return false;
	}
	boolean isAntiPerfect() {
		return isAntiPerfect(getTheNumber());
	}

	

	public static boolean isArithmetic(int aNumber) {
		List<Integer> list = getFactors(aNumber);
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}

		int d = sum % list.size();
//		System.out.printf("%d %% %d = %d\n", sum, list.size(), d);
		if (sum % list.size() == 0) {
			return true;
		}
		return false;
	}
	boolean isArithmetic() {
		return isArithmetic(getTheNumber());
	}

	

	/**
	 * Astonishing Number is a number N whose representation can be decomposed into
	 * two parts, a and b, such that N is equal to the sum of the integers from a to
	 * b and a + b = N where ‘+’ denotes concatenation.
	 * 
	 * @param aNumber
	 * @return boolean
	 */
	public static boolean isAstonishing(int aNumber) {
		
		//Does not work for all numbers 
		// 190 204 216
		// https://www.geeksforgeeks.org/astonishing-numbers/
		// This code is contributed by shubhamsingh10
		// Time Complexity: O(n)
		// Auxiliary Space: O(1)

		// Loop to find sum of all integers
		// from i until the sum becomes >= aNumber
		for (int i = 1; i < aNumber; i++) {
			// variable to store sum of all integers
			// from i to j and check if sum and
			// concatenation equals aNumber or not.
			int sum = 0;
			for (int j = i; j < aNumber; j++) {
				sum += j;
				if (sum == aNumber) {

					// Finding concatenation of i and j
					int concatenation = concat(i, j);

					// condition for astonishing number
					if (concatenation == aNumber) {
						return true;
					}
				}

			}
		}
		return false;
	}
	boolean isAstonishing() {
		return isAstonishing(getTheNumber());
	}

	/**
	 * Attached to isAstonishing()
	 * 
	 * @param a first number to be concatenated
	 * @param b second number to be concatenated
	 * @return concat two integers into one
	 * @see NumberTheory#isAstonishing(int aNumber)
	 */
	private static int concat(int a, int b) {
		// Convert both integers to string
		String s1 = Integer.toString(a);
		String s2 = Integer.toString(b);

		// Concatenate both strings
		String s = s1 + s2;

		// Convert concatenated string to integer
		int c = Integer.parseInt(s);

		return c;
	}

	/**
	 * @author Jeffrey Schneider
	 * @param aNumber
	 * @return
	 */
	public static boolean isAutomorphic(long aNumber) {
		long squared = (long) Math.pow(aNumber, 2.0);
		String theString = String.valueOf(squared);
		String ends = String.valueOf(aNumber);
//		System.out.printf("\n%s %s\n", theString, ends);
		return theString.endsWith(ends);

	}

	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return List list of non-trivial (not the number and not the number 1)
	 *         divisors
	 * 
	 */
	public static List<Integer> getNonTrivialDivisors(int aNumber) {
		List<Integer> retList = new ArrayList<>();
		retList = getFactors(aNumber);
		Collections.sort(retList);
		int Length = retList.size();
		retList.remove(Length - 1);
		retList.remove(0);
		return retList;

	}

	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return List list of the digits in a number
	 */
	public static List<Integer> getListOfDigits(int aNumber) {
		List<Integer> retList = new LinkedList<>();
		// This works right to left.
		while (aNumber > 0) {
			int remainder = aNumber % 10;
			retList.add(remainder);
			aNumber /= 10;
		}
		// Flip the list to get it in the correct order.
		Collections.reverse(retList);
		return retList;
	}

	public static int[] getFirstAndLastDigits(int aNumber) {		
//		int firstDigit = getListOfDigits(aNumber).get(0);
//		int length = getListOfDigits(aNumber).size() -1 ; 
//		int lastDigit = getListOfDigits(aNumber).get(length);
		List<Integer> theList = getListOfDigits(aNumber);
		int firstDigit = theList.get(0);
		int length = theList.size()-1;
		int lastDigit = theList.get(length);
		int[] retVal = {firstDigit, lastDigit};
		return retVal;
	}
	
	
	/**
	 * @author JeffreySchneider
	 * @param aList
	 * @return int sum of the squares of a list of numbers
	 */
	public static int getSumOfSquares(List<Integer> aList) {
		int retVal = 0;
		for (Integer integer : aList) {
			retVal += integer * integer;
		}
		return retVal;
	}
	
	public static int getProductOfSquares(List<Integer> aList) {
		int retVal = 1;
		for(Integer integer: aList) {
			retVal *= integer * integer;
		}
		return retVal;
	
	}

	/**
	 * @author JeffreySchneider
	 * @param aList
	 * @return int sum of a numbers digits.
	 */
	public static int getSumOfDigits(List<Integer> aList) {
		int retVal = 0;
		for (Integer integer : aList) {
			retVal += integer;
		}
		return retVal;
	}
	
	public static int getProductOfDigits(List<Integer> aList) {
		int retVal = 0;
		for (Integer integer : aList) {
			retVal *= integer;
		}
		return retVal;
	}

	
	/**
	 * 
	 * Canada numbers are those 'n' such that the sum of the squares of the digits
	 * of 'n' is equal to the sum of the non-trivial divisors of 'n', i.e.
	 * '\sigma(n)-n-1'. For example, 581, whose divisors are 1, 7, 83 and 581, is a
	 * Canada number because {@code <code>5^2+8^2+1^2=7+83</code>}.
	 * 
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return boolean is number a Canada Number?
	 * 
	 * @see #getNonTrivialDivisors(int)
	 * @see #getListOfDigits(int)
	 * @see #getSumOfSquares(List)
	 * @see #getSumOfDigits(List)
	 */
	public static boolean isCanadaNumber(int aNumber) {
		int sumOfSquaresOfDigits = getSumOfSquares(getListOfDigits(aNumber));
		int sumOfNonTrivialDivisors = getSumOfDigits(getNonTrivialDivisors(aNumber));
		return sumOfSquaresOfDigits == sumOfNonTrivialDivisors;
	}
	boolean isCanadaNumber() {
		return isCanadaNumber(getTheNumber());
	}


	/**
	 * @author Jeffrey Schneider
	 * @param aNumber
	 * @return boolean
	 * 
	 *         {@code <code>A prime is said to be balanced if it is the average of the two surrounding primes, 
	 * i.e., it is at equal distance from previous prime and next prime.</code>}
	 */
	public static boolean isBalancedPrime(int aNumber) {
		// If aNumber isn't prime, don't go any further.
		if (!isPrime(aNumber)) {
			return false;
		}
		List<Integer> theList = new ArrayList<>();

		// Find the first prime number less than aNumber.
		// Add it to a list, then break out of the discovery loop.
		int counter = aNumber - 1;
		while (counter > 0) {
			if (isPrime(counter)) {
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
			if (isPrime(counter)) {
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
		return isInterPrime(getTheNumber());
	}

	
	public static boolean isInterPrime(int aNumber) {
		List<Integer> theList = new ArrayList<>();

		// Find the first prime number less than aNumber.
		// Add it to a list, then break out of the discovery loop.
		int counter = aNumber - 1;
		while (counter > 0) {
			if (isPrime(counter)) {
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
			if (isPrime(counter)) {
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
	
	
	
	// https://oeis.org/wiki/Centered_polygonal_numbers
	public static int getCenteredPolygonalNumber(int sideNumber, int aNumber) {
		return (int) sideNumber * aNumber * (aNumber + 1) / 2 + 1;
	}

	

	public static double getPolygonalNumber(int S, int N) {
		int sMinusTwo = S - 2;
		int sMinusFour = S - 4;
		double retVal = (1 / 2.0) * (sMinusTwo * Math.pow(N, 2.0) - sMinusFour * N);
		return retVal;
	}
	double getPolygonalNumber() {
		return getPolygonalNumber(getTheNumber(), 10);
	}
	

	/**
	 * @author JCSchneider
	 * @param aNumber
	 * @return boolean In mathematics, a semiprime is a natural number that is the product of exactly two prime numbers.
	 */
	public static boolean isSemiPrime(int aNumber) {
		List<Integer> anotherList = NumberTheory.getPrimeFactors(aNumber);
		return (anotherList.size() == 2); 
	}
	boolean isSemiPrime() {
		return isSemiPrime(getTheNumber());
	}
	
	public static boolean isEmirpimeses(int aNumber) {
		return isSemiPrime(aNumber) &&
				isSemiPrime(getReverseNumber(aNumber));
	}
	boolean isEmirpimeses() {
		return isEmirpimeses(getTheNumber());
	}
	
	/**
	 * 
	 * @param aNumber
	 * @return boolean 
	 * 		A prime number p is called a Chen prime if p + 2 is either a prime 
	 * 		or a product of two primes (also called a semiprime). 
	 */
	public static boolean isChenPrime(int aNumber) {
		if(isPrime(aNumber)) {
			return (isPrime(aNumber + 2) || isSemiPrime(aNumber + 2));
		}
		return false;
	}
	boolean isChenPrime() {
		return isChenPrime(getTheNumber());
	}

	
	
	/**
	 * @author Jeffrey Schneider
	 * @param aNumber
	 * @return BigInteger multiples of aNumber of primes.
	 */
	public static BigInteger getPrimorials(int aNumber){
		BigInteger summary = BigInteger.ONE;
		int counter = 1;
		int numberOfPrimes = 0;
		while(numberOfPrimes <= aNumber) {
			if(isPrime(counter)) {
				summary = summary.multiply(BigInteger.valueOf(counter));
				numberOfPrimes++;
			}
			counter++;			
		}
		return summary;
	}
	
	
	
	
	//n * 2^n + 1
	/**
	 * @author JCSchneider
	 * @param aNumber
	 * @return BigInteger getCullen()
	 */
	public static BigInteger getCullen(int aNumber) {
		BigInteger n = BigInteger.valueOf(aNumber);		
		BigInteger exponent = BigInteger.TWO.pow(aNumber);
		BigInteger retVal = n.multiply(exponent).add(BigInteger.ONE);
		//retVal = BigInteger.valueOf(aNumber).multiply(partC);		
		//return (int) (aNumber * Math.pow(2, aNumber) + 1);
		return retVal;
	}
	BigInteger getCullen() {
		return getCullen(getTheNumber());
	}
	
	
	
	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @param bNumber
	 * @return boolean is the gcd of both numbers 1?
	 */
	public static boolean isCoPrime(int aNumber, int bNumber) {
		if( gcd(aNumber, bNumber) == 1) {
			return true;
		}
		return false;
	}
	boolean isCoPrime(int aNumber) {
		return isCoPrime(getTheNumber(), aNumber); 
	}

	
	/**
	 * Not sure if this works....  09/30/2022
	 * @param aNumber
	 * @return
	 */
	public static BigInteger getCompositorial(int aNumber) {
		BigInteger fact = getFactorial(aNumber);
		BigInteger prim = getPrimorials(aNumber);
//		System.out.println(fact + "/" + prim);
		BigInteger retVal = fact.divide(prim);
		return retVal;
	}
	
	
	
	public static boolean isCurzon(int aNumber) {		
		BigInteger two = BigInteger.TWO;
		BigInteger a = two.pow(aNumber).add(BigInteger.ONE);
		BigInteger b = two.multiply(BigInteger.valueOf(aNumber)).add(BigInteger.ONE);
		return a.mod(b) == BigInteger.ZERO;
	}
	boolean isCurzon() {
		return isCurzon(getTheNumber());
	}
	
	

	public static List<Integer> getPowerfulNumber(int aNumber){
		return null;
	}
	
	
	
	public static List<Integer> getTotatives(int aNumber){
		List<Integer> retList = new LinkedList<>(); //LinkedList? Why not?
		int counter = 1;
		while(counter <= aNumber) {
			if(isCoPrime(aNumber, counter)) {
				retList.add(counter);
			}
			counter++;
		}
		return retList;
	}
	List<Integer> getTotatives(){
		return getTotatives(getTheNumber());
	}
	
	

	public static int getEulersTotient(int aNumber) {
		return getTotatives(aNumber).size();
	}

	int getEulersTotient() {
		return getEulersTotient(getTheNumber());
	}	

	
	
	public static boolean isCyclic(int aNumber) {
		return isCoPrime(aNumber, getEulersTotient(aNumber));
	}
	
	boolean isCyclic() {
		return isCyclic(getTheNumber());
	}
	
	
	
	
	/**
	 * 
	 * @param n
	 * @return boolean A de Polignac number is an odd number  'n'  that cannot 
	 * 					be expressed as  'n=2^k+p', for  'p'  prime.
	 */
	public static boolean isDePolignac(int n) {
		if(!isEven(n)) {
			for (int p = 1; p < n; p++) {
				if(isPrime(p)) {
					for(int k = 1; k < p; k++) {
						if(n - p == Math.pow(2, k)) {
							return false;
						}
					}
				}					
			}
			return true;
		}
		return false;
	}
	
	boolean isDePolignac() {
		return isDePolignac(getTheNumber());
	}
	
	
	
	
	
	public static boolean isEven(int aNumber) {
		return (aNumber % 2 == 0);
	}
	boolean isEven() {
		return isEven(getTheNumber());
	}

	
	
	/**
	 * @author(Jeffrey Schneider)
	 * @param aNumber
	 * @return BigInteger The double factorial of an integer  'n>0', denoted by  'n!!', 
	 * 	is the product of all the integers from 1 to  'n'  which have 
	 * 	the same parity as  'n'.
	 */
	public static BigInteger getDoubleFactorial(int aNumber) {		
		BigInteger factorial = BigInteger.ONE;
		int start = 1;
		if(isEven(aNumber)) {
			start = 2;			
		}
		System.out.println(start);
		for(int count = start; count <= aNumber; count+=2) {			
			factorial = factorial.multiply(BigInteger.valueOf(count));
		}
		return factorial;
	}
	BigInteger getDoubleFactorial() {
		return getDoubleFactorial(getTheNumber());
	}

	
	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return boolean  Mario Velucchi called a number  'n'  droll 
	 * 					if the sum of its even prime factors equals 
	 * 					the sum of its odd prime factors.
	 */
	public static boolean isDroll(int aNumber) {				
		List<Integer> primeFactors = getPrimeFactors(aNumber);
		int evenTotal = 0;
		int oddTotal = 0;
		for (Integer integer : primeFactors) {
			if(isEven(integer)) {
				evenTotal += integer;
			}else {
				oddTotal += integer;
			}
		}
		if (evenTotal > 0 && evenTotal == oddTotal)
			return true;
		return false;
	}
	boolean isDroll() {
		return isDroll(getTheNumber());
	}
	

	//125
	public static boolean isEconomical(int aNumber) {
		/*TODO: Make this work correctly, 2^10 is 3 digits*/ 
		return true;
	}
	
	boolean isEconomical() {
		return isEconomical(getTheNumber());
	}
	
	
	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return boolean	An emirp (prime spelled backwards) is a prime number 
	 * 					that results in a different prime when its decimal digits 
	 * 					are reversed. This definition excludes the related 
	 * 					palindromic primes.
	 */
	public static boolean isEmirp(int aNumber) {
		return (isPrime(aNumber) && isPrime(getReverseNumber(aNumber)));
	}
	boolean isEmirp() {
		return isEmirp(getTheNumber());
	}

	
	
	/**
	 * @author JeffreySchneider
	 * @param i
	 * @return	boolean L.Colucci calls a number  'n'  of at least 3 digits
	 * 					a gapful number if  'n'  is divisible by the number 
	 * 					formed by the first and last digit of  'n'.
	 */
	public static boolean isGapful(int i) {
		if(i  < 100 || isPrime(i) ) {
			//If number isn't at least 3 digits, fail.
			return false;			
		}
		int[] a = getFirstAndLastDigits(i);
		int divisor = a[0] * 10 + a[1];
		if(i % divisor == 0) {
			return true;
		}
		return false;
	}
	boolean isGapful() {
		return isGapful(getTheNumber());
	}

	
	/**
	 * @author JeffreySchneider	
	 *  
	 * @param aNumber
	 * @return	boolean  Duffinian numbers are defined as numbers that are composite
	 * 					 and relatively prime to the sum of their divisors. The first 
	 * 					 such number is 4 because it is composite and the sum of its
	 * 					 divisors (1, 2 and 4) is 7 and relatively prime to 4. 
	 * 					 Source: http://voodooguru23.blogspot.com/2018/10/duffinian-numbers.html
	 */
	public static boolean isDuffinian(int aNumber) {
		//int factorSum = getFactorSum(aNumber);
		int factorSum = getSigma(aNumber);
		if(isCoPrime(aNumber, factorSum)){
			return true;
		}
		return false;
	}
	boolean isDuffinian() {
		return isDuffinian(getTheNumber());
	}
	
	
	public static double getHarmonicMean(List<Integer> aList) {
		double sum = 0;
		for(int i = 0; i < aList.size(); i++) {
			sum = sum +(double)1/aList.get(i);
		}
		return aList.size() / sum;
	}
	
	
	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return boolean 
	 * 
	 * This is broken.  Floor and ceil don't seem to work.
	 * Broken for:
	 * 30240,332640,360360,753480,1421280,1539720,2457000,11981970,15495480,
	 *  17428320,27027000,46683000,52141320,71253000,80832960
	 * 
	 */
	public static boolean isHarmonicDivisorNumber(int aNumber) {
		List<Integer> theList = getFactors(aNumber);
		double harmMean = getHarmonicMean(theList);
		double harmMeanTrunc = Math.floor(harmMean * 100) / 100;
		if(harmMeanTrunc  % 1 == 0) //Best way to tell if the harmonic mean is an integer?
			return true;
		return false;
	}
	boolean isHarmonicDivisorNumber() {
		return isHarmonicDivisorNumber(getTheNumber());
	}

	
	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return	boolean  A number divisible by the sum of its digits.
	 */
	public static boolean isHarshad(int aNumber) {
		int summation = getSumOfDigits(getListOfDigits(aNumber));
		if(aNumber % summation == 0)
			return true;
		return false;
	}
	boolean isHarshad() {
		return isHarshad(getTheNumber());
	}
	
	
	/**
	 * 
	 * @param aNumber
	 * @return int
	 * 
	 * Check to display this in a spiral form.
	 * 
	 */
	public static int getHogben(int aNumber){
		return (int) (Math.pow(aNumber, 2.0) - aNumber + 1);
	}
	int getHogben() {
		return getHogben(getTheNumber());
	}

	
	
	/**
	 * @author JeffreySchneider
	 * @param aNumber
	 * @return int  The  'n'-th house number  
	 * 				'h_n'  is a figurate number made by a cube of side  'n+1', 
	 * 				surmounted by a square pyramidal number with side  'n'.
	 * 				<code>\[h_n=(8 n^3+21 n^2+19 n+6)/6.\]</code>
	 * 
	 */
	public static int getHouse(int aNumber) {
		int a = (int) (8 * Math.pow(aNumber, 3.0));
		int b = (int) (21 * Math.pow(aNumber, 2.0));
		int c = 19 * aNumber;
		return (a + b + c + 6) / 6;
	}
	int getHouse() {
		return getHouse(getTheNumber());
	}

	public static boolean isHungry(int k ) {
		BigInteger n = BigInteger.TWO.pow(k);
		String stringN = n.toString();	
		int length = stringN.length();
		System.out.println("Length: " + length);
		String jeff = LocalMath.StringPI().replaceAll("\\.", "");
		return false;
	}

	public static boolean isInsolite(int v) {
		//Is number divisible by the sum and product
		//  of the squares of its digits.
		int a = getSumOfSquares(getListOfDigits(v));
		int b = getProductOfSquares(getListOfDigits(v));
		System.out.println("Insolite: " + a + " " + b);
		if(v % a == 0 && v % b == 0)
			return true;
		return false;
	}
	protected boolean isInsolite() {
		return isInsolite(getTheNumber());
	}

	
	
 
	
	
	
	

}
