package google.model;

import java.util.ArrayList;
import java.util.List;
import google.utility.Utility;

public class Input {
	private int numberClients;
	private List<Client> clients = new ArrayList<Client>();
	
	public Input() {
		super();
	}

	public int getNumberClients() {
		return numberClients;
	}

	public void setNumberClients(int numberClients) {
		this.numberClients = numberClients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Input [numberClients=" + numberClients + ", clients=" + Utility.toStringList(clients) + "]";
	}
	
}
