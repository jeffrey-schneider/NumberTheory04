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

import org.junit.jupiter.api.Test;

class NumberTheoryTest {

	@Test
	void testGetTheNumber() {
		System.out.println("getTheNumber()");
		numberTheory.NumberTheory instance = new NumberTheory(12);
		int expected = 12;
		int result = instance.getTheNumber();
		assertEquals(expected, result);
	}

	
	@Test
	void testSetTheNumber() {
		System.out.println("getTheNumber()");
		NumberTheory instance = new NumberTheory();
		int theNumber = 59;
		instance.setTheNumber(theNumber);		
		assertEquals(theNumber, instance.getTheNumber());		
	}	

	  /**
	     * Test of the getJugglers() method.
	     */
	    @Test
	    public void testGetJugglers(){
	    	System.out.println("getJugglers()");
	        NumberTheory instance = new NumberTheory(9);
	        List<Integer> expected = new ArrayList<>(Arrays.asList(9, 27, 140, 11, 36, 6, 2, 1));
	        List<Integer> result = instance.getJugglers();
	        assertIterableEquals(expected, result);
	        System.out.println("getJugglers(9)");
	        result = NumberTheory.getJugglers(9);
	        assertIterableEquals(expected, result);
	    }	    
	    
	@Test
	void testGetSquare() {
		System.out.println("getSquare()");
        NumberTheory instance = new NumberTheory(9);
        int expected = 81;
        int result = instance.getSquare();
        assertEquals(expected, result);
        
        System.out.println("getSquare(4)");
        result = NumberTheory.getSquare(4);
        assertEquals(16,result);
	}

	@Test
	void testIsPrime() {
		System.out.println("isPrime()");
		NumberTheory instance = new NumberTheory(17);
		assertTrue(instance.isPrime());
		assertTrue(NumberTheory.isPrime(17));
		instance.setTheNumber(15);
		System.out.println("isPrime(15)");
		assertFalse(instance.isPrime());
		assertFalse(NumberTheory.isPrime(15));
	}
	
	@Test
	void testIsAbundant() {
		System.out.println("isAbundant()");
		NumberTheory instance = new NumberTheory(60);
		assertTrue(instance.isAbundant());
		instance.setTheNumber(17);
		assertFalse(instance.isAbundant());
		assertTrue(NumberTheory.isAbundant(60));
		assertFalse(NumberTheory.isAbundant(17));
		
	}
	
	
	
	/**
     * Test of the getCollatz() method
     */
    @Test
    public void testGetCollatz(){    	
    	System.out.println("getCollatz()");
    	int theTestValue = 19;
        NumberTheory instance = new NumberTheory(theTestValue);
        //[19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1]
        List<Integer> expected = new ArrayList<>(Arrays.asList(19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13,40,20,10,5,16,8,4,2,1));
        List<Integer> result = instance.getCollatz();
        assertIterableEquals(expected, result);
        
        System.out.println("getCollatz(6)");
        expected = new ArrayList<>(Arrays.asList(6,3,10,5,16,8,4,2,1));
        assertIterableEquals(expected, NumberTheory.getCollatz(6));
}
    
