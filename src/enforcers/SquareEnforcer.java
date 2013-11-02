package enforcers;

import main.Matrix;
import main.MatrixEnforcer;

public class SquareEnforcer implements MatrixEnforcer{

	@Override
	public boolean allowableShape(int rows, int cols) {
		return rows == cols;
	}

	@Override
	/**
	 * All values are allowed for a SquareMatrix
	 */
	public boolean allowableValue(Matrix m, double v, int row, int col) {
		return true;
	}

}
