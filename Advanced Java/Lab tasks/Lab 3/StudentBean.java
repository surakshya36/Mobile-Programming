import java.io.Serializable;

public class StudentBean implements Serializable {
    private String name;
    private int age;
    private String grade;
    
    // Default constructor
    public StudentBean() {}
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public static void main(String[] args) {
        StudentBean student = new StudentBean();
        student.setName("John Doe");
        student.setAge(20);
        student.setGrade("A");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Grade: " + student.getGrade());
    }
}