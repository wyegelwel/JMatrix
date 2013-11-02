package main;

//TODO correct LowerTriangularMatrix and UpperTriangularMatrix so that they don't need to be square
//TODO Consider having matrix constructors simply take the double array from other matrix because they are meant to be immutable anyway
//TODO Have enforcers of different matrix types
public class Matrix {
	protected int _rows;
	protected int _cols;
	protected double[][] _m;
	
	public static double EQUALITY_EPSILON = 1e-10;
	
	protected Matrix(int rows, int cols){
		_rows = rows;
		_cols = cols;
		_m = new double[rows][cols];
	}
			
	/**
	 * Returns a new matrix resulting from the multiplications of left and right
	 * Note: This is not element-wise
	 * @param left
	 * @param right
	 * @throws IllegalArgumentException if columns of left matrix don't match
	 * rows of the right matrix
	 * @return
	 */
	public static Matrix mult(Matrix left, Matrix right){
		if (left.cols() != right.rows()){
			throw new IllegalArgumentException("The columns of the left matrix " +
												"must match the columns of the right" +
												" matrix. Left dimensions: " + 
												left.getDimensionString()+ " right" +
												" dimensions: " +right.getDimensionString());
		} else{
			MatrixBuilder m = new MatrixBuilder(left.rows(), right.cols());
			for (int row = 0; row < left.rows(); row++){
				for (int col = 0; col < right.cols(); col++){
					m.set(left.getRow(row).dot(right.getColumn(col)), row, col);
				}
			}
			return m.build();
		}
	}
	
	/**
	 * Returns a new matrix resulting from the element wise addition of 'this' and m
	 * @param m
	 * @throws IllegalArgumentException if matrix dimensions don't match
	 * @return
	 */
	public Matrix add(Matrix m){
		if (!dimensionsMatch(m)){
			throw new IllegalArgumentException("Matrix dimensions must match. " + 
												"'this' dimensions: " + getDimensionString()
												+" param dimensions: " + m.getDimensionString());
		}
		MatrixBuilder toReturn = new MatrixBuilder(m.rows(), m.cols());
		for (int row = 0; row < rows(); row++){
			for (int col = 0; col < cols(); col++){
				toReturn.set(get(row,col) + m.get(row,col), row, col);
			}
		}
		
		return toReturn.build();
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
	
	public String getDimensionString(){
		return "(" + rows() + ", " + cols() + ")";
	}
	
	
	
	public boolean dimensionsMatch(Matrix m){
		return m.rows() == rows() && m.cols() == cols();
	}
	
	/**
	 * Equality check for Matrix. Note: that it can be expensive as it compares 
	 * every element in both matrices for equality
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Matrix){
			Matrix m = (Matrix) obj;
			//Check if dim
			if (!dimensionsMatch(m)){
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
