package main;

//TODO correct LowerTriangularMatrix and UpperTriangularMatrix so that they don't need to be square
//TODO Consider having matrix constructors simply take the double array from other matrix because they are meant to be immutable anyway
public class Matrix {
	protected int _rows;
	protected int _cols;
	protected double[][] _m;
	
	public static double EQUALITY_EPSILON = 1e-10;
	
	public Matrix(int rows, int cols){
		_rows = rows;
		_cols = cols;
		_m = new double[rows][cols];
	}
	
	public Matrix(int rows, int cols, double[][] d){
		this(rows, cols);
		_m = copy(d, rows, cols);
	}
	
	public Matrix(Matrix m){
		_rows = m._rows;
		_cols = m._cols;
		_m = copy(m._m, _rows, _cols);
	}
	
	public double get(int row, int col){
		return _m[row][col];
	}
	
	public Vector getRow(int row){
		return Vector.rowVector(this, row);
	}
	
	public Vector getColumn(int col){
		return Vector.columnVector(this, col);
	}
	
	public int rows(){
		return _rows;
	}
	
	public int cols(){
		return _cols;
	}
	
	/**
	 * Multiplies two matrices using matrix multiplication (NOT ELEMENTWISE!)
	 * @param left
	 * @param right
	 * @return
	 */
	public static Matrix mult(Matrix left, Matrix right){
		if (left.cols() != right.rows()){
			throw new IllegalArgumentException("The columns of the left matrix " +
												"must match the columns of the right" +
												" matrix. Left dimensions: (" + left.rows()
												+ ", " + left.cols() + ") right dimensions: ("
												+ right.rows() + ", " + right.cols() + ")");
		} else{
			Matrix m = new Matrix(left.rows(), right.cols());
			for (int row = 0; row < left.rows(); row++){
				for (int col = 0; col < right.cols(); col++){
					m._m[row][col] = left.getRow(row).dot(right.getColumn(col));
				}
			}
			return m;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < _rows; row++){
			for (int col = 0; col < _cols; col++){
				sb.append(String.format("%12.3f", _m[row][col]) + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	protected double[][] copy(double[][] src, int rows, int cols){
		double[][] dest = new double[rows][cols];
		for (int row = 0; row < rows; row++){
			for (int col = 0; col < cols; col++){
				dest[row][col] = src[row][col];
			}
		}
		return dest;
	}
	
	/**
	 * Equality check for Matrix. Note: that it can be expensive as it compares 
	 * every element in both matrices for equality
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Matrix){
			Matrix m = (Matrix) obj;
			if (m.rows() != rows() || m.cols() != cols()){
				return false;
			}
			for (int row = 0; row < rows(); row++){
				for (int col = 0; col < cols(); col++){
					if (Math.abs(m.get(row, col) - get(row, col)) > EQUALITY_EPSILON){
						return false;
					}
				}
			}
			return true;
		} else{
			return super.equals(obj);
		}
	}
}
