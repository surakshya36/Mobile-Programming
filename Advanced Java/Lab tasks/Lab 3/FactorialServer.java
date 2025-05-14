import java.rmi.*;
import java.rmi.server.*;
public class FactorialServer extends UnicastRemoteObject implements Factorial {
    public FactorialServer() throws RemoteException {}
    public long calculateFactorial(int n) throws RemoteException {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public static void main(String[] args) {
        try {
            FactorialServer server = new FactorialServer();
            Naming.rebind("FactorialServer", server);
            System.out.println("FactorialServer ready");
        } catch (Exception e) {
            System.err.println("FactorialServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}