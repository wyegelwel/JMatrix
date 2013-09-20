package main;

public class UpperTriangularMatrix extends SquareMatrix {
	
	@Deprecated
	public UpperTriangularMatrix(int rows, int cols) {
		super(rows, cols);
		
	}

	@Deprecated
	public UpperTriangularMatrix(int rows, int cols, double[][] d) {
		super(rows, cols);
		_m = upperCopy(d, _n);
	}
	
	public UpperTriangularMatrix(int n){
		super(n);
	}
	
	public UpperTriangularMatrix(int n, double[][] d){
		super(n);
		_m = upperCopy(d, _n);
	}

	/**
	 * Constructs a UpperTriangularMatrix using SquareMatrix m as a template.  
	 * @param identity
	 */
	//TODO make this a static method
	public UpperTriangularMatrix(SquareMatrix m) {
		super(m._n);
		_m = upperCopy(m._m, _n);
	}
	/**
	 * Copies the upper triangle of src
	 * http://en.wikipedia.org/wiki/Triangular_matrix
	 * @param src
	 * @param rows
	 * @param cols
	 * @return
	 */
	protected double[][] upperCopy(double[][] src, int n){
		double[][] dest = new double[n][n];
		for (int col = 0; col < n; col++){
			for (int row = 0; row <= col; row++){
				dest[row][col] = src[row][col];
			}
		}
		return dest;
	}
	
	public static void main(String[] args){
		double[][] d = new double[][]{{ 111, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		UpperTriangularMatrix u = new UpperTriangularMatrix(3, d);
		System.out.println(u);
	}
}
