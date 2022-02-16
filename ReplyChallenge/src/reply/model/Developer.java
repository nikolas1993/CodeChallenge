package reply.model;

import java.util.Set;

public class Developer extends User{
	private int numSkills;
	private Set<String> skills;
	
	public Developer(int numSkills, Set<String> skills) {
		super();
		this.numSkills = numSkills;
		this.skills = skills;
	}

	public Developer() {
		super();
	}

	public int getNumSkills() {
		return numSkills;
	}

	public void setNumSkills(int numSkills) {
		this.numSkills = numSkills;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Developer [numSkills=" + numSkills + ", skills=" + skills + ", getCompany()=" + getCompany()
				+ ", getBonus()=" + getBonus() + ", getIndex()=" + getIndex() + "]";
	}
}
