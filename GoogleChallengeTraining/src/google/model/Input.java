package google.model;

import java.util.List;

public class Input {
	private int numPizze;
	private int num2Teams;
	private int num3Teams;
	private int num4Teams;
	private List<Pizza> pizze;
	
	public Input() {
		super();
	}

	public Input(int numPizze, int num2Teams, int num3Teams, int num4Teams, List<Pizza> pizze) {
		super();
		this.numPizze = numPizze;
		this.num2Teams = num2Teams;
		this.num3Teams = num3Teams;
		this.num4Teams = num4Teams;
		this.pizze = pizze;
	}

	/**
	 * @return the numPizze
	 */
	public int getNumPizze() {
		return numPizze;
	}

	/**
	 * @return the num2Teams
	 */
	public int getNum2Teams() {
		return num2Teams;
	}

	/**
	 * @return the num3Teams
	 */
	public int getNum3Teams() {
		return num3Teams;
	}

	/**
	 * @return the num4Teams
	 */
	public int getNum4Teams() {
		return num4Teams;
	}

	/**
	 * @return the pizze
	 */
	public List<Pizza> getPizze() {
		return pizze;
	}

	/**
	 * @param numPizze the numPizze to set
	 */
	public void setNumPizze(int numPizze) {
		this.numPizze = numPizze;
	}

	/**
	 * @param num2Teams the num2Teams to set
	 */
	public void setNum2Teams(int num2Teams) {
		this.num2Teams = num2Teams;
	}

	/**
	 * @param num3Teams the num3Teams to set
	 */
	public void setNum3Teams(int num3Teams) {
		this.num3Teams = num3Teams;
	}

	/**
	 * @param num4Teams the num4Teams to set
	 */
	public void setNum4Teams(int num4Teams) {
		this.num4Teams = num4Teams;
	}

	/**
	 * @param pizze the pizze to set
	 */
	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	@Override
	public String toString() {
		return "Input [numPizze=" + numPizze + ", num2Teams=" + num2Teams + ", num3Teams=" + num3Teams + ", num4Teams="
				+ num4Teams + ", pizze=" + pizze + "]";
	}	
	
}
