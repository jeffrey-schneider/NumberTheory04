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

	}
}
