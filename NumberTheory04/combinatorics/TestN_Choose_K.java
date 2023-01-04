/**
 * 
 */
package combinatorics;

/**
 * @author JeffreySchneider
 *
 */
public class TestN_Choose_K {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("Use the NCR formula to find the number of ways to select 3 books from 5 books on the shelf. ");
		System.out.println(N_Choose_K.n_choose_k(3, 5));
		System.out.print("Trevor has to choose 5 marbles from 12 marbles. In how many ways can she choose them? ");
		System.out.println(N_Choose_K.n_choose_k(5, 12));
		System.out.print("John asks his daughter to choose 4 apples from the basket. "
				+ "If the basket has 18 apples to choose from, how many different possible answers could the daughter give? ");
		System.out.println(N_Choose_K.ncr(4, 18));
		System.out.print("Choose 4 fruits from 10 fruits ");
		System.out.println(N_Choose_K.ncr(4,10));
		System.out.print("Choose 10 fruits from 10 fruits ");
		System.out.println(N_Choose_K.ncr(10,10));
		System.out.print("Choose 0 fruits from 10 fruits ");
		System.out.println(N_Choose_K.ncr(0,10));
	}

}
