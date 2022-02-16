package google.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import google.dao.InputDao;
import google.model.Car;
import google.model.Input;
import google.model.Intersection;
import google.model.Output;
import google.model.Street;
import google.utility.Utility;

public class GoogleMain {
	
	
	public static void main(String[] args) throws IOException {
		String filename = "b";
		InputDao inDao = InputDao.getInstance();
		Input input = inDao.getInput(filename);
		//System.out.println(input.toString());
		Map<Street, List<Car>> queue = input.getQueue();
		int d = input.getSimDuration();
		while(d > 0) {
			Map<Street, List<Car>> queue2 = new HashMap<Street, List<Car>>();
			Set<Street> streets = new HashSet<Street>(queue.keySet());
			int sistemazione = 0;
			int maxCosto = 0;
			for (Street street : streets) {
				int costo = 0;
				List<Car> carList = queue.remove(street);
				
				if(carList != null) {
					for (Car car : carList) {
						int costoCar = car.getStreetsList().remove(0).getTime();
						costo += costoCar;
						if(car.getStreetsList().size() > 0) {
							List<Car> cars = queue2.remove(car.getStreetsList().get(0));
							if(cars == null) {
								cars = new ArrayList<Car>();
							}
							cars.add(car);
							queue2.put(car.getStreetsList().get(0), cars);
						}
					}
				}
				if(costo > d) {
					costo = d;
				}
				if(costo > 0 && (street.getTimeSemaforo() > costo || street.getTimeSemaforo() == 0)) {
					sistemazione ++;
					street.setTimeSemaforo(costo);
					d = d + street.getTimeSemaforo() - costo;
				} else {
					d = d - Utility.min(costo, d);
				}
				List<Car> cars = queue2.remove(street);
				queue2.put(street, cars);
				if(maxCosto < costo) {
					maxCosto = costo;
				}

			}
			queue = queue2;
		}
		
		Map<Integer, Intersection> intersections = new HashMap<Integer, Intersection>();
		Set<Street> streets = queue.keySet();
		for (Street street : streets) {
			if(street.getTimeSemaforo() > 0) {
				Intersection inter = new Intersection();
				inter.setId(street.getIntersectionEnd());
				Intersection interOld = intersections.remove(inter.getId());	
				if(interOld == null) {
					List<Street> s = new ArrayList<Street>();
					s.add(street);
					inter.setListStreet(s);
					inter.setNumInStreets(inter.getListStreet().size());
				} else {
					interOld.getListStreet().add(street);
					inter.setListStreet(interOld.getListStreet());
					inter.setNumInStreets(interOld.getNumInStreets() + 1);
				}
				intersections.put(inter.getId(), inter);
			}
		}
		
		Output out = new Output();
		out.setNumIntersections(intersections.size());
		out.setIntersectionList(new ArrayList<Intersection>(intersections.values()));
		
		
		
		Utility.writeFileOutput(out.toString(), filename);
	}
}
