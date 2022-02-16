package reply.model;

import java.util.List;

public class Input {
	private int width;
	private int height;
	private int numBuildings;
	private int numAntennas;
	private int reward;
	private List<Building> buildingsList;
	private List<int[]> buildingsPosition;
	private List<Antenna> antennasList;
	
	public Input() {
		super();
	}

	public Input(int width, int height, int numBuildings, int numAntennas, int reward, List<Building> buildingsList,
			List<Antenna> antennasList) {
		super();
		this.width = width;
		this.height = height;
		this.numBuildings = numBuildings;
		this.numAntennas = numAntennas;
		this.reward = reward;
		this.buildingsList = buildingsList;
		this.antennasList = antennasList;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getNumBuildings() {
		return numBuildings;
	}

	public void setNumBuildings(int numBuildings) {
		this.numBuildings = numBuildings;
	}

	public int getNumAntennas() {
		return numAntennas;
	}

	public void setNumAntennas(int numAntennas) {
		this.numAntennas = numAntennas;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public List<Building> getBuildingsList() {
		return buildingsList;
	}

	public void setBuildingsList(List<Building> buildingsList) {
		this.buildingsList = buildingsList;
	}

	public List<Antenna> getAntennasList() {
		return antennasList;
	}

	public void setAntennasList(List<Antenna> antennasList) {
		this.antennasList = antennasList;
	}

	public List<int[]> getBuildingsPosition() {
		return buildingsPosition;
	}

	public void setBuildingsPosition(List<int[]> buildingsPosition) {
		this.buildingsPosition = buildingsPosition;
	}

	@Override
	public String toString() {
		return "Input [width=" + width + ", height=" + height + ", numBuildings=" + numBuildings + ", numAntennas="
				+ numAntennas + ", reward=" + reward + ", buildingsList=" + buildingsList + ", antennasLis="
				+ antennasList + "]";
	}
	
}
