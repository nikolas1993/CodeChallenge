package google.model;

import java.util.List;

public class Client {
	private int numberLike;
	private List<String> like;
	private int numberDisLike;
	private List<String> disLike;
	
	public Client() {
		super();
	}

	public Client(int numberLike, List<String> like, int numberDisLike, List<String> disLike) {
		super();
		this.numberLike = numberLike;
		this.like = like;
		this.numberDisLike = numberDisLike;
		this.disLike = disLike;
	}

	public List<String> getLike() {
		return like;
	}

	public void setLike(List<String> like) {
		this.like = like;
	}

	public List<String> getDisLike() {
		return disLike;
	}

	public void setDisLike(List<String> disLike) {
		this.disLike = disLike;
	}

	public int getNumberLike() {
		return numberLike;
	}

	public void setNumberLike(int numberLike) {
		this.numberLike = numberLike;
	}

	public int getNumberDisLike() {
		return numberDisLike;
	}

	public void setNumberDisLike(int numberDisLike) {
		this.numberDisLike = numberDisLike;
	}

	@Override
	public String toString() {
		return "Client [numberLike=" + numberLike + ", like=" + like + ", numberDisLike=" + numberDisLike + ", disLike="
				+ disLike + "]";
	}
	
}
