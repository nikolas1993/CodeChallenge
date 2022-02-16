package google.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import google.model.Ingredient;
import google.model.Input;
import google.model.Pizza;

public class InputDao {
	private static InputDao instance;

	private InputDao() {
		super();
	}

	public static InputDao getInstance() {
		if (instance == null) {
			instance = new InputDao();
		}
		return instance;
	}
	
	public Input parser(String filepath) throws FileNotFoundException {
		File file = new File(filepath);
		Input in = new Input();
		Scanner s = new Scanner(file);
		String firstLine = s.nextLine();
		String[] split = firstLine.split(" ");
		in.setNumPizze(Integer.parseInt(split[0]));
		in.setNum2Teams(Integer.parseInt(split[1]));
		in.setNum3Teams(Integer.parseInt(split[2]));
		in.setNum4Teams(Integer.parseInt(split[3]));
		List<Pizza> pizze = new LinkedList<Pizza>();
		int i = 0;
		List<Ingredient> ingredients = new ArrayList<Ingredient>(in.getNumPizze());
		while(s.hasNextLine()){
			String line = s.nextLine();
			String[] split1 = line.split(" ");
			Pizza pizza = new Pizza();
			List<String> ingredientsPizza = Arrays.asList(split1);
			List<String> ingredientsPizzaList = new ArrayList<String>(ingredientsPizza);
			pizza.setNumIngredienti(Integer.parseInt(ingredientsPizzaList.remove(0)));
			List<Ingredient> setIngPizza = new ArrayList<Ingredient>(pizza.getNumIngredienti());
			for (String ingredient : ingredientsPizzaList) {
				int index = ingredients.indexOf(new Ingredient(ingredient, 0));
				if(index > -1) {
					ingredients.get(index).setNumber(ingredients.get(index).getNumber() +1);
					setIngPizza.add(ingredients.get(index));
				} else {
					ingredients.add(new Ingredient(ingredient, 1));
					setIngPizza.add(ingredients.get(ingredients.size() -1));
				}
			}
			pizza.setIngredients(setIngPizza);
			pizza.setIndex(i);
			pizze.add(pizza);
			i++;
		}
		in.setPizze(pizze);
		in.setNumPizze(pizze.size());
		s.close();
		return in;
	}

	/*public Input parser(String filepath) throws FileNotFoundException {
		File file = new File(filepath);
		Input in = new Input();
		Scanner s = new Scanner(file);
		String firstLine = s.nextLine();
		String[] split = firstLine.split(" ");
		in.setNumPizze(Integer.parseInt(split[0]));
		in.setNum2Teams(Integer.parseInt(split[1]));
		in.setNum3Teams(Integer.parseInt(split[2]));
		in.setNum4Teams(Integer.parseInt(split[3]));
		Tuple[][] floor = new Tuple[in.getH()][in.getW()];
		List<Tuple> pmPosition = new ArrayList<Tuple>();
		List<Tuple> devPosition = new ArrayList<Tuple>();
		for (int i = 0; i < in.getH(); i++) {
			String line = s.nextLine();
			for (int j = 0; j < line.length(); j++) {
				floor[i][j] = new Tuple("" + line.charAt(j), 0); 
				if (floor[i][j].getI().equals("M")) {
					pmPosition.add(new Tuple(i, j));
					int count =0;
					if(j-1>=0 && (!floor[i][j-1].getI().equals("#"))) {
						count ++;
						floor[i][j-1].setJ((Integer)floor[i][j-1].getJ() + 1);
					}
					if(i-1>=0 && (!floor[i-1][j].getI().equals("#"))){
						count ++;
						floor[i-1][j].setJ((Integer)floor[i-1][j].getJ() + 1);
					}
					floor[i][j].setJ(count);
				} else if (floor[i][j].getI().equals("_")) {
					devPosition.add(new Tuple(i, j));
					int count =0;
					if(j-1>=0 && (!floor[i][j-1].getI().equals("#"))) {
						count ++;
						floor[i][j-1].setJ((Integer)floor[i][j-1].getJ() + 1);
					}
					if(i-1>=0 && (!floor[i-1][j].getI().equals("#"))) {
						count ++;
						floor[i-1][j].setJ((Integer)floor[i-1][j].getJ() + 1);
					}
					floor[i][j].setJ(count);
				}
			}
		}
		in.setFloor(floor);
		in.setPmPosition(pmPosition);
		in.setDevPosition(devPosition);
		in.setNumDev(Integer.parseInt(s.nextLine()));
		List<Developer> devs= new ArrayList<Developer>();
		for (int i = 0; i < in.getNumDev(); i++) {
			Developer dev = new Developer();
			dev.setIndex(i);
			String line = s.nextLine();
			String[] sp = line.split(" ");
			dev.setCompany(sp[0]);
			dev.setBonus(Integer.parseInt(sp[1]));
			dev.setNumSkills(Integer.parseInt(sp[2]));
			Set<String> skills = new HashSet<String>(dev.getNumSkills());
			for (int j = 0; j < dev.getNumSkills(); j++) {
				skills.add(sp[j+3]);
			}
			dev.setSkills(skills);
			devs.add(dev);
		}
		in.setNumPM(Integer.parseInt(s.nextLine()));
		List<ProjectManager> pms= new ArrayList<ProjectManager>();
		for (int i = 0; i < in.getNumPM(); i++) {
			ProjectManager pm = new ProjectManager();
			pm.setIndex(i);
			String line = s.nextLine();
			String[] sp = line.split(" ");
			pm.setCompany(sp[0]);
			pm.setBonus(Integer.parseInt(sp[1]));
			pms.add(pm);
		}
		in.setDevelopers(devs);
		in.setPms(pms);
		s.close();
		return in;
	}*/
}
