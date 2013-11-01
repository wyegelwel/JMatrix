package main;

public class LUDecomposition {
	private UpperTriangularMatrix _U;
	private LowerTriangularMatrix _L;
	private SquareMatrix _P, _A;
	
	
	public LUDecomposition(SquareMatrix A){
		_A = A;
		
	}
	
	private boolean decomposed(){
		return _U != null;
	}
	
	/**
	 * Returns the LUDecomposition {@link LUDecomposition} of the matrix.
	 * LUDecomposition() uses Gaussian Elimination with Partial Pivoting 
	 * (http://en.wikipedia.org/wiki/Gaussian_elimination), which is regarded
	 * as stable in practice.
	 * @return this to allow for chaining
	 */
	public LUDecomposition decompose(){
		if (!decomposed()){
			int n = _A._n;
			LowerTriangularMatrix L = new LowerTriangularMatrix(SquareMatrix.identity(_A._n));
			SquareMatrix U = SquareMatrix.copy(_A);
			Vector p = Vector.range(0, n-1, 1); //n-1 because range is inclusive
			for (int i = 0; i < n-1; i++){
				int maxRow = getMaxRowInColumn(U, i, i);
				if (maxRow > i){
					swapRows(U,i,maxRow);
					swapRows(p,i,maxRow);
					swapRows(L,i,maxRow,i);
				}
				//for each row
				for (int k = i+1; k < n; k++){
					L._m[k][i] = U.get(k, i)/U.get(i,i); // compute multiplier
					//perform row op
					for (int j = i; j < n; j++){
						U._m[k][j] = U.get(k, j) - L.get(k, i)*U.get(i, j);
					}
				}
			}			
		}
		return this;
	}
	
	/**
	 * Returns the row with the maximum absolute value in column c, starting at 
	 * belowRow until the end of the matrix.
	 * @param m
	 * @param c
	 * @param belowRow
	 * @return
	 */
	private int getMaxRowInColumn(Matrix m, int c, int belowRow){
		Vector v = m.getColumn(c);
		int maxRow = belowRow;
		double max = Math.abs(v.get(belowRow));
		for (int i = belowRow+1; i < m._rows; i++){
			if (max < Math.abs(v.get(i))){
				maxRow = i;
				max = Math.abs(v.get(i));
			}
		}
		return maxRow;
	}
	
	/**
	 * Swaps rows a and b in matrix m
	 * @param m
	 * @param a
	 * @param b
	 */
	private void swapRows(Matrix m, int a, int b){
		for (int col = 0; col < m.cols(); col++){
			double tmp = m.get(a, col);
			m._m[a][col] = m._m[b][col];
			m._m[b][col] = tmp;
		}
	}
	
	/**
	 * Swaps rows a and b in matrix m, up  to (but not including) maxColumn
	 * @param m
	 * @param a
	 * @param b
	 * @param maxColumn
	 */
	private void swapRows(Matrix m, int a, int b, int maxColumn){
		for (int col = 0; col < maxColumn; col++){
			double tmp = m.get(a, col);
			m._m[a][col] = m._m[b][col];
			m._m[b][col] = tmp;
		}
	}
	
	public LowerTriangularMatrix getL(){
		if (!decomposed()){
			decompose();
		}
		return _L;
	}
	
	public UpperTriangularMatrix getU(){
		if (!decomposed()){
			decompose();
		}
		return _U;
	}
	
	/**
	 * Returns the permutation matrix P
	 * @return
	 */
	public SquareMatrix getP(){
		if (!decomposed()){
			decompose();
		}
		return _P;
	}
	
	public SquareMatrix getA(){
		return _A;
	}
}
