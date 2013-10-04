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
		 Pair<LowerTriangularMatrix, UpperTriangularMatrix>  LU = sm.LU_decomposition();
		 assertTrue(sm.equals(Matrix.mult(LU.l, LU.r)));
	}

}
