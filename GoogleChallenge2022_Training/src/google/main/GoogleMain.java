package google.main;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import google.dao.InputDao;
import google.model.Client;
import google.model.Input;
import google.model.Output;
import google.utility.Utility;

public class GoogleMain {
	
	public static boolean containsElement(List<String> list1, Set<String> list2) {
		return list2.stream().filter(l2 -> {
					return list1.stream().filter(l1 -> l1.equals(l2)).count() > 0;
				}).count() > 0;
	}
	
	public static void main(String[] args) throws IOException {
		String filename = "e";
		InputDao inDao = InputDao.getInstance();
		Input input = inDao.getInput(filename);
		//System.out.println(input.toString());
		Set<String> ingredients = new HashSet<String>();
		Set<String> eliminated = new HashSet<String>();
		while(input.getClients().size() > 0) {
			int index = Utility.randomIndex(input.getClients().size());
			Client c = input.getClients().get(index);
			if(containsElement(c.getLike(), eliminated)) {
				input.getClients().remove(index);
				continue;
			}
			ingredients.addAll(c.getLike());
			eliminated.addAll(c.getDisLike());
			input.getClients().remove(index);
		}
		
		
		Output out = new Output();
		out.setNumIngredients(ingredients.size());
		out.setIngredients(ingredients);
		
		Utility.writeFileOutput(out.toString(), filename);
	}
}
