package main;

public class MatrixFactory {

	public static Matrix copy(Matrix m){
		Matrix toReturn = new Matrix(m.rows(), m.cols());
		toReturn._m = m._m.clone();
		return toReturn;
	}
	
	public static Matrix create(int rows, int cols, double[][] d){
		Matrix toReturn = new Matrix(rows, cols);
		toReturn._m = d.clone();
		return toReturn;
	}

}
