package travel_reminder;

import java.util.HashMap;

public class ENT_Client{
	private HashMap<String, String> clients = new HashMap<>();
	private HashMap<String, String> client_roles = new HashMap<>();

	public void initializeClients(){
		clients.put("Benita", "benita");
		client_roles.put("Benita", "user");
		clients.put("Karuna", "karuna");
		client_roles.put("Karuna", "user");
		clients.put("Sanidhya", "sanidhya");
		client_roles.put("Sanidhya", "driver");
		clients.put("Yash", "yash");
		client_roles.put("Yash", "driver");
		clients.put("Mayur", "mayur");
		client_roles.put("Mayur", "mayur");
	}
	public HashMap<String, String> getClients(){
		return this.clients;
	}
	public HashMap<String, String> getClientRoles(){
		return this.client_roles;
	}
}
