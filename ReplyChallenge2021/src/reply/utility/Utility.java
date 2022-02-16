package reply.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import reply.model.Antenna;
import reply.model.Building;
import reply.model.Distance;

public class Utility {
	private static String CIAO = "ciao";
	public static int indexBuildMaxSpeed(List<Building> builds) {
		int maxValue = 0;
		int maxIndex = 0;
		for(int j = 0; j < builds.size(); j++) {
			Building b = builds.get(j);
			
			int value =  b.getSpeed() * b.getLatency();
			if(value > maxValue) {
				maxValue = value;
				maxIndex = j;
			}
		}
		return maxIndex;
	}
	
	public static int indexAntennadMaxSpeed(List<Antenna> antenna) {
		int maxValue = 0;
		int maxIndex = 0;
		for(int j = 0; j < antenna.size(); j++) {
			Antenna a = antenna.get(j);
			
			int value = a.getSpeed() * a.getRange();
			if(value > maxValue) {
				maxValue = value;
				maxIndex = j;
			}
		}
		return maxIndex;
	}
	
	public static int randomIndex(int size){
		if(size == 0) {
			return 0;
		}
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
	
	public static boolean isOnRange(int positionAntenna[], int rangeAntenna, int positionBuild[] ) {
		int d = Distance.manhattanDistance(positionAntenna, positionBuild);
		return d <= rangeAntenna;
	}
	
}
