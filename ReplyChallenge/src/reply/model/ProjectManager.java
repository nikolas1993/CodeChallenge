package reply.model;

public class ProjectManager extends User implements Comparable<ProjectManager> {

	public ProjectManager() {
	}

	@Override
	public String toString() {
		return "ProjectManager [getCompany()=" + getCompany() + ", getBonus()=" + getBonus() + ", getIndex()="
				+ getIndex() + "]";
	}

	@Override
	public int compareTo(ProjectManager arg0) {
		return this.getBonus() - ((ProjectManager) arg0).getBonus();
	}

	
}
