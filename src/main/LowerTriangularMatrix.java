package main;

public class LowerTriangularMatrix extends SquareMatrix {
	public LowerTriangularMatrix(int n){
		super(n);
	}
	
	public LowerTriangularMatrix(int n, double[][] d){
		super(n);
		_m = lowerCopy(d, _n);
	}

	/**
	 * Constructs a LowerTriangularMatrix using SquareMatrix m as a template.  
	 * @param identity
	 */
	//TODO make this a a static method
	public LowerTriangularMatrix(SquareMatrix m) {
		super(m._n);
		_m = lowerCopy(m._m, _n);
	}

	/**
	 * Copies the lower triangle of src
	 * http://en.wikipedia.org/wiki/Triangular_matrix
	 * @param src
	 * @param rows
	 * @param cols
	 * @return
	 */
	protected double[][] lowerCopy(double[][] src, int n){
		double[][] dest = new double[n][n];
		for (int col = 0; col < n; col++){
			for (int row = col; row < n; row++){
				dest[row][col] = src[row][col];
			}
		}
		return dest;
	}
	
	public static void main(String[] args){
		double[][] d = new double[][]{{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		LowerTriangularMatrix u = new LowerTriangularMatrix(3, d);
		System.out.println(u);
	}
}
