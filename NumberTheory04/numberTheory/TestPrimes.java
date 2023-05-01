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
		int lineCounter = 0;
		Primes instance = new Primes(24);
		System.out.println(instance.getTheNumber());
		System.out.println(instance.isChenPrime());

		System.out.println("Semi Primes: ");
		int i = 2;
		lineCounter = 0;
		while (i < 100) {
			if (Primes.isSemiPrime(i)) {				
				System.out.printf(" %d ", i);
				if(++lineCounter % 10 == 0) {
					System.out.println();
				}
			}
			i++;
		}
		System.out.println();
		
		System.out.println("\nChen Primes");
		i = 2;
		lineCounter = 0;
		while (i < 300) {
			if (Primes.isChenPrime(i)) {
				System.out.printf(" %d ", i);
				if(++lineCounter % 10 == 0) {
					System.out.println();
				}
			}
			i++;
		}
		System.out.println();
		
		System.out.println("Is Emirpimeses");
		lineCounter =0; 
		for (int j = 1; j < 6700; j++) {
			if (Primes.isEmirpimeses(j)) {
				System.out.printf("%d ", j);
				if(++lineCounter % 10 == 0) {
					System.out.println();
				}
			}
		}
		System.out.println();
		
		
		System.out.println("Good Primes:");
		lineCounter = 0;
		for (int j = 2; j <= 1000; j++) {
			if(Primes.isGoodPrime(j)) {
				System.out.print(j + " " );
				if(++lineCounter % 10 == 0)
					System.out.println();
			}						
		}
		System.out.println();
		
		
		System.out.println("\nCheck this out: (DNumber)");
		lineCounter = 1;
		for (int j = 3; j < 1500; j++) {
			if(NumberTheory.isDNumber(j)) {			
				System.out.print(j + " " );
				if(lineCounter++ % 10 == 0)
					System.out.println();
			}
		}
		System.out.println();
		
		
		
//		System.out.println("Primorials: ");
//		for(i = 1; i < 50; i++) {
//			System.out.printf("%d\n", NumberTheory.getPrimorials(i));
//		}
//		System.out.println("Fin");
		
		System.out.println("Fortunates: ");
		for(i = 1; i < 20; i++) {
			System.out.println(i +  " "+ Primes.getFortunateNumbers(i));
		}
		
	}

}