package travel_reminder;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CNT_ISourceDest  extends Remote{
	public void setSourceIndex(int s_index) throws RemoteException;
  public void setDestIndex(int d_index) throws RemoteException;
  public int getSourceIndex() throws RemoteException;
  public int getDestIndex() throws RemoteException;
  public boolean validateLocation(ENT_Location imapObj, String source, String destination) throws RemoteException;
  public void getSourceDest(ENT_Location imapObj)throws RemoteException;
}
