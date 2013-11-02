package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatrixTest {

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
	public void testMultWithIdentity() {
		double[][] d1 = new double[][]{{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};;
		Matrix left = MatrixFactory.create(3, 3, d1);
		Matrix right = SquareMatrix.identity(3);
		Matrix m = Matrix.mult(left, right);
		assertTrue(m.equals(left));
	}

	@Test
	public void testMultDifferentShapes() {
		double[][] d1 = new double[][]{{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		double[][] d2 = new double[][]{{1, 1, 1}, {2, 2, 2}};
		double[][] expected = new double[][] {{12, 15, 18}, {24, 30, 36}}; //from wolfram
		Matrix right = MatrixFactory.create(3, 3, d1);
		Matrix left = MatrixFactory.create(2, 3, d2);
		Matrix m = Matrix.mult(left, right);
		assertTrue(m.equals(MatrixFactory.create(2,3,expected)));
	}
}
