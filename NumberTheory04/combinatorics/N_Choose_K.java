package combinatorics;

import java.math.BigInteger;

import numberTheory.*;


public class N_Choose_K {

	/**
	 * @author JeffreySchneider
	 * @param n
	 * @param k
	 * @return
	 */
	public static BigInteger n_choose_k(int n, int k) {
		if ( n > k ) {
			return null;
		}
		if(n == k || k == 0) {
			return BigInteger.ONE;
		}
		BigInteger bigN = NumberTheory.getFactorial(n);
		BigInteger bigK = NumberTheory.getFactorial(k);
		int jeff = k - n;
		BigInteger bigK_Minus_bigN = NumberTheory.getFactorial(jeff);
		
		BigInteger retVal = bigK.divide(bigN.multiply(bigK_Minus_bigN));
		return retVal;		
	}
	
	/**
	 * Some texts call this the NCR formula, N choose R
	 * @param n
	 * @param r
	 * @return
	 */
	public static BigInteger ncr(int n, int r) {
		return n_choose_k(n, r);
	}
	
	/**
	 * @author JeffreySchneider
	 * A combination is all about grouping. The number of different groups which
	 *  can be formed from the available things can be calculated using combinations.
	 * @param n
	 * @param k
	 * @return
	 */
	public static BigInteger combinations(int n, int k) {
		return n_choose_k(n,k);
	}
	
	
	/**
	 * @author JeffreySchneider
	 * A permutation is an arrangement in a definite order of a number of objects
	 *  taken some or all at a time.
	 * @param n
	 * @param r
	 * @return
	 */
	public static BigInteger permutations(int n, int r) {
		// n!
		// divided by ( n - r)!
		BigInteger bigN = NumberTheory.getFactorial(n);
		BigInteger bigN_Minus_R = NumberTheory.getFactorial(n - r);
		BigInteger retVal = bigN.divide(bigN_Minus_R);
		return retVal;
	}
}
