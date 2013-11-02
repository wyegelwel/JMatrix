package enforcers;

import main.Matrix;

public class UpperTriangularEnforcer extends SquareEnforcer{

	@Override
	public boolean allowableValue(Matrix m, double v, int row, int col) {
		//Allow for essentially zero entries
		return row >= col || v < Matrix.EQUALITY_EPSILON; 
	}
}
