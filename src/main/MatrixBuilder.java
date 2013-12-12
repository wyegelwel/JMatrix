package main;

import java.util.Collections;
import java.util.List;

public class MatrixBuilder {
	private boolean _isBuilt = false;
	private Matrix _matrix;
	private List<MatrixEnforcer> _enforcers;
	
	public MatrixBuilder(int rows, int cols){
		this(rows, cols, Collections.<MatrixEnforcer> emptyList());
	}
	
	public MatrixBuilder(int rows, int cols, List<MatrixEnforcer> enforcers){
		_enforcers = enforcers;
		for (MatrixEnforcer e : _enforcers){
			if (!e.allowableShape(rows, cols)){
				throw new IllegalArgumentException("Enforcer: " + e + " does not" +
													" allow a matrix with (rows,cols) =  "+
													"(" + rows + ", " + cols + ")");
			}
		}
		_matrix = new Matrix(rows, cols);
		
	}
		
	/**
	 * Sets (row, col) to v. 
	 * @param v
	 * @param row
	 * @param col
	 * @throws IllegalStateException if the Builder has already been built
	 * @return this to allow chaining
	 */
	public MatrixBuilder set(double v, int row, int col){
		if (_isBuilt){
			throw new IllegalStateException("Builder has been build already.");
		}
		if (row >= _matrix.rows() || col >= _matrix.cols()){
			throw new IllegalArgumentException("Tried to set value outside of " +
												"matrix. Size: " + 
												_matrix.getSizeString() + 
												"row, col: (" + row + ", " + col + ")");
		}
		for (MatrixEnforcer e : _enforcers){
			if (!e.allowableValue(_matrix, v, row, col)){
				throw new IllegalArgumentException("Enforcer: " + e + " does not" +
													" allow this set");
			}
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
		for (MatrixEnforcer e : _enforcers){
			if (!e.allowablePrebuild(_matrix)){
				throw new IllegalArgumentException("Enforcer: " + e + " does not" +
													" allow matrix");
			}
		}
		_isBuilt = true;
		return _matrix;
	}
	
}
