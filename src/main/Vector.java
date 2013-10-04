package main;

import com.sun.org.apache.bcel.internal.generic.L2D;

public class Vector extends Matrix {
	
	private int _n;
	
	/**
	 * This is a private constructor so that people can't create a vector that 
	 * has 2d, i.e. put it in a bad state
	 */
	private Vector(int rows, int cols){
		super(rows, cols);
		_n = Math.max(rows, cols);
	}
	
	public static Vector rowVector(int cols){
		return new Vector(1, cols);
	}
	
	public static Vector rowVector(double[] d, int cols){
		Vector v = new Vector(1, cols);
		for (int i = 0; i < cols; i++){
			v.set(i, d[i]);
		}
		return v;
	}
	
	public static Vector rowVector(Matrix m, int row){
		Vector v = new Vector(1, m.cols());
		for (int i = 0; i < m.cols(); i++){
			v.set(i, m.get(row, i));
		}
		return v;
	}
	
	public static Vector columnVector(Matrix m, int col){
		Vector v = new Vector(m.rows(), 1);
		for (int i = 0; i < m.rows(); i++){
			v.set(i, m.get(i, col));
		}
		return v;
	}
	
	public static Vector columnVector(int rows){
		return new Vector(rows, 1);
	}
	
	public static Vector columnVector(double[] d, int rows){
		Vector v = new Vector(rows, 1);
		for (int i = 0; i < rows; i++){
			v.set(i, d[i]);
		}
		return v;
	}
	
	/**
	 * Convenience method for setting values in the vector to avoid indexing issues
	 * @param i
	 * @param value
	 */
	private void set(int i, double value){
		if (isRowVector()){
			_m[0][i] = value;
		} else{
			_m[i][0] = value;
		}
	}
	
	/**
	 * Returns the length of the vector 
	 * @return
	 */
	public int length(){
		return _n;
	}
	
	/**
	 * Returns whether the vector is a row vector. Note if vector has length 1, 
	 * it is neither a row or column vector
	 * @return
	 */
	public boolean isRowVector(){
		return (rows() == 1 && cols() > 1);
	}
	
	/**
	 * Returns whether the vector is a column vector. Note if vector has length 1, 
	 * it is neither a row or column vector
	 * @return
	 */
	public boolean isColumnVector(){
		return !isRowVector();
	}
	
	/**
	 * Convenience method for getting the elements of a vector without 
	 * knowing if it is a row or column vector
	 * @param i
	 * @return
	 */
	public double get(int i){
		if (isRowVector()){
			return get(0, i);
		} else{
			return get(i, 0);
		}
	}
	
	/**
	 * Performs a vector dot product. The vectors must be the same length
	 * @throws IllegalArgumentException if the vectors differ in length
	 * @param v
	 * @return
	 */
	public double dot(Vector v){
		if (v.length() != length()){
			throw new IllegalArgumentException("Dot product must be between vectors" +
												" of the same length. this.length()== " + 
												length() + ", v.length() == " + v.length());
		}
		double sum = 0;
		for (int i = 0; i < length(); i++){
			sum += v.get(i) * get(i);
		}
		return sum;	
	}
	
	/**
	 * Computes the L2 norm of the vector
	 * @return
	 */
	public double norm(){
		return Math.sqrt(this.dot(this));
	}
	
	/**
	 * Returns a new vector with its elements normalized
	 * @return
	 */
	public Vector normalize(){
		Vector v = new Vector(rows(), cols());
		double norm = norm();
		for (int i = 0; i < v.length(); i++){
			v.set(i, get(i)/norm);
		}
		return v;
	}
	
}
