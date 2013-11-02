package main;

public class MatrixBuilder {
	private boolean _isBuilt = false;
	private Matrix _matrix;
	
	//TODO Have enforcers of different matrix types
	public MatrixBuilder(int rows, int cols){
		_matrix = new Matrix(rows, cols); 
	}
	
	public MatrixBuilder set(double v, int row, int col){
		if (_isBuilt){
			throw new IllegalStateException("Builder has been build already.");
		}
		_matrix._m[row][col] = v;
		return this;
	}
	
	/**
	 * Returns but does NOT build the underlying matrix. 
	 * This means there is no guarantee the matrix will not be mutated further
	 * @return
	 */
	public Matrix getMatrix(){
		return _matrix;
	}
	
	public Matrix build(){
		_isBuilt = true;
		return _matrix;
	}
	
}
