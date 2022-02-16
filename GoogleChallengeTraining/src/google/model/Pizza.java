package google.model;

import java.util.List;

public class Pizza implements Comparable<Pizza>{
	private int index;
	private int numIngredienti;
	private List<Ingredient> ingredients;
	
	public Pizza() {
		super();
	}

	public Pizza(int index, int numIngredienti, List<Ingredient> ingredients) {
		super();
		this.index = index;
		this.numIngredienti = numIngredienti;
		this.ingredients = ingredients;
	}

	/**
	 * @return the numIngredienti
	 */
	public int getNumIngredienti() {
		return numIngredienti;
	}

	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param numIngredienti the numIngredienti to set
	 */
	public void setNumIngredienti(int numIngredienti) {
		this.numIngredienti = numIngredienti;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Pizza [index = " + index + ", numIngredienti=" + numIngredienti + ", ingredients=" + ingredients + "]";
	}

	@Override
	public int compareTo(Pizza o) {
		Integer value1 = 0;
		Integer value2 = 0;
		for (Ingredient ingredient : this.getIngredients()) {
			value1 += ingredient.getNumber();
		}
		for (Ingredient ingredient : o.getIngredients()) {
			value2 += ingredient.getNumber();
		}
		return value1.compareTo(value2);
	}
	
}
