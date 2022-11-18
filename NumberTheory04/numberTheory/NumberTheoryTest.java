package numberTheory;


//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

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
	Primes primeInstance;

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
		
		@Test
		@DisplayName("Hogben Number")
		public void hogbenSpec() {
			int expected = 359401;
			int result = NumberTheory.getHogben(600);
			assertEquals(expected, result);
			
			instance.setTheNumber(599);
			expected =  358203;
			result = instance.getHogben();
			assertEquals(expected, result);	
			instance.setTheNumber(5);
			expected = 21;
			result = instance.getHogben();
			assertEquals(expected, result);
		}
		
		@Test
		@DisplayName("House Number")
		public void getHouseNumberSpec() {
			int expected = 933;
			int result = NumberTheory.getHouse(8);
			assertEquals(expected, result);
			
			instance.setTheNumber(10);
			expected = 1716;
			result = instance.getHouse();
			assertEquals(expected, result);
			
			instance.setTheNumber(599);
			expected = 287820100;
			result = instance.getHouse();
			assertEquals(expected, result);
		}
		
		
		//@Test
		@DisplayName("Hungry Number")
		public void getHungryNumberSpec() {
			assertTrue(NumberTheory.isHungry(7339199));
			assertTrue(NumberTheory.isHungry(144));
			assertFalse(NumberTheory.isHungry(145));
		}
		
		/**
		 * Test method for {@link numberTheory.NumberTheory#getAlternatingFactorial}.
		 * 3301819
		 */
		@Test
		@DisplayName("Alternating Factorial")
		public void getAlternatingFactorial() {
			BigInteger expected = BigInteger.valueOf(3301819);
			BigInteger result = NumberTheory.getAlternatingFactorial(10);
			assertEquals(expected, result);
			expected = BigInteger.valueOf(101);
			result = NumberTheory.getAlternatingFactorial(5);
			assertEquals(expected, result);
			
			instance.setTheNumber(50);
			result = instance.getAlternatingFactorial();
			BigInteger expected2 = new BigInteger("29817972015629302995182567242334801579950768815528034161635577019");
			assertEquals(expected2, result);
		}
		
		
	} // End of SimpleSingleValueReturn class ----------------------------------------------------------------------------

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
		@DisplayName("Is Astonishing?")
		public void isAstonishingSpec() {
			assertTrue(NumberTheory.isAstonishing(15));
			//assertTrue(NumberTheory.isAstonishing(216));
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
			assertTrue(Primes.isEmirp(179));
			assertFalse(Primes.isEmirp(114));
			
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
		
		
		@Test
		@DisplayName("Is number gapful?")
		public void isGapfulSpec() {
			assertTrue(NumberTheory.isGapful(108));
			assertTrue(NumberTheory.isGapful(5772));
			assertFalse(NumberTheory.isGapful(5771));
			assertFalse(NumberTheory.isGapful(7789));
		}
		
		@Test
		@DisplayName("Is Duffinian Number?")
		public void isDuffinianSpec() {
			//4, 8, 9, 16, 21, 25, 27, 32, 35, 36, 39, 49, 50, 55, 57, 63, 64, 65, 75, 77, 81, 85, 93, 98, 100, 111, 115, 119, 121, 125, 128, 129, 133, 143, 144, 155, 161, 169, 171, 175, 183, 185, 187, 189, 201, 203, 205, 209, 215, 217, 219
			assertTrue(NumberTheory.isDuffinian(4));
			assertTrue(NumberTheory.isDuffinian(8));
			assertFalse(NumberTheory.isDuffinian(10));
			instance.setTheNumber(247);
			assertTrue(instance.isDuffinian());
			instance.setTheNumber(246);
			assertFalse(instance.isDuffinian());
			assertTrue(NumberTheory.isDuffinian(25387));
			instance.setTheNumber(18633);
			assertTrue(instance.isDuffinian());			
		}
		
		//115048440 8128 4713984
		
		@Test
		@DisplayName("Is Harmonic Divisor Number?")
		public void isHarmonicDivisorNumberSpec() {
			assertTrue(NumberTheory.isHarmonicDivisorNumber(8128));
			assertFalse(NumberTheory.isHarmonicDivisorNumber(8219));
//			instance.setTheNumber(115048440);
//			assertTrue(instance.isHarmonicDivisorNumber());
//			instance.setTheNumber(4713984);
//			assertTrue(instance.isHarmonicDivisorNumber());
		}
		
		
		@Test
		@DisplayName("Is number Harshad?")
		public void isHarshadSpec() {
			assertTrue(NumberTheory.isHarshad(666));
			assertTrue(NumberTheory.isHarshad(3102));
			assertFalse(NumberTheory.isHarshad(11));
			instance.setTheNumber(41441420);
			assertTrue(instance.isHarshad());
		}
		
		@Test
		@DisplayName("Is Happy")
		public void isHappyInt() {		
			assertTrue(NumberTheory.isHappy(103));
			assertTrue(NumberTheory.isHappy(130));
			assertTrue(NumberTheory.isHappy(3913));
			assertFalse(NumberTheory.isHappy(110));
		}
		
		@Test
		@DisplayName("Is Happy Spec")
		public void isHappySpec() {
			instance.setTheNumber(2181);
			assertTrue(instance.isHappy());
			instance.setTheNumber(3352);
			assertFalse(instance.isHappy());
		}
		
		@Test
		@DisplayName("Is Cyclic")
		public void isCyclic() {
			assertTrue(NumberTheory.isCyclic(71));
			assertTrue(NumberTheory.isCyclic(145));
			assertFalse(NumberTheory.isCyclic(102));
		}
		
		@Test
		@DisplayName("Is Cyclic Spec")
		public void isCyclicSpec() {
			instance.setTheNumber(51);
			assertTrue(instance.isCyclic());
			instance.setTheNumber(95);
			assertTrue(instance.isCyclic());
			instance.setTheNumber(144);
			assertFalse(instance.isCyclic());
		}

		
		@Test
		@DisplayName("Is Powerful")
		public void isPowerful() {
			assertTrue(NumberTheory.isPowerful(8));
			assertTrue(NumberTheory.isPowerful(256));
			assertTrue(NumberTheory.isPowerful(972));
			assertFalse(NumberTheory.isPowerful(999));
			instance.setTheNumber(675);
			assertTrue(instance.isPowerful());
			instance.setTheNumber(864);
			assertTrue(instance.isPowerful());
			instance.setTheNumber(674);
			assertFalse(instance.isPowerful());	
		}
		
		@Test
		@DisplayName("Is Frugal")
		public void isFrugal() {
			assertTrue(NumberTheory.isFrugal(125));
			assertTrue(NumberTheory.isFrugal(1536));
			assertTrue(NumberTheory.isFrugal(115248));
			assertFalse(NumberTheory.isFrugal(1251));
		}

		@Test
		@DisplayName("Is Evil?")
		public void isEvil() {
			assertTrue(NumberTheory.isEvil(23));
			assertFalse(NumberTheory.isEvil(134));
			instance.setTheNumber(1200);
			assertTrue(instance.isEvil());
			instance.setTheNumber(1199);
			assertFalse(instance.isEvil());
		}
		
		@Test
		@DisplayName("Highly Composite Numbers")
		public void isHighlyCompositeSpec() {
			assertTrue(NumberTheory.isHighlyComposite(36));
			assertTrue(NumberTheory.isHighlyComposite(20160));
			assertFalse(NumberTheory.isHighlyComposite(30));
			instance.setTheNumber(15120);
			assertTrue(instance.isHighlyComposite());
			instance.setTheNumber(120);
			assertTrue(instance.isHighlyComposite());
			instance.setTheNumber(30);
			assertFalse(instance.isHighlyComposite());
		}
		
		
		@Test
		@DisplayName("Is Pernicious")
		public void isPernicious() {
			assertTrue(NumberTheory.isPernicious(34));
			assertTrue(NumberTheory.isPernicious(998));
			assertFalse(NumberTheory.isPernicious(1011));
			instance.setTheNumber(454);
			assertTrue(instance.isPernicious());
			instance.setTheNumber(1047);
			assertTrue(instance.isPernicious());
			instance.setTheNumber(1046);
			assertFalse(instance.isPernicious());
		}
		
		
		@Test
		@DisplayName("Is Perfect Power")
		public void isPerfectPower() {
			assertTrue(NumberTheory.isPerfectPower(32));
			assertTrue(NumberTheory.isPerfectPower(225));
			assertFalse(NumberTheory.isPerfectPower(257));
			instance.setTheNumber(1024);
			assertTrue(instance.isPerfectPower());
			instance.setTheNumber(1764);
			assertTrue(instance.isPerfectPower());
			instance.setTheNumber(1025);
			assertFalse(instance.isPerfectPower());
			
		}
		@Test
		@DisplayName("Is Achilles")
		public void isAchilles() {
			assertTrue(NumberTheory.isAchilles(3200));
			assertTrue(NumberTheory.isAchilles(1125));
			assertTrue(NumberTheory.isAchilles(3087));
			assertFalse(NumberTheory.isAchilles(3088));
			assertFalse(NumberTheory.isAchilles(2701));
		}
		
		

	} // End of boolean tests ---------------------------------------------------------------------------------------------

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
		
		/**
		 * Test method for {@link numberTheory.NumberTheory#getListOfDigits(int)}.
		 */
		@Test		
		@DisplayName("Check List of Digits.")
		void testGetListOfDigitsInt() {
			List<Integer> expected = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
			List<Integer> result = NumberTheory.getListOfDigits(654321);
			assertIterableEquals(expected, result);
		}
		
		/**
		 * Test method for {@link numberTheory.NumberTheory#getListOfDigits(BigInteger)}.
		 */
		@Test		
		@DisplayName("Check List of Digits.")
		void testGetListOfDigitsBigInt() {
			List<Integer> expected = new ArrayList<>(Arrays.asList(9,8,7,6, 5, 4, 3, 2, 1));
			BigInteger temp = BigInteger.valueOf(987654321L);
			List<Integer> result = NumberTheory.getListOfDigits(temp);
			assertIterableEquals(expected, result);
		}
		
		/**
		 * Test method for {@link numberTheory.NumberTheory#getListOfDigits()}.
		 */
		@Test
		void testGetListOfDigits() {
			instance.setTheNumber(687321);
			List<Integer> expected = new ArrayList<>(Arrays.asList(6,8,7,3,2,1));
			List<Integer> result = instance.getListOfDigits();
			assertIterableEquals(expected, result);
		}
		
		
		/**
		 * Test method for {@link numberTheory.NumberTheory#getTotatives()}.
		 */
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
		 * Test method for {@link numberTheory.NumberTheory#getCollatz()}.
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
			List<BigInteger> result = instance.getFibonacci();
			List<BigInteger> expected = new ArrayList<BigInteger>(Arrays.asList(BigInteger.ZERO, 
					BigInteger.ONE, 
					BigInteger.ONE,
					BigInteger.TWO, 
					BigInteger.valueOf(3),
					BigInteger.valueOf(5), 
					BigInteger.valueOf(8),
					BigInteger.valueOf(13), 
					BigInteger.valueOf(21),
					BigInteger.valueOf(34)));
			
			//List<BigInteger> expected = new LinkedList<>(Arrays.asList(null))
			assertIterableEquals(expected, result);

			result = NumberTheory.getFibonacciList(17);
			//expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987));
			expected = new ArrayList<BigInteger>(Arrays.asList(BigInteger.ZERO, 
					BigInteger.ONE, 
					BigInteger.ONE,
					BigInteger.TWO, 
					BigInteger.valueOf(3),
					BigInteger.valueOf(5), 
					BigInteger.valueOf(8),
					BigInteger.valueOf(13), 
					BigInteger.valueOf(21),
					BigInteger.valueOf(34),
					BigInteger.valueOf(55),
					BigInteger.valueOf(89),
					BigInteger.valueOf(144),
					BigInteger.valueOf(233),
					BigInteger.valueOf(377),
					BigInteger.valueOf(610),
					BigInteger.valueOf(987)));
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
		@DisplayName("Get Jacobsthal")
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
		
		
		@Test
		@DisplayName("Is Insolite Number")
		public void isInsoliteSpec() {
			instance.setTheNumber(122121216);
			assertTrue(instance.isInsolite());
			assertTrue(NumberTheory.isInsolite(122121216));
			assertTrue(NumberTheory.isInsolite(1111211136));
			//assertTrue(NumberTheory.isInsolite(211912113131712));
			assertFalse(NumberTheory.isInsolite(123));
			
		}
		
		
		
		@Test
		@DisplayName("Motzkin Numbers")
		public void getMotzkinNumbersSpec() {
			BigInteger result = NumberTheory.getMotzkin(18);
			BigInteger expected = BigInteger.valueOf(6536382);
			assertEquals(expected, result);
			instance.setTheNumber(29);
			result = instance.getMotzkin();
			expected = BigInteger.valueOf(1697385471211L);
		}
		
		
		
		
		
		
		
		@Test
		@DisplayName("GCD")
		public void gcdSpec() {
			int result = NumberTheory.gcd(10, 15);
			int expected = 5;
			assertEquals(expected,result);
			result = NumberTheory.gcd(100, 15);
			expected = 5;
			assertEquals(expected,result);
			
			instance.setTheNumber(100);
			result = instance.gcd(15);
			expected = 5;
			assertEquals(expected,result);
			
			instance.setTheNumber(100);
			result = instance.gcd(52);
			expected = 4;
			assertEquals(expected,result);
			
			instance.setTheNumber(54);
			result = instance.gcd(100);
			expected = 2;
			assertEquals(expected,result);
			
			expected = 45;
			assertNotEquals(expected, result);			
		}
		
		@Test
		@DisplayName("LCM")
		public void lcmSpec() {
			int result = NumberTheory.lcm(21, 6);
			int expected = 42;
			assertEquals(expected,result);
			
			result = NumberTheory.lcm(4, 6);
			expected = 12;
			assertEquals(expected,result);
			
			instance.setTheNumber(22);
			result = instance.lcm(13);
			expected = 286;
			assertEquals(expected,result);
		}

		
		/**
		 * Test method for {@link numberTheory.NumberTheory#isDeficient()}.
		 */
		@Test
		@DisplayName("Is deficient number?")
		public void isDeficientSpec() {
			assertTrue(NumberTheory.isDeficient(13));
			assertTrue(NumberTheory.isDeficient(796));
			assertTrue(NumberTheory.isDeficient(571));			
			assertFalse(NumberTheory.isDeficient(792));
			instance.setTheNumber(779);
			assertTrue(instance.isDeficient());
			instance.setTheNumber(786);
			assertFalse(instance.isDeficient());
		}

		/**
		 * @see {@link://www.numbersaplenty.com/set/equidigital_number/}.
		 * Test method for {@link numberTheory.NumberTheory#isEquidigital()}.
		 * 
		 */
		@Test
		@DisplayName("Is number equidigital?")
		public void isEquidigitalSpec() {
			assertTrue(NumberTheory.isEquidigital(1655));			
			assertFalse(NumberTheory.isEquidigital(1653));
		}
		
	}
	
	

}
