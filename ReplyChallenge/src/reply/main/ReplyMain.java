package reply.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import reply.dao.InputDao;
import reply.model.Developer;
import reply.model.Input;
import reply.model.ProjectManager;
import reply.model.Tuple;
import reply.utility.Utility;

public class ReplyMain {
	public static void main(String[] args) throws IOException {
		long timeIn = System.currentTimeMillis();
		String filename = "d";
		InputDao dao = InputDao.getInstance();
		Input in = dao.parser("input\\" + filename + ".txt");
		List<ProjectManager> pmsNotUsed = new ArrayList<ProjectManager>(in.getPms());
		List<Developer> devNotUsed = new ArrayList<Developer>(in.getDevelopers());
		Collections.sort(pmsNotUsed);
		Collections.sort(in.getPmPosition(), new Comparator<Tuple>() {
			@Override
			public int compare(Tuple o1, Tuple o2) {
				return -1*((Integer)in.getFloor()[(int) o1.getI()][(int) o1.getJ()].getJ() - (Integer)in.getFloor()[(int) o2.getI()][(int) o2.getJ()].getJ());
			}
		});
		int profitTot = 0;
		for (Tuple pmPosition : in.getPmPosition()) {
			int i = (int) pmPosition.getI();
			int j = (int) pmPosition.getJ();
			if(pmsNotUsed.size() == 0) {
				break;
			}
			ProjectManager pm = null;
			if(in.getFloor()[i][j].getI().equals("#")) {
				continue;
			}else if(((String)in.getFloor()[i][j].getI()).length() > 1) {
				pm = in.getPms().get(Integer.parseInt(((String)in.getFloor()[i][j].getI()).substring(1)));
			}else {
				pm = pmsNotUsed.remove(pmsNotUsed.size()-1);
			}
			
			in.getFloor()[i][j].setI("#");
			in.getPms().get(pm.getIndex()).setPosition(new Tuple(i,j));
			List<Tuple> positions = new ArrayList<Tuple>();
			positions.add(new Tuple(i-1,j));
			positions.add(new Tuple(i+1,j));
			positions.add(new Tuple(i,j-1));
			positions.add(new Tuple(i,j+1));
			for (Tuple pos : positions) {
				int indexI = (int) pos.getI();
				int indexJ = (int) pos.getJ();
				if(indexI >= 0 && indexI < in.getH() && indexJ >= 0 && indexJ < in.getW()) {
					if(in.getFloor()[indexI][indexJ].getI().equals("M")) {
						Tuple t = Utility.indexMax(pmsNotUsed, pm);
						int index = (int) t.getI();
						profitTot +=  (int)t.getJ();
						if(index != -1) {
							ProjectManager pmMax = pmsNotUsed.remove(index);
							in.getFloor()[indexI][indexJ].setI("M" + pmMax.getIndex());
							in.getPms().get(pmMax.getIndex()).setPosition(new Tuple(indexI,indexJ));
						}
					}
					if(in.getFloor()[indexI][indexJ].getI().equals("_")) {
						Tuple t = Utility.indexMax(devNotUsed, pm);
						int index = (int) t.getI();
						profitTot += (int)t.getJ();
						if(index != -1) {
							Developer devMax = devNotUsed.remove(index);
							in.getFloor()[indexI][indexJ].setI("#");
							in.getDevelopers().get(devMax.getIndex()).setPosition(new Tuple(indexI,indexJ));
						}
					}
				}
			}
		}
		for (Tuple devPosition : in.getDevPosition()) {
			int i = (int) devPosition.getI();
			int j = (int) devPosition.getJ();
			if(in.getFloor()[i][j].getI().equals("#")) {
				continue;
			}
			if(devNotUsed.size() == 0) {
				break;
			}
			Developer dev = devNotUsed.remove(Utility.randomIndex(devNotUsed.size()));
			in.getFloor()[i][j].setI("#");
			in.getDevelopers().get(dev.getIndex()).setPosition(new Tuple(i,j));
			List<Tuple> positions = new ArrayList<Tuple>();
			positions.add(new Tuple(i-1,j));
			positions.add(new Tuple(i+1,j));
			positions.add(new Tuple(i,j-1));
			positions.add(new Tuple(i,j+1));
			for (Tuple pos : positions) {
				int indexI = (int) pos.getI();
				int indexJ = (int) pos.getJ();
				if(indexI >= 0 && indexI < in.getH() && indexJ >= 0 && indexJ < in.getW()) {
					if(in.getFloor()[indexI][indexJ].getI().equals("_")) {
						Tuple t = Utility.indexMax(devNotUsed, dev);
						int index = (int) t.getI();
						profitTot += (int)t.getJ();
						if(index != -1) {
							Developer devMax = devNotUsed.remove(index);
							in.getFloor()[indexI][indexJ].setI("#");
							in.getDevelopers().get(devMax.getIndex()).setPosition(new Tuple(indexI,indexJ));
						}
					}
				}
			}
		}
		long timeend= System.currentTimeMillis();
		String payload = "";
		for (Developer developer : in.getDevelopers()) {
			if(developer.getPosition() == null) {
				payload += "X\r\n";
			}else {
				payload += developer.getPosition().getJ() + " " + developer.getPosition().getI() + "\r\n";
			}
		}
		for (ProjectManager pm : in.getPms()) {
			if(pm.getPosition() == null) {
				payload += "X\r\n";
			}else {
				payload += pm.getPosition().getJ() + " " + pm.getPosition().getI() + "\r\n";
			}
		}
		Utility.writeFile(payload, "output\\" + filename + "_output.txt");	
		System.out.println("\r\n\r\nProfit:" + profitTot + "\r\rTime:" + (timeend-timeIn));
	}
}
