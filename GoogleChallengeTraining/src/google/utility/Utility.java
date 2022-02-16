package google.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;

import google.model.Ingredient;
import google.model.Pizza;

public class Utility {
	
	public static int score(List<List<Pizza>> pizzeTeams) {
		int score = 0;
		for (List<Pizza> delivery : pizzeTeams) {
			Set<Ingredient> ingredients = new HashSet<Ingredient>();
			for (Pizza pizza : delivery) {
				ingredients.addAll(pizza.getIngredients());
			}
			score = score + (ingredients.size() * ingredients.size());
		}
		return score;
	}
	
	public static int indexPizzaMaxDist(List<Pizza> pizze) {
		int indexMax = 0;
		int maxValue = 0;
		for(int i = 0; i < pizze.size(); i++) {
			int value = 0;
			for (Ingredient ingredient : pizze.get(i).getIngredients()) {
				value += ingredient.getNumber();
			}
			if(value > maxValue) {
				maxValue = value;
				indexMax = i;
			}
		}
		return indexMax;
	}
	
	public static int indexPizzaMaxDist(Pizza pizza, List<Pizza> pizze) {
		int maxValue = 0;
		int maxIndex = 0;
		for(int j = 0; j < pizze.size(); j++) {
			int value = diffIngredients(pizza, pizze.get(j));	
			if(value > maxValue) {
				maxValue = value;
				maxIndex = j;
			}
		}
		return maxIndex;
	}
	
	public static int parallelIndexPizzaMaxDist(Pizza pizza, List<Pizza> pizze) {	
		OptionalInt maxIndex = pizze.parallelStream()
									.mapToInt(p -> diffIngredients(pizza, p))
									.max();
		return maxIndex.getAsInt();
	}
	
	public static int diffIngredients(Pizza pizza1, Pizza pizza2) {
		int max = Math.max(pizza1.getNumIngredienti(), pizza2.getNumIngredienti());
		List<Ingredient> list = new ArrayList<Ingredient>(pizza1.getNumIngredienti() + pizza2.getNumIngredienti());
		list.addAll(pizza1.getIngredients());
		list.addAll(pizza2.getIngredients());
		Set<Ingredient> union = new HashSet<Ingredient>(list);
		return union.size() - max;
	}
	
	public static Pizza pizzaUnion(Pizza pizza1, Pizza pizza2) {
		Pizza p = new Pizza();
		List<Ingredient> unionIng = new ArrayList<Ingredient>(pizza1.getNumIngredienti() + pizza2.getNumIngredienti());
		unionIng.addAll(pizza1.getIngredients());
		unionIng.addAll(pizza2.getIngredients());
		Set<Ingredient> union = new HashSet<Ingredient>(unionIng);
		unionIng.clear();
		unionIng.addAll(union);
		p.setIngredients(unionIng);
		return p;
	}
	
	public static Pizza parallelIndexPizzaMaxDist(List<Pizza> pizze) {
		Optional<Pizza> pizza = null;
		pizza = pizze.parallelStream()
			.max((p1, p2) -> p1.compareTo(p2));
		return pizza.get();
	}
	
	public static int randomIndex(int size){
		Random random = new Random();
		return random.nextInt(size);
	}
	
	public static void writeFileOutput(String payload, String fileName) throws IOException {
		writeFile(payload, "output\\" + fileName + "_output.txt");
	}
	
	public static void writeFile(String payload, String filepath) throws IOException {
		File file = new File(filepath);
		file.createNewFile();
		FileWriter w = new FileWriter(file);
		w.write(payload);
		w.close();
	}
	
	public static void orderList(List<Object> list) {
		list.parallelStream()
			.sorted();
	}
	
	public static void orderList(List<Object> list, Comparator<Object> comparator) {
		list.parallelStream()
			.sorted(comparator);
	}
	
	public static <T extends Comparable<T>> T getMaxFromList(List<T> list) {
		return list.parallelStream()
				   .max((l1, l2) -> l1.compareTo(l2))
				   .get();
	}
	
	public static <T extends Comparable<T>> T getMinFromList(List<T> list) {
		return list.parallelStream()
				   .min((l1, l2) -> l1.compareTo(l2))
				   .get();
	}
	
	public static <T extends Comparable<T>> int getMaxIndexFromList(List<T> list) {
		T t = list.parallelStream()
            .max((l1, l2) -> l1.compareTo(l2)).get();
		return list.indexOf(t);
	}
	
	public static <T extends Comparable<T>> int getMinIndexFromList(List<T> list) {
		T t = list.parallelStream()
				   .min((l1, l2) -> l1.compareTo(l2))
				   .get();
		
		return list.indexOf(t);
	}
	
	public static void exampleOpList() {
		/*List<UserDataInfoDto> filteredList = userDataVoList
			    .stream()
			    .filter(u -> !u.getUsrDataField().endsWith("DESC"))
			    .map(vo -> {
			     UserDataInfoDto userData = new UserDataInfoDto();
			     userData.setCompositeId(vo.getCompositeId());
			     userData.setTable(vo.getUsrDataTable());
			     userData.setField(vo.getUsrDataField());
			     userData.setDesc(vo.getUsrDataDesc());
			     userData.setValue(null); //verrà poi popolata dal adjustMetadataFromRowVo
			     userData.setMandatory(vo.isMandatory());
			     String[] parts = vo.getUsrDataField().split("_");
			     userData.setIndex(parts[parts.length-1]);
			     boolean editVal = false;
			     if(!isReadonlyMode) { //se siamo in sola visualizzazione saranno sempre readonly
			      if("Y".equals(vo.getEditable())) { //sempre modificabile
			       editVal = true;
			      } else if("C".equals(vo.getEditable())) { //modificale solo se documento è non confermato
			       if(headerConfirmed) {
			        editVal = false;
			       } else {
			        editVal = true;
			       }
			      } else if("N".equals(vo.getEditable())) { //mai modificabile
			       editVal = false;
			      }
			     }
			     userData.setReadonly(!editVal); 
			     // cerco il metodo di get per il campo a DB
			     String methodName = ReflectUtils.convertDbFieldToCamelCase(vo.getUsrDataField());
			     List<Method> methodList = ReflectUtils.getFilteredMethods(rowVo.getClass(), methodName, "get");
			     try {
			      if(methodList != null && methodList.size() > 0) {
			       // setto il valore
			       Method getMethod = methodList.get(0);
			       userData.setValue( (String)getMethod.invoke(rowVo) );
			      }
			     } catch (SecurityException e) {
			      e.printStackTrace();
			      logger.error("UserDataUtils.initMetadata error found", e);
			     } catch (IllegalAccessException e) {
			      e.printStackTrace();
			      logger.error("UserDataUtils.initMetadata error found", e);
			     } catch (IllegalArgumentException e) {
			      e.printStackTrace();
			      logger.error("UserDataUtils.initMetadata error found", e);
			     } catch (InvocationTargetException e) {
			      e.printStackTrace();
			      logger.error("UserDataUtils.initMetadata error found", e);
			     }
			     return userData;
			    })
			    .collect(Collectors.<UserDataInfoDto>toList());*/
		
		
		/*rifInfoList = rifInfoList.stream()
		        .sorted( new Attr01Comparator() )
		        .collect(Collectors.toList());*/

	}
	
}
