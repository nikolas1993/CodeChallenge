package google.model;

import java.util.List;

public class Car implements Comparable<Car>{
	private int numStreets;
	private List<Street> streetsList;
	
	public Car() {
		super();
	}

	public Car(int numStreets, List<Street> streetsList) {
		super();
		this.numStreets = numStreets;
		this.streetsList = streetsList;
	}

	/**
	 * @return the numStreet
	 */
	public int getNumStreets() {
		return numStreets;
	}

	/**
	 * @return the streetsList
	 */
	public List<Street> getStreetsList() {
		return streetsList;
	}

	/**
	 * @param numStreet the numStreet to set
	 */
	public void setNumStreets(int numStreets) {
		this.numStreets = numStreets;
	}

	/**
	 * @param streetsList the streetsList to set
	 */
	public void setStreetsList(List<Street> streetsList) {
		this.streetsList = streetsList;
	}

	@Override
	public int compareTo(Car arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Car [numStreets=" + numStreets + ", streetsList=" + streetsList + "]";
	}
	
}
