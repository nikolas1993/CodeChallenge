package google.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import google.model.Car;
import google.model.Input;
import google.model.Street;

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
	
	public Input getInput(String filename) throws FileNotFoundException {
		return parser("input\\" + filename + ".txt");
	}
	
	public Input parser(String filepath) throws FileNotFoundException {
		File file = new File(filepath);
		Input in = new Input();
		Scanner s = new Scanner(file);
		String firstLine = s.nextLine();
		String[] split = firstLine.split(" ");
		in.setSimDuration(Integer.parseInt(split[0]));
		in.setNumIntersection(Integer.parseInt(split[1]));
		in.setNumStreets(Integer.parseInt(split[2]));
		in.setNumCars(Integer.parseInt(split[3]));
		in.setBonus(Integer.parseInt(split[4]));
		List<Street> streetsList = new ArrayList<Street>(in.getNumStreets());
		Map<Street, List<Car>> queue = new HashMap<Street, List<Car>>(in.getNumStreets());
		int i = 0;
		while(s.hasNextLine() && i < in.getNumStreets()){
			String line = s.nextLine();
			String[] split1 = line.split(" ");
			Street street = new Street();
			street.setIntersectionStart(Integer.parseInt(split1[0]));
			street.setIntersectionEnd(Integer.parseInt(split1[1]));
			street.setName(split1[2]);
			street.setTime(Integer.parseInt(split1[3]));
			street.setTimeSemaforo(0);
			streetsList.add(street);
			i++;
		}
		in.setStreetsList(streetsList);
		List<Car> carsList = new ArrayList<Car>(in.getNumCars());
		i = 0;
		while(s.hasNextLine() && i < in.getNumCars()){
			String line = s.nextLine();
			String[] split1 = line.split(" ");
			Car car = new Car();
			car.setNumStreets(Integer.parseInt(split1[0]));
			List<Street> streetsCarList = new ArrayList<Street>(car.getNumStreets());
			for(int j = 1; j < car.getNumStreets(); j++) {
				Street street = streetsList.get(streetsList.indexOf(new Street(split1[j])));
				streetsCarList.add(street);
			}
			car.setStreetsList(streetsCarList);
			carsList.add(car);
			Street street = car.getStreetsList().get(0);
			List<Car> cars = queue.remove(street);
			if(cars == null) {
				cars = new ArrayList<Car>();
			}
			cars.add(car);
			queue.put(street, cars);
			i++;
		}
		in.setQueue(queue);
		in.setCarsList(carsList);
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
