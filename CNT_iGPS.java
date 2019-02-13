package travel_reminder;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.*;

public interface CNT_iGPS extends Remote{
  public void isGpsWeak() throws RemoteException;;
}
