package main;

import utils.Pair;

public class SquareMatrix extends Matrix {
	protected int _n;
	
	@Deprecated
	public SquareMatrix(int rows, int cols) {
		this(rows);
	}
	
	@Deprecated
	public SquareMatrix(int rows, int cols, double[][] d){
		this(rows, d);
	}
	
	public SquareMatrix(int n) {
		super(n,n);
		_n = n;
	}
	
	public SquareMatrix(int n, double[][] d){
		this(n);
		_m = squareCopy(d, _n);
	}
	
	
	
	public double[][] squareCopy(double[][] src, int n){
		double[][] dest = new double[n][n];
		for (int row = 0; row < n; row++){
			for (int col = 0; col < n; col++){
				dest[row][col] = src[row][col];
			}
		}
		return dest;
	}
	
	public static SquareMatrix identity(int n){
		SquareMatrix m = new SquareMatrix(n);
		for (int i = 0; i < n; i++){
			m._m[i][i] = 1;
		}
		return m;
	}
	
	public static void main(String[] args){
		System.out.println(SquareMatrix.identity(5));
	}

}
