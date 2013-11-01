package main;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Pair;
import static java.lang.Math.*;

public class SquareMatrixTest {

	@Test
	public void testLU_decomposition() {
		double[][] d1 = new double[][]{{ random(), random(), random()}, {random(), random(), random()}, {random(), random(), random()}};
		SquareMatrix sm = new SquareMatrix(3, d1);
		LUDecomposition LU = new LUDecomposition(sm);
		 assertTrue(Matrix.mult(LU.getP(), LU.getA()).equals(Matrix.mult(LU.getL(), LU.getU())));
	}

}
