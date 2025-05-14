import java.rmi.*;
import java.rmi.server.*;

public class MathServer extends UnicastRemoteObject implements MathOperations {
    public MathServer() throws RemoteException {}
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }
    public int difference(int a, int b) throws RemoteException {
        return a - b;
    }
    public static void main(String[] args) {
        try {
            MathServer server = new MathServer();
            Naming.rebind("MathServer", server);
            System.out.println("MathServer ready");
        } catch (Exception e) {
            System.err.println("MathServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}