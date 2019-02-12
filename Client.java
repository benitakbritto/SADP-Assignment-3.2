import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import travel_reminder.*;

public class Client {
   private Client() {}
   public static void main(String[] args) {
      try {
         // Getting the registry
         Registry registry = LocateRegistry.getRegistry(null);

         // Looking up the registry for the remote object
         //Hello stub = (Hello) registry.lookup("Hello");
         CNT_Account acc_stub = (CNT_Account) registry.lookup("CNT_Account");
       /*  CNT_SourceDest srcDst_stub = (CNT_SourceDest) registry.lookup("CNT_SourceDest");
         CNT_Eta eta_stub = (CNT_Eta) registry.lookup("CNT_Eta");
         CNT_Map map_stub = (CNT_Map) registry.lookup("CNT_Map");
         CNT_GPS gps_stub = (CNT_GPS) registry.lookup("CNT_GPS");*/

         // Calling the remote method using the obtained object
        //CALL THE METHODS !!!!!!
         //stub.printMsg();
         //
         INT_Account i = new INT_Account();
         ENT_Client e = new ENT_Client();
         //CNT_IAccount c = new CNT_Account(i, e);

         i.getUsernamePassword();
         e.initializeClients();

      if(acc_stub.validateLoginInfo(i.getUsername(), i.getPassword()))
      {
        System.out.println("Inside if");
      }
      else
      {
        System.exit(0);
      }

         // System.out.println("Remote method invoked");
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
