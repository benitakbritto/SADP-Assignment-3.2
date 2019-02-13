import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import travel_reminder.*;

public class Server implements CNT_IAccount, CNT_ISourceDest, CNT_IETA, CNT_iGPS{

    public Server() {}

   public boolean validateLoginInfo(String username, String password){
        return true;
  }

    public void setSourceIndex(int s_index) {}
    public void setDestIndex(int d_index) {}
    public int getSourceIndex() { return 1;}
    public int getDestIndex() {return 1;}
    public boolean validateLocation(ENT_Location imapObj, String source, String destination) { return true;}
    public void getSourceDest(ENT_Location imapObj){}
    public int displayTime(){ return 1;}
    public int displayDistance(){return 1;}
    public void test_ETA(int graph[][], int src_i, int dest_i){}
    public void isGpsWeak(){}

    public static void main(String args[]){
      try {
         // Instantiating the implementation class
        INT_Account i = new INT_Account();
        ENT_Client e = new ENT_Client();
        CNT_IAccount acc_obj = new CNT_Account(i, e);
        CNT_ISourceDest srcDst_obj = new CNT_SourceDest();
        CNT_IETA eta_obj = new CNT_ETA();
        CNT_iGPS gps_obj = new CNT_GPS();

         // Exporting the object of implementation class
          //(here we are exporting the remote object to the stub)
        CNT_IAccount acc_stub =  (CNT_IAccount) UnicastRemoteObject.exportObject(acc_obj, 0);
        CNT_ISourceDest srcDst_stub =  (CNT_ISourceDest) UnicastRemoteObject.exportObject(srcDst_obj, 0);
        CNT_IETA eta_stub =  (CNT_IETA) UnicastRemoteObject.exportObject(eta_obj, 0);
        CNT_iGPS gps_stub =  (CNT_iGPS) UnicastRemoteObject.exportObject(gps_obj, 0);

         // Binding the remote object (stub) in the registry
         Registry registry = LocateRegistry.getRegistry();

         registry.bind("CNT_IAccount", acc_stub);
         registry.bind("CNT_ISourceDest", srcDst_stub);
         registry.bind("CNT_IETA", eta_stub);
         registry.bind("CNT_iGPS", gps_stub);

         System.err.println("Server ready");
      } catch (Exception e) {
         System.err.println("Server exception: " + e.toString());
         e.printStackTrace();
      }
   }
}
