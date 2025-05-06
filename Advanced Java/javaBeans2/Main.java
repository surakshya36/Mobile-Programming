class Student {
    private String name;
    private int rollNo;
    private boolean passed; // boolean property

    // No-arg constructor
    public Student() {
        this.name = "";
        this.rollNo = 0;
        this.passed = false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    // For boolean, we can use "is" as getter
    public boolean isPassed() {
        return passed;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}

// Test class with main method
public class Main {
    public static void main(String[] args) {
        // Creating Student JavaBean object
        Student student = new Student();

        // Setting values
        student.setName("Ujjwal");
        student.setRollNo(7);
        student.setPassed(true);

        // Displaying values
        System.out.println("Student Info:");
        System.out.println("Name: " + student.getName());
        System.out.println("Roll No: " + student.getRollNo());
        System.out.println("Passed: " + (student.isPassed() ? "Yes" : "No"));
    }
}

