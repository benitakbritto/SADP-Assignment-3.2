package travel_reminder;
import java.util.Scanner;
import java.io.*;

public class INT_SourceDest{
    public String source,destination;
    public String getSource(){
        System.out.println("-----------------------");
        System.out.println("Enter Source Location");
        Scanner s=new Scanner(System.in);
        String source=s.nextLine();
        return source;
    }
    public String getDest(){
        System.out.println("Enter Destination");
        Scanner s=new Scanner(System.in);

        String destination=s.nextLine();
        System.out.println("Validating information...");
        return destination;
    }

}
