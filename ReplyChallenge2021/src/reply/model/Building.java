package reply.model;

public class Building {
	private int[] position;
	private int latency;
	private int speed;
	
	public Building(int[] position, int latency, int speed) {
		super();
		this.position = position;
		this.latency = latency;
		this.speed = speed;
	}

	public Building() {
		super();
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Building [position=" + position + ", latency=" + latency + ", speed=" + speed + "]";
	}	
	
}
