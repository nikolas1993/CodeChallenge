package google.model;

import java.util.List;
import java.util.Map;

public class Input {
	private int simDuration;
	private int numIntersection;
	private int numStreets;
	private int numCars;
	private int bonus;
	private List<Street> streetsList;
	private List<Car> carsList;
	private Map<Street, List<Car>> queue;
	
	public Input() {
		super();
	}

	public Input(int simDuration, int numIntersection, int numStreets, int numCars, int bonus, List<Street> streetsList,
			List<Car> carsList) {
		super();
		this.simDuration = simDuration;
		this.numIntersection = numIntersection;
		this.numStreets = numStreets;
		this.numCars = numCars;
		this.bonus = bonus;
		this.streetsList = streetsList;
		this.carsList = carsList;
	}

	/**
	 * @return the simDuration
	 */
	public int getSimDuration() {
		return simDuration;
	}

	/**
	 * @return the numIntersection
	 */
	public int getNumIntersection() {
		return numIntersection;
	}

	/**
	 * @return the numStreets
	 */
	public int getNumStreets() {
		return numStreets;
	}

	/**
	 * @return the numCars
	 */
	public int getNumCars() {
		return numCars;
	}

	/**
	 * @return the bonus
	 */
	public int getBonus() {
		return bonus;
	}

	/**
	 * @return the streetsList
	 */
	public List<Street> getStreetsList() {
		return streetsList;
	}

	/**
	 * @return the carsList
	 */
	public List<Car> getCarsList() {
		return carsList;
	}

	/**
	 * @param simDuration the simDuration to set
	 */
	public void setSimDuration(int simDuration) {
		this.simDuration = simDuration;
	}

	/**
	 * @param numIntersection the numIntersection to set
	 */
	public void setNumIntersection(int numIntersection) {
		this.numIntersection = numIntersection;
	}

	/**
	 * @param numStreets the numStreets to set
	 */
	public void setNumStreets(int numStreets) {
		this.numStreets = numStreets;
	}

	/**
	 * @param numCars the numCars to set
	 */
	public void setNumCars(int numCars) {
		this.numCars = numCars;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	/**
	 * @param streetsList the streetsList to set
	 */
	public void setStreetsList(List<Street> streetsList) {
		this.streetsList = streetsList;
	}

	/**
	 * @param carsList the carsList to set
	 */
	public void setCarsList(List<Car> carsList) {
		this.carsList = carsList;
	}

	/**
	 * @return the queueList
	 */
	public Map<Street, List<Car>> getQueue() {
		return queue;
	}

	/**
	 * @param queueList the queueList to set
	 */
	public void setQueue(Map<Street, List<Car>> queue) {
		this.queue = queue;
	}

	@Override
	public String toString() {
		return "Input [simDuration=" + simDuration + ", numIntersection=" + numIntersection + ", numStreets="
				+ numStreets + ", numCars=" + numCars + ", bonus=" + bonus + ", streetsList=" + streetsList
				+ ", carsList=" + carsList + ", queue=" + queue + "]";
	}
	
}
