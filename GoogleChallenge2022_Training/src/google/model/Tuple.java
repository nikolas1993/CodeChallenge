package google.model;

public class Tuple <T extends Object, E extends Object> {
	private T i;
	private E j;
	
	public Tuple(T i, E j) {
		super();
		this.i = i;
		this.j = j;
	}

	public Tuple() {
		super();
	}

	public T getI() {
		return i;
	}

	public void setI(T i) {
		this.i = i;
	}

	public E getJ() {
		return j;
	}

	public void setJ(E j) {
		this.j = j;
	}

	@Override
	public String toString() {
		return "Tuple [i=" + i + ", j=" + j + "]";
	}
}
