package reply.model;

import java.util.Arrays;
import java.util.List;

public class Input {
	private int W;
	private int H;
	private Tuple[][] floor;
	private int numDev;
	private List<Developer> developers;
	private int numPM;
	private List<ProjectManager> pms;
	private List<Tuple> pmPosition;
	private List<Tuple> devPosition;
	
	public Input(int w, int h, Tuple[][] floor, int numDev, List<Developer> developers, int numPM,
			List<ProjectManager> pms) {
		super();
		W = w;
		H = h;
		this.floor = floor;
		this.numDev = numDev;
		this.developers = developers;
		this.numPM = numPM;
		this.pms = pms;
	}
	
	public Input() {
	}
	
	public int getW() {
		return W;
	}
	
	public void setW(int w) {
		W = w;
	}
	public int getH() {
		return H;
	}
	public void setH(int h) {
		H = h;
	}
	public Tuple[][] getFloor() {
		return floor;
	}
	public void setFloor(Tuple[][] floor) {
		this.floor = floor;
	}
	public int getNumDev() {
		return numDev;
	}
	public void setNumDev(int numDev) {
		this.numDev = numDev;
	}
	public List<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	public int getNumPM() {
		return numPM;
	}
	public void setNumPM(int numPM) {
		this.numPM = numPM;
	}
	public List<ProjectManager> getPms() {
		return pms;
	}
	public void setPms(List<ProjectManager> pms) {
		this.pms = pms;
	}

	public List<Tuple> getPmPosition() {
		return pmPosition;
	}

	public List<Tuple> getDevPosition() {
		return devPosition;
	}

	public void setPmPosition(List<Tuple> pmPosition) {
		this.pmPosition = pmPosition;
	}

	public void setDevPosition(List<Tuple> devPosition) {
		this.devPosition = devPosition;
	}

	@Override
	public String toString() {
		return "Input [W=" + W + ", H=" + H + ", floor=" + Arrays.toString(floor) + ", numDev=" + numDev
				+ ", developers=" + developers + ", numPM=" + numPM + ", pms=" + pms + ", pmPosition=" + pmPosition
				+ ", devPosition=" + devPosition + "]";
	}
	
}
