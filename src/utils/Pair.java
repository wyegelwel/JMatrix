package utils;


/**
 * Utility class to store a pair of data.
 * @author wil
 *
 * @param <L>
 * @param <R>
 */
public class Pair <L, R>{
	public L l;
	public R r;
	
	public Pair(L l, R r){
		this.l = l;
		this.r = r;
	}
	
	public static <A, B> Pair<A,B> create(A a, B b){
		return new Pair<A, B>(a, b);
	}
	
	@Override
	public String toString() {
		return l.toString() + " " + r.toString();
	}
}
