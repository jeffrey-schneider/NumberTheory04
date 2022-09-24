package numberTheory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NumberTheory {
	private int theNumber;

	public NumberTheory(int theNumber) {
		setTheNumber(theNumber);
	}

	public NumberTheory() {
	}

	public int getTheNumber() {
		return theNumber;
	}

	public void setTheNumber(int theNumber) {
		this.theNumber = theNumber;
	}

	 int getSquare() {
		return getSquare(getTheNumber());
	}

	public static int getSquare(int aNumber) {
		return aNumber * aNumber;
	}

	boolean isPrime() {
		return isPrime(getTheNumber());
	}

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

	List<Integer> getCollatz() {
		return getCollatz(getTheNumber());
	}

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

	boolean isPerfect() {
		return isPerfect(getTheNumber());

	}

	public static boolean isPerfect(int aNumber) {
		return getAbundance(aNumber) == 0;
	}

	int getReverseNumber() {
		return getReverseNumber(getTheNumber());
	}

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

	boolean isPrimativeAbundant() {
		return isPrimativeAbundant(getTheNumber());
	}

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
		for(int i = 1; i <= aNumber; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

	
	
	BigInteger getCatalan(){
		return getCatalan(getTheNumber());
	}
	public static BigInteger getCatalan(int aNumber) {
		BigInteger catA = NumberTheory.getFactorial(2*aNumber);
		BigInteger catB = NumberTheory.getFactorial(aNumber+1);
		BigInteger catC = NumberTheory.getFactorial(aNumber);
		BigInteger catFinal = catA.divide(catB.multiply(catC));
		return catFinal;	
	}
	
	
	
	List<Integer> getFibonacci(){
		return getFibonacci(getTheNumber());
	}
	
	public static List<Integer> getFibonacci(int aNumber) {
		int num1 = 0;
		int num2 = 1;
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

	
	List<Integer> getLucas(){
		return getLucas(getTheNumber());
	}
	public static List<Integer> getLucas(int aNumber) {
		int num1 = 2;
		int num2 = 1;
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

	
	List<Integer> getJaconbsthal(){
		return getJacobsthal(getTheNumber());
	}
	public static List<Integer> getJacobsthal(int aNumber){
		int num1 = 0;
		int num2 = 1;
		int counter = 0;
		List<Integer> retList = new ArrayList<>();
		//Iterate until counter == aNumber
		while(counter < aNumber) {
			retList.add(num1);
			int num3 = num2 + 2*num1;
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
		if(!isPrime(aNumber)) {
			return false;
		}else {
		Stack<Integer> theStack = new Stack<>();
		int number = aNumber;
		theStack.push(aNumber);
		while (number > 0) {
			theStack.push(number % 10);
			number /= 10;
		}
		int nextNumber = 0;		
		while(!theStack.isEmpty()) {
			nextNumber += theStack.pop();
		}
		if(isPrime(nextNumber))
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
		if(blin == aNumber && bla > blin) {
			return bla;
		}
		return -1;		
	}
	
	
	
	public static String getBigIntegerPower(int base, int exponent){		
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

}
