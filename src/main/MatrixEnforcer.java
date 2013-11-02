package main;

//TODO: consider recommending making enforcers singletons
public interface MatrixEnforcer {
	
	/**
	 * Determines if the shape of the matrix is allowed
	 * @param rows
	 * @param cols
	 * @return
	 */
	public boolean allowableShape(int rows, int cols);
	
	/**
	 * Determines if setting (row,col) to v is allowed under this enforcer
	 * @param m
	 * @param v
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean allowableValue(Matrix m, double v, int row, int col);
	
}
