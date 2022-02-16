package reply.model;

public class Antenna implements Comparable<Antenna>{
	private int id;
	private int range;
	private int speed;
	private int[] position;
	
	public Antenna() {
		super();
	}

	public Antenna(int id, int range, int speed, int[] position) {
		super();
		this.range = range;
		this.speed = speed;
		this.id = id;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return id + " " + position[0] + " " + position[1];
	}
	
	@Override
	public int compareTo(Antenna o) {
		Integer value1 = this.speed * this.range;
		Integer value2 = o.speed * o.range;
		return value1.compareTo(value2);
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}
	
}
