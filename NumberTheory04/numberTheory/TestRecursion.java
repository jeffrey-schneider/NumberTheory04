package numberTheory;

public class TestRecursion {

	public static void main(String[] args) {
		for(int i = 10; i <= 30; i++) {
			System.out.printf("%d %b\n", i, NumberTheory.isPrimitiveAbundant(i));
		}

	}

}
