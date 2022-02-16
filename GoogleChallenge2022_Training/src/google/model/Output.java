package google.model;

import java.util.Set;

public class Output {
	private int numIngredients;
	private Set<String> ingredients;
	
	
	public Output() {
		super();
	}

	public int getNumIngredients() {
		return numIngredients;
	}


	public void setNumIngredients(int numIngredients) {
		this.numIngredients = numIngredients;
	}


	public Set<String> getIngredients() {
		return ingredients;
	}


	public void setIngredients(Set<String> ingredients) {
		this.ingredients = ingredients;
	}


	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(numIngredients);
		if(ingredients != null) {
			for (String ing : ingredients) {
				output.append(" ");
				output.append(ing.toString());
			}	
		}
		return output.toString();
	}
	
}
