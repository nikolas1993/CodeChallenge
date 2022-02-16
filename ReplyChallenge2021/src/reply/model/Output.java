package reply.model;

import java.util.List;

public class Output {
	private int numAntennas;
	private List<Antenna> antennaOut;
	
	public Output() {
		super();
	}

	public Output(int numAntennas, List<Antenna> antennaOut) {
		super();
		this.numAntennas = numAntennas;
		this.antennaOut = antennaOut;
	}

	public int getNumAntennas() {
		return numAntennas;
	}

	public void setNumAntennas(int numAntennas) {
		this.numAntennas = numAntennas;
	}

	public List<Antenna> getAntennaOut() {
		return antennaOut;
	}

	public void setAntennaOut(List<Antenna> antennaOut) {
		this.antennaOut = antennaOut;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(numAntennas);
		if(antennaOut != null) {
			for (Antenna row : antennaOut) {
				output.append("\n");
				output.append(row.toString());
			}	
		}
		return output.toString();
	}
	
}
