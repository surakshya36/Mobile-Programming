import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class Server {
    public static void main(String args[]) {
        try {
            // Create RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Create remote object
            Hello stub = new ImplExample();
            
            // Bind the remote object
            registry.rebind("RMITest", stub);
            
            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}