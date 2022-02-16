package google.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import google.dao.InputDao;
import google.model.Input;
import google.model.Output;
import google.model.Pizza;
import google.utility.Utility;

public class GoogleMain {
	public static void main(String[] args) throws IOException {
		String filename = "e";
		InputDao inputDao = InputDao.getInstance();
		Input input = inputDao.parser("input\\" + filename + ".txt");
		//System.out.println(input.toString());
		
		Output out = new Output();
		out.setPizzeTeams(new ArrayList<List<Integer>>(input.getNum4Teams() + input.getNum3Teams() + input.getNum2Teams()));
		out.setNumPizzeDeliver(0);
		List<Pizza> pizzeNotUsed = input.getPizze();
		for(int i = 0; i < input.getNum4Teams() && pizzeNotUsed.size() > 3; i++) {
			List<Integer> pizzeTeam = new ArrayList<Integer>();
			pizzeTeam.add(4);
			Pizza maxPizza= Utility.parallelIndexPizzaMaxDist(pizzeNotUsed);
			pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(pizzeNotUsed));
			pizzeTeam.add(maxPizza.getIndex());
			Pizza pizza1 = pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(maxPizza, pizzeNotUsed));
			pizzeTeam.add(pizza1.getIndex());
			Pizza pizzaUnion = Utility.pizzaUnion(maxPizza, pizza1);
			Pizza pizza2 = pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(pizzaUnion, pizzeNotUsed));
			pizzeTeam.add(pizza2.getIndex());
			pizzaUnion = Utility.pizzaUnion(pizzaUnion, pizza2);
			Pizza pizza3 = pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(pizzaUnion, pizzeNotUsed));
			pizzeTeam.add(pizza3.getIndex());
			out.getPizzeTeams().add(pizzeTeam);
			out.setNumPizzeDeliver(out.getNumPizzeDeliver() + 1);
			//System.out.println(input.getNum4Teams() - i);
		}
		
		for(int i = 0; i < input.getNum3Teams() && pizzeNotUsed.size() > 2; i++) {
			List<Integer> pizzeTeam = new ArrayList<Integer>();
			pizzeTeam.add(3);
			Pizza maxPizza= Utility.parallelIndexPizzaMaxDist(pizzeNotUsed);
			pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(pizzeNotUsed));
			pizzeTeam.add(maxPizza.getIndex());
			Pizza pizza1 = pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(maxPizza, pizzeNotUsed));
			pizzeTeam.add(pizza1.getIndex());
			Pizza pizzaUnion = Utility.pizzaUnion(maxPizza, pizza1);
			Pizza pizza2 = pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(pizzaUnion, pizzeNotUsed));
			pizzeTeam.add(pizza2.getIndex());
			out.getPizzeTeams().add(pizzeTeam);
			out.setNumPizzeDeliver(out.getNumPizzeDeliver() + 1);

			//System.out.println(input.getNum3Teams() - i);
		}
		
		for(int i = 0; i < input.getNum2Teams() && pizzeNotUsed.size() > 1; i++) {
			List<Integer> pizzeTeam = new ArrayList<Integer>();
			pizzeTeam.add(2);
			Pizza maxPizza= Utility.parallelIndexPizzaMaxDist(pizzeNotUsed);
			pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(pizzeNotUsed));
			pizzeTeam.add(maxPizza.getIndex());
			Pizza pizza1 = pizzeNotUsed.remove(Utility.parallelIndexPizzaMaxDist(maxPizza, pizzeNotUsed));
			pizzeTeam.add(pizza1.getIndex());
			out.getPizzeTeams().add(pizzeTeam);
			out.setNumPizzeDeliver(out.getNumPizzeDeliver() + 1);

			//System.out.println(input.getNum2Teams() - i);
		}
		
		Utility.writeFileOutput(out.toString(), filename);
	}
}
