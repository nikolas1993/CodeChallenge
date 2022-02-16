package google.model;

public class Street implements Comparable<Street>{
	private int intersectionStart;
	private int intersectionEnd;
	private String name;
	private int time;
	private int timeSemaforo;
	
	public Street() {
		super();
	}

	public Street(String name) {
		super();
		this.name = name;
	}

	public Street(int intersectionStart, int intersectionEnd, String name, int time) {
		super();
		this.intersectionStart = intersectionStart;
		this.intersectionEnd = intersectionEnd;
		this.name = name;
		this.time = time;
	}

	/**
	 * @return the intersectionStart
	 */
	public int getIntersectionStart() {
		return intersectionStart;
	}




	/**
	 * @return the intersectionEnd
	 */
	public int getIntersectionEnd() {
		return intersectionEnd;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}




	/**
	 * @param intersectionStart the intersectionStart to set
	 */
	public void setIntersectionStart(int intersectionStart) {
		this.intersectionStart = intersectionStart;
	}




	/**
	 * @param intersectionEnd the intersectionEnd to set
	 */
	public void setIntersectionEnd(int intersectionEnd) {
		this.intersectionEnd = intersectionEnd;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * @return the timeSemaforo
	 */
	public int getTimeSemaforo() {
		return timeSemaforo;
	}

	/**
	 * @param timeSemaforo the timeSemaforo to set
	 */
	public void setTimeSemaforo(int timeSemaforo) {
		this.timeSemaforo = timeSemaforo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Street other = (Street) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Street arg0) {
		String street1 = this.name;
		String street2 = arg0.name;
		return street1.compareTo(street2);
	}

	@Override
	public String toString() {
		return name + " " + timeSemaforo;
	}
	
	
	
}
