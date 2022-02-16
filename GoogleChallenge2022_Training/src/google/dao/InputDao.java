package google.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import google.model.Client;
import google.model.Input;

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
	
	@SuppressWarnings("resource")
	public Input parser(String filepath) throws FileNotFoundException {
		File file = new File(filepath);
		Input in = new Input();
		Scanner s = new Scanner(file);
		String firstLine = s.nextLine();
		in.setNumberClients(Integer.parseInt(firstLine));
		while(s.hasNext()) {
			String line = s.nextLine();
			String[] split = line.split(" ");
			int numberLike = Integer.parseInt(split[0]);
			List<String> like = new ArrayList<String>(numberLike);
			for(int i=1; i <= numberLike; i++) {
				like.add(split[i]);
			}
			String line2 = s.nextLine();
			String[] split2 = line2.split(" ");
			int numberDisLike = Integer.parseInt(split2[0]);
			List<String> disLike = new ArrayList<String>(numberDisLike);
			for(int i=1; i <= numberDisLike; i++) {
				disLike.add(split2[i]);
			}
			in.getClients().add(new Client(numberLike, like, numberDisLike, disLike));
		}
		return in;	
	}
}
