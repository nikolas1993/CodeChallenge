import java.util.function.BiFunction;

public class Pair<T> {
	final BiFunction<T, T, Boolean> validator;
	T left = null;
	T right = null;
	
	private Pair() {
		validator = null;
	}

	Pair(BiFunction<T, T, Boolean> v, T x, T y) {
		super();
		this.validator = v;
		set(x, y);
	}

	void set(T x, T y) {
		if(!validator.apply(x, y)) throw new IllegalArgumentException();
		setLeft(x);
		setRight(y);
	}

	void setLeft(T left) {
		this.left = left;
	}

	void setRight(T right) {
		this.right = right;
	}
	
	final boolean isValid() {
		return validator.apply(left, right);
	}
	
}
