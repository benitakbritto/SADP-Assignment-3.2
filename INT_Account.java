package travel_reminder;
import java.util.Scanner;

public class INT_Account{
	Scanner in;
	private String username="", password="";

	public void getUsernamePassword(){
		in = new Scanner(System.in);
		System.out.println("Enter your Username: ");
		this.username = in.nextLine();
		System.out.println("Enter password: ");
		this.password = in.nextLine();
		in.close();
	}

	public String getUsername(){
		return this.username;
	}

	public String getPassword(){
		return this.password;
	}
}
