package main;

import utils.Pair;

public class SquareMatrix extends Matrix {
	protected int _n;

	public SquareMatrix(int n) {
		super(n,n);
		_n = n;
	}
	
	public SquareMatrix(int n, double[][] d){
		this(n);
		_m = squareCopy(d, _n);
	}
		
	public static SquareMatrix identity(int n){
		SquareMatrix m = new SquareMatrix(n);
		for (int i = 0; i < n; i++){
			m._m[i][i] = 1;
		}
		return m;
	}
	
	public static <T extends SquareMatrix> SquareMatrix copy(T sm){
		SquareMatrix m = new SquareMatrix(sm._n);
		m._m = squareCopy(sm._m, m._n);
		return m;
	}
	
	/**
	 * Performs Gaussian Elimination without pivoting. Note that this algorithm is generally UNSTABLE 
	 * @return
	 */
	public Pair<LowerTriangularMatrix, UpperTriangularMatrix> LU_decomposition(){
		LowerTriangularMatrix L = new LowerTriangularMatrix(SquareMatrix.identity(_n));
		SquareMatrix U = SquareMatrix.copy(this);
		//for each pivot
		for (int i = 0; i < _n-1; i++){
			//for each row
			for (int k = i+1; k < _n; k++){
				L._m[k][i] = U.get(k, i)/U.get(i,i); // compute multiplier
				//perform row op
				for (int j = i; j < _n; j++){
					U._m[k][j] = U.get(k, j) - L.get(k, i)*U.get(i, j);
				}
			}
		}
		return Pair.create(L, new UpperTriangularMatrix(U));
	}
	
	protected static double[][] squareCopy(double[][] src, int n){
		double[][] dest = new double[n][n];
		for (int row = 0; row < n; row++){
			for (int col = 0; col < n; col++){
				dest[row][col] = src[row][col];
			}
		}
		return dest;
	}
	

	public static void main(String[] args){
		//System.out.println(SquareMatrix.identity(5));
		double[][] d = new double[][]{{ 1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		SquareMatrix s = new SquareMatrix(3, d);
		System.out.println(s.LU_decomposition());
	}

}
