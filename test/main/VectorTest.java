package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VectorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNormZeros(){
		double[] d = new double[]{0, 0, 0};
		Vector v = Vector.columnVector(d, 3);
		assertEquals(0, v.norm(), 1e-10);
	}
	
	@Test
	public void testNormPositives(){
		double[] d = new double[]{2, 2, 2, 2, 3};
		Vector v = Vector.columnVector(d, 5);
		assertEquals(5, v.norm(), 1e-10);
	}
	
	@Test
	public void testNormMixed(){
		double[] d = new double[]{2, -2, 2, -2, -3};
		Vector v = Vector.columnVector(d, 5);
		assertEquals(5, v.norm(), 1e-10);
	}
	
	@Test
	public void testDotTrivial() {
		double[] d1 = new double[]{1, 2, 3};
		double[] d2 = new double[]{1, 1, 1};
		Vector v1 = Vector.columnVector(d1, 3);
		Vector v2 = Vector.columnVector(d2, 3);
		assertEquals(6, v1.dot(v2), 1e-10);
	}

	@Test
	public void testDotLessTrivial() {
		double[] d1 = new double[]{1, 2, 3};
		double[] d2 = new double[]{3, 2, 1};
		Vector v1 = Vector.columnVector(d1, 3);
		Vector v2 = Vector.columnVector(d2, 3);
		assertEquals(10, v1.dot(v2), 1e-10);
	}

}
