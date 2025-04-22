
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplExample extends UnicastRemoteObject implements Hello {
    
    public ImplExample() throws RemoteException {
        super();  // Calls UnicastRemoteObject constructor
    }
    
    public int Add(int x, int y) throws RemoteException {
        int sum = x + y;
        System.out.println("Calculating sum: " + x + " + " + y + " = " + sum);
        return sum;  // Return the sum to client
    }
}