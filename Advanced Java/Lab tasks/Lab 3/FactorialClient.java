import java.rmi.*;
import java.util.Scanner;
public class FactorialClient {
    public static void main(String[] args) {
        try {
            Factorial factorial = (Factorial)Naming.lookup("rmi://localhost/FactorialServer");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            System.out.println("Factorial of " + num + " is: " + factorial.calculateFactorial(num));
        } catch (Exception e) {
            System.err.println("FactorialClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
