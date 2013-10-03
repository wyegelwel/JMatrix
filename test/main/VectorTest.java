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
	public void testRowVectorInt() {
		int cols = (int) Math.random()*100+1;
		Vector v = Vector.rowVector(cols);
		assertTrue(v.rows() == 1);
		assertTrue(v.cols() == cols);
	}

	@Test
	public void testRowVectorMatrixInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testColumnVectorMatrixInt() {
		int rows = (int) Math.random()*100+1;
		Vector v = Vector.columnVector(rows);
		assertTrue(v.rows() == rows);
		assertTrue(v.cols() == 1);
	}

	@Test
	public void testColumnVectorInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsRowVector() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsColumnVector() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInt() {
		fail("Not yet implemented");
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
