package reply.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import reply.model.Antenna;
import reply.model.Input;
import reply.model.Building;

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
		in.setWidth(Integer.parseInt(split[0]));
		in.setHeight(Integer.parseInt(split[1]));
		String secondLine = s.nextLine();
		String[] splitSecond = secondLine.split(" ");
		in.setNumBuildings(Integer.parseInt(splitSecond[0]));
		in.setNumAntennas(Integer.parseInt(splitSecond[1]));
		in.setReward(Integer.parseInt(splitSecond[2]));
		List<Building> buildingsList = new ArrayList<Building>(in.getNumBuildings());
		List<int[]> buildingsPosition = new ArrayList<int[]>();
		List<Antenna> antennasList = new ArrayList<Antenna>(in.getNumAntennas());
		int i = 0;
		
		while(s.hasNextLine() && i < in.getNumBuildings()){
			String line = s.nextLine();
			String[] split1 = line.split(" ");
			Building building = new Building();
			int[] position = {Integer.parseInt(split1[0]), Integer.parseInt(split1[1])};
			building.setPosition(position);
			building.setLatency(Integer.parseInt(split1[2]));
			building.setSpeed(Integer.parseInt(split1[3]));
			buildingsList.add(building);
			buildingsPosition.add(position);
			i++;
		}
		
		i = 0;
		
		while(s.hasNextLine() && i < in.getNumAntennas()){
			String line = s.nextLine();
			String[] split1 = line.split(" ");
			Antenna antenna = new Antenna();
			antenna.setRange(Integer.parseInt(split1[0]));
			antenna.setSpeed(Integer.parseInt(split1[1]));
			antenna.setId(i);
			antennasList.add(antenna);
			i++;
		}
		in.setBuildingsList(buildingsList);
		in.setBuildingsPosition(buildingsPosition);
		in.setAntennasList(antennasList);
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
