package main;

public class UpperTriangularEnforcer extends SquareEnforcer{

	@Override
	public boolean allowableValue(Matrix m, double v, int row, int col) {
		return row >= col;
	}
}
