package reply.model;

public class User {
	private int index;
	private String company;
	private int bonus;
	private Tuple position;
	
	public User() {
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Tuple getPosition() {
		return position;
	}

	public void setPosition(Tuple position) {
		this.position = position;
	}
}
