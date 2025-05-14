import java.rmi.Remote;
import java.rmi.RemoteException;
public interface StudentService extends Remote {
    StudentBean getStudent(String name, int age, String grade) throws RemoteException;
    String displayStudent(StudentBean student) throws RemoteException;
}