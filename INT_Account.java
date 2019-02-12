package travel_reminder;

import java.util.Scanner;

public class INT_Account{
	Scanner in= new Scanner(System.in);
	private String username="", password="";

	public void getUsernamePassword(){
		System.out.println("Enter your Username: ");
		this.username = in.nextLine();
		System.out.println("Enter password: ");
		this.password = in.nextLine();
	}
	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return this.password;
	}
}
