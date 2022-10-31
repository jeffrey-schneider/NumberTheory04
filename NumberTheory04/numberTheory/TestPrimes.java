package numberTheory;

/**
 * @author JeffreySchneider
 *
 */
public class TestPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Primes instance = new Primes(24);
		System.out.println(instance.getTheNumber());
		System.out.println(instance.isChenPrime());

		System.out.println("Semi Primes: ");
		int i = 2;
		while (i < 100) {
			if (Primes.isSemiPrime(i)) {
				System.out.print(i);
			}
			i++;
		}

		System.out.println("\nChen Primes");
		i = 2;
		while (i < 300) {
			if (Primes.isChenPrime(i)) {
				System.out.printf(" %d ", i);
			}
			i++;
		}
		System.out.println();

		System.out.println("Is Emirpimeses");
		for (int j = 1; j < 6700; j++) {
			if (Primes.isEmirpimeses(j))
				System.out.printf("%d\n", j);
		}
		
		System.out.println("Good Primes:");
		for (int j = 2; j <= 100; j++) {
			if(Primes.isGoodPrime(j)) {
				System.out.println(j);	
			}						
		}
	}

}