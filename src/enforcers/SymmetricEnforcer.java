package enforcers;

import main.Matrix;


public class SymmetricEnforcer extends SquareEnforcer {
	@Override
	/**
	 * A matrix is symmetric if A = A_T
	 */
	public boolean allowablePrebuild(Matrix m) {
		for (int row = 0; row < m.rows(); row++){
			for (int col = 0; col <= row; col++){
				if (Math.abs(m.get(row, col) - m.get(col, row)) 
						> Matrix.EQUALITY_EPSILON){
					return false;
				}
			}
		}
		return true;
	}
}
