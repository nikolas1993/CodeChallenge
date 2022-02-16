package reply.model;

public class Tuple {
	private Object i;
	private Object j;
	
	public Tuple(Object i, Object j) {
		super();
		this.i = i;
		this.j = j;
	}

	public Tuple() {
		super();
	}

	public Object getI() {
		return i;
	}

	public void setI(Object i) {
		this.i = i;
	}

	public Object getJ() {
		return j;
	}

	public void setJ(Object j) {
		this.j = j;
	}
	
}
