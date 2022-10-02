package numberTheory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NumberTheoryTest {

	NumberTheory instance;

	@BeforeEach()
	public void initEach() {

//		System.out.println("BeforeEach initEach() method called.");
		instance = new NumberTheory(12);

	}

	@Nested
	@DisplayName("Simple single value return methods.")
	class SimpleSingleValueReturnSpec {

		@Test
		@DisplayName("NumberTheory gets the number ")
		void testGetTheNumber() {
			int expected = 12;
			int result = instance.getTheNumber();
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Number Theory sets the number ")
		void testSetTheNumber() {
			int theNumber = 59;
			instance.setTheNumber(theNumber);
			assertEquals(theNumber, instance.getTheNumber());
		}

		@Test
		@DisplayName("Return the square value")
		void testGetSquare() {
			instance.setTheNumber(9);
			int expected = 81;
			int result = instance.getSquare();
			assertEquals(expected, result);

			result = NumberTheory.getSquare(4);
			assertEquals(16, result);
		}

		@Test
		@DisplayName("Aliquot Sum")
		public void testaliquotSumSpec() {
			instance.setTheNumber(60);
			int expected = 108;
			int result = instance.getAliquotSum();
			assertEquals(expected, result);
			assertEquals(expected, NumberTheory.getAliquotSum(60));
		}

		/**
		 * Test of getReverseNumber method
		 */
		@Test
		@DisplayName("Get Reverse Number")
		public void testGetReverseNumber() {
			int theTestValue = 34;
			instance.setTheNumber(theTestValue);
			int expected = 43;
			int result = instance.getReverseNumber();
			assertEquals(expected, result);

			expected = 5;
			assertEquals(expected, NumberTheory.getReverseNumber(50));
		}

		/**
		 * Test of getReciprocalNumber method
		 */
		@Test
		@DisplayName("getReciprocalNumber")
		public void testGetReciprocalNumber() {
			instance.setTheNumber(34);
			double result = instance.getReciprocalNumber();
			double expected = 0.0294117647;
			assertEquals(expected, result, 5);
			assertEquals(expected, NumberTheory.getReciprocalNumber(34), 5);
		}

		/**
		 * Test of getHex method
		 */
		@Test
		@DisplayName("GetHex")
		public void testGetHex() {
			instance.setTheNumber(76576500);
			String result = instance.getHex();
			String expected = "49076F4";
			assertEquals(expected, result);
			result = NumberTheory.getHex(76576500);
			assertEquals(expected, result);
		}

		/**
		 * Test of getOctal() method.
		 */
		@Test
		@DisplayName("GetOctal")
		public void testGetOctal() {
			instance.setTheNumber(76576500);
			String result = instance.getOctal();
			String expected = "444073364";
			assertEquals(expected, result);
		}

		/**
		 * Test of getBinary() method.
		 */
		@Test
		@DisplayName("getBinary")
		public void testGetBinary() {
			instance.setTheNumber(76576500);
			String result = instance.getBinary();
			String expected = "100100100000111011011110100";
			assertEquals(expected, result);
			assertEquals(expected, NumberTheory.getBinary(76576500));
		}

		/**
		 * Test of getSigma()
		 */
		@Test
		@DisplayName("getSigma")
		public void testGetSigma() {
			instance.setTheNumber(9);
			int result = instance.getSigma();
			int expected = 13;
			assertEquals(expected, result);
			instance.setTheNumber(15);
			result = instance.getSigma();
			expected = 24;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("getKynea")
		public void testKyneaNumber() {
			instance.setTheNumber(5);
			int expected = 1087;
			int result = instance.getKynea();
			assertEquals(expected, result);
			expected = 4223;
			result = NumberTheory.getKynea(6);
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Carol Numbers")
		public void testCarolNumber() {
			instance.setTheNumber(7);
			int expected = 16127;
			int result = instance.getCarol();
			assertEquals(expected, result);
			assertEquals(65023, NumberTheory.getCarol(8));
			assertNotEquals(65023, NumberTheory.getCarol(7));
		}

		@Test
		@DisplayName("Factorials")
		public void getFactorialSpec() {
			instance.setTheNumber(15);
			BigInteger expected = BigInteger.valueOf(1307674368000L);
			BigInteger result = instance.getFactorial();
			assertEquals(expected, result);
			assertEquals(BigInteger.valueOf(3628800), NumberTheory.getFactorial(10));
			assertNotEquals(BigInteger.valueOf(3628801), NumberTheory.getFactorial(10));
		}

		@Test
		@DisplayName("Catalan")
		public void testCatalanSpec() {
			instance.setTheNumber(20);
			BigInteger result = instance.getCatalan();
			BigInteger expected = BigInteger.valueOf(6564120420L);

			assertEquals(expected, result);
			assertEquals(BigInteger.valueOf(16796), NumberTheory.getCatalan(10));
		}

		@Test
		@DisplayName("Amicable")
		public void amicableSpec() {
			instance.setTheNumber(220);
			int result = instance.getAmicableNumber();
			int expected = 284;
			assertEquals(expected, result);

			result = NumberTheory.getAmicableNumber(12285);
			expected = 14595;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Cake")
		public void cakeSpec() {
			int result = NumberTheory.getCakeNumber(24);
			int expected = 2325;
			assertEquals(expected, result);

			instance.setTheNumber(22);
			result = instance.getCakeNumber();
			expected = 1794;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("lazyCaterer")
		public void lazyCatererSpec() {
			int result = NumberTheory.getLazyCaterer(24);
			int expected = 301;
			assertEquals(expected, result);

			instance.setTheNumber(22);
			result = instance.getLazyCaterer();
			expected = 254;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Centered Polygonal Numbers")
		public void getCenteredPolygonalNumberSpec() {
			int result = NumberTheory.getCenteredPolygonalNumber(3, 2);
			int expected = 10;
			assertEquals(expected, result);
			result = NumberTheory.getCenteredPolygonalNumber(14, 20);
			expected = 2941;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Bell Numbers")
		public void bellNumberSpec() {
			long result = NumberTheory.getBellNumber(20).longValue();
			long expected = 51724158235372L;
			assertEquals(expected, result);

			instance.setTheNumber(20);
			result = instance.getBellNumber().longValue();
			expected = 51724158235372L;
			assertEquals(expected, result);

		}

		@Test
		@DisplayName("Polygonal Number")
		public void getPolygonalSpec() {
			int result = (int) NumberTheory.getPolygonalNumber(24, 9);
			int expected = 801;
			assertEquals(expected, result);

			instance.setTheNumber(20);
			result = (int) instance.getPolygonalNumber();
			expected = 820;
			assertEquals(expected, result);
		}

		@Test
		@DisplayName("Cullen Numbers")
		public void getCullenSpec() {
			BigInteger result = NumberTheory.getCullen(13);
			BigInteger expected = BigInteger.valueOf(106497);
			assertEquals(expected, result);

			instance.setTheNumber(12);
			result = instance.getCullen();
			expected = BigInteger.valueOf(49153);
			assertEquals(expected, result);
		}

		
		//40
		@Test
		@DisplayName("Euler's Totient")
		public void getEulersTotientSpec() {
			instance.setTheNumber(75);
			int result = instance.getEulersTotient();
			int expected = 40;
			assertEquals(expected, result);
			result = NumberTheory.getEulersTotient(9);
			expected = 6;
			assertEquals(expected, result);
		}
		
		
		@Test
		@DisplayName("Double Factorial")
		public void doubleFactorialSpec() {
			int variable = 9;
			BigInteger expected = BigInteger.valueOf(945);
			BigInteger result = NumberTheory.getDoubleFactorial(variable);
			assertEquals(expected, result);
			
			instance.setTheNumber(8);
			expected = BigInteger.valueOf(384);
			result = instance.getDoubleFactorial();
			assertEquals(expected, result);
		}
		
		
		
	} // End of SimpleSingleValueReturn class

	@Nested
	@DisplayName("Boolean Tests")
	class BooleanSpec {
		@Test
		@DisplayName("Number tests out to be prime.")
		void testIsPrime() {
			instance.setTheNumber(17);
			assertTrue(instance.isPrime());
			assertTrue(NumberTheory.isPrime(17));
			instance.setTheNumber(15);
			assertFalse(instance.isPrime());
			assertFalse(NumberTheory.isPrime(15));
		}

		@Test
		@DisplayName("Is value abundant?")
		void testIsAbundant() {
			instance.setTheNumber(60);
			assertTrue(instance.isAbundant());
			instance.setTheNumber(17);
			assertFalse(instance.isAbundant());
			assertTrue(NumberTheory.isAbundant(60));
			assertFalse(NumberTheory.isAbundant(17));
		}

		@Test
		@DisplayName("Is value perfect?")
		public void testIsPerfect() {
			int theTestValue = 28;
			instance.setTheNumber(theTestValue);
			assertTrue(instance.isPerfect());
			assertTrue(NumberTheory.isPerfect(theTestValue));
			theTestValue = 29;
			instance.setTheNumber(theTestValue);
			assertFalse(instance.isPerfect());
			assertFalse(NumberTheory.isPerfect(theTestValue));
		}

		@Test
		@DisplayName("Are two numbers co-prime?")
		public void isCoPrimeSpec() {
			assertTrue(NumberTheory.isCoPrime(18, 35));
			assertFalse(NumberTheory.isCoPrime(18, 36));

			instance.setTheNumber(13);
			assertTrue(instance.isCoPrime(31));
			instance.setTheNumber(150);
			assertFalse(instance.isCoPrime(295));
		}
		
		

		@Test
		@DisplayName("Is a Chen Prime?")
		public void isChenPrimeSpec() {
			assertTrue(NumberTheory.isChenPrime(137));
			assertFalse(NumberTheory.isChenPrime(133));

			instance.setTheNumber(211);
			assertTrue(instance.isChenPrime());
			instance.setTheNumber(84);
			assertFalse(instance.isChenPrime());
		}

		@Test
		@DisplayName("Is semi prime?")
		public void isSemiPrimeSpec() {
			assertTrue(NumberTheory.isSemiPrime(15));
			assertFalse(NumberTheory.isSemiPrime(92));

			instance.setTheNumber(74);
			assertTrue(instance.isSemiPrime());
			instance.setTheNumber(84);
			assertFalse(instance.isSemiPrime());
		}

		@Test
		@DisplayName("Is Astonishing?")
		public void isAstonishingSpec() {
			assertTrue(NumberTheory.isAstonishing(15));
			assertFalse(NumberTheory.isAstonishing(20));

			instance.setTheNumber(1353);
			assertTrue(instance.isAstonishing());
			instance.setTheNumber(1354);
			assertFalse(instance.isAstonishing());
		}

		// isAutomorphic
		// 12890625
		@Test
		@DisplayName("Is automorphic?")
		public void isAutomorphicSpec() {
			assertTrue(NumberTheory.isAutomorphic((long) 890625));
			assertFalse(NumberTheory.isAutomorphic((long) 20));
		}

		@Test
		@DisplayName("Is interprime?")
		public void isInterPrimeSpec() {
			assertTrue(NumberTheory.isInterPrime(120));
			assertFalse(NumberTheory.isInterPrime(121));

			instance.setTheNumber(120);
			assertTrue(instance.isInterPrime());
			instance.setTheNumber(121);
			assertFalse(instance.isInterPrime());
		}

		@Test
		@DisplayName("Is Canada Number?")
		public void isCanadaSpec() {
			assertTrue(NumberTheory.isCanadaNumber(16999));
			assertFalse(NumberTheory.isCanadaNumber(17000));

			instance.setTheNumber(8549);
			assertTrue(instance.isCanadaNumber());
			instance.setTheNumber(17000);
			assertFalse(instance.isCanadaNumber());
		}

		@Test
		@DisplayName("Is admirable? ")
		public void admirableNumberSpec() {
			assertTrue(NumberTheory.isAdmirable(12));

			instance.setTheNumber(20);
			assertTrue(instance.isAdmirable());
			instance.setTheNumber(21);
			assertFalse(instance.isAdmirable());
		}

		@Test
		@DisplayName("Is amenable")
		public void amenableNumberSpec() {
			assertTrue(NumberTheory.isAmenable(12));
			NumberTheory instance = new NumberTheory(49);
			assertTrue(instance.isAmenable());
			instance.setTheNumber(46);
			assertFalse(instance.isAmenable());
		}

		@Test
		@DisplayName("Is SuperD?")
		public void isSuperDSpec() {
			assertTrue(NumberTheory.isSuperD(333));
			assertFalse(NumberTheory.isSuperD(330));

			instance.setTheNumber(19);
			assertTrue(instance.isSuperD());
			instance.setTheNumber(46);
			assertFalse(instance.isSuperD());
		}

		@Test
		@DisplayName("Is alternating?")
		public void isAlternatingSpec() {
			assertTrue(NumberTheory.isAlternating(903));
			assertFalse(NumberTheory.isAlternating(904));

			instance.setTheNumber(19);
			assertFalse(instance.isAlternating());
			instance.setTheNumber(1872);
			assertTrue(instance.isAlternating());
		}

		@Test
		@DisplayName("Is antiperfect?")
		public void isAntiPerfectSpec() {
			assertTrue(NumberTheory.isAntiPerfect(133857));
			assertFalse(NumberTheory.isAntiPerfect(44));

			instance.setTheNumber(211);
			assertFalse(instance.isAntiPerfect());
			instance.setTheNumber(244);
			assertTrue(instance.isAntiPerfect());
		}

		@Test
		@DisplayName("Is arithmetic?")
		public void isArithmeticSpec() {
			assertTrue(NumberTheory.isArithmetic(56));
			assertFalse(NumberTheory.isArithmetic(58));

			instance.setTheNumber(245);
			assertTrue(instance.isArithmetic());
			instance.setTheNumber(244);
			assertFalse(instance.isArithmetic());
		}

		/**
		 * In mathematics a primitive abundant number is an abundant number whose proper
		 * divisors are all deficient numbers. Test of isPrimativeAbundant()
		 */
		@Test
		@DisplayName("Is primative abundant?")
		public void testIsPrimativeAbundant() {
			instance.setTheNumber(20);
			assertTrue(instance.isPrimativeAbundant());
			instance.setTheNumber(70);
			assertTrue(instance.isPrimativeAbundant());
			instance.setTheNumber(87);
			assertFalse(instance.isPrimativeAbundant());

			assertTrue(NumberTheory.isPrimativeAbundant(20));
			assertFalse(instance.isPrimativeAbundant());
		}

		@Test
		@DisplayName("Is a keith number?")
		public void testIsAKeithNumber() {
			instance.setTheNumber(1104);
			assertTrue(instance.isAKeithNumber());
			assertTrue(NumberTheory.isAKeithNumber(7913837));
			assertFalse(NumberTheory.isAKeithNumber(7913838));
		}

		/**
		 * Test of isSuperabundant() method, of class NumberTheory
		 */
		@Test
		@DisplayName("Is superabundant?")
		public void testIsSuperabundant() {
			instance.setTheNumber(360);
			assertTrue(instance.isSuperabundant());
			instance.setTheNumber(1260);
			assertTrue(instance.isSuperabundant());
			instance.setTheNumber(25);
			assertFalse(instance.isSuperabundant());

			assertTrue(NumberTheory.isSuperabundant(360));
			assertFalse(NumberTheory.isSuperabundant(25));
		}

		@Test
		@DisplayName("Is carmichael?")
		public void isCarmichaelSpec() {
			instance.setTheNumber(2821);
			assertTrue(instance.isCarmichael());
		}
		
		@Test
		@DisplayName("Is Curzon?")
		public void isCurzonSpec() {
			assertTrue(NumberTheory.isCurzon(4769));
			assertFalse(NumberTheory.isCurzon(4770));
			instance.setTheNumber(2109);
			assertTrue(instance.isCurzon());
			instance.setTheNumber(2119);
			assertFalse(instance.isCurzon());
		}
		
		@Test
		@DisplayName("Is de Polignac?")
		public void isDePolignacSpec() {
			assertTrue(NumberTheory.isDePolignac(19961));
			assertFalse(NumberTheory.isDePolignac(20322));
			instance.setTheNumber(13285);
			assertTrue(instance.isDePolignac());
			instance.setTheNumber(13283);
			assertFalse(instance.isDePolignac());
		}
		
		
		
		@Test
		@DisplayName("Is number Droll?")
		public void isDrollSpec() {
			assertTrue(NumberTheory.isDroll(72));
			assertFalse(NumberTheory.isDroll(73));
			
			instance.setTheNumber(48384);
			assertTrue(instance.isDroll());
			instance.setTheNumber(instance.getTheNumber() + 1);
			assertFalse(instance.isDroll());
		}
		
		

		@Test
		@DisplayName("Is number Emirp?")
		public void isEmirpSpec() {
			assertTrue(NumberTheory.isEmirp(179));
			assertFalse(NumberTheory.isEmirp(114));
			
			instance.setTheNumber(10009);
			assertTrue(instance.isEmirp());
			instance.setTheNumber(19272);
			assertFalse(instance.isEmirp());
		}
		
		
		
		@Test
		@DisplayName("Is number Economical? Still under construction.")
		public void iseconomicalSpec() {
			assertTrue(NumberTheory.isEconomical(77));
		}
		
		

	} // End of boolean tests

	@Nested
	@DisplayName("List return value tests")
	class ListReturnSpec {
		/**
		 * Test of the getJugglers() method.
		 */
		@Test
		@DisplayName("Return a list of jugglers sequence.")
		public void testGetJugglers() {
			instance.setTheNumber(9);
			List<Integer> expected = new ArrayList<>(Arrays.asList(9, 27, 140, 11, 36, 6, 2, 1));
			List<Integer> result = instance.getJugglers();
			assertIterableEquals(expected, result);
			result = NumberTheory.getJugglers(9);
			assertIterableEquals(expected, result);
		}

		
		@Test
		@DisplayName("Return Totatives List.")
		public void getTotatives() {
			List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 7, 8));
			List<Integer> result = NumberTheory.getTotatives(9);
			assertIterableEquals(expected, result);
			expected.clear();
			
			instance.setTheNumber(75);
			expected = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 
					22, 23, 26, 28, 29, 31, 32, 34, 37, 38, 41, 43, 44, 46, 47, 49, 52, 53, 
					56, 58, 59, 61, 62, 64, 67, 68, 71, 73, 74));
			result = instance.getTotatives();
			assertIterableEquals(expected, result);
		}
		
		
		
		
		/**
		 * Test of the getCollatz() method
		 */
		@Test
		@DisplayName("Return a list of all integers in the collatz sequence.")
		public void testGetCollatz() {
			int theTestValue = 19;
			instance.setTheNumber(theTestValue);
			// [19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2,
			// 1]
			List<Integer> expected = new ArrayList<>(
					Arrays.asList(19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1));
			List<Integer> result = instance.getCollatz();
			assertIterableEquals(expected, result);

			expected = new ArrayList<>(Arrays.asList(6, 3, 10, 5, 16, 8, 4, 2, 1));
			assertIterableEquals(expected, NumberTheory.getCollatz(6));
		}

		/**
		 * Test of the getPrimeFactors() method.
		 */
		@Test
		@DisplayName("Prime factors")
		public void testGetPrimeFactors() {
			int theTestValue = 60;
			instance.setTheNumber(theTestValue);
			List<Integer> expected = new ArrayList<>(Arrays.asList(2, 2, 3, 5));
			List<Integer> result = instance.getPrimeFactors();
			assertIterableEquals(expected, result);
			assertIterableEquals(expected, NumberTheory.getPrimeFactors(theTestValue));
		}

		/**
		 * Test of the getFactors() method.
		 */
		@Test
		@DisplayName("Get Factors")
		public void testfactorsSpec() {
			int theTestValue = 60;
			instance.setTheNumber(theTestValue);
			List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60));
			List<Integer> result = instance.getFactors();
			assertIterableEquals(expected, result);
			assertIterableEquals(expected, NumberTheory.getFactors(theTestValue));
		}

		/**
		 * Test of the getProperDivisors() method.
		 */
		@Test
		@DisplayName("Get Proper Divisors")
		public void testProperDivisorsSpec() {
			int theTestValue = 36;
			instance.setTheNumber(theTestValue);
			List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 9, 12, 18));
			List<Integer> result = instance.getProperDivisors();
			assertIterableEquals(expected, result);
			assertIterableEquals(expected, NumberTheory.getProperDivisors(theTestValue));
		}

		@Test
		@DisplayName("Get Fibonacci")
		public void fibonacciSpec() {
			instance.setTheNumber(10);
			List<Integer> result = instance.getFibonacci();
			List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34));
			assertIterableEquals(expected, result);

			result = NumberTheory.getFibonacci(17);
			expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987));
			assertIterableEquals(expected, result);
		}

		@Test
		@DisplayName("Lucas Numbers")
		public void lucasSpec() {
			instance.setTheNumber(12);
			List<Integer> result = instance.getLucas();
			List<Integer> expected = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 7, 11, 18, 29, 47, 76, 123, 199));
			assertIterableEquals(expected, result);

			result = NumberTheory.getLucas(33);
			expected = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 7, 11, 18, 29, 47, 76, 123, 199, 322, 521, 843, 1364,
					2207, 3571, 5778, 9349, 15127, 24476, 39603, 64079, 103682, 167761, 271443, 439204, 710647, 1149851,
					1860498, 3010349, 4870847));
			assertIterableEquals(expected, result);

		}

		@Test
		@DisplayName("Get jacobsthal")
		public void jacobsthalSpec() {
			instance.setTheNumber(20);
			List<Integer> result = instance.getJacobsthal();
			List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365,
					2731, 5461, 10923, 21845, 43691, 87381, 174763));
			assertIterableEquals(expected, result);

			result = NumberTheory.getJacobsthal(25);
			expected = new ArrayList<>(Arrays.asList(0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461,
					10923, 21845, 43691, 87381, 174763, 349525, 699051, 1398101, 2796203, 5592405));
			assertIterableEquals(expected, result);
		}

	}

}
