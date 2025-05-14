import java.rmi.*;
import java.rmi.server.*;
public class StudentServer extends UnicastRemoteObject implements StudentService {
    public StudentServer() throws RemoteException {}
    public StudentBean getStudent(String name, int age, String grade) throws RemoteException {
        StudentBean student = new StudentBean();
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        return student;
    }
    public String displayStudent(StudentBean student) throws RemoteException {
        return "Student: " + student.getName() + 
               ", Age: " + student.getAge() + 
               ", Grade: " + student.getGrade();
    }
    public static void main(String[] args) {
        try {
            StudentServer server = new StudentServer();
            Naming.rebind("StudentServer", server);
            System.out.println("StudentServer ready");
        } catch (Exception e) {
            System.err.println("StudentServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}