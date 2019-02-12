import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import travel_reminder.*;

/*public class Server implements CNT_iAccount,CNT_iSourceDest, CNT_iEta, CNT_iMap, CNT_iGPS{*/

public class Server implements CNT_IAccount{
   public Server() {}

   public boolean validateLoginInfo(String username, String password)
  {
            return true;
  }

   public static void main(String args[])
   {
      try {
         // Instantiating the implementation class
        INT_Account i = new INT_Account();
         ENT_Client e = new ENT_Client();
         CNT_IAccount acc_obj = new CNT_Account(i, e);
       /*  CNT_iSourceDest srcDst_obj = new CNT_SourceDest();
         CNT_iEta eta_obj = new CNT_Eta();
         CNT_iMap map_obj = new CNT_Map();
         CNT_iGPS gps_obj = new CNT_GPS();*/


         /* Exporting the object of implementation class
          (here we are exporting the remote object to the stub)*/
         CNT_IAccount acc_stub =  (CNT_IAccount) UnicastRemoteObject.exportObject(acc_obj, 0);
        /* CNT_SourceDest srcDst_stub =  (CNT_SourceDest) UnicastRemoteObject.exportObject(srcDst_obj, 0);         CNT_Account acc_stub =  (CNT_Account) UnicastRemoteObject.exportObject(acc_obj, 0);
         CNT_Eta eta_stub =  (CNT_Eta) UnicastRemoteObject.exportObject(eta_obj, 0);
         CNT_Map map_stub =  (CNT_Map) UnicastRemoteObject.exportObject(map_obj, 0);
         CNT_GPS gps_stub =  (CNT_GPS) UnicastRemoteObject.exportObject(gps_obj, 0);*/

         // Binding the remote object (stub) in the registry
         Registry registry = LocateRegistry.getRegistry();

         registry.bind("CNT_IAccount", acc_stub);
         /*registry.bind("CNT_SourceDest", srcDst_stub);
         registry.bind("CNT_Eta", eta_stub);
         registry.bind("CNT_Map", map_stub);
         registry.bind("CNT_GPS", gps_stub);*/

         


         System.err.println("Server ready");
      } catch (Exception e) {
         System.err.println("Server exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
