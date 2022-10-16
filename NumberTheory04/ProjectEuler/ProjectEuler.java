package ProjectEuler;

import numberTheory.NumberTheory;

public class ProjectEuler {
	
	public static void main(String args) {
		
		System.out.println("In ProjectEuler.ProjetEuler.main()");
		
		int counter = 1;
		while(true) {
			System.out.println(NumberTheory.getFibonacci(counter));
			if(counter == 100)
				break;
			counter++;
		}
		
		
		euler01();
	}

	private static void euler01() {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if(i % 5 == 0 || i %3 == 0)
				sum+= i;
		}
		System.out.println(sum);
	}

}
