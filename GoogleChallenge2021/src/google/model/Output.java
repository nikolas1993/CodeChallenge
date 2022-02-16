package google.model;

import java.util.List;

public class Output {
	private int numIntersections;
	private List<Intersection> intersectionList;
	
	
	public Output() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the numIntersections
	 */
	public int getNumIntersections() {
		return numIntersections;
	}


	/**
	 * @return the intersectionList
	 */
	public List<Intersection> getIntersectionList() {
		return intersectionList;
	}


	/**
	 * @param numIntersections the numIntersections to set
	 */
	public void setNumIntersections(int numIntersections) {
		this.numIntersections = numIntersections;
	}


	/**
	 * @param intersectionList the intersectionList to set
	 */
	public void setIntersectionList(List<Intersection> intersectionList) {
		this.intersectionList = intersectionList;
	}


	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(numIntersections);
		if(intersectionList != null) {
			for (Intersection inter : intersectionList) {
				output.append("\n");
				output.append(inter.toString());
			}	
		}
		return output.toString();
	}
	
}
