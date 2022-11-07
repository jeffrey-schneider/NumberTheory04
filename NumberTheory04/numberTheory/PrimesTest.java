package numberTheory;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
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

	/**
	 * Test method for {@link numberTheory.Primes#isEmirpimeses(int)}.
	 */
	@Test
	@DisplayName("Is Number Emirpimeses")
	void testIsEmirpimesesInt() {
		assertTrue(Primes.isEmirpimeses(15));
		assertTrue(Primes.isEmirpimeses(159));
		assertTrue(Primes.isEmirpimeses(178));
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
		assertFalse(Primes.isInterPrime(121));

		instance.setTheNumber(120);
		assertTrue(instance.isInterPrime());
		instance.setTheNumber(121);
		assertFalse(instance.isInterPrime());
	}
}
