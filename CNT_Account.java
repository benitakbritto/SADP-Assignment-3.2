package travel_reminder;

import java.util.HashMap;

public class CNT_Account implements CNT_IAccount {
	INT_Account i;
	ENT_Client e;

	public CNT_Account(INT_Account i, ENT_Client e){
		this.i = i;
		this.e = e;
	}

	public boolean validateLoginInfo(String username, String password){
		HashMap<String, String> clients, client_roles;
		clients= e.getClients();
		System.out.println(clients.size());
		client_roles = e.getClientRoles();

		if(clients.containsKey(username)){
			if(clients.get(username).equals(password)){
				System.out.println("Hello "+ username + "!");
				return true;
			}
			else{
				System.out.println("Incorrect password!");
			}
		}
		else{
			System.out.println("Incorrect Username");
		}
		return false;
	}
}
