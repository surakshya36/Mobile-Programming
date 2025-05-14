import java.rmi.Remote;
import java.rmi.RemoteException;
public interface ProductService extends Remote {
    int calculateProduct(int a, int b) throws RemoteException;
}
