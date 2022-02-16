package reply.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import reply.dao.InputDao;
import reply.model.Input;
import reply.model.Output;
import reply.model.Antenna;
import reply.model.Building;
import reply.utility.Utility;

public class ReplyMain {
	public final static int MAX_ITER =10;
	public final static int DIMENSION =2;
	
	public static void main(String[] args) throws IOException {
		
		
		BigDecimal a = new BigDecimal(53.28);
		BigDecimal b = new BigDecimal(12992.34);
		BigDecimal c = a.multiply(new BigDecimal(100)).divide(b, 2 , RoundingMode.HALF_UP);//.multiply(new BigDecimal(100));
		//double c = Math.round((a.doubleValue()/b.doubleValue()) * new Double(100) * 100.0) / 100.0;
		//double c = a.divide(b, 2, RoundingMode.).multiply(new BigDecimal(100)).doubleValue();
		
		System.out.println(c);
		
		return;
		/*String filename = "f";
		InputDao inputDao = InputDao.getInstance();
		Input input = inputDao.parser("input\\" + filename + ".txt");
		//System.out.println(input.toString());
		
		List<Building> builds = new ArrayList<>(input.getBuildingsList());

		List<Antenna> antennas = new ArrayList<>(input.getAntennasList());
		
		//sort discendente
		antennas = antennas.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
		
		//Collections.sort(antennas);
		
		int indexAntennas = 0;
		for (indexAntennas = 0; indexAntennas < input.getNumAntennas() && builds.size() > 0; indexAntennas++) {
			Building bMax = builds.remove(Utility.indexBuildMaxSpeed(builds));
			Antenna a = antennas.get(indexAntennas);
			int[] position = bMax.getPosition();
			builds = builds.stream().filter((b) -> !Utility.isOnRange(position, a.getRange(), b.getPosition())).collect(Collectors.<Building>toList());
			a.setPosition(position);
			antennas.set(indexAntennas, a);
		}		
		
		if(builds.size() > 0) {
			String ciao ="";
		}
		
		Output out = new Output();
		out.setNumAntennas(indexAntennas);
		List<Antenna> outAntenna = new ArrayList<>();
		for (int i = 0; i < indexAntennas; i++) {
			outAntenna.add(antennas.get(i));
		}
		out.setAntennaOut(outAntenna);
		
		Utility.writeFileOutput(out.toString(), filename);*/
	}
}
