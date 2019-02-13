package travel_reminder;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CNT_IAccount  extends Remote{
	boolean validateLoginInfo(String username, String password) throws RemoteException;
}
