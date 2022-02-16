package reply.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import reply.model.Developer;
import reply.model.ProjectManager;
import reply.model.Tuple;
import reply.model.User;

public class Utility {
	
	public static int profit(User u1, User u2) {
		int profit = 0;
		if (u1.getCompany().equals(u2.getCompany())) {
			profit += u1.getBonus() * u1.getBonus();
		}
		if (!(u1 instanceof ProjectManager || u2 instanceof ProjectManager)) {
			Set<String> set1 = ((Developer) u1).getSkills();
			Set<String> set2 = ((Developer) u2).getSkills();
			Set<String> setIntersect = new HashSet<String>(set1);
			setIntersect.retainAll(set2);
			profit += setIntersect.size() * (set1.size() +set2.size() - 2*setIntersect.size());
		}
		return profit;
	}
	
	public static int randomIndex(int size){
		Random random = new Random();
		return random.nextInt(size);
	}
	
	public static <T extends User, D extends User> Tuple indexMax(List<T> users, D user) {
		if(users.size() == 0) {
			return new Tuple(-1,0);
		}
		int maxProfit = -1;
		int indexProfit = -1;
		for(int i = users.size() -1 ; i>= 0; i --) {
			int profit = profit(users.get(i), user);
			if(profit > maxProfit) {
				maxProfit =profit;
				indexProfit = i;
			}
		}
		return new Tuple(indexProfit, maxProfit);
	}
	
	public static void writeFile(String payload, String filepath) throws IOException {
		File file = new File(filepath);
		file.createNewFile();
		FileWriter w = new FileWriter(file);
		w.write(payload);
		w.close();
	}
	
}
