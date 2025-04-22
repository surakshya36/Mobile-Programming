
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            // 1. Get RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // 2. Lookup remote object
            Hello stub = (Hello) registry.lookup("RMITest");
            
            // 3. Call remote method
            int result = stub.Add(5, 10);
            System.out.println("Result from server: " + result);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}