package org.jfree.data.test;

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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		r1 = new Range(-1.0,1.0);
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
	public void testGetUpperBound() {
		assertEquals("getUpperBound: Did not return the expected output",1.0,r1.getUpperBound(),0.000000001d);
		
	}
	
	@Test
	public void testGetLowerBound() {
		assertEquals("getLowerBound: Did not return the expected output",-1.0,r1.getLowerBound(),0.000000001d);
		
	}
}

