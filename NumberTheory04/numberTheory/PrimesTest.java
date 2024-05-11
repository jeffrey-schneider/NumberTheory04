package numberTheory;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author JeffreySchneider
 *
 */
class PrimesTest {

	Primes instance;

	@BeforeEach()
	public void initEach() {

//		System.out.println("BeforeEach initEach() method called.");
		instance = new Primes(12);

	}

	/**
	 * Test method for {@link numberTheory.Primes#isSemiPrime(int)}.
	 */
	@Test
	@DisplayName("Is semi prime?")
	public void isSemiPrimeSpec() {
		assertTrue(Primes.isSemiPrime(15));
		assertFalse(Primes.isSemiPrime(92));

		instance.setTheNumber(74);
		assertTrue(instance.isSemiPrime());
		instance.setTheNumber(84);
		assertFalse(instance.isSemiPrime());
	}

	@Test
	@DisplayName("Is Brilliant Number?")
	public void isBrilliantSpec() {
		assertTrue(Primes.isBrilliant(253));
		assertTrue(Primes.isBrilliant(24823));
		assertFalse(Primes.isBrilliant(295));
		instance.setTheNumber(24797);
		assertTrue(instance.isBrilliant());
		instance.setTheNumber(25352);
		assertFalse(instance.isBrilliant());

	}

	/**
	 * Test method for {@link numberTheory.Primes#isEmirpimeses(int)}.
	 */
	@Test
	@DisplayName("Is Number Emirpimeses")
	void testIsEmirpimesesInt() {
		assertTrue(Primes.isEmirpimeses(15));
		assertTrue(Primes.isEmirpimeses(159));
		assertTrue(Primes.isEmirpimeses(178));
		assertFalse(Primes.isEmirpimeses(3692));
		instance.setTheNumber(205);
		assertTrue(instance.isEmirpimeses());
		instance.setTheNumber(6463);
		assertTrue(instance.isEmirpimeses());
		instance.setTheNumber(6465);
		assertFalse(instance.isEmirpimeses());

	}

	/**
	 * Test method for {@link numberTheory.Primes#isEmirpimeses()}.
	 */
	@Test
	void testIsEmirpimeses() {
		instance.setTheNumber(15);
		assertTrue(instance.isEmirpimeses());
		instance.setTheNumber(159);
		assertTrue(instance.isEmirpimeses());
		instance.setTheNumber(178);
		assertTrue(instance.isEmirpimeses());
	}

	/**
	 * Test method for {@link numberTheory.Primes#isChenPrime(int)}.
	 */
	@Test
	@DisplayName("Is a Chen Prime?")
	void testIsChenPrimeInt() {
		assertTrue(Primes.isChenPrime(137));
//		assertFalse(Primes.isChenPrime(133));

	}

	/**
	 * Test method for {@link numberTheory.Primes#isChenPrime()}.
	 */
	@Test
	@DisplayName("Is a Chen Prime?")
	void testIsChenPrime() {
		instance.setTheNumber(211);
		assertTrue(instance.isChenPrime());
		instance.setTheNumber(84);
		assertFalse(instance.isChenPrime());
	}

	@Test
	@DisplayName("Good Primes")
	public void getGoodPrimesSpec() {
		assertTrue(Primes.isGoodPrime(967));
		assertFalse(Primes.isGoodPrime(568));
		instance.setTheNumber(347);
		assertTrue(instance.isGoodPrime());
		instance.setTheNumber(258);
		assertFalse(instance.isGoodPrime());
	}

	@Test
	@DisplayName("Is interprime?")
	public void isInterPrimeSpec() {
		assertTrue(Primes.isInterPrime(120));
		assertTrue(Primes.isInterPrime(1482));
		assertTrue(Primes.isInterPrime(2802));
		assertFalse(Primes.isInterPrime(121));
		assertFalse(Primes.isInterPrime(1000));

		instance.setTheNumber(120);
		assertTrue(instance.isInterPrime());
		instance.setTheNumber(1020);
		assertTrue(instance.isInterPrime());
		instance.setTheNumber(3120);
		assertTrue(instance.isInterPrime());
		instance.setTheNumber(2790);
		assertTrue(instance.isInterPrime());
		instance.setTheNumber(121);
		assertFalse(instance.isInterPrime());
		instance.setTheNumber(1101);
		assertFalse(instance.isInterPrime());
	}

