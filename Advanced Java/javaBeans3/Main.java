// JavaBean class: Student.java
class Student {
    private String name;
    private int marks;
    private boolean passed;

    // No-argument constructor
    public Student() {
        this.name = "";
        this.marks = 0;
        this.passed = false;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
        // Automatically set pass status based on marks
        this.passed = marks >= 40;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public boolean isPassed() {
        return passed;
    }
}

// Main testing class
public class Main {
    public static void main(String[] args) {
        // Create student object
        Student s1 = new Student();

        // Set values
        s1.setName("Ridhim");
        s1.setMarks(45); // Passed because >= 40

        // Display results
        System.out.println("Student Result:");
        System.out.println("Name: " + s1.getName());
        System.out.println("Marks: " + s1.getMarks());
        System.out.println("Passed: " + (s1.isPassed() ? "Yes ✅" : "No ❌"));

        // Let's try another student
        Student s2 = new Student();
        s2.setName("Rahul");
        s2.setMarks(32); // Failed

        System.out.println("\nStudent Result:");
        System.out.println("Name: " + s2.getName());
        System.out.println("Marks: " + s2.getMarks());
        System.out.println("Passed: " + (s2.isPassed() ? "Yes ✅" : "No ❌"));
    }
}

