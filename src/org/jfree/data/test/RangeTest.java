package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
	
	private Range rangeObjectUnderTest;
	private Range r1;
	private Range r2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		r1 = new Range(-1.0,1.0);
		r2 = new Range(-3,-1);
		rangeObjectUnderTest = new Range(-1,1);
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),0.000000001d);
	}
	
	@Test
	public void testGetUpperBoundSucceedsWhenBothSamePositiveValues() {
		Range t1 = new Range(5,5);
		assertEquals("getUpperBound: Did not return the expected output",5,t1.getUpperBound(),0.000000001d);	
	}
	
	@Test
	public void testGetUpperBoundSucceedsWhenBothSameNegativeValues() {
		Range t2 = new Range(-8,-8);
		assertEquals("getUpperBound: Did not return the expected output",-8,t2.getUpperBound(),0.000000001d);	
	}
	
	@Test
	public void testGetUpperBoundSucceedsWhenBothDifferentPositiveValues() {
		Range t3 = new Range(3,9);
		assertEquals("getUpperBound: Did not return the expected output",9,t3.getUpperBound(),0.000000001d);	
	}
	@Test
	public void testGetUpperBoundSucceedsWhenPositiveUpperAndNegativeLowerValues() {
		Range t4 = new Range(-4,6);
		assertEquals("getUpperBound: Did not return the expected output",6,t4.getUpperBound(),0.000000001d);	
	}

	@Test
	public void testGetUpperBoundSucceedsWhenBothDifferentNegativeValues() {
		Range t5 = new Range(-7,-3);
		assertEquals("getUpperBound: Did not return the expected output",-3,t5.getUpperBound(),0.000000001d);	
	}
	
	@Test
	public void testGetLowerBoundSucceedsWhenBothSamePositiveValues() {
		Range t1 = new Range(5,5);
		assertEquals("getLowerBound: Did not return the expected output",5,t1.getUpperBound(),0.000000001d);	
	}
	
	@Test
	public void testGetLowerBoundSucceedsWhenBothSameNegativeValues() {
		Range t2 = new Range(-8,-8);
		assertEquals("getLowerBound: Did not return the expected output",-8,t2.getUpperBound(),0.000000001d);	
	}
	
	@Test
	public void testGetLowerBoundSucceedsWhenBothDifferentPositiveValues() {
		Range t3 = new Range(3,9);
		assertEquals("getLowerBound: Did not return the expected output",3,t3.getUpperBound(),0.000000001d);	
	}
	@Test
	public void testGetLowerBoundSucceedsWhenPositiveUpperAndNegativeLowerValues() {
		Range t4 = new Range(-4,6);
		assertEquals("getLowerBound: Did not return the expected output",-4,t4.getUpperBound(),0.000000001d);	
	}

	@Test
	public void testGetLowerBoundSucceedsWhenBothDifferentNegativeValues() {
		Range t5 = new Range(-7,-3);
		assertEquals("getLowerBound: Did not return the expected output",-7,t5.getUpperBound(),0.000000001d);	
	}
	
	
	
	@Test
	public void testExpandPositiveRange() {
		Range t1 = new Range(0,8);
		Range expectedOutput = new Range(-2,10);
		double upperMargin = 0.25;
		double lowerMargin = 0.25;
		assertEquals("Did not return expected output:",expectedOutput,Range.expand(t1, lowerMargin, upperMargin));
		
	}
	
	@Test
	public void testExpandFailsWhenNull() {
		try {
			Range.expand(null, 0.5,0.5);
			fail("Exception wasn't thrown: expected output: InvalidParameterException");
		}
		catch (Exception e) {
			System.out.println(e.getClass());
			assertTrue("Incorrect exception thrown:",e.getClass().equals(InvalidParameterException.class));
		}
		
	}
	
}