	@Test
	@DisplayName("Is SemiPrime")
	public void isSemiPrime() {
		assertTrue(Primes.isSemiPrime(4));
		assertTrue(Primes.isSemiPrime(1041));
		assertTrue(Primes.isSemiPrime(2098));
		assertFalse(Primes.isSemiPrime(2060));
		instance.setTheNumber(1418);
		assertTrue(instance.isSemiPrime());
		instance.setTheNumber(1050);
		assertFalse(instance.isSemiPrime());
	}

	@Test
	@DisplayName("A_Pointer Prime")
	public void isA_PointerPrime() {
		assertTrue(Primes.isA_PointerPrime(293));
		assertTrue(Primes.isA_PointerPrime(3221));
		assertTrue(Primes.isA_PointerPrime(149033));
		assertFalse(Primes.isA_PointerPrime(294));

		instance.setTheNumber(161123);
		assertTrue(instance.isA_PointerPrime());
		instance.setTheNumber(121508);
		assertFalse(instance.isA_PointerPrime());
	}

	@Test
	@DisplayName("M_Pointer Prime")
	public void isM_PointerPrime() {
		assertTrue(Primes.isM_PointerPrime(611113));
		assertTrue(Primes.isM_PointerPrime(1123));
		assertTrue(Primes.isM_PointerPrime(13121117));
		assertFalse(Primes.isM_PointerPrime(294));

		instance.setTheNumber(12113);
		assertTrue(instance.isM_PointerPrime());
		instance.setTheNumber(13120);
		assertFalse(instance.isM_PointerPrime());
	}

	@Test
	@DisplayName("Get Next Prime")
	public void nextPrime() {
		int expected = 199;
		int result = Primes.getNextPrime(198);
		assertEquals(expected, result);
		expected = 1193;
		result = Primes.getNextPrime(1187);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Get Next Prime Inclusive")
	public void nextPrimeInclusive() {
		//Return the number if it is prime
		int expected = 199;
		int result = Primes.getNextPrimeInclusive(199);
		assertEquals(expected, result);
		expected = 1187;
		result = Primes.getNextPrimeInclusive(1187);
		assertEquals(expected, result);
		//Return next prime number if v is not prime
		expected = 1193;
		result = Primes.getNextPrimeInclusive(1188);
		assertEquals(expected, result);
	}

	@Test
	@DisplayName("Get Previous Prime Inclusive")
	public void previousPrimeInclusive() {
		//Return the number if it is prime
		int expected = 199;
		int result = Primes.getPreviousPrimeInclusive(210);
		assertEquals(expected, result);
		expected = 1187;
		result = Primes.getPreviousPrimeInclusive(1187);
		assertEquals(expected, result);
		//Return next prime number if v is not prime
		expected = 1733;
		result = Primes.getPreviousPrimeInclusive(1740);
		assertEquals(expected, result);
	}
	@Test
	@DisplayName("Get Previous Prime")
	public void previousPrime() {
		int expected = 199;
		int result = Primes.getPreviousPrime(210);
		assertEquals(expected, result);
		expected = 1181;
		result = Primes.getPreviousPrime(1187);
		assertEquals(expected, result);
	}

	@Test
	@DisplayName("Get Prime Lucky Numbers")
	public void getPrimeLuckyNumbers() {
		List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 7, 13, 31, 37, 43, 67, 73, 79, 127, 151, 163, 193, 211, 223, 241));
		List<Integer> result = Primes.getPrimeLuckyNumbers(250);
		assertIterableEquals(expected, result);
		instance.setTheNumber(150);
		expected = new ArrayList<>(Arrays.asList(1, 3, 7, 13, 31, 37, 43, 67, 73, 79, 127));
		result = instance.getPrimeLuckyNumbers();
		assertIterableEquals(expected, result);
	}
	
	@Test
	@DisplayName("Twin Primes")
	public void getPrimeList() {
		List<Integer> testList = new ArrayList<>(Arrays.asList(29,31));
		assertTrue(Primes.isPrimeList(testList));
		testList.clear();
		testList = new ArrayList<>(Arrays.asList(223,227,229));
		assertTrue(Primes.isPrimeList(testList));
	}
	
	@Test
	@DisplayName("Sextuplet Primes")
	public void getSextupletList() {
		List<Integer> expected = new ArrayList<>(Arrays.asList(16057, 16061, 16063, 16067, 16069, 16073));
		List<Integer> result = Primes.getSextuplePrimes(200,16100);
		assertIterableEquals(expected, result);
	}

}
