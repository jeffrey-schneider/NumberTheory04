package numberTheory;

public class TestNumberTheory {
	public static void main(String[] args) {
		NumberTheory theTheory = new NumberTheory(19);
		System.out.println(theTheory.getCollatz());
		theTheory.setTheNumber(27);
		System.out.println(theTheory.getCollatz());

		theTheory.setTheNumber(0);
		System.out.println(theTheory.getCollatz());

		System.out.println(NumberTheory.isAKeithNumber(917));

		theTheory.setTheNumber(20);
		System.out.println("Catalan: " + theTheory.getCatalan());
		System.out.println("Catalan: " + NumberTheory.getCatalan(20));
		System.out.printf("Factorial(52): %,d", NumberTheory.getFactorial(52));
		System.out.println();

		System.out.println("Fibonacci(17): " + NumberTheory.getFibonacci(17));

		System.out.println("Negative exponent(Math.pow(4.0, -1.0): " + Math.pow(4.0, -1.0));
		System.out.println("Lucas(33) " + NumberTheory.getLucas(33));
		theTheory.setTheNumber(12);
		System.out.println(theTheory.getLucas());
		System.out.println(NumberTheory.getJacobsthal(25));

		System.out.println(NumberTheory.getAlternatingFactorial(5));

		// a_PointerPrimeTest();

		//getAmicableNumbers();
		System.out.println(NumberTheory.getApocolyptic(192));
		System.out.println(theTheory.getApocolyptic(0));
		
		theTheory.setTheNumber(6601);
		System.out.println(NumberTheory.isCaramichael(561));
		System.out.println(NumberTheory.isCaramichael(1105));
		System.out.println(NumberTheory.isCaramichael(15841));
		System.out.println(theTheory.isCarmichael());
		
		System.out.println("Cake Numbers:");
		int n = 0;
		while(n < 25) {			
			System.out.printf("Cake: %d  %d\n", n, NumberTheory.getCakeNumber(n++));
		}
		
		System.out.println("Lazy Caterer's Numbers:");
		n =0;
		while(n < 25) {
			System.out.printf("Lazy: %d  %d\n", n, NumberTheory.getLazyCaterer(n++));
		}
		
		System.out.println("Bell's numbers");
		
		n = 0;
		while(n <= 50) {
			System.out.printf("%d  %d\n", n, NumberTheory.getBellNumber(n));
			n++;		
		}
		
		System.out.println("First 50 Admirable Numbers");
		n = 0;
		int counter = 50;
		while(counter > 0) {		
			++n;		
			if(NumberTheory.isAdmirable(n)) {
				System.out.printf("%d  %d\n", 50-counter, n);
				counter--;
			}
		}
		
		System.out.println("First 25 Amenable Numbers");
		n = 0;
		counter = 25;
		while(counter > 0) {
			++n;
			if(NumberTheory.isAmenable(n)) {
				System.out.printf("%d %d\n", 25 - counter, n);
				counter--;
			}
		}
		
		System.out.println("First 25 Super D Numbers");
		int i = 1;
		counter = 25;
		while(i < 1000) {
				if(NumberTheory.isSuperD(i)) {
					System.out.println(i + " is SuperD. " );
					counter--;
				}
				i++;			
			if(counter == 0) {
				break;
			}
		}
		
		for(int N = 129; N < 150; N++){
			System.out.printf("Is %d alternating? %b\n", N, NumberTheory.isAlternating(N));
		}
		
		 int N = 133857 ;
		 System.out.printf("Is %d anti-perfect? %b\n", N, NumberTheory.isAntiPerfect(N));
		 
		 
		 
		 for(int r = 47; r <= 60; r++) {
			 System.out.printf("Is %d arithmetic? %b\n", r, NumberTheory.isArithmetic(r));
		 }
		 
	}
	
	
}
