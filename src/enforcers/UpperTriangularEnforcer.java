package enforcers;

import main.Matrix;

public class UpperTriangularEnforcer extends SquareEnforcer{

	@Override
	public boolean allowableValue(Matrix m, double v, int row, int col) {
		//Allow for essentially zero entries
		return row >= col || v < Matrix.EQUALITY_EPSILON; 
	}
	
	@Override
	/**
	 * If allowableShape and all allowableValue calls passed, then the matrix is allowable
	 */
	public boolean allowablePrebuild(Matrix m) {
		return true;
	}
}
