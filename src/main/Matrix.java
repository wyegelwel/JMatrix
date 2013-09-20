package main;

public class Matrix {
	protected int _rows;
	protected int _cols;
	protected double[][] _m;
	
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
	
	public int rows(){
		return _rows;
	}
	
	public int cols(){
		return _cols;
	}
	
	//TODO implement. Consider making a column and row vector class and implement dot product there first
	// Then just have a get row and get column method in matrix
	public static Matrix mult(Matrix left, Matrix right){
		if (left.cols() != right.rows()){
			//TODO throw error
			System.out.println("THROW AN ERROR NOW!");
			return null;
		} else{
			Matrix m = new Matrix(left.rows(), right.cols());
			
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
}
