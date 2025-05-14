import java.rmi.*;
import java.util.Scanner;
public class StudentClient {
    public static void main(String[] args) {
        try {
            StudentService service = (StudentService)Naming.lookup("rmi://localhost/StudentServer");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter student grade: ");
            String grade = scanner.nextLine();
            StudentBean student = service.getStudent(name, age, grade);
            System.out.println(service.displayStudent(student));
        } catch (Exception e) {
            System.err.println("StudentClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
