package google.model;

import java.util.List;

public class Output {
	private int numPizzeDeliver;
	private List<List<Integer>> pizzeTeams;
	
	public Output() {
		super();
	}

	public Output(int numPizzeDeliver, List<List<Integer>> pizzeTeams) {
		super();
		this.numPizzeDeliver = numPizzeDeliver;
		this.pizzeTeams = pizzeTeams;
	}

	/**
	 * @return the numPizzeDeliver
	 */
	public int getNumPizzeDeliver() {
		return numPizzeDeliver;
	}

	/**
	 * @return the pizzeTeams
	 */
	public List<List<Integer>> getPizzeTeams() {
		return pizzeTeams;
	}

	/**
	 * @param numPizzeDeliver the numPizzeDeliver to set
	 */
	public void setNumPizzeDeliver(int numPizzeDeliver) {
		this.numPizzeDeliver = numPizzeDeliver;
	}

	/**
	 * @param pizzeTeams the pizzeTeams to set
	 */
	public void setPizzeTeams(List<List<Integer>> pizzeTeams) {
		this.pizzeTeams = pizzeTeams;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(numPizzeDeliver);
		if(pizzeTeams != null) {
			for (List<Integer> row : pizzeTeams) {
				output.append("\n");
				for (Integer element : row) {
					output.append(element + " ");
				}
				if(row.size() > 0) {
					output.deleteCharAt(output.length()-1);
				}
			}	
		}
		return output.toString();
	}
	
}
