package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {

	
	private Values2D values2D;
	private KeyedValues values;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		//in order to create a 1d keyed values object we must do this:
		DefaultKeyedValues testValues1D = new DefaultKeyedValues();
		values = testValues1D;
		testValues1D.addValue("0",5);
		testValues1D.addValue("1",9);
		testValues1D.addValue("2",2);
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testValidDataAndColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesNotNull() {
		try
		{
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown, expect outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesNormalValues() {
		DefaultKeyedValues testCase = new DefaultKeyedValues();
		testCase.addValue("0",0.3125);
		testCase.addValue("1",0.875);
		testCase.addValue("2",1);
		System.out.println(DataUtilities.getCumulativePercentages(values).toString());
		assertEquals("Wrong KeyedValues instance returned.",testCase,DataUtilities.getCumulativePercentages(values));
	}
	
	@Test
	public void testGetCumulativePercentagesNegativeValues() {
		DefaultKeyedValues testCase = new DefaultKeyedValues();
		testCase.addValue("0",1.0);
		testCase.addValue("1", 0.875);
		testCase.addValue("2", 1.0);
		System.out.println(DataUtilities.getCumulativePercentages(values).getValue("r"));
		assertEquals("Wrong KeyedValues instance returned.",testCase,DataUtilities.getCumulativePercentages(values));
	}
	
	@Test
	public void testCreateNumberArray() {
		Number[] z = {1.0,2.0,3.0,4.0};
		double[] x = {1.0,2.0,3.0,4.0};
		System.out.println(x);
		System.out.println(DataUtilities.createNumberArray(x).equals(z));
		assertEquals("createNumberArray: The expected output is not correct.",z.getClass(),DataUtilities.createNumberArray(x).getClass());
	}
	
	@Test
	public void testCreateNumberArrayNotNull() {
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception thrown, expected outcome was: InvalidParameterException");
		}
		catch (Exception e) {
			System.out.println(e.getClass());
			assertTrue("Incorrect exception type thrown",e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArrayTypicalValues() {
		double[] t1 = {1.0,2.0,3.0};
		Number[] z = {1.0,2.0,3.0};
		assertEquals("createaNumberArray",z.length,DataUtilities.createNumberArray(t1).length);
	}
	
	@Test
	public void testCreateNumberArrayEmptyArray() {
		double[] t1 = {};
		Number[] z = {};
		assertEquals("createNumberArray: The expected output is not correct.",z.length,DataUtilities.createNumberArray(t1).length);
	}
	
	/*
	@Test
	public void testCreateNumberArrayWith2DInput() {
		double[][] t1 = {{1.0,2.0},{3.0,4.0}};
		DataUtilities.createNumberArray(t1);
	}
	*/
	@Test
	public void testCreateNumberArray2DNotNull() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown, expected outcome was : InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",e.getClass().equals(IllegalArgumentException.class));
			}
	}
	
	@Test
	public void testCreateNumberArray2DTypicalValues() {
		double[][] t1 = {{1.0,2.0},{3.0,4.0}};
		Number[][] z = {{1.0,2.0},{3.0,4.0}};
		assertEquals(z.length,DataUtilities.createNumberArray2D(t1).length);
	}
	
	@Test
	public void testCreateNumberArray2D1DArray() {
		double[][] t1 = {{1.0,2.0}};
		Number[][] z = {{1.0,2.0}};
		assertEquals(z.length,DataUtilities.createNumberArray2D(t1).length);
	}
	
	@Test
	public void testCreateNumberArray2DEmptyArray() {
		double[][] t1 = {};
		Number[][] z = {};
		assertEquals(z.length,DataUtilities.createNumberArray2D(t1).length);
	}
}
