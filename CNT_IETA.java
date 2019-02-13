package travel_reminder;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CNT_IETA extends Remote{
    public int displayTime() throws RemoteException;
    public int displayDistance() throws RemoteException;
    public void test_ETA(int graph[][], int src_i, int dest_i) throws RemoteException;
}
