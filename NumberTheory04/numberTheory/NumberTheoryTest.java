package numberTheory;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

		// 40
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
			expected = 358203;
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
			long expected = 933L;
			long result = NumberTheory.getHouse(8);
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

	} // End of SimpleSingleValueReturn class
		// ----------------------------------------------------------------------------

	@Nested
	@DisplayName("Boolean Tests")
	class BooleanSpec {
		@Test
		@DisplayName("Number tests to be prime.")
		void testIsPrime() {
			instance.setTheNumber(17);
			assertTrue(instance.isPrime());
			assertTrue(NumberTheory.isPrime(17));
			instance.setTheNumber(15);
			assertFalse(instance.isPrime());
			assertFalse(NumberTheory.isPrime(15));
		}

		@Test
		@DisplayName("Is this a Hungry Number")
		public void getHungryNumberSpec() {
			assertTrue(NumberTheory.isHungry(7339199));
			assertTrue(NumberTheory.isHungry(144));
			assertTrue(NumberTheory.isHungry(5));
			assertFalse(NumberTheory.isHungry(145));
			instance.setTheNumber(2003);
			assertTrue(instance.isHungry());
			instance.setTheNumber(17);
			assertTrue(instance.isHungry());
			instance.setTheNumber(20);
			assertFalse(instance.isHungry());
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
			assertTrue(Primes.isCoPrime(18, 35));
			assertFalse(Primes.isCoPrime(18, 36));

			instance.setTheNumber(13);
			assertTrue(instance.isCoPrime(31));
			instance.setTheNumber(150);
			assertFalse(instance.isCoPrime(295));
		}

		@Test
		@DisplayName("Is Astonishing?")
		public void isAstonishingSpec() {
			assertTrue(NumberTheory.isAstonishing(15));
			// assertTrue(NumberTheory.isAstonishing(216));
			assertFalse(NumberTheory.isAstonishing(20));

			instance.setTheNumber(1353);
			assertTrue(instance.isAstonishing());
			instance.setTheNumber(1354);
			assertFalse(instance.isAstonishing());
		}

		// isAutomorphic
		// 12890625
		@Test
		@DisplayName("Is Automorphic?")
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
		@DisplayName("Is Admirable? ")
		public void admirableNumberSpec() {
			assertTrue(NumberTheory.isAdmirable(12));

			instance.setTheNumber(20);
			assertTrue(instance.isAdmirable());
			instance.setTheNumber(21);
			assertFalse(instance.isAdmirable());
		}

		@Test
		@DisplayName("Is Amenable")
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
		@DisplayName("Is Alternating?")
		public void isAlternatingSpec() {
			assertTrue(NumberTheory.isAlternating(903));
			assertFalse(NumberTheory.isAlternating(904));

			instance.setTheNumber(19);
			assertFalse(instance.isAlternating());
			instance.setTheNumber(1872);
			assertTrue(instance.isAlternating());
		}

		@Test
		@DisplayName("Is Antiperfect?")
		public void isAntiPerfectSpec() {
			assertTrue(NumberTheory.isAntiPerfect(133857));
			assertFalse(NumberTheory.isAntiPerfect(44));

			instance.setTheNumber(211);
			assertFalse(instance.isAntiPerfect());
			instance.setTheNumber(244);
			assertTrue(instance.isAntiPerfect());
		}

		@Test
		@DisplayName("Is Arithmetic?")
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
		 * divisors are all deficient numbers. Test of isPrimitiveAbundant()
		 */
		@Test
		@DisplayName("Is Primitive Abundant?")
		public void testIsPrimitiveAbundant() {
			instance.setTheNumber(20);
			assertTrue(instance.isPrimitiveAbundant());
			instance.setTheNumber(70);
			assertTrue(instance.isPrimitiveAbundant());

			instance.setTheNumber(87);
			assertFalse(instance.isPrimitiveAbundant());

			assertTrue(NumberTheory.isPrimitiveAbundant(20));
			assertFalse(instance.isPrimitiveAbundant());

//			instance.setTheNumber(88);
//			assertFalse(instance.isPrimitiveAbundant());			
			

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

		/**
		 * Test method for {@link numberTheory.NumberTheory#isCarmichael()}.
		 */
		@Test
		@DisplayName("Is Carmichael?")
		public void isCarmichaelSpec() {
			assertTrue(NumberTheory.isCarmichael(8911));
			assertTrue(NumberTheory.isCarmichael(1729));
			assertFalse(NumberTheory.isCarmichael(1100));
			instance.setTheNumber(2821);
			assertTrue(instance.isCarmichael());
			instance.setTheNumber(2465);
			assertTrue(instance.isCarmichael());
			instance.setTheNumber(8911);
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
		public void isEconomicalSpec() {
			assertTrue(NumberTheory.isEconomical(1655));
			assertTrue(NumberTheory.isEconomical(13));
			assertFalse(NumberTheory.isEconomical(12));
			assertTrue(NumberTheory.isEconomical(108749));
		}

		@Test
		@DisplayName("Is number Equidigital? ")
		public void isEquidigitalSpec() {
			assertTrue(NumberTheory.isEquidigital(64));
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
			// 4, 8, 9, 16, 21, 25, 27, 32, 35, 36, 39, 49, 50, 55, 57, 63, 64, 65, 75, 77,
			// 81, 85, 93, 98, 100, 111, 115, 119, 121, 125, 128, 129, 133, 143, 144, 155,
			// 161, 169, 171, 175, 183, 185, 187, 189, 201, 203, 205, 209, 215, 217, 219
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

		// 115048440 8128 4713984

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

		@Test
		@DisplayName("In Number Enlightened")
		public void isEnlightened() {
			assertTrue(NumberTheory.isEnlightened(250));
			assertTrue(NumberTheory.isEnlightened(25600));
			assertTrue(NumberTheory.isEnlightened(262144));
			assertTrue(NumberTheory.isEnlightened(219488));
			assertTrue(NumberTheory.isEnlightened(119911));
			// assertTrue(NumberTheory.isEnlightened(2377970784L));
			assertFalse(NumberTheory.isEnlightened(262145));
			instance.setTheNumber(25600);
			assertTrue(instance.isEnlightened());
		}
		
		
		@Test
		@DisplayName("Is Number Esthetic")
		public void isEsthetic(){
			assertTrue(NumberTheory.isEsthetic(121210));
			assertTrue(NumberTheory.isEsthetic(121));
			assertTrue(NumberTheory.isEsthetic(210));
			assertFalse(NumberTheory.isEsthetic(99));
			instance.setTheNumber(21012);
			assertTrue(instance.isEsthetic());
			instance.setTheNumber(21011);
			assertFalse(instance.isEsthetic());
			
		}

	} // End of boolean tests
		// ---------------------------------------------------------------------------------------------

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
		@DisplayName("Lucky Numbers")
		public void testGetLuckyNumbers() {			
			List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 7, 9, 13, 15, 21, 25, 31, 33, 37, 43, 49, 51, 63, 67, 69, 73, 75, 79, 87, 93, 99, 105, 111, 115, 127, 129, 133, 135, 141, 151, 159, 163, 169, 171, 189, 193, 195, 201, 205, 211, 219, 223, 231, 235, 237, 241));
			List<Integer> result = NumberTheory.getLuckyNumber(250);
			assertIterableEquals(expected, result);
			instance.setTheNumber(150);
			expected = new ArrayList<>(Arrays.asList(1, 3, 7, 9, 13, 15, 21, 25, 31, 33, 37, 43, 49, 51, 63, 67, 69, 73, 75, 79, 87, 93, 99, 105, 111, 115, 127, 129, 133, 135, 141));
			result = instance.getLuckyNumber();
			assertIterableEquals(expected, result);
		}
		//1, 3, 7, 9, 13, 15, 21, 25, 31, 33, 37, 43, 49, 51, 63, 67, 69, 73, 75, 79, 87, 93, 99, 105, 111, 115, 127, 129, 133, 135, 141, 151, 159, 163, 169, 171, 189, 193, 195, 201, 205, 211, 219, 223, 231, 235, 237, 241,
		
		
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
		 * Test method for
		 * {@link numberTheory.NumberTheory#getListOfDigits(BigInteger)}.
		 */
		@Test
		@DisplayName("Check List of Digits.")
		void testGetListOfDigitsBigInt() {
			List<Integer> expected = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
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
			List<Integer> expected = new ArrayList<>(Arrays.asList(6, 8, 7, 3, 2, 1));
			List<Integer> result = instance.getListOfDigits();
			assertIterableEquals(expected, result);
		}

		/**
		 * Test method for {@link numberTheory.NumberTheory#getTotativesList()}.
		 */
		@Test
		@DisplayName("Return Totatives List.")
		public void getTotatives() {
			List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 7, 8));
			List<Integer> result = NumberTheory.getTotativesList(9);
			assertIterableEquals(expected, result);
			expected.clear();

			instance.setTheNumber(75);
			expected = new ArrayList<>(Arrays.asList(1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19, 22, 23, 26, 28, 29, 31, 32,
					34, 37, 38, 41, 43, 44, 46, 47, 49, 52, 53, 56, 58, 59, 61, 62, 64, 67, 68, 71, 73, 74));
			result = instance.getTotativesList();
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
			Primes thePrimeInstance = new Primes();
			
			thePrimeInstance.setTheNumber(theTestValue);
			List<Integer> expected = new ArrayList<>(Arrays.asList(2, 2, 3, 5));
			List<Integer> result = thePrimeInstance.getPrimeFactors();
			assertIterableEquals(expected, result);
			assertIterableEquals(expected, Primes.getPrimeFactors(theTestValue));
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
			List<BigInteger> expected = new ArrayList<BigInteger>(Arrays.asList(BigInteger.ZERO, BigInteger.ONE,
					BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(8),
					BigInteger.valueOf(13), BigInteger.valueOf(21), BigInteger.valueOf(34)));

			// List<BigInteger> expected = new LinkedList<>(Arrays.asList(null))
			assertIterableEquals(expected, result);

			result = NumberTheory.getFibonacciList(17);
			// expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
			// 89, 144, 233, 377, 610, 987));
			expected = new ArrayList<BigInteger>(Arrays.asList(BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE,
					BigInteger.TWO, BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(8),
					BigInteger.valueOf(13), BigInteger.valueOf(21), BigInteger.valueOf(34), BigInteger.valueOf(55),
					BigInteger.valueOf(89), BigInteger.valueOf(144), BigInteger.valueOf(233), BigInteger.valueOf(377),
					BigInteger.valueOf(610), BigInteger.valueOf(987)));
			assertIterableEquals(expected, result);
		}
		
		
		@Test
		@DisplayName("Get Tribonacci")
		public void tribonacciSpec() {		
			List<BigInteger> expected;
			instance.setTheNumber(15);
			List<BigInteger> result = instance.getTribonacciList();
			expected = new ArrayList<BigInteger>(Arrays.asList(
					BigInteger.ZERO,
					BigInteger.ONE,
					BigInteger.ONE,
					BigInteger.valueOf(2L),
					BigInteger.valueOf(4L),
					BigInteger.valueOf(7L),
					BigInteger.valueOf(13L),
					BigInteger.valueOf(24L),
					BigInteger.valueOf(44L),
					BigInteger.valueOf(81L),
					BigInteger.valueOf(149L),
					BigInteger.valueOf(274L),
					BigInteger.valueOf(504L),
					BigInteger.valueOf(927L),
					BigInteger.valueOf(1705L)));
			assertIterableEquals(expected, result);
			result = NumberTheory.getTribonacciList(15);
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
			assertFalse(NumberTheory.isInsolite(123));

			instance.setTheNumber(1122112);
			assertTrue(instance.isInsolite());
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
			assertEquals(expected, result);
			result = NumberTheory.gcd(100, 15);
			expected = 5;
			assertEquals(expected, result);

			instance.setTheNumber(100);
			result = instance.gcd(15);
			expected = 5;
			assertEquals(expected, result);

			instance.setTheNumber(100);
			result = instance.gcd(52);
			expected = 4;
			assertEquals(expected, result);

			instance.setTheNumber(54);
			result = instance.gcd(100);
			expected = 2;
			assertEquals(expected, result);

			expected = 45;
			assertNotEquals(expected, result);
			
			List<Integer> gcdList = new ArrayList<>(Arrays.asList(10, 15, 50, 1750));
			result = NumberTheory.findGCD(gcdList);
			expected = 5;
			assertEquals(expected, result);
			
			
		}

		@Test
		@DisplayName("LCM")
		public void lcmSpec() {
			int result = NumberTheory.lcm(21, 6);
			int expected = 42;
			assertEquals(expected, result);

			result = NumberTheory.lcm(4, 6);
			expected = 12;
			assertEquals(expected, result);

			instance.setTheNumber(22);
			result = instance.lcm(13);
			expected = 286;
			assertEquals(expected, result);
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
		 * @see {@link://www.numbersaplenty.com/set/equidigital_number/}. Test method
		 *      for {@link numberTheory.NumberTheory#isEquidigital()}.
		 * 
		 */
		@Test
		@DisplayName("Is number equidigital?")
		public void isEquidigitalSpec() {
			assertTrue(NumberTheory.isEquidigital(1655));
			assertFalse(NumberTheory.isEquidigital(1653));
		}

		@Test
		@DisplayName("Is number apocalyptic?")
		public void isApocalypticSpec() {
			assertTrue(NumberTheory.isApocalyptic(157));
			assertTrue(NumberTheory.isApocalyptic(285));
			assertFalse(NumberTheory.isApocalyptic(412));

			instance.setTheNumber(434);
			assertTrue(instance.isApocalyptic());
			instance.setTheNumber(2300);
			assertTrue(instance.isApocalyptic());
			instance.setTheNumber(2159);
			assertFalse(instance.isApocalyptic());
		}
		
		@Test
		@DisplayName("FiboDiv")
		public void isFiboDiv() {
			assertTrue(NumberTheory.isFiboDiv(14));
			assertTrue(NumberTheory.isFiboDiv(122));
			assertTrue(NumberTheory.isFiboDiv(12992));
			assertTrue(NumberTheory.isFiboDiv(14562410));
		}
		
		@Test
		@DisplayName("Is Number D-Number?")
		public void isDNumber() {
			assertTrue(NumberTheory.isDNumber(9));
			//assertTrue(NumberTheory.isDNumber(7179));
			//assertTrue(NumberTheory.isDNumber(9411));
			assertFalse(NumberTheory.isDNumber(7500));
			instance.setTheNumber(15);
			assertTrue(instance.isDNumber());
		}
		
		@Test
		@DisplayName("Gilda")
		public void isGilda() {
			assertTrue(NumberTheory.isGilda(29));
			assertTrue(NumberTheory.isGilda(38006));
			assertTrue(NumberTheory.isGilda(933138));
			assertFalse(NumberTheory.isGilda(30));
			instance.setTheNumber(35422);
			assertTrue(instance.isGilda());
		}
		
		@Test
		@DisplayName("Giuga")
		public void isGiuga() {
			//30, 858, 1722, 1723, 66198
			assertTrue(NumberTheory.isGiuga(30));
			assertTrue(NumberTheory.isGiuga(858));
			assertTrue(NumberTheory.isGiuga(1722));
			assertFalse(NumberTheory.isGiuga(1723));
			instance.setTheNumber(66198);
			assertTrue(instance.isGiuga());
		}
		
		
		@Test
		@DisplayName("Dicksons Method")
		public void isDicksonsMethod() {			
			instance.setTheNumber(6);
			assertTrue(instance.isDicksonsMethod());
		}
		
		@Test
		@DisplayName("Saint Exupery")
		public void getSaintExupery() {
			instance.setTheNumber(20);
			List<Long> expected = new ArrayList<>(Arrays.asList(60L, 480L, 780L, 1620L, 2040L, 3840L, 4200L, 6240L, 7500L, 12180L, 12960L, 14760L, 15540L, 16320L, 20580L, 21060L, 30720L, 33600L, 40260L, 43740L, 49920L, 55080L, 60000L, 65520L, 66780L, 92820L, 97500L, 113400L, 118080L, 124320L, 189840L, 199980L, 322080L, 354960L, 619020L, 1021020L));
			List<Long> result = instance.getSaintExupery();
			assertIterableEquals(expected, result);
			result = NumberTheory.getSaintExupery(20);
			assertIterableEquals(expected, result);
		}
		
		@Test
		@DisplayName("Perrins Numbers")
		public void getPerrinsNumber() {
			int result = NumberTheory.getPerrin(45);
			int expected = 313007;
			assertEquals(expected, result);
			instance.setTheNumber(44);
			result = instance.getPerrin();
			expected = 236282;
			assertEquals(expected, result);			
		}
		
		@Test
		@DisplayName("Cunningham Numbers")
		public void isCunninghamNumber() {
			assertTrue(NumberTheory.isCunningham(17));
			instance.setTheNumber(28);
			assertTrue(instance.isCunningham());
		}
		
		@Test
		@DisplayName("Hoax Numbers")
		public void isHoax() {
			assertTrue(NumberTheory.isHoaxNumber(22));
			assertTrue(NumberTheory.isHoaxNumber(5464));
			assertTrue(NumberTheory.isHoaxNumber(32880));
			assertFalse(NumberTheory.isHoaxNumber(23));
			instance.setTheNumber(33169);
			assertTrue(instance.isHoaxNumber());
		}
		
		
		@Test
		@DisplayName("Eulerian Numbers")
		public void getEulerian() {
			int result = NumberTheory.getEulerian(9, 4);
			int expected = 156190;
			assertEquals(expected, result);
			result = NumberTheory.getEulerian(10, 5);
			expected = 1310354;
			assertEquals(expected, result);
		}
		
		@Test
		@DisplayName("Betrothed Numbers")
		public void getBetrothed() {
			int result = NumberTheory.getBetrothedNumber(1050);
			int expected = 1925;
			assertEquals(expected, result);
			instance.setTheNumber(9504);
			result = instance.getBetrothedNumber();
			expected = 20735;
			assertEquals(expected, result);
		}
		
		@Test
		@DisplayName("iccanobiF List")
		public void iccanobiFSpec() {
			instance.setTheNumber(30);
			List<BigInteger> result2 = instance.iccanobiFNumbers();
			List<BigInteger> result = NumberTheory.iccanobiFNumbers(30);
			List<BigInteger> expected = new ArrayList<>(Arrays.asList(BigInteger.valueOf(1), 
					BigInteger.valueOf(2), 
					BigInteger.valueOf(3), 
					BigInteger.valueOf(5), 
					BigInteger.valueOf(8), 
					BigInteger.valueOf(13), 
					BigInteger.valueOf(39), 
					BigInteger.valueOf(124), 
					BigInteger.valueOf(514), 
					BigInteger.valueOf(836), 
					BigInteger.valueOf(1053), 
					BigInteger.valueOf(4139), 
					BigInteger.valueOf(12815), 
					BigInteger.valueOf(61135), 
					BigInteger.valueOf(104937), 
					BigInteger.valueOf(792517), 
					BigInteger.valueOf(1454698), 
					BigInteger.valueOf(9679838), 
					BigInteger.valueOf(17354310), 
					BigInteger.valueOf(9735140), 
					BigInteger.valueOf(1760750), 
					BigInteger.valueOf(986050), 
					BigInteger.valueOf(621360), 
					BigInteger.valueOf(113815), 
					BigInteger.valueOf(581437), 
					BigInteger.valueOf(1252496), 
					BigInteger.valueOf(7676706), 
					BigInteger.valueOf(13019288)));
			
			assertIterableEquals(expected, result);
			assertEquals(28, result.size());
			assertIterableEquals(expected, result2);
			assertEquals(28, result2.size());
		}
		
		@Test
		@DisplayName("isPolite")		
		public void isPolite() {
			assertFalse(NumberTheory.isImpolite(12));
			instance.setTheNumber(12);
			assertFalse(instance.isImpolite());
			assertTrue(NumberTheory.isImpolite(2048));
		}
		
		@Test
		@DisplayName("isHonakerPrime")
		public void isHonakerPrime() {
			assertTrue(NumberTheory.isHonakerPrime(131));
			assertTrue(NumberTheory.isHonakerPrime(47623));	
			assertFalse(NumberTheory.isHonakerPrime(137));
			assertNull(NumberTheory.isHonakerPrime(132));
			instance.setTheNumber(34471);
			assertTrue(instance.isHonakerPrime());
			instance.setTheNumber(197);
			assertFalse(instance.isHonakerPrime());
			instance.setTheNumber(134);
			assertNull(instance.isHonakerPrime());			
		}
		
		@Test
		@DisplayName("Is Idoneal Number?")
		public void isIdoneal() {
			assertTrue(NumberTheory.isIdoneal(177));
			assertFalse(NumberTheory.isIdoneal(31));
			instance.setTheNumber(60);
			assertTrue(instance.isIdoneal());
			instance.setTheNumber(59);
			assertFalse(instance.isIdoneal());
			
		}
		
		@Test
		@DisplayName("Junction Numbers")
		public void JunctionNumbers() {
			List<Integer> result = NumberTheory.getJunctionNumbers(109);
			List<Integer> expected = new ArrayList<>(Arrays.asList(101, 103, 105, 107, 109, 111, 113, 115, 117));
			assertIterableEquals(expected, result);
			instance.setTheNumber(109);
			result = instance.getJunctionNumbers();
			assertIterableEquals(expected, result);			
		}
		
		@Test
		@DisplayName("Kaprekar Numbers")
		public void KaprekarNumbers() {
			assertTrue(NumberTheory.isKaprekar(703L));
			assertTrue(NumberTheory.isKaprekar(648648L));
			
		}
		
		@Test
		@DisplayName("Return a list of Leyland sequence.")
		public void testGetLeyland() {
			instance.setTheNumber(10);
			List<Long> expected = new ArrayList<>(Arrays.asList(8L, 17L, 32L, 54L, 57L, 145L, 368L, 512L, 1649L, 6250L));
			List<Long> result = instance.getLeyland();
			assertIterableEquals(expected, result);
			result = NumberTheory.getLeyland(9);
			expected = new ArrayList<>(Arrays.asList(8L, 17L, 32L, 54L, 57L, 145L, 368L, 512L, 1649L));
			assertIterableEquals(expected, result);
		}
		
		@Test
		@DisplayName("Hyperperfect Number")
		public void testHyperPerfect() {
			instance.setTheNumber(28);
			assertTrue(instance.isHyperPerfect(1));
			assertTrue(NumberTheory.isHyperPerfect(496, 1));
			assertTrue(NumberTheory.isHyperPerfect(2133, 2));
			assertTrue(NumberTheory.isHyperPerfect(301, 6));
		}
		
		
		@Test
		@DisplayName("Pierpont Primes")
		public void testPierpontPrime() {
			Primes primeInstance = new Primes();
			primeInstance.setTheNumber(7);
			primeInstance.setTheNumber(995329);
			assertTrue(primeInstance.isPierpontPrime());
			assertTrue(Primes.isPierpontPrime(839809));
		}
		
		
		@Test
		@DisplayName("Katadromes")
		public void testIsKatadromes() {
			instance.setTheNumber(43210);
			assertTrue(instance.isKatadrome());
			assertTrue(NumberTheory.isKatadrome(76521));
			instance.setTheNumber(43211);
			assertFalse(instance.isKatadrome());
			assertFalse(NumberTheory.isKatadrome(76523));
			instance.setTheNumber(0);
		}
		
		
		
		
		@Test
		@DisplayName("Metadromes")
		public void testIsMetadromes() {
			instance.setTheNumber(12789);
			assertTrue(instance.isMetadrome());
			assertTrue(NumberTheory.isMetadrome(1234));
			assertTrue(NumberTheory.isMetadrome(123789));
			assertFalse(NumberTheory.isMetadrome(4321));
		}
		
		@Test
		@DisplayName("Lynch-Bells")
		public void testIsLynchBell() {
			instance.setTheNumber(9867312);
			assertTrue(instance.isLynchBell());
			assertTrue(NumberTheory.isLynchBell(728));
			assertFalse(NumberTheory.isLynchBell(650));			
		}
		
		@Test
		@DisplayName("Magic square constants")
		public void testGetMagicSquareConstants() {
			instance.setTheNumber(18);
			int result = instance.getMagicSquareConstant();
			int expected = 2925;
			assertEquals(expected, result);
			result = NumberTheory.getMagicSquareConstant(301);
			expected = 13635601;
			assertEquals(expected, result);
		}
		
		@Test
		@DisplayName("Is Magnanimous")
		public void testIsMagnanimous() {			
			instance.setTheNumber(203);
			assertTrue(instance.isMagnanimous());
			assertTrue(NumberTheory.isMagnanimous(112));
			assertTrue(NumberTheory.isMagnanimous(4001));
			assertFalse(NumberTheory.isMagnanimous(113));
			instance.setTheNumber(173);
			assertFalse(instance.isMagnanimous());
			assertTrue(NumberTheory.isMagnanimous(799394));
		}
		
		@Test
		@DisplayName("Is Modest")
		public void testIsModest() {
			instance.setTheNumber(211);
			assertTrue(instance.isModest());
			assertTrue(NumberTheory.isModest(9699));
			assertTrue(NumberTheory.isModest(10999));
			assertTrue(NumberTheory.isModest(20003));
			assertFalse(NumberTheory.isModest(19170));
		}
		
		
		@Test
		@DisplayName("Is Moran")
		public void testIsMoran() {
			instance.setTheNumber(21036);
			assertTrue(instance.isMoran());
			assertTrue(NumberTheory.isMoran(9232));
			assertTrue(NumberTheory.isMoran(423));
			assertTrue(NumberTheory.isMoran(21481224));
			assertFalse(NumberTheory.isMoran(422));
		}
		
		
		@Test
		@DisplayName("Is Narcissistic")
		public void testIsNarcissistic() {
			instance.setTheNumber(9474);
			assertTrue(instance.isNarcissistic());
			assertTrue(NumberTheory.isNarcissistic(54748));
			assertTrue(NumberTheory.isNarcissistic(93084));
			assertTrue(NumberTheory.isNarcissistic(912985153));
			assertFalse(NumberTheory.isNarcissistic(912985152));
		}
		
		
		@Test
		@DisplayName("Is Nude Number")
		public void testIsNude() {
			instance.setTheNumber(21126);
			assertTrue(instance.isNude());
			assertTrue(NumberTheory.isNude(13362));
			assertTrue(NumberTheory.isNude(8248));
			assertTrue(NumberTheory.isNude(883176));
			assertFalse(NumberTheory.isNude(883417));
			assertFalse(NumberTheory.isNude(883017));
		}		
		
		@Test
		@DisplayName("Is Poulet")
		public void testIsPoulet() {
			instance.setTheNumber(1105);
			assertTrue(instance.isPoulet());
			assertFalse(NumberTheory.isPoulet(342));
			assertTrue(NumberTheory.isPoulet(341));
			assertTrue(NumberTheory.isPoulet(561));
			assertTrue(NumberTheory.isPoulet(6601));
			assertTrue(NumberTheory.isPoulet(5461));
			assertTrue(NumberTheory.isPoulet(6135585));
			assertFalse(NumberTheory.isPoulet(6140160));
		}
		
		@Test
		@DisplayName("Pronic")
		public void testGetPronic() {
			instance.setTheNumber(100);
			int result = instance.getPronic();
			int expected = 10100;
			assertEquals(expected, result);
			result = NumberTheory.getPronic(100);
			assertEquals(expected, result);
		}
		
		@Test
		@DisplayName(" Is Pronic")
		public void testIsPronic() {
			instance.setTheNumber(355812);
			assertTrue(instance.isPronic());
			assertTrue(NumberTheory.isPronic(30450));
			assertTrue(NumberTheory.isPronic(6));
			assertFalse(NumberTheory.isPronic(620));
		}
		
		@Test
		@DisplayName("Pronic List")
		public void testGetPronicList() {			
			List<Integer> result = NumberTheory.getPronic(20, 25);
			List<Integer> expected = new ArrayList<>(Arrays.asList(420, 462, 506, 552, 600, 650));			
			assertIterableEquals(expected, result);
			instance.setTheNumber(20);
			int expected2 = 420;
			int result2 = instance.getPronic();
			assertEquals(expected2, result2);
			expected2 = 650;
			result2 = NumberTheory.getPronic(25);
			assertEquals(expected2, result2);			
		}
		
		
		@Test
		@DisplayName("Deceptive")
		public void testIsDeceptive() {
			instance.setTheNumber(7471);
			assertTrue(instance.isDeceptive());
			assertTrue(NumberTheory.isDeceptive(91));
			assertTrue(NumberTheory.isDeceptive(259));
			assertTrue(NumberTheory.isDeceptive(451));
			assertTrue(NumberTheory.isDeceptive(8401));
			assertFalse(NumberTheory.isDeceptive(260));
		}
		
		@Test
		@DisplayName("Sastry")
		public void testIsSastry() {
			instance.setTheNumber(13224);
			assertTrue(instance.isSastry());
			instance.setTheNumber(instance.getTheNumber() + 1);
			assertFalse(instance.isSastry());
			assertTrue(NumberTheory.isSastry(2975208L));
			assertTrue(NumberTheory.isSastry(715L));
			assertTrue(NumberTheory.isSastry(996225356413048L));
		}
		
		@Test
		@DisplayName("Sphenic")
		public void testIsSphenic() {
			instance.setTheNumber(3642);
			assertTrue(instance.isSphenic());
			assertTrue(NumberTheory.isSphenic(3111));
			assertTrue(NumberTheory.isSphenic(2715));
			assertTrue(NumberTheory.isSphenic(2233));
			assertFalse(NumberTheory.isSphenic(3622));
		}
		
		@Test
		@DisplayName("Rare Numbers")
		public void testIsRare() {
			assertTrue(NumberTheory.isRare(65L));
			assertTrue(NumberTheory.isRare(281089082L));
			assertTrue(NumberTheory.isRare(816984566129618L));
			assertFalse(NumberTheory.isRare(66L));  //repdigit cannot be rare
			assertFalse(NumberTheory.isRare(85l));	
		}
		
		@Test
		@DisplayName("PalPrimes")
		public void testIsPalPrime() {
			assertTrue(NumberTheory.isPalPrime(101));
			assertTrue(NumberTheory.isPalPrime(1114111));
			assertTrue(NumberTheory.isPalPrime(143787341));
		}
		
		
		@Test
		@DisplayName("Ormiston Pairs")
		public void testGetOrmiston() {
			HashMap<Integer,Integer> expectedMap = new HashMap<>();
			expectedMap.put(1913, 1931);
			HashMap<Integer, Integer> resultMap = NumberTheory.getOrmiston(1913);			
			Assert.assertNotNull("Provided map is null;", expectedMap);
			Assert.assertNotNull("Resultant map is null;", resultMap);
			Assert.assertEquals("Size mismatch for maps; ", expectedMap.size(), resultMap.size());
			Assert.assertTrue("Missing key in resultant map:", resultMap.keySet().containsAll(expectedMap.keySet()));
			
			instance.setTheNumber(1913);			
			HashMap<Integer, Integer> resultMap2 = instance.getOrmiston();			
			Assert.assertNotNull("Provided map is null;", expectedMap);
			Assert.assertNotNull("Resultant map is null;", resultMap2);
			Assert.assertEquals("Size mismatch for maps; ", expectedMap.size(), resultMap2.size());
			Assert.assertTrue("Missing key in resultant map:", resultMap2.keySet().containsAll(expectedMap.keySet()));			
		}
	
	
		@Disabled("Disabled until isFriedmanNumber is completed")
		@Test
		@DisplayName("Friedman Numbers")
		public void testFriedmanNumbers() {
			assertTrue(NumberTheory.isFriedmanNumber(13125));
			//assertTrue(NumberTheory.isFriedmanNumber(25));
			//assertTrue(NumberTheory.isFriedmanNumber(121));
			//assertFalse(NumberTheory.isFriedmanNumber(100));
			//findFriedmanNumbers
			//List<Integer> result = NumberTheory.findFriedmanNumbers(130);
			//List<Integer> expected = new ArrayList<>(Arrays.asList(25,121,125,126,127,128));			
			//assertIterableEquals(expected, result);
			
		}
		
		@Test
		@DisplayName("Trimorphic Numbers")
		public void testIsTrimorphic() {
			assertTrue(NumberTheory.isTrimorphic(99));
			assertTrue(NumberTheory.isTrimorphic(759918212890625L));
			assertFalse(NumberTheory.isTrimorphic(50));
			instance.setTheNumber(99);
			assertTrue(instance.isTrimorphic());
		}
		
		@Test
		@DisplayName("Tau Numbers")
		public void testIsTau() {
			//It is a tau number, because it is divible by the number of its divisors (12).
			assertTrue(NumberTheory.isTau(108));
			instance.setTheNumber(8560);
			assertTrue(instance.isTau());
			assertFalse(NumberTheory.isTau(109));			
		}
		
		@Test
		@DisplayName("Truncatable Prime")
		public void testIsTruncatable() {
			assertFalse(NumberTheory.isTruncatablePrime(2023, "L"));
			assertTrue(NumberTheory.isTruncatablePrime(26947, "LEft"));
			assertTrue(NumberTheory.isTruncatablePrime(23399, "Right"));
			assertTrue(NumberTheory.isTruncatablePrime(1825711, "b"));
		}
		
		@Test
		@DisplayName("Parse Number to List Test")
		public void testParseNumberToList() {
			List<Long> expected = new ArrayList<>(Arrays.asList(1l,2l,3l,4l,5l,6l));
			List<Long> result = NumberTheory.parseNumberToList(123456);
			assertIterableEquals(expected, result);
		}
		
		
		@Test
		@DisplayName("Semi-Perfect (Pseudo-perfect) Test")
		public void testIsSemiPerfect() {
			assertTrue(NumberTheory.isSemiPerfect(30));
			assertTrue(NumberTheory.isSemiPerfect(40));
			assertFalse(NumberTheory.isSemiPerfect(35));
			assertFalse(NumberTheory.isSemiPerfect(1));
			instance.setTheNumber(2432);
			assertTrue(instance.isSemiPerfect());
			instance.setTheNumber(195);
			assertFalse(instance.isSemiPerfect());			
		}
		
		@Test
		@DisplayName("O'Halloran Numbers Test")
		public void testOHalloranNumbers() {
			List<Integer> expected = new ArrayList<>(Arrays.asList(8, 12, 20, 36, 44, 60, 84, 116, 140, 156, 204, 260, 380, 420, 660, 924));
			List<Integer> result = NumberTheory.OHalloranNumbers(1000);
			assertIterableEquals(expected, result);
			instance.setTheNumber(999);
			result = instance.OHalloranNumbers();
			assertIterableEquals(expected, result);
		}
		
	}
	
	

}