    /**
     * Test of the getPrimeFactors() method.
     */
    @Test
    public void testGetPrimeFactors(){
    	int theTestValue = 60;
        NumberTheory instance = new NumberTheory(theTestValue);
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 2, 3, 5));
        List<Integer> result = instance.getPrimeFactors();
        System.out.println("getPrimeFactors()");
        assertIterableEquals(expected, result);
        System.out.println("getPrimeFactors(60)");
        assertIterableEquals(expected, NumberTheory.getPrimeFactors(theTestValue));
    }
    
    
    /**
     * Test of the getPrimeFactors() method.
     */
    @Test
    public void testfactorsSpec(){
    	int theTestValue = 60;
        NumberTheory instance = new NumberTheory(theTestValue);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,10,12,15,20,30,60));
        List<Integer> result = instance.getFactors();
        System.out.println("getFactors()");
        assertIterableEquals(expected, result);
        System.out.println("getFactors(60)");
        assertIterableEquals(expected, NumberTheory.getFactors(theTestValue));
    }
    
    
    @Test
    public void testaliquotSumSpec(){
        NumberTheory instance = new NumberTheory(60);
        int expected = 108;
        int result = instance.getAliquotSum();
        System.out.println("AliquotSum()");
        assertEquals(expected, result);
        System.out.println("AliquotSum(60)");
        assertEquals(expected, NumberTheory.getAliquotSum(60));        
    }
   
    /**
     * Test of the getProperDivisors() method.
     */
    @Test
    public void testProperDivisorsSpec(){
    	int theTestValue = 36;
        NumberTheory instance = new NumberTheory(theTestValue);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4,6,9,12,18));
        List<Integer> result = instance.getProperDivisors();
        System.out.println("getProperDivisors()");
        assertIterableEquals(expected, result);
        System.out.println("getProperDivisors(36)");
        assertIterableEquals(expected, NumberTheory.getProperDivisors(theTestValue));
    }
    
    @Test
    public void testIsPerfect() {
    	int theTestValue = 28;
    	NumberTheory instance = new NumberTheory(theTestValue);
    	assertTrue(instance.isPerfect());
    	assertTrue(NumberTheory.isPerfect(theTestValue));
    	theTestValue = 29;
    	instance.setTheNumber(theTestValue);
    	assertFalse(instance.isPerfect());
    assertFalse(NumberTheory.isPerfect(theTestValue));
    }
    
    
    /**
     * Test of getReverseNumber method
     */
    @Test
    public void testGetReverseNumber(){
    	int theTestValue = 34;
        System.out.println("getReverseNumber()");
        NumberTheory instance = new NumberTheory(theTestValue);
        int expected = 43;    
        int result = instance.getReverseNumber();
        assertEquals(expected, result);
        
        System.out.println("getReverseNumber(50)");
        expected = 5;        
        assertEquals(expected, NumberTheory.getReverseNumber(50));
    }
    
    /**
     * Test of getReciprocalNumber method
     */
    @Test
    public void testGetReciprocalNumber(){
        System.out.println("getReciprocalNumber()");
        NumberTheory instance = new NumberTheory(34);
        double result = instance.getReciprocalNumber();
        double expected = 0.0294117647;
        assertEquals(expected, result, 5);
        assertEquals(expected, NumberTheory.getReciprocalNumber(34), 5);
    }
    
    /**
     * Test of getHex method
     */
    @Test
    public void testGetHex(){
        System.out.println("getHex");
        NumberTheory instance = new NumberTheory(76576500);
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
    public void testGetOctal(){
        System.out.println("getOctal");
        NumberTheory instance = new NumberTheory(76576500);
        String result = instance.getOctal();
        String expected = "444073364";
        assertEquals(expected, result);
    }
    
    /**
     * Test of getBinary() method.
     */
    @Test
    public void testGetBinary(){
        System.out.println("getBinary");
        NumberTheory instance = new NumberTheory(76576500);
        String result = instance.getBinary();
        String expected = "100100100000111011011110100";        
        assertEquals(expected, result);
        
        assertEquals(expected, NumberTheory.getBinary(76576500));        
    }
    
    /**
     * Test of getSigma()
     */
    @Test
    public void testGetSigma(){
        System.out.println("testGetSigma()");
        NumberTheory instance = new NumberTheory(9);
        int result = instance.getSigma();
        int expected = 13;
        assertEquals(expected, result);
        instance.setTheNumber(15);
        result = instance.getSigma();
        expected = 24;
        assertEquals(expected, result);
    }
    
    
    /**
     * Test of isSuperabundant() method, of class NumberTheory
     */
    @Test
    public void testIsSuperabundant(){
        System.out.println("isSuperabundant()");
        NumberTheory instance = new NumberTheory(360);
        assertTrue(instance.isSuperabundant());
        instance.setTheNumber(1260);
        assertTrue(instance.isSuperabundant());
        instance.setTheNumber(25);
        assertFalse(instance.isSuperabundant());
        
        assertTrue(NumberTheory.isSuperabundant(360));
        assertFalse(NumberTheory.isSuperabundant(25));
    }
    
    /**
     * In mathematics a primitive abundant number is an abundant number whose proper divisors are all deficient numbers.
     * Test of isPrimativeAbundant()
     */
    @Test
    public void testIsPrimativeAbundant(){
        System.out.println("isPrimativeAbundant()");
        NumberTheory instance = new NumberTheory(20);
        assertTrue(instance.isPrimativeAbundant());
        instance.setTheNumber(70);
        assertTrue(instance.isPrimativeAbundant());
        instance.setTheNumber(87);
        assertFalse(instance.isPrimativeAbundant());
        
        assertTrue(NumberTheory.isPrimativeAbundant(20));
        assertFalse(instance.isPrimativeAbundant());        
    }
    
    @Test
    public void testIsAKeithNumber() {
    	System.out.println("Is a keith number?");
    	NumberTheory instance = new NumberTheory(1104);
    	assertTrue(instance.isAKeithNumber());    	
    	assertTrue(NumberTheory.isAKeithNumber(7913837));
    	assertFalse(NumberTheory.isAKeithNumber(7913838));
    }
    
    
    @Test
    public void testKyneaNumber() {
    	System.out.println("Kynea Numbers");
    	NumberTheory instance = new NumberTheory(5);
    	int expected = 1087;
    	int result = instance.getKynea();    	
    	assertEquals(expected, result);
    	expected = 4223;
    	result = NumberTheory.getKynea(6);    	
    	assertEquals(expected, result);
    }
    
    
    @Test
    public void testCarolNumber() {
    	System.out.println("Carol Numbers");
    	NumberTheory instance = new NumberTheory(7);
    	int expected = 16127;
    	int result = instance.getCarol();
    	assertEquals(expected, result);
    	assertEquals(65023, NumberTheory.getCarol(8));
    	assertNotEquals(65023, NumberTheory.getCarol(7));    	
    }
    
    
    @Test
    public void getFactorialSpec() {
    	System.out.println("Factorials of");
    	NumberTheory instance = new NumberTheory(15);
    	BigInteger expected = BigInteger.valueOf(1307674368000L);
    	BigInteger result = instance.getFactorial();
    	assertEquals(expected, result);
    	assertEquals(BigInteger.valueOf(3628800), NumberTheory.getFactorial(10));
    	assertNotEquals(BigInteger.valueOf(3628801), NumberTheory.getFactorial(10));
    }
    
    @Test
    public void testCatalanSpec() {
    	System.out.println("Catalan ");
    	NumberTheory instance = new NumberTheory(20);
    	BigInteger result = instance.getCatalan();
    	BigInteger expected = BigInteger.valueOf(6564120420L);
    	
    	assertEquals(expected, result);
    	assertEquals(BigInteger.valueOf(16796),NumberTheory.getCatalan(10));
    }
    
    @Test
    public void fibonacciSpec() {
    	System.out.println("Fibonacci ");
    	NumberTheory instance = new NumberTheory(10);
    	List<Integer> result = instance.getFibonacci();    	
    	List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34));
    	assertIterableEquals(expected, result);
    	
    	result = NumberTheory.getFibonacci(17);
    	expected = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987));    	
    	assertIterableEquals(expected, result);
    }
    
    @Test
    public void lucasSpec() {
    	System.out.println("Lucas ");
    	NumberTheory instance = new NumberTheory(12);
    	List<Integer> result = instance.getLucas();
    	List<Integer> expected = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 7, 11, 18, 29, 47, 76, 123, 199));
    	assertIterableEquals(expected, result);
    	
    	result = NumberTheory.getLucas(33);
    	expected = new ArrayList<>(Arrays.asList(2, 1, 3, 4, 7, 11, 18, 29, 47, 76, 123, 199, 322, 521, 843, 1364, 2207, 3571, 5778, 9349, 15127, 24476, 39603, 64079, 103682, 167761, 271443, 439204, 710647, 1149851, 1860498, 3010349, 4870847));
    	assertIterableEquals(expected, result);
    	
    }
    
    @Test
    public void jacobsthalSpec() {
    	System.out.println("Jacobsthal ");
    	NumberTheory instance = new NumberTheory(20);
    	List<Integer> result = instance.getJacobsthal();
    	List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 10923, 21845, 43691, 87381, 174763));
    	assertIterableEquals(expected, result);

    	result = NumberTheory.getJacobsthal(25);
    	expected = new ArrayList<>(Arrays.asList(0, 1, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 10923, 21845, 43691, 87381, 174763, 349525, 699051, 1398101, 2796203, 5592405));
    	assertIterableEquals(expected, result);
    }
    
    @Test
    public void amicableSpec() {
    	System.out.println("Amicable: ");
    	NumberTheory instance = new NumberTheory(220);
    	int result = instance.getAmicableNumber();
    	int expected = 284;
    	assertEquals(expected, result);
    	
    	result = NumberTheory.getAmicableNumber(12285);
    	expected = 14595;
    	assertEquals(expected, result);   	
    }
    
    @Test
    public void isCarmichaelSpec() {
    	System.out.println("Carmichael? ");
    	NumberTheory instance = new NumberTheory(2821);
    	assertTrue(instance.isCarmichael());
    }
    
    
    @Test
    public void cakeSpec() {
    	System.out.println("Cake numbers: ");
    	int result = NumberTheory.getCakeNumber(24);
    	int expected = 2325;
    	assertEquals(expected, result);
    	
    	NumberTheory instance = new NumberTheory(22);
    	result = instance.getCakeNumber();
    	expected = 1794;
    	assertEquals(expected, result);
    }
    
    @Test
    public void lazyCatererSpec() {
    	System.out.println("lazyCaterer numbers: ");
    	int result = NumberTheory.getLazyCaterer(24);
    	int expected = 301;
    	assertEquals(expected, result);
    	
    	NumberTheory instance = new NumberTheory(22);
    	result = instance.getLazyCaterer();
    	expected = 254;
    	assertEquals(expected, result);
    }
    
    @Test
    public void getCenteredPolygonalNumberSpec() {
    	System.out.println("Centered Polygonal Numbers: ");
    	int result = NumberTheory.getCenteredPolygonalNumber(3, 2);
    	int expected = 10;
    	assertEquals(expected, result);
    	result = NumberTheory.getCenteredPolygonalNumber(14, 20);
    	expected = 2941;
    	assertEquals(expected, result);
    }
    
    @Test
    public void bellNumberSpec() {
    	System.out.println("bellNumbers: ");
    	long result = NumberTheory.getBellNumber(20).longValue();
    	long expected = 51724158235372L;    	
    	assertEquals(expected, result);
    	
    	NumberTheory instance = new NumberTheory(20);
    	result = instance.getBellNumber().longValue();
    	expected = 51724158235372L;    	
    	assertEquals(expected, result);
    	
    }
    
    @Test
    public void admirableNumberSpec() {
    	System.out.println("Is admirable");
    	assertTrue(NumberTheory.isAdmirable(12));
    	
    	NumberTheory instance = new NumberTheory(20);
    	assertTrue(instance.isAdmirable());
    	instance.setTheNumber(21);
    	assertFalse(instance.isAdmirable());
    }
    
    @Test
    public void amenableNumberSpec() {
    	System.out.println("Is amenable");
    	assertTrue(NumberTheory.isAmenable(12));
    	
    	NumberTheory instance = new NumberTheory(49);
    	assertTrue(instance.isAmenable());
    	instance.setTheNumber(46);
    	assertFalse(instance.isAmenable());
    }
    
    
    @Test
    public void isSuperDSpec() {
    	System.out.println("Is SuperD?");
    	assertTrue(NumberTheory.isSuperD(333));
    	assertFalse(NumberTheory.isSuperD(330));
    	
    	NumberTheory instance = new NumberTheory(19);
    	assertTrue(instance.isSuperD());
    	instance.setTheNumber(46);
    	assertFalse(instance.isSuperD());
    }
    
    
    @Test
    public void isAlternatingSpec() {
    	System.out.println("Is Alternating? ");
    	assertTrue(NumberTheory.isAlternating(903));
    	assertFalse(NumberTheory.isAlternating(904));
    	
    	NumberTheory instance = new NumberTheory(19);
    	assertFalse(instance.isAlternating());
    	instance.setTheNumber(1872);
    	assertTrue(instance.isAlternating());
    }
    
    @Test
    public void isAntiPerfectSpec() {
    	System.out.println("Is Antiperfect? ");
    	assertTrue(NumberTheory.isAntiPerfect(133857));
    	assertFalse(NumberTheory.isAntiPerfect(44));
    	
    	NumberTheory instance = new NumberTheory(211);
    	assertFalse(instance.isAntiPerfect());
    	instance.setTheNumber(244);
    	assertTrue(instance.isAntiPerfect());
    }
    
    @Test
    public void isArithmeticSpec() {
    	System.out.println("Is arithmetic?");
    	assertTrue(NumberTheory.isArithmetic(56));
    	assertFalse(NumberTheory.isArithmetic(58));
    	
    	NumberTheory instance = new NumberTheory(245);
    	assertTrue(instance.isArithmetic());
    	instance.setTheNumber(244);
    	assertFalse(instance.isArithmetic());
    	
    	
    }
    
    @Test
    public void isAstonishingSpec() {
    	System.out.println("Is Astonishing?");
    	assertTrue(NumberTheory.isAstonishing(15));
    	assertFalse(NumberTheory.isAstonishing(20));
    	
    	NumberTheory instance = new NumberTheory(1353);
    	assertTrue(instance.isAstonishing());
    	instance.setTheNumber(1354);
    	assertFalse(instance.isAstonishing());
    }
    
    //isAutomorphic
    //12890625
    @Test
    public void isAutomorphicSpec() {
    	System.out.println("Is Automorphic?");
    	assertTrue(NumberTheory.isAutomorphic((long)890625));
    	assertFalse(NumberTheory.isAutomorphic((long)20));   	
    }
    
    
    @Test
    public void isInterPrimeSpec() {
    	System.out.println("Is Interprime?");
    	assertTrue(NumberTheory.isInterPrime(120));
    	assertFalse(NumberTheory.isInterPrime(121));
    	
    	NumberTheory instance = new NumberTheory(120);
    	assertTrue(instance.isInterPrime());
    	instance.setTheNumber(121);
    	assertFalse(instance.isInterPrime());
    }
    
    @Test
    public void isCanadaSpec() {
    	System.out.println("Is Canada Number?");
    	assertTrue(NumberTheory.isCanadaNumber(16999));
    	assertFalse(NumberTheory.isCanadaNumber(17000));
    	
    	NumberTheory instance = new NumberTheory(8549);
    	assertTrue(instance.isCanadaNumber());
    	instance.setTheNumber(17000);
    	assertFalse(instance.isCanadaNumber());
    }
    
    
    
}
