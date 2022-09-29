package numberTheory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.function.BooleanSupplier;

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
	 * @return getSquare of the instance variable theNumber
	 */
	int getSquare() {
		return getSquare(getTheNumber());
	}

	/**
	 * 
	 * @param aNumber the number to square
	 * @return the square of a number
	 */
	public static int getSquare(int aNumber) {
		return aNumber * aNumber;
	}

	/**
	 * 
	 * @return boolean
	 * @see #isPrime(int)
	 */
	boolean isPrime() {
		return isPrime(getTheNumber());
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

	/**
	 * 
	 * @return
	 * @see #getCollatz(int aNumber)
	 */
	List<Integer> getCollatz() {
		return getCollatz(getTheNumber());
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

	List<Integer> getJugglers() {
		return getJugglers(getTheNumber());
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

	List<Integer> getFactors() {
		return getFactors(getTheNumber());
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

	List<Integer> getPrimeFactors() {
		return getPrimeFactors(getTheNumber());
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

	int getAliquotSum() {
		return getAliquotSum(getTheNumber());
	}

	public static int getAliquotSum(int aNumber) {
		int retVal = 0;
		for (Integer factor : getFactors(aNumber)) {
			retVal += factor;
		}
		return retVal - aNumber;
	}

	List<Integer> getProperDivisors() {
		return getProperDivisors(getTheNumber());
	}

	public static List<Integer> getProperDivisors(int aNumber) {
		List<Integer> retVal = new ArrayList<>();
		for (int i = 1; i < aNumber; i++) {
			if (aNumber % i == 0)
				retVal.add(i);
		}
		return retVal;
	}

	int getAbundance() {
		return getAbundance(getTheNumber());
	}

	public static int getAbundance(int aNumber) {
		return getAliquotSum(aNumber) - aNumber;
	}

	boolean isAbundant() {
		return isAbundant(getTheNumber());
	}

	public static boolean isAbundant(int aNumber) {
		return getAliquotSum(aNumber) > aNumber;
	}

	/**
	 * 
	 * @return
	 * @see #isPerfect(int)
	 */
	boolean isPerfect() {
		return isPerfect(getTheNumber());

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
	 * 
	 * @return int
	 * @see #getReverseNumber(int)
	 */
	int getReverseNumber() {
		return getReverseNumber(getTheNumber());
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

	double getReciprocalNumber() {
		return getReciprocalNumber(getTheNumber());
	}

	public static double getReciprocalNumber(int aNumber) {
		return 1.0 / aNumber;
	}

	String getHex() {
		return getHex(getTheNumber());
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

	String getOctal() {
		return getOctal(getTheNumber());
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

	String getBinary() {
		return getBinary(getTheNumber());
	}

	public static String getBinary(int aNumber) {
		return Integer.toBinaryString(aNumber);
	}

	int getSigma() {
		return getSigma(getTheNumber());
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

	boolean isSuperabundant() {
		return isSuperabundant(getTheNumber());
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

	/**
	 * 
	 * @return boolean
	 * 
	 * @see #isPrimativeAbundant(int)
	 */
	boolean isPrimativeAbundant() {
		return isPrimativeAbundant(getTheNumber());
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

	boolean isAKeithNumber() {
		return isAKeithNumber(getTheNumber());
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

	int getKynea() {
		return getKynea(getTheNumber());
	}

	public static int getKynea(Integer aNumber) {
		double kyneaA = Math.pow(4.0, Double.valueOf(aNumber));
		double kyneaB = Math.pow(2.0, (Double.valueOf(aNumber) + 1.0));
		double kyneaFinal = kyneaA + kyneaB - 1.0;
		return (int) kyneaFinal;
	}

	int getCarol() {
		return getCarol(getTheNumber());
	}

	public static int getCarol(int aNumber) {
		System.out.println(aNumber);
		double carolA = Math.pow(4.0, Double.valueOf(aNumber));
		double carolB = Math.pow(2.0, (Double.valueOf(aNumber) + 1.0));
		double carolFinal = carolA - carolB - 1.0;
		return (int) carolFinal;
	}

	BigInteger getFactorial() {
		return getFactorial(getTheNumber());
	}

	public static BigInteger getFactorial(int aNumber) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= aNumber; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	BigInteger getCatalan() {
		return getCatalan(getTheNumber());
	}

	public static BigInteger getCatalan(int aNumber) {
		BigInteger catA = NumberTheory.getFactorial(2 * aNumber);
		BigInteger catB = NumberTheory.getFactorial(aNumber + 1);
		BigInteger catC = NumberTheory.getFactorial(aNumber);
		BigInteger catFinal = catA.divide(catB.multiply(catC));
		return catFinal;
	}

	List<Integer> getFibonacci() {
		return getFibonacci(getTheNumber());
	}

	public static List<Integer> getFibonacci(int aNumber) {
		int num1 = 0;
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

	List<Integer> getJacobsthal() {
		return getJacobsthal(getTheNumber());
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

	public static boolean getAlternatingFactorial(int i) {
		return false;
	}

	boolean getA_PointerPrime() {
		return getA_PointerPrime(getTheNumber());
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

	int getAmicableNumber() {
		return getAmicableNumber(getTheNumber());
	}

	public static int getAmicableNumber(int aNumber) {
		int bla = NumberTheory.getAliquotSum(aNumber);
		int blin = NumberTheory.getAliquotSum(bla);
		if (blin == aNumber && bla > blin) {
			return bla;
		}
		return -1;
	}

	public static String getBigIntegerPower(int base, int exponent) {
		BigInteger biggie = BigInteger.valueOf(base);
		String retVal = biggie.pow(exponent).toString();
		return retVal;
	}

	String getApocolyptic() {
		return getApocolyptic(getTheNumber());
	}

	public static String getApocolyptic(int exponent) {
		String getTestNumber = getBigIntegerPower(2, exponent);
		System.out.println();
		return "NOPE";
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

	boolean isCarmichael() {
		return isCaramichael(getTheNumber());
	}

	// https://www.javatpoint.com/carmichael-numbers-in-java
	public static boolean isCaramichael(int aNumber) {
		for (int b = 2; b <= aNumber; b++) {
			if (gcd(b, aNumber) == 1 && power(b, aNumber - 1, aNumber) != 1)
				return false;
		}
		return true;
	}

	int getCakeNumber() {
		return getCakeNumber(getTheNumber());
	}

	// Wikipedia
	public static int getCakeNumber(int aNumber) {
		return (int) ((1.0 / 6.0) * (Math.pow(aNumber, 3) + 5 * aNumber + 6));
	}

	int getLazyCaterer() {
		return getLazyCaterer(getTheNumber());
	}

	public static int getLazyCaterer(int aNumber) {
		return (aNumber * aNumber + aNumber + 2) / 2;
	}

	BigInteger getBellNumber() {
		return getBellNumber(getTheNumber());
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

	/**
	 * https://www.geeksforgeeks.org/admirable-numbers/
	 * 
	 * @return is the number admirable?
	 */
	boolean isAdmirable() {
		return isAdmirable(getTheNumber());
	}

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

	boolean isAmenable() {
		return isAmenable(getTheNumber());
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

	boolean isSuperD() {
		return isSuperD(getTheNumber());
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
	 * @see #isAlternating()
	 * @return boolean
	 */
	boolean isAlternating() {
		return isAlternating(getTheNumber());
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

	boolean isAntiPerfect() {
		return isAntiPerfect(getTheNumber());
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
			System.out.println(getReverseNumber(integer));
		}
		if (sum == aNumber) {
			return true;
		}
		;
		return false;
	}

	boolean isArithmetic() {
		return isArithmetic(getTheNumber());
	}

	public static boolean isArithmetic(int aNumber) {
		List<Integer> list = getFactors(aNumber);
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}

		int d = sum % list.size();
		System.out.printf("%d %% %d = %d\n", sum, list.size(), d);
		if (sum % list.size() == 0) {
			return true;
		}
		return false;
	}

	boolean isAstonishing() {
		return isAstonishing(getTheNumber());
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
		System.out.printf("\n%s %s\n", theString, ends);
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

	boolean isCanadaNumber() {
		return isCanadaNumber(getTheNumber());
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

	double getPolygonalNumber() {
		return getPolygonalNumber(getTheNumber(), 10);
	}

	public static double getPolygonalNumber(int S, int N) {
		int sMinusTwo = S - 2;
		int sMinusFour = S - 4;
		double retVal = (1 / 2.0) * (sMinusTwo * Math.pow(N, 2.0) - sMinusFour * N);
		return retVal;
	}

	
	/**
	 * 
	 * @return boolean is number a semi-prime number?
	 * 
	 */
	boolean isSemiPrime() {
		return isSemiPrime(getTheNumber());
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
	
	
	/**
	 * 
	 * @return boolean is number a Chen prime?
	 * @see #isChenPrime(int)
	 */
	boolean isChenPrime() {
		return isChenPrime(getTheNumber());
	}
	
	/**
	 * 
	 * @param aNumber
	 * @return boolean 
	 * 		A prime number p is called a Chen prime if p + 2 is either a prime or a product of two primes (also called a semiprime). 
	 */
	public static boolean isChenPrime(int aNumber) {
		if(isPrime(aNumber)) {
			return (isPrime(aNumber + 2) || isSemiPrime(aNumber + 2));
		}
		return false;
	}
	
	
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
	
}
