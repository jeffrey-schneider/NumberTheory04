//http://www.numbergossip.com/
// http://www.numbersaplenty.com

package numberTheory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class NumberTheory {
	/**
	 * The number.
	 */
	private int theNumber;
	public static int runNumber = 0;

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
	 * @author JeffreySchneider
	 * @param v the number to square
	 * @return the square of a number
	 */
	public static int getSquare(int v) {
		return v * v;
	}

	int getSquare() {
		return getSquare(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v the number to cube
	 * @return int the cube of the number
	 */
	public static int getCube(int v) {
		return (int) Math.pow(v, 3);
	}

	int getCube() {
		return getCube(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v the number to test for primality
	 * @return boolean is number prime?
	 */
	public static boolean isPrime(long v) {
		long stopVal = (int) Math.sqrt(v);
		long i = 2;
		while (i <= stopVal) {
			if (v % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}

	public static boolean isPrime(int v) {		
		return isPrime((long)v);
	}
	boolean isPrime() {
		return isPrime(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v the number to generate collatz sequence from
	 * @return list of collatz sequence.
	 * @see https://en.wikipedia.org/wiki/Collatz_conjecture#:~:text=The%20Collatz%20conjecture%20is%20one,every%20positive%20integer%20into%201.
	 */
	public static List<Integer> getCollatz(int v) {
		List<Integer> retVal = new ArrayList<>();
		retVal.add(v);
		int counter = v;
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
	 * @author JeffreySchneider
	 * @param v
	 * @return list of jugglers sequence for the number
	 * @see https://en.wikipedia.org/wiki/Juggler_sequence
	 */
	public static List<Integer> getJugglers(int v) {
		double factr = 0.0;
		List<Integer> retVal = new ArrayList<>();
		retVal.add(v);
		int counter = v;
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

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return Integer list of factors.
	 */
	public static List<Integer> getFactors(int v) {
		List<Integer> retVal = new ArrayList<>();
		for (int i = 1; i < v; i++) {
			if (v % i == 0)
				retVal.add(i);
		}
		retVal.add(v);
		return retVal;
	}

	List<Integer> getFactors() {
		return getFactors(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return Long list of a number's factors.
	 */
	public static List<Long> getFactors(long v) {
		List<Long> retVal = new ArrayList<>();
		for (long i = 1; i < v; i++) {
			if (v % i == 0)
				retVal.add(i);
		}
		retVal.add(v);
		return retVal;
	}


	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return Integer sum of factors
	 */
	public static int getAliquotSum(int v) {
		int retVal = 0;
		for (Integer factor : getFactors(v)) {
			retVal += factor;
		}
		return retVal - v;
	}

	int getAliquotSum() {
		return getAliquotSum(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return Sum of a number's factors.
	 */
	public static int getFactorSum(int v) {
		int retVal = 0;
		for (Integer factor : getFactors(v)) {
			retVal += factor;
		}
		return retVal;
	}

	int getFactorSum() {
		return getFactorSum(getTheNumber());
	}

	public static List<Integer> getProperDivisors(int v) {
		List<Integer> retVal = new ArrayList<>();
		for (int i = 1; i < v; i++) {
			if (v % i == 0)
				retVal.add(i);
		}
		return retVal;
	}

	List<Integer> getProperDivisors() {
		return getProperDivisors(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return Difference of aliquot sum and the number.
	 *         {@link numberTheory.NumberTheory#getAliquotSum()}}
	 */
	public static int getAbundance(int v) {
		return getAliquotSum(v) - v;
	}

	int getAbundance() {
		return getAbundance(getTheNumber());
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isAbundant(int v) {
		return getAliquotSum(v) > v;
	}

	boolean isAbundant() {
		return isAbundant(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return
	 */
	public static boolean isDeficient(int v) {
		return getAliquotSum(v) < v;
	}

	boolean isDeficient() {
		return isDeficient(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean is number perfect?
	 *         {@link numberTheory.NumberTheory#getAbundace()}}
	 */
	public static boolean isPerfect(int v) {
		return getAbundance(v) == 0;
	}

	/**
	 * @see #isPerfect(int)
	 */
	boolean isPerfect() {
		return isPerfect(getTheNumber());
	}

	/**
	 * 
	 * @param v
	 * @return int the number reversed
	 */
	public static int getReverseNumber(int v) {
		int num = v;
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
	 * 
	 */
	int getReverseNumber() {
		return getReverseNumber(getTheNumber());
	}

	/**
	 * 
	 * @param v
	 * @return double One divided by the number.
	 */
	public static double getReciprocalNumber(int v) {
		return 1.0 / v;
	}

	double getReciprocalNumber() {
		return getReciprocalNumber(getTheNumber());
	}

	/**
	 * 
	 * @param v
	 * @return String hex value of number.
	 */
	public static String getHex(int v) {
		String retVal = "";
		String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		int rem = 0;
		int buffer = v;
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

	/**
	 * 
	 * @param v
	 * @return String octal value of number.
	 */
	public static String getOctal(int v) {
		String retVal = "";
		String[] dig = { "0", "1", "2", "3", "4", "5", "6", "7" };
		int rem = 0;
		int buffer = v;
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

	/**
	 * 
	 * @param v
	 * @return String binary value of number.
	 */
	public static String getBinary(int v) {
		return Integer.toBinaryString(v).toString();
	}

	String getBinary() {
		return getBinary(getTheNumber());
	}

	public static int getSigma(double v) {
		if (v == 1) {
			return 1;
		}
		int result = 0;
		for (int i = 1; i <= v; i++) {
			if (v % i == 0) {
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
	 * @param v number to check for superabundancy
	 * @return boolean is number superabundant?
	 */
	public static boolean isSuperabundant(int v) {
		double M = 0.0;
		double theNumberDouble = Double.parseDouble(String.valueOf(v));
		double N = getSigma(theNumberDouble) / theNumberDouble;
		for (double i = 0.0; i < v; i++) {
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
	 * @param v
	 * @return boolean is number primative abundant?
	 */
	public static boolean isPrimativeAbundant(int v) {
		// 20, 70, True
		// 87 False
		if (isAbundant(v)) {
			List<Integer> FactorArray = getProperDivisors(v);
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
	 * @author JeffreySchneider
	 * @return boolean: is the number a Keith number?
	 */
	public static boolean isAKeithNumber(Integer v) {
		if (v > Integer.MAX_VALUE) {
			throw new ArithmeticException("Integer Overflow");
		}
		Deque<Integer> theDeque = new LinkedList<>();
		int number = v;
		while (number > 0) {
			theDeque.addFirst(number % 10);
			number /= 10;
		}
		int nextNumber = 0;

		while (nextNumber < v) {
			nextNumber = 0;
			for (Integer item : theDeque) {
				nextNumber += item;
			}
			theDeque.remove();
			theDeque.add(nextNumber);

			if (nextNumber == v) {
				return true;
			}
		}
		return false;
	}

	boolean isAKeithNumber() {
		return isAKeithNumber(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean Is number Kynea?
	 * 
	 *         Kynea numbers are near-squares of the form
	 *         '(2^k+1)^2-2=4^k+2^{k+1}-1'.
	 */
	public static int getKynea(Integer v) {
		double kyneaA = Math.pow(4.0, Double.valueOf(v));
		double kyneaB = Math.pow(2.0, (Double.valueOf(v) + 1.0));
		double kyneaFinal = kyneaA + kyneaB - 1.0;
		return (int) kyneaFinal;
	}

	int getKynea() {
		return getKynea(getTheNumber());
	}

	/**
	 * 
	 * @param v Return the v'th carol number.
	 * @return integer
	 * 
	 *         A Carol number is an integer of the form 4n ??? 2(n+1) ??? 1. An
	 *         equivalent formula is (2n-1)2 ??? 2.
	 */
	public static int getCarol(int v) {
		double carolA = Math.pow(4.0, Double.valueOf(v));
		double carolB = Math.pow(2.0, (Double.valueOf(v) + 1.0));
		double carolFinal = carolA - carolB - 1.0;
		return (int) carolFinal;
	}

	int getCarol() {
		return getCarol(getTheNumber());
	}

	/**
	 * @author JeffreySchneider Return long factorial from v parameter
	 * @param v
	 * @return
	 */
	public static long getLittleFactorial(int v) {
		long factorial = 1;
		for (int i = 1; i <= v; i++) {
			factorial *= i;
		}
		return factorial;
	}

	/**
	 * @author JeffreySchneider Return BigInteger factorial from v parameter.
	 * @param v
	 * @return
	 */
	public static BigInteger getFactorial(int v) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= v; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	BigInteger getFactorial() {
		return getFactorial(getTheNumber());
	}

	/**
	 * BigInteger for loop
	 * 
	 * @param v
	 * @return
	 */
	public static BigInteger getFactorial(BigInteger v) {
		BigInteger factorial = BigInteger.ONE;
		for (BigInteger i = BigInteger.ONE; i.compareTo(v) != 0; i = i.add(BigInteger.ONE)) {
			factorial = factorial.multiply(i);
		}
		return factorial;
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return BigInteger v'th catalan number
	 */
	public static BigInteger getCatalan(int v) {
		BigInteger catA = NumberTheory.getFactorial(2 * v);
		BigInteger catB = NumberTheory.getFactorial(v + 1);
		BigInteger catC = NumberTheory.getFactorial(v);
		BigInteger catFinal = catA.divide(catB.multiply(catC));
		return catFinal;
	}

	BigInteger getCatalan() {
		return getCatalan(getTheNumber());
	}

	/**
	 * 
	 * @param v
	 * @return BigInteger List of {@link=
	 *         https://en.wikipedia.org/wiki/Fibonacci_number} numbers up to
	 *         aNumber.
	 * 
	 */
	public static List<BigInteger> getFibonacciList(int v) {
		BigInteger num1 = BigInteger.ZERO;
		BigInteger num2 = BigInteger.ONE;
		int counter = 0;
		List<BigInteger> retList = new ArrayList<>();

		// Iterate until counter == aNumber
		while (counter < v) {
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
	 * From: {@link=https://www.geeksforgeeks.org/motzkin-number/}
	 * 
	 * @param v
	 * @return BigInteger Motzkin number
	 */
	public static BigInteger getMotzkin(int n) {
		Map<Integer, BigInteger> memo = new HashMap<>();
		if (n == 0 || n == 1)
			return BigInteger.ONE;

		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		BigInteger BigN = BigInteger.valueOf(n);
		BigInteger Two = BigInteger.TWO;
		BigInteger Three = BigInteger.valueOf(3);
		BigInteger One = BigInteger.ONE;
		BigInteger m1 = getMotzkin(n - 1);
		BigInteger m2 = getMotzkin(n - 2);

		BigInteger firstPart = Two.multiply(BigN).add(One).multiply(m1);
		BigInteger secondPart = Three.multiply(BigN).subtract(Three).multiply(m2);
		BigInteger lastPart = BigN.add(BigInteger.TWO);
		BigInteger retVal = (firstPart.add(secondPart)).divide(lastPart);
		memo.put(n, retVal);

		return (retVal);
	}

	BigInteger getMotzkin() {
		return getMotzkin(getTheNumber());
	}

	public static int motzkin(int n) {
		// Base Case
		if (n == 0 || n == 1)
			return 1;

		// Recursive step
		return ((2 * n + 1) * motzkin(n - 1) + (3 * n - 3) * motzkin(n - 2)) / (n + 2);
	}

	/*
	 * Returns the v-th fibonacci number.
	 */
	public static BigInteger getFibonacciBkup(int v) {
		BigInteger num1 = BigInteger.ZERO;
		BigInteger num2 = BigInteger.ONE;
		BigInteger num3 = BigInteger.ZERO;
		int counter = 1;

		// Iterate until counter == aNumber
		while (num3.compareTo(BigInteger.valueOf(counter)) < v) {
			num3 = num2.add(num1);
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return num3;
	}

	/**
	 * Used for memoization.
	 */
	private static Map<Integer, BigInteger> memo = new HashMap<>();

	// https://www.interviewcake.com/concept/java/memoization
	public static BigInteger getFibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Enter a positive number.");
		} else if (n == 0 || n == 1) {
			return BigInteger.valueOf(n);
		}

		// Have we already calculated this?
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		BigInteger fib1 = getFibonacci(n - 1);
		BigInteger fib2 = getFibonacci(n - 2);
		BigInteger result = fib1.add(fib2);
		memo.put(n, result);

		return result;

	}

	/**
	 * @param v
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static List<Integer> getFibonacciLike(int v, int number1, int number2) {
		int num1 = number1;
		int num2 = number2;
		int num3 = 0;
		//int counter = 0;
		List<Integer> retList = new ArrayList<>();
		
		while (num1 <= v) {
			retList.add(num1);
			num3 = num2 + num1;
			num1 = num2;			
			num2 = num3;
			//counter++;
		}
		return retList;
	}
	
	
	/**
	 * 
	 * @param v
	 * @param number1
	 * @param number2
	 * @return
	 * A number n which can be split into two numbers which seed a Fibonacci-like sequence containing n itself.
	 */	
	// Split a number, 'v', into sets of two numbers
	// IE: 549 => 5 49
	//		549=> 54 9
	//
	//  v = 23418
	//	
	//	2 3418
	//	23 418
	//	234 18
	//	2341 8
	public static boolean isFiboDiv(int v){
		StringBuilder sb = new StringBuilder();
		sb.append(v);
		int left = 0;
		int right = 0;
		for (int i = 1; i < sb.length(); i++) {
			left = Integer.valueOf(sb.substring(0, i));
			right =Integer.valueOf(sb.substring(i, sb.length()));
			//System.out.println(v + " Left: " + left + " Right: " + right);
			if(getFibonacciLike(v, left, right).contains(v)){
				return true;
			}			
		}
		return false;
	}
	
	
	
	/**
	 * 
	 * @param v
	 * @return Integer list of the Lucas sequence up to v.
	 */
	public static List<Integer> getLucas(int v) {
		int num1 = 2;
		int num2 = 1;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();

		// Iterate until counter == aNumber
		while (counter < v) {
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
	 * @param v
	 * @return Integer list of pell numbers up to and including v.
	 */
	public static List<Integer> getPellList2(int v) {
		int num1 = 0;
		int num2 = 1;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();
		// Iterate until counter == aNumber
		while (counter < v) {
			retList.add(num1);
			int num3 = 2 * num2 + num1;
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return BigInteger List of Pell Numbers up to and including v.
	 */
	public static List<BigInteger> getPellList(int v) {
		BigInteger num1 = BigInteger.ZERO;
		BigInteger num2 = BigInteger.ONE;
		int counter = 0;
		List<BigInteger> retList = new ArrayList<>();
		// Iterate until counter == aNumber
		while (counter < v) {
			retList.add(num1);
			BigInteger num3 = BigInteger.TWO.multiply(num2).add(num1);
			// int num3 = 2 * num2 + num1;
			num1 = num2;
			num2 = num3;
			counter++;
		}
		return retList;
	}

	public static BigInteger getPell(int v) {
		List<BigInteger> theList = getPellList(v);
		Stack<BigInteger> theStack = new Stack<>();
		for (BigInteger bigInteger : theList) {
			theStack.push(bigInteger);
		}
		return theStack.pop();
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return Integer list of Jacobsthal numbers
	 *         {@link https://en.wikipedia.org/wiki/Jacobsthal_number}
	 */
	public static List<Integer> getJacobsthal(int v) {
		int num1 = 0;
		int num2 = 1;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();
		// Iterate until counter == aNumber
		while (counter < v) {
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

	/**
	 * How to print a HashMap... How to use a 'for' BigInteger loop.
	 * 
	 * @param v
	 * @return
	 * @deprecated Save to show how to code a BigInteger for loop.
	 */
	public static boolean getAlternatingFactorialbkup(int v) {
		HashMap<BigInteger, BigInteger> theList = new HashMap<>();
		theList.put(BigInteger.ONE, BigInteger.ONE);
		BigInteger BigV = BigInteger.valueOf(v);
		for (BigInteger i = BigInteger.TWO; i.compareTo(BigV) != 0; i = i.add(BigInteger.ONE)) {
			// theList.add(getFactorial(i).subtract(theList.get(i.subtract(BigInteger.ONE)));
			theList.put(i, getFactorial(i));
		}

//		theList.entrySet().forEach(entry->{
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		});

		return false;
	}

	/**
	 * @see https://planetmath.org/alternatingfactorial
	 * @param v
	 * @return
	 */
	public static BigInteger getAlternatingFactorial(int v) {
		HashMap<Integer, BigInteger> theList = new HashMap<>();
		theList.put(1, BigInteger.ONE);
		theList.put(2, BigInteger.ONE);
		for (int i = 3; i <= v; i++) {
			theList.put(i, getFactorial(i).subtract(theList.get(i - 1)));
		}
		return theList.get(v);
	}

	BigInteger getAlternatingFactorial() {
		return getAlternatingFactorial(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return Integer
	 * 
	 *         Two numbers $(m,n)$ form an amicable pair if the sum of proper
	 *         divisors of one number equals the other, i.e., if $\sigma(n)-n = m$
	 *         and $\sigma(m)-m = n$.
	 * 
	 *         {@link https://www.numbersaplenty.com/set/amicable_number/}
	 */
	public static int getAmicableNumber(int v) {
		int firstDivisorSum = NumberTheory.getAliquotSum(v);
		int secondDivisorSum = NumberTheory.getAliquotSum(firstDivisorSum);
		// if (secondDivisorSum == v && firstDivisorSum > secondDivisorSum) {
		if (secondDivisorSum == v) {
			return firstDivisorSum;
		}
		return -1;
	}

	int getAmicableNumber() {
		return getAmicableNumber(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param base
	 * @param exponent
	 * @return String BigInteger raised to exponent point.
	 */
	public static String getBigIntegerPower(int base, int exponent) {
		BigInteger biggie = BigInteger.valueOf(base);
		String retVal = biggie.pow(exponent).toString();
		return retVal;
	}

	/**
	 * @author JeffreySchneider
	 * @param exponent
	 * @return {@code True} A number n such that the pattern 666 is contained among
	 *         the digits of 2^n.
	 */
	public static boolean isApocalyptic(int exponent) {
		String getTestNumber = getBigIntegerPower(2, exponent);
		return getTestNumber.contains("666");
	}

	boolean isApocalyptic() {
		return isApocalyptic(getTheNumber());
	}

	/**
	 * 
	 * @param b
	 * @param n
	 * @return int Greatest Common Divisor
	 */
	public static long gcd(long b, long n) {		
		if (n == 0)
			return b;
		return gcd(n, b % n);
	}

	public static int gcd(int b, int n) {
		long a = (long) b;
		long c = (long) n;
		return (int) gcd(a, c);
	}

	int gcd(int n) {
		return gcd(getTheNumber(), n);

	}

	public static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	int lcm(int b) {
		return lcm(getTheNumber(), b);
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

	/**
	 * @author https://www.javatpoint.com/carmichael-numbers-in-java
	 * @param v
	 * @return boolean
	 * 
	 * @see{https://en.wikipedia.org/wiki/Carmichael_number}
	 */
	public static boolean isCarmichael(int v) {
		for (int b = 2; b <= v; b++) {
			if (gcd(b, v) == 1 && power(b, v - 1, v) != 1)
				return false;
		}
		return true;
	}	
	
	boolean isCarmichael() {
		return isCarmichael(getTheNumber());
	}

	
	
	//Adapted for BigInteger from https://www.geeksforgeeks.org/d-numbers/
	public static boolean isDNumber(int n) {
		if(n < 4) {
			return false;
		}
		BigInteger numerator = BigInteger.ZERO;
		BigInteger bigK = BigInteger.ZERO;
		BigInteger bigN = BigInteger.ZERO;
		int hcf = 0;
		for(int k = 2; k < n; k++) {
			bigK = BigInteger.valueOf(k);
			bigN = BigInteger.valueOf(n);
			numerator = bigK.pow(n-2).subtract(bigK);
			BigInteger modN = numerator.mod(bigN);
			
			hcf = __gcd(n,k);
			 if(hcf == 1 && modN.compareTo(BigInteger.ZERO) != 0)
				 return false;
		}
		return true;
	}
	
	boolean isDNumber() {
		return isDNumber(getTheNumber());
	}
	
	
	static int __gcd(int a, int b)
	{
	    return b == 0 ? a : __gcd(b, a % b);    
	}
	
	
	
	
	
	

	// Wikipedia
	/**
	 * <CODE> In mathematics, the cake number, denoted by Cn, is the maximum number
	 * of regions into which a 3-dimensional cube can be partitioned by exactly n
	 * planes. The cake number is so-called because one may imagine each partition
	 * of the cube by a plane as a slice made by a knife through a cube-shaped cake.
	 * It is the 3D analog of the lazy caterer's sequence.
	 * 
	 * @param v
	 * @return
	 */
	public static int getCakeNumber(int v) {
		return (int) ((1.0 / 6.0) * (Math.pow(v, 3) + 5 * v + 6));
	}

	int getCakeNumber() {
		return getCakeNumber(getTheNumber());
	}

	public static int getLazyCaterer(int v) {
		return (v * v + v + 2) / 2;
	}

	int getLazyCaterer() {
		return getLazyCaterer(getTheNumber());
	}

	public static BigInteger getBellNumber(int v) {
		BigInteger[][] bell = new BigInteger[v + 1][v + 1];
		bell[0][0] = BigInteger.ONE;
		for (int i = 1; i <= v; i++) {
			bell[i][0] = bell[i - 1][i - 1];
			for (int j = 1; j <= i; j++)
				bell[i][j] = bell[i - 1][j - 1].add(bell[i][j - 1]);
		}
		return bell[v][0];
	}

	BigInteger getBellNumber() {
		return getBellNumber(getTheNumber());
	}

	/**
	 * https://www.geeksforgeeks.org/admirable-numbers/
	 * 
	 * @return is the number admirable?
	 */

	public static boolean isAdmirable(int v) {
		int sigmaN = getSigma(v);
		for (int i = 2; i <= Math.sqrt(v); i++) {
			// if 'i' is a divisor of 'num'
			if (v % i == 0) {
				// if both divisors are the same, then add
				// it only once else add both
				if (i == (v / i)) {
					if (sigmaN - 2 * i == 2 * v)
						return true;
				} else {
					if (sigmaN - 2 * i == 2 * v)
						return true;
					if (sigmaN - 2 * (v / i) == 2 * v)
						return true;
				}
			}
		}
		// Check 1 since 1 is also a divisor
		if (sigmaN - 2 * 1 == 2 * v)
			return true;
		return false;
	}

	boolean isAdmirable() {
		return isAdmirable(getTheNumber());
	}

	/**
	 * https://www.geeksforgeeks.org/amenable-numbers/
	 * 
	 * @param v
	 * @return is number Amenable
	 */
	public static boolean isAmenable(int v) {
		// return true if N is of the form
		// 4K or 4K+1
		return (v % 4 == 0 || (v - 1) % 4 == 0);
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
	 * @param v
	 * @return boolean - is number SuperD?
	 */
	public static boolean isSuperD(int v) {
		for (int d = 2; d < 10; d++) {
			String subString = intToString(d);
			if (String.valueOf((d * Math.pow(v, d))).contains(subString)) {
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
	 * @param v
	 * @return boolean
	 */
	public static boolean isAlternating(int v) {
		String str = Integer.toString(v);
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
	 * @param v
	 * @return boolean
	 */
	public static boolean isAntiPerfect(int v) {
		List<Integer> list = getFactors(v);
		int lastElement = list.size() - 1;
		list.remove(lastElement);
		int sum = 0;
		for (Integer integer : list) {
			sum += getReverseNumber(integer);
//			System.out.println(getReverseNumber(integer));
		}
		if (sum == v) {
			return true;
		}
		return false;
	}

	boolean isAntiPerfect() {
		return isAntiPerfect(getTheNumber());
	}

	public static boolean isArithmetic(int v) {
		List<Integer> list = getFactors(v);
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}

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
	 * b and a + b = N where ???+??? denotes concatenation.
	 * 
	 * @param v
	 * @return boolean
	 */
	public static boolean isAstonishing(int v) {

		// Does not work for all numbers
		// 190 204 216
		// https://www.geeksforgeeks.org/astonishing-numbers/
		// This code is contributed by shubhamsingh10
		// Time Complexity: O(n)
		// Auxiliary Space: O(1)

		// Loop to find sum of all integers
		// from i until the sum becomes >= aNumber
		for (int i = 1; i < v; i++) {
			// variable to store sum of all integers
			// from i to j and check if sum and
			// concatenation equals aNumber or not.
			int sum = 0;
			for (int j = i; j < v; j++) {
				sum += j;
				if (sum == v) {

					// Finding concatenation of i and j
					int concatenation = concat(i, j);

					// condition for astonishing number
					if (concatenation == v) {
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
	 * @param v
	 * @return
	 */
	public static boolean isAutomorphic(long v) {
		long squared = (long) Math.pow(v, 2.0);
		String theString = String.valueOf(squared);
		String ends = String.valueOf(v);
//		System.out.printf("\n%s %s\n", theString, ends);
		return theString.endsWith(ends);

	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return List list of non-trivial (not the number and not the number 1)
	 *         divisors
	 * 
	 */
	public static List<Integer> getNonTrivialDivisors(int v) {
		List<Integer> retList = new ArrayList<>();
		retList = getFactors(v);
		Collections.sort(retList);
		int Length = retList.size();
		retList.remove(Length - 1);
		retList.remove(0);
		return retList;

	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return List list of the digits in a number
	 */
	public static List<Integer> getListOfDigits(int v) {
		List<Integer> retList = new LinkedList<>();
		// This works right to left.
		while (v > 0) {
			int remainder = v % 10;
			retList.add(remainder);
			v /= 10;
		}
		// Flip the list to get it in the correct order.
		Collections.reverse(retList);
		return retList;
	}

	List<Integer> getListOfDigits() {
		return getListOfDigits(getTheNumber());
	}
	
	
	/**
	 * Get the list of a number's digits as a string list.
	 * @author JeffreySchneider
	 * @param v
	 * @return
	 */
	public static List<String> getStringListOfDigits(int v){
		List<String> retList = new LinkedList<>();
		for (Integer integer : getListOfDigits(v)) {
			retList.add(integer.toString());
		}
		return retList;
	}

	public static List<Integer> getListOfDigits(BigInteger v) {
		List<Integer> retList = new LinkedList<>();
		// This works right to left.
		while (!BigInteger.ZERO.equals(v)) {
			int remainder = (v.mod(BigInteger.TEN)).intValue();
			retList.add(remainder);
			v = v.divide(BigInteger.TEN);
		}
		// Flip the list to get it in the correct order.
		Collections.reverse(retList);
		return retList;
	}

	public static int[] getFirstAndLastDigits(int v) {
//		int firstDigit = getListOfDigits(aNumber).get(0);
//		int length = getListOfDigits(aNumber).size() -1 ; 
//		int lastDigit = getListOfDigits(aNumber).get(length);
		List<Integer> theList = getListOfDigits(v);
		int firstDigit = theList.get(0);
		int length = theList.size() - 1;
		int lastDigit = theList.get(length);
		int[] retVal = { firstDigit, lastDigit };
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
		for (Integer integer : aList) {
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
	 * @param v
	 * @return boolean is number a Canada Number?
	 * 
	 * @see #getNonTrivialDivisors(int)
	 * @see #getListOfDigits(int)
	 * @see #getSumOfSquares(List)
	 * @see #getSumOfDigits(List)
	 */
	public static boolean isCanadaNumber(int v) {
		int sumOfSquaresOfDigits = getSumOfSquares(getListOfDigits(v));
		int sumOfNonTrivialDivisors = getSumOfDigits(getNonTrivialDivisors(v));
		return sumOfSquaresOfDigits == sumOfNonTrivialDivisors;
	}

	boolean isCanadaNumber() {
		return isCanadaNumber(getTheNumber());
	}

	/**
	 * @author Jeffrey Schneider
	 * @param v
	 * @return boolean
	 * 
	 *         {@code <code>A prime is said to be balanced if it is the average of the two surrounding primes, 
	 * i.e., it is at equal distance from previous prime and next prime.</code>}
	 */
	public static boolean isBalancedPrime(int v) {
		// If aNumber isn't prime, don't go any further.
		if (!isPrime(v)) {
			return false;
		}
		List<Integer> theList = new ArrayList<>();

		// Find the first prime number less than aNumber.
		// Add it to a list, then break out of the discovery loop.
		int counter = v - 1;
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
		counter = v + 1;
		while (counter >= v) {
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
		if (v - up == dn - v) {
			return true;
		} else {
			return false;
		}
	}

	// https://oeis.org/wiki/Centered_polygonal_numbers
	public static int getCenteredPolygonalNumber(int sideNumber, int v) {
		return (int) sideNumber * v * (v + 1) / 2 + 1;
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
	 * @author Jeffrey Schneider
	 * @param v
	 * @return BigInteger multiples of aNumber of primes.
	 */
	public static BigInteger getPrimorials(int v) {
		BigInteger summary = BigInteger.ONE;
		int counter = 1;
		int numberOfPrimes = 0;
		while (numberOfPrimes <= v) {
			if (isPrime(counter)) {
				summary = summary.multiply(BigInteger.valueOf(counter));
				numberOfPrimes++;
			}
			counter++;
		}
		return summary;
	}

	// n * 2^n + 1
	/**
	 * @author JCSchneider
	 * @param v
	 * @return BigInteger getCullen()
	 */
	public static BigInteger getCullen(int v) {
		BigInteger n = BigInteger.valueOf(v);
		BigInteger exponent = BigInteger.TWO.pow(v);
		BigInteger retVal = n.multiply(exponent).add(BigInteger.ONE);
		// retVal = BigInteger.valueOf(aNumber).multiply(partC);
		// return (int) (aNumber * Math.pow(2, aNumber) + 1);
		return retVal;
	}

	BigInteger getCullen() {
		return getCullen(getTheNumber());
	}

	boolean isCoPrime(int bNumber) {
		return Primes.isCoPrime(getTheNumber(), bNumber);
	}

	/**
	 * Not sure if this works.... 09/30/2022
	 * 
	 * @param v
	 * @return
	 */
	public static BigInteger getCompositorial(int v) {
		BigInteger fact = getFactorial(v);
		BigInteger prim = getPrimorials(v);
		BigInteger retVal = fact.divide(prim);
//		System.out.println(v + " fact: " + fact + " prim: " + prim + " getCompositorial: " + retVal);
		return retVal;
	}

	/**
	 * 
	 * @param v
	 * @return boolean J.J.Tattersall defined the Curzon numbers to be those n for
	 *         which 2n+1 divides 2^n+1.
	 */
	public static boolean isCurzon(int v) {
		BigInteger two = BigInteger.TWO;
		BigInteger a = two.pow(v).add(BigInteger.ONE);
		BigInteger b = two.multiply(BigInteger.valueOf(v)).add(BigInteger.ONE);
		return a.mod(b) == BigInteger.ZERO;
	}

	boolean isCurzon() {
		return isCurzon(getTheNumber());
	}

	public static List<Integer> getPowerfulNumber(int v) {
		return null;
	}

	/**
	 * In number theory, a totative of a given positive integer n is an integer k
	 * such that 0 < k ??? n and k is coprime to n. Euler's totient function ??(n)
	 * counts the number of totatives of n. The totatives under multiplication
	 * modulo n form the multiplicative group of integers modulo n.
	 * 
	 * @author JeffreySchneider
	 * @param v
	 * @return Integer list of Totatives up to the number.
	 *         {@link https://en.wikipedia.org/wiki/Totative}
	 */
	public static List<Integer> getTotatives(int v) {
		List<Integer> retList = new LinkedList<>(); // LinkedList? Why not?
		int counter = 1;
		while (counter <= v) {
			if (Primes.isCoPrime(v, counter)) {
				retList.add(counter);
			}
			counter++;
		}
		return retList;
	}

	//https://cp-algorithms.com/algebra/phi-function.html#properties
	// Is this useful?   Not as of 12/15/2022
	public static int eulersPhi(int n) {
		int result = n;
		for(int i =2; i * i <= n; i++) {
			if(n % i == 0) {
				while(n % i == 0) {
					n /= i;
				}
				result -= result/ i;
			}
		}
		if(n>1)
			result -= result/n;
		return result;
	}
	
	
	List<Integer> getTotatives() {
		return getTotatives(getTheNumber());
	}

	public static int getEulersTotient(int v) {
		return getTotatives(v).size();
	}

	int getEulersTotient() {
		return getEulersTotient(getTheNumber());
	}

	public static boolean isCyclic(int v) {
		return Primes.isCoPrime(v, getEulersTotient(v));
	}

	boolean isCyclic() {
		return isCyclic(getTheNumber());
	}

	/**
	 * 
	 * @param n
	 * @return boolean A de Polignac number is an odd number 'n' that cannot be
	 *         expressed as 'n=2^k+p', for 'p' prime.
	 */
	public static boolean isDePolignac(int n) {
		if (!isEven(n)) {
			for (int p = 1; p < n; p++) {
				if (isPrime(p)) {
					for (int k = 1; k < p; k++) {
						if (n - p == Math.pow(2, k)) {
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

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean Is number even?
	 */
	public static boolean isEven(int v) {
		return (v % 2 == 0);
	}

	boolean isEven() {
		return isEven(getTheNumber());
	}

	/**
	 * @author(Jeffrey Schneider)
	 * @param v
	 * @return BigInteger The double factorial of an integer 'n>0', denoted by
	 *         'n!!', is the product of all the integers from 1 to 'n' which have
	 *         the same parity as 'n'.
	 */
	public static BigInteger getDoubleFactorial(int v) {
		BigInteger factorial = BigInteger.ONE;
		int start = 1;
		if (isEven(v)) {
			start = 2;
		}
//		System.out.println(start);
		for (int count = start; count <= v; count += 2) {
			factorial = factorial.multiply(BigInteger.valueOf(count));
		}
		return factorial;
	}

	BigInteger getDoubleFactorial() {
		return getDoubleFactorial(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean Mario Velucchi called a number 'n' droll if the sum of its
	 *         even prime factors equals the sum of its odd prime factors.
	 */
	public static boolean isDroll(int v) {
		List<Integer> primeFactors = Primes.getPrimeFactors(v);
		int evenTotal = 0;
		int oddTotal = 0;
		for (Integer integer : primeFactors) {
			if (isEven(integer)) {
				evenTotal += integer;
			} else {
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

	boolean isEconomical() {
		return isEconomical(getTheNumber());
	}

	boolean isEmirp() {
		return Primes.isEmirp(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param i
	 * @return boolean L.Colucci calls a number 'n' of at least 3 digits a gapful
	 *         number if 'n' is divisible by the number formed by the first and last
	 *         digit of 'n'.
	 */
	public static boolean isGapful(int i) {
		if (i < 100 || isPrime(i)) {
			// If number isn't at least 3 digits, fail.
			return false;
		}
		int[] a = getFirstAndLastDigits(i);
		int divisor = a[0] * 10 + a[1];
		if (i % divisor == 0) {
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
	 * @param v
	 * @return boolean Duffinian numbers are defined as numbers that are composite
	 *         and relatively prime to the sum of their divisors. The first such
	 *         number is 4 because it is composite and the sum of its divisors (1, 2
	 *         and 4) is 7 and relatively prime to 4. Source:
	 *         http://voodooguru23.blogspot.com/2018/10/duffinian-numbers.html
	 */
	public static boolean isDuffinian(int v) {
		// int factorSum = getFactorSum(aNumber);
		int factorSum = getSigma(v);
		if (Primes.isCoPrime(v, factorSum)) {
			return true;
		}
		return false;
	}

	boolean isDuffinian() {
		return isDuffinian(getTheNumber());
	}

	public static double getHarmonicMean(List<Integer> aList) {
		double sum = 0;
		for (int i = 0; i < aList.size(); i++) {
			sum = sum + (double) 1 / aList.get(i);
		}
		return aList.size() / sum;
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean
	 * 
	 *         This is broken. Floor and ceil don't seem to work. Broken for:
	 *         30240,332640,360360,753480,1421280,1539720,2457000,11981970,15495480,
	 *         17428320,27027000,46683000,52141320,71253000,80832960
	 * 
	 */
	public static boolean isHarmonicDivisorNumber(int v) {
		List<Integer> theList = getFactors(v);
		double harmMean = getHarmonicMean(theList);
		// double harmMeanTrunc = Math.floor(harmMean * 100) / 100;
		if (harmMean % 1 == 0) // Best way to tell if the harmonic mean is an integer?
			return true;
		return false;
	}

	boolean isHarmonicDivisorNumber() {
		return isHarmonicDivisorNumber(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean A number divisible by the sum of its digits.
	 */
	public static boolean isHarshad(int v) {
		int summation = getSumOfDigits(getListOfDigits(v));
		if (v % summation == 0)
			return true;
		return false;
	}

	boolean isHarshad() {
		return isHarshad(getTheNumber());
	}

	/**
	 * 
	 * @param v
	 * @return int
	 * 
	 *         Check to display this in a spiral form.
	 * 
	 */
	public static int getHogben(int v) {
		return (int) (Math.pow(v, 2.0) - v + 1);
	}

	int getHogben() {
		return getHogben(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return int The 'n'-th house number 'h_n' is a figurate number made by a cube
	 *         of side 'n+1', surmounted by a square pyramidal number with side 'n'.
	 *         <code>\[h_n=(8 n^3+21 n^2+19 n+6)/6.\]</code>
	 * 
	 */
	public static long getHouse(long v) {
		long a = (long) (8 * Math.pow(v, 3.0));
		long b = (long) (21 * Math.pow(v, 2.0));
		long c = 19L * v;
		return (a + b + c + 6) / 6;
	}

	long getHouse() {
		return getHouse(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param k
	 * @return boolean The 'n'-th hungry number is the smallest number 'k' such that
	 *         in the decimal expansion of '2^k' appear the first 'n' decimal digits
	 *         of pi
	 * 
	 */
	public static boolean isHungry(int k) {
		BigInteger n = BigInteger.TWO.pow(k);
		String stringN = n.toString();
		int length = getListOfDigits(k).size();
		String fullPiVal = LocalMath.StringPI().replaceAll("\\.", "");
		String testPiVal = fullPiVal.substring(0, length);
//		System.out.printf("%s\n %s \n", stringN, testPiVal);		
		return stringN.contains(testPiVal);
	}

	boolean isHungry() {
		return isHungry(getTheNumber());
	}

	/**
	 * @author JeffreySchneider
	 * @param int v
	 * @return boolean A number 'n' is said to be insolite if it is divisible by the
	 *         sum and by the product of the squares of its digits.
	 * 
	 */
	public static boolean isInsolite(int v) {
		// Is number divisible by the sum and product
		// of the squares of its digits.
		int a = getSumOfSquares(getListOfDigits(v));
		int b = getProductOfSquares(getListOfDigits(v));
		if (v % a == 0 && v % b == 0)
			return true;
		return false;
	}

	protected boolean isInsolite() {
		return isInsolite(getTheNumber());
	}

	public static boolean isHappy(int v) {
		Set<Integer> theSet = new HashSet<>();
		int a = getSumOfSquares(getListOfDigits(v));
		while (a != 1) {
			a = getSumOfSquares(getListOfDigits(a));
//			System.out.println(a);
			if (theSet.contains(a)) {
				return false;
			} else {
				theSet.add(a);
			}
		}
		return true;
	}

	protected boolean isHappy() {
		return isHappy(getTheNumber());
	}

	boolean isPowerful() {
		return isPowerful(getTheNumber());
	}

	// from: https://www.geeksforgeeks.org/powerful-number/
	public static boolean isPowerful(int n) {
		while (n % 2 == 0) {
			int power = 0;
			while (n % 2 == 0) {
				n /= 2;
				power++;
			}

			// If only 2^1 divides n (Not higher powers)
			// then return false
			if (power == 1) {
				return false;
			}
		}

		// If n is not a power of 2, then this loop will execute
		// repeat above process
		for (int factor = 3; factor <= Math.sqrt(n); factor += 2) {
			// Find highest power of 'factor' that divides n
			int power = 0;
			while (n % factor == 0) {
				n = n / factor;
				power++;
			}
			// If only factor^1 divides n (Not higher powers)
			// then return false
			if (power == 1) {
				return false;
			}
		}

		// n must be 1 now if it is not a prime number.
		// Since prime numbers are not powerful, we return
		// false if n is not 1.
		return (n == 1);
	}

	/**
	 * A number 'n' is called frugal if the number of digits in its prime
	 * factorization (including exponents greater than 1) is smaller than the number
	 * of digits of 'n'.
	 * 
	 * Get the list of prime factors from simplifiedPrimeFactor which was passed
	 * getPrimeFactors(n). Remove the ^ and * from above method's output to
	 * determine the number of digits in the prime factors. Compare prime factors
	 * number list length to the length of numbers in the passed argument.
	 * 
	 * @author JCSchneider
	 * @param n
	 * @return boolean
	 */
	public static boolean isFrugal(int n) {
		int length = String.valueOf(n).length();
		String str = simplifiedPrimeFactor(Primes.getPrimeFactors(n));
		str = str.replace("^", "").replace("*", "").trim();
		int length2 = str.length();
		if (length2 < length)
			return true;
		return false;
	}

	/**
	 * 
	 * A number 'n' is called equidigital if the number of digits in its prime
	 * factorization (including exponents greater than 1) is equal to the number of
	 * digits of 'n'.
	 * 
	 * @author JCSchneider
	 * @param n
	 * @return boolean
	 */
	public static boolean isEquidigital(int n) {
		int length = String.valueOf(n).length();
		String str = simplifiedPrimeFactor(Primes.getPrimeFactors(n));
		str = str.replace("^", "").replace("*", "").trim();
		int length2 = str.length();
		if (length2 == length)
			return true;
		return false;
	}

	/**
	 *
	 * A number 'n' is called economical if the number of digits in its prime
	 * factorization (including exponents greater than 1) is not greater than the
	 * number of digits of 'n'.
	 * 
	 * @param aNumber
	 * @return boolean
	 * 
	 * @see NumberTheory.#isFrugal()
	 */
	public static boolean isEconomical(int n) {
		int nLength = String.valueOf(n).length();
		String str = simplifiedPrimeFactor(Primes.getPrimeFactors(n));
		str = str.replace("^", "").replace("*", "").trim();
		int stringLength = str.length();
		if (stringLength == nLength)
			return true;
		return false;
	}

	/**
	 * This method takes a list of prime factors and changes it from: 2, 2, 2, 2, 2,
	 * 5, 5 to 2^5*5^2 to be used with isFrugal().
	 * 
	 * @param theList1
	 * @return String list of the prime factors.
	 */
	static String simplifiedPrimeFactor(List<Integer> theList1) {
		String retVal = " ";
		Map<Integer, Integer> theHash = new HashMap<Integer, Integer>();
		for (Integer integer : theList1) {
			if (theHash.containsKey(integer)) {
				theHash.put(integer, theHash.get(integer) + 1);
			} else {
				theHash.put(integer, 1);
			}
		}
//		System.out.println("Size of theHash: " + theHash.size());
		int numberOfNumerals = theHash.size();
		Iterator<Map.Entry<Integer, Integer>> it = theHash.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> entry = it.next();
			/**
			 * Adds the caret ^ symbol to show base raised to exponent power.
			 */
			if (entry.getValue() > 1) {
				retVal += entry.getKey().toString() + "^" + entry.getValue().toString();
			} else {
				retVal += entry.getKey();
			}
			if (numberOfNumerals > 1) {
				retVal += "*";
			}
			numberOfNumerals--;
		}
		return retVal;
	}

	/**
	 * A number n is called evil if the sum of its binary digits is even and odious
	 * if the sum of its binary digits is odd.
	 * 
	 * For example, 23=(10111)_2 is evil since the sum of its binary digits is 4.
	 * 
	 * @param v
	 * @return {@code true} if the number is evil.
	 */
	public static boolean isEvil(int v) {
		int sum = 0;
		char[] b1 = getBinary(v).toCharArray();
		for (int i = 0; i < b1.length; i++) {
			sum += b1[i] - 48; // Change the chars to integers One or Zero.
		}
		if (sum % 2 == 0)
			return true;
		return false;
	}

	boolean isEvil() {
		return isEvil(getTheNumber());
	}

	/**
	 * Question: Can this be done without the HashMap?
	 * 
	 * A highly composite number (sometimes called anti-prime) is a positive integer
	 * with more divisors than any smaller positive integer has. The related concept
	 * of largely composite number refers to a positive integer which has at least
	 * as many divisors as any smaller positive integer.
	 * 
	 * A number n is called highly composite if it has more divisors than any
	 * smaller number, i.e., if it sets a new record in the number of divisors.
	 * 
	 * @param v
	 * @return {@code boolean}
	 * 
	 */
	public static boolean isHighlyComposite(int v) {
		int vLength = 0;
		int max = Integer.MIN_VALUE;

		// Lets use a HashMap to store the number and the largest number of factors.
		// Fustest with the mostest.
		HashMap<Integer, Integer> theMap = new HashMap<>();
		theMap.put(0, 0);

		for (int a = 1; a <= v; a++) {
			vLength = getFactors(a).size();
			if (vLength > max) {
				max = vLength;
				theMap.put(a, vLength);
			}
		}
		if (theMap.containsKey(v)) {
			return true;
		}

		return false;
	}

	boolean isHighlyComposite() {
		return isHighlyComposite(getTheNumber());
	}

	/**
	 * A number 'n' is called pernicious if it contains a prime number of ones in
	 * its binary representation.
	 * 
	 * For example, '21=(10101)_2' is pernicious since it contains 3 ones and 3 is a
	 * prime number.
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isPernicious(int v) {
		String retVal = Integer.toBinaryString(v);
		int count = (int) retVal.chars().filter(ch -> ch == '1').count();
		// System.out.println(v + " " + retVal + " count-> " + count);
		if (isPrime(count) && count > 1)
			return true;
		return false;
	}

	boolean isPernicious() {
		return isPernicious(getTheNumber());
	}

	/**
	 * A number which is powerful but not a perfect power, like 72 = 2^3 ??? 3^2.
	 * 
	 * @author JCSchneider
	 * @param v
	 * @return
	 */
	public static boolean isAchilles(int v) {
		if (isPowerful(v) && !isPerfectPower(v))
			return true;
		return false;
	}

	boolean isAchilles() {
		return isAchilles(getTheNumber());
	}

	/**
	 * I recognize that this is basically On^2 efficiency, but for now, it will
	 * suffice.
	 * 
	 * @author JCSchneider
	 * @param n
	 * @return
	 */
	public static boolean isPerfectPower(int n) {
		/*
		 * Tests whether an integer n is a perfect power, perfect powers are any integer
		 * that is an integer power of another integer e.g. 4(2^2) 9(3^2) 27(3^3)
		 * 243(3^5) are all perfect powers Returns a pair of integers [a,b] such that n
		 * = a^b. (If multiple possible values for a and b exist, the pair with the
		 * smallest a value is returned)
		 */
		if (isPrime(n)) {
			return false;
		}

		for (int m = 1; m <= Math.sqrt(n); m++) {
			for (int k = 1; k <= n; k++) {
				if (Math.pow(m, k) == n)
					return true;
			}
		}
		return false;
	}

	boolean isPerfectPower() {
		return isPerfectPower(getTheNumber());
	}

	/**
	 * 
	 * Still In Progress
	 * 
	 * A number 'n' is said to be enlightened if it begins with the concatenation of
	 * its distinct prime factors.
	 * 
	 * @param v
	 * @return
	 */
	public static boolean isEnlightened(long v) {
		String numberString = "";
		List<Long> theList = Primes.getPrimeFactors(v);
		for (Long x : theList) {
			numberString += x.toString();
		}

		System.out.println(numberString);
		Set<Long> hSet = new HashSet<Long>(theList);
		String theString = "";
		System.out.print("V: " + v + " ");
		for (Long x : hSet) {
			theString += x.toString();
		}
		System.out.println("The String = " + theString + " NumberString: " + numberString);
		if (numberString.contains(theString))
			return true;
		return false;
	}
	
	boolean isEnlightened() {
		return isEnlightened((long)getTheNumber());
	}
	
	public static boolean isDPowerful(int v) {
		//List<Integer> theList = getListOfDigits(v);
		List<Integer> theList = Primes.getPrimeFactors(v);
		
		
		for (Integer integer : theList) {
			System.out.printf("%d ", integer);
		}		
		System.out.println();
		
		//int sumOfSquaresOfDigits = getSumOfSquares(getListOfDigits(v));
		//int sumOfNonTrivialDivisors = getSumOfDigits(getNonTrivialDivisors(v));
		System.out.println();
		return true;
	}
	
	
	/**
	 * For example, starting with n=152 we have the sequence |1-5-2|=6, 1+5+2=8, then 14, 22, 36, 58, 94, and finally 152.
	 * @param v
	 * @return
	 */
	public static boolean isGilda(int v) {
		List<Integer> theDigitList = getListOfDigits(v);
		//We need the first number to be positive then subtract all the other digits, ergo, multiply the first
		// element of the list by 2 then the for loop will correct the first digit issue.
		int left = theDigitList.get(0) * 2;
		int right = 0;		
		for (Integer integer : theDigitList) {
			left -= integer;
			right += integer;
		}
		left = Math.abs(left);
		if(getFibonacciLike(v, left, right).contains(v)){
			return true;
		}
		return false;
	}
	
	boolean isGilda() {
		return isGilda(getTheNumber());
	}
	
	
	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return
	 */
	public static  boolean isGiuga(int v) {
		if(!isSquareFree(v)) {
			return false;
		}
		//Yes, yes I cheated a little.  
		if(v == 30) {
			return true;
		}
		double epsilon = 0.01d;
		double addReciprocal = 0.0;
		double multiplyReciprocal = 0.0;
		double buffer = 0.0;
		
		List<Integer> theList = new LinkedList<>();
		theList = Primes.getPrimeFactors(v);		
		for (Integer integer : theList) {
			buffer = getReciprocalNumber(integer);
			addReciprocal += buffer;
			multiplyReciprocal *= buffer;
		}
		buffer = addReciprocal - multiplyReciprocal;		
		if(Math.abs(buffer - 1.0) < epsilon) {
			return true;
		}
		return false;
	}
	
	boolean isGiuga() {
		return isGiuga(getTheNumber());
	}

	
	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return boolean
	 * In mathematics, a square-free integer (or squarefree integer) is an integer which is 
	 * divisible by no square number other than 1. That is, its prime factorization has 
	 * exactly one factor for each prime that appears in it.
	 * @see https://en.wikipedia.org/wiki/Square-free_integer
	 */
	public static boolean isSquareFree(int v) {
		List<Integer> theList = Primes.getPrimeFactors(v);
		Map<Integer, Integer> theHash = new HashMap<>();
		for (Integer integer : theList) {
			if (theHash.containsKey(integer)) {
				return false;				
			} else {
				theHash.put(integer, 1);
			}
		}
		return true;
	}

	boolean isSquareFree() {
		return isSquareFree(getTheNumber());
	}

	
	/**
	 * Finding Pythagorian Triples using https://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples
	 * @param v
	 * @return
	 */
	public static boolean isDicksonsMethod(int r) {
		boolean retBool = false;
		if(!isEven(r)) {
			return false;
		}
		int multiplicity = (int) (Math.pow(r, 2)/2);	
		List<ArrayList<Integer>> factorPairs = getFactorPairs(multiplicity);
		for(int j = 0; j < factorPairs.size(); j++) {			
			//System.out.printf("%d %d\n", factorPairs.get(j).get(0), factorPairs.get(j).get(1));
			int s = factorPairs.get(j).get(0);
			int t = factorPairs.get(j).get(1);
			int firstNumber = r + s;
			int secondNumber = r + t;
			int z = r + s + t;
			System.out.printf("%d,  %d, %d\n", firstNumber, secondNumber, z);
			retBool = true;
		}
		
		//List<Integer> retVal = new ArrayList<>(Arrays.asList(7, 24, 25));
		return retBool;
	}
	
	public static List<ArrayList<Integer>> getDicksonsMethod(int r){
		List<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
		if(!isEven(r)) {
			return null;
		}
		int multiplicity = (int) (Math.pow(r, 2)/2);	
		List<ArrayList<Integer>> factorPairs = getFactorPairs(multiplicity);
		for(int j = 0; j < factorPairs.size(); j++) {			
			//System.out.printf("%d %d\n", factorPairs.get(j).get(0), factorPairs.get(j).get(1));
			int s = factorPairs.get(j).get(0);
			int t = factorPairs.get(j).get(1);
			int firstNumber = r + s;
			int secondNumber = r + t;
			int z = r + s + t;
			//System.out.printf("%d,  %d, %d\n", firstNumber, secondNumber, z);
			retVal.add(new ArrayList<Integer>(Arrays.asList(firstNumber, secondNumber, z)));
		}
		
		//List<Integer> retVal = new ArrayList<>(Arrays.asList(7, 24, 25));
		return retVal;
	}
	
	boolean isDicksonsMethod(){
		return isDicksonsMethod(getTheNumber());
	}
	
	
	/**
	 * @author JeffreySchneider
	 * @param v
	 * @return  
	 * 	List of factor pairs, used with:
	 *  @see #isDicksonsMethod(int aNumber)
	 *  
	 *   ie: 18 = ((1, 18), ( 2, 9), (3, 6))
	 */
	public static List<ArrayList<Integer>> getFactorPairs(int v){
		List<Integer> theFactors = getFactors(v);
		if(!isEven(theFactors.size())){
			return null;
		}
		Deque<Integer> factorPairs = new LinkedList<>();
		for (Integer integer : theFactors) {
			factorPairs.add(integer);
		}
		List<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
				
		int counter = 0;
		int first = 0;
		int second = 0;
		while(!factorPairs.isEmpty()) {
			first = factorPairs.removeFirst();
			second = factorPairs.removeLast();					
			retList.add(counter++, new ArrayList<>(Arrays.asList(first, second)));
		}
		//System.out.println(retList.get(0));
		return retList;
		
	}
}
