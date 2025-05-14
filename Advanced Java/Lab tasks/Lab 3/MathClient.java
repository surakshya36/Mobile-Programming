import java.rmi.*;

public class MathClient {
    public static void main(String[] args) {
        try {
            MathOperations math = (MathOperations)Naming.lookup("rmi://localhost/MathServer");
            System.out.println("Sum (5,3): " + math.sum(5, 3));
            System.out.println("Difference (5,3): " + math.difference(5, 3));
        } catch (Exception e) {
            System.err.println("MathClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}