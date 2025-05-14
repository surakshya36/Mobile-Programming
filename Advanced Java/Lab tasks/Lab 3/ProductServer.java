import java.rmi.*;
import java.rmi.server.*;
public class ProductServer extends UnicastRemoteObject implements ProductService {
    public ProductServer() throws RemoteException {}
    public int calculateProduct(int a, int b) throws RemoteException {
        return a * b;
    }
    public static void main(String[] args) {
        try {
            ProductServer server = new ProductServer();
            Naming.rebind("ProductServer", server);
            System.out.println("ProductServer ready");
        } catch (Exception e) {
            System.err.println("ProductServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}