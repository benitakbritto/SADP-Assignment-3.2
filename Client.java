import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import travel_reminder.*;

public class Client {
   private Client() {}
   public static void main(String[] args)
   {
      try
      {
         // Getting the registry
         Registry registry = LocateRegistry.getRegistry(null);

         // Looking up the registry for the remote object
         CNT_IAccount acc_stub = (CNT_IAccount) registry.lookup("CNT_IAccount");
         CNT_ISourceDest srcDst_stub = (CNT_ISourceDest) registry.lookup("CNT_ISourceDest");
         CNT_IETA eta_stub = (CNT_IETA) registry.lookup("CNT_IETA");
         CNT_iGPS gps_stub = (CNT_iGPS) registry.lookup("CNT_iGPS");

         // Calling the remote method using the obtained object
         INT_Account i = new INT_Account();
         ENT_Client e = new ENT_Client();
         i.getUsernamePassword();

        if(acc_stub.validateLoginInfo(i.getUsername(), i.getPassword())){
            ENT_Location Loc_Obj = new ENT_Location();
            srcDst_stub.getSourceDest(Loc_Obj);
            gps_stub.isGpsWeak();
            int source_index = srcDst_stub.getSourceIndex();
            int dest_index = srcDst_stub.getDestIndex();
            eta_stub.test_ETA(Loc_Obj.graph, source_index, dest_index);
            gps_stub.isGpsWeak();
        }
        else{
          System.exit(0);
        }
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
