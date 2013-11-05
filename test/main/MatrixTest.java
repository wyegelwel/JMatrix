package main;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enforcers.SquareEnforcer;
import enforcers.UpperTriangularEnforcer;

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
	public void testTransposeSquare(){
		double[][] d = new double[][]{{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		double[][] dt = new double[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		Matrix A = MatrixFactory.create(3, 3, d);
		Matrix AT = MatrixFactory.create(3, 3, dt);
		assertTrue(A.transpose().equals(AT));
	}
	
	@Test
	public void testTransposeRectangular(){
		double[][] d = new double[][]{{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
		double[][] dt = new double[][]{{1, 4, 7, 10}, {2, 5, 8, 11}, {3, 6, 9, 12}};
		Matrix A = MatrixFactory.create(4, 3, d);
		Matrix AT = MatrixFactory.create(3, 4, dt);
		assertTrue(A.transpose().equals(AT));
	}
	
	@Test
	public void testMultWithIdentity() {
		double[][] d1 = new double[][]{{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
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
	
	@Test (expected = IllegalArgumentException.class)
	public void testUpperTriangularEnforcer(){
		List<MatrixEnforcer> enforcers = new ArrayList<MatrixEnforcer>(); 
		enforcers.add(new UpperTriangularEnforcer());
		int rows = 5;
		int cols = 5;
		MatrixBuilder b = new MatrixBuilder(rows, cols, enforcers);
		for (int row = 0; row < rows; rows++){
			for (int col = 0; col < cols; col++){
				b.set(Math.random(), row, col);
			}
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSquareEnforcer(){
		List<MatrixEnforcer> enforcers = new ArrayList<MatrixEnforcer>(); 
		enforcers.add(new SquareEnforcer());
		int rows = 5;
		int cols = 6;
		MatrixBuilder b = new MatrixBuilder(rows, cols, enforcers);
	}
}
