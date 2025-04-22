import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    int Add(int a, int b) throws RemoteException;  // Changed to return sum
}