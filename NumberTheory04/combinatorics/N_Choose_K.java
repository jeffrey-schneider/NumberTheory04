package combinatorics;

import java.math.BigInteger;

import numberTheory.*;


public class N_Choose_K {

	/**
	 * In mathematics, the binomial coefficients are the positive integers that occur as 
	 * coefficients in the binomial theorem. Commonly, a binomial coefficient is indexed 
	 * by a pair of integers n ≥ k ≥ 0, (see <a href="https://en.wikipedia.org/wiki/Binomial_coefficient">{@link URL}</a>)
	 * 
	 * {@code How many ways can you choose k items from n items set without repetition and without order.}
	 * @author JeffreySchneider
	 * @param n int Number of items in the set.
	 * @param k int Number of choices to be selected.
	 * @return Number of ways you can choose k items from an n item set.
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
	 * @param n int Number of items in the set.
	 * @param k int Number of choices to be selected.
	 * @return Number of ways you can choose k items from an n item set.
	 */
	public static BigInteger ncr(int n, int r) {
		return n_choose_k(n, r);
	}
	
	/**
	 * @author JeffreySchneider
	 * A combination is all about grouping. The number of different groups which
	 *  can be formed from the available things can be calculated using combinations.
	 * @param n int Number of items in the set.
	 * @param k int Number of choices to be selected.
	 * @return Number of ways you can choose k items from an n item set.
	 */
	public static BigInteger combinations(int n, int k) {
		return n_choose_k(n,k);
	}
	
	
	/**
	 * @author JeffreySchneider
	 * A permutation is an arrangement in a definite order of a number of objects
	 *  taken some or all at a time.
	 * @param n int Number of items in the set.
	 * @param r int Number of choices to be selected.
	 * @return In mathematics, a permutation of a set is, loosely speaking, 
	 * an arrangement of its members into a sequence or linear order, or if the 
	 * set is already ordered, a rearrangement of its elements. 
	 * The word "permutation" also refers to the act or process of changing 
	 * the linear order of an ordered set.
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
