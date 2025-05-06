// JavaBean class (Employee.java)
class Employee {
    // 1. Private properties
    private String name;
    private int id;
    private double salary;

    // 2. Public no-argument constructor
    public Employee() {
        // Default values
        this.name = "Unknown";
        this.id = 0;
        this.salary = 0.0;
    }

    // 3. Getters (accessors)
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    // 4. Setters (mutators)
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

// Test class with main method 
public class Main {
    public static void main(String[] args) {
        // Creating object of JavaBean
        Employee emp = new Employee();

        // Setting properties
        emp.setName("Bishal");
        emp.setId(101);
        emp.setSalary(50000.50);

        // Getting properties
        System.out.println("Employee Details:");
        System.out.println("Name: " + emp.getName());
        System.out.println("ID: " + emp.getId());
        System.out.println("Salary: Rs. " + emp.getSalary());
    }
}

