package google.model;

import java.util.List;

public class Intersection {
	private int id;
	private int numInStreets;
	private List<Street> listStreet;
	
	public Intersection() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the numInStreets
	 */
	public int getNumInStreets() {
		return numInStreets;
	}

	/**
	 * @return the listStreet
	 */
	public List<Street> getListStreet() {
		return listStreet;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param numInStreets the numInStreets to set
	 */
	public void setNumInStreets(int numInStreets) {
		this.numInStreets = numInStreets;
	}

	/**
	 * @param listStreet the listStreet to set
	 */
	public void setListStreet(List<Street> listStreet) {
		this.listStreet = listStreet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Intersection other = (Intersection) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = id + "\n" + numInStreets;
		for (Street street : listStreet) {
			s += "\n";
			s += street.toString();
		}
		return s;
	}	
	
}
