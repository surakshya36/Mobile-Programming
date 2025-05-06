// JavaBean class with indexed property
class Student {
    private String name;
    private int[] marks; // Indexed property for 5 subjects

    // No-arg constructor
    public Student() {
        this.name = "";
        this.marks = new int[5]; // Assuming 5 subjects
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int index, int mark) {
        if (index >= 0 && index < marks.length) {
            marks[index] = mark;
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMarks(int index) {
        if (index >= 0 && index < marks.length) {
            return marks[index];
        } else {
            return -1; // Invalid index
        }
    }

    public int[] getAllMarks() {
        return marks;
    }
}

// Main class to test the JavaBean
public class Main {
    public static void main(String[] args) {
        // Create a Student bean object
        Student student = new Student();
        student.setName("Bishal");

        // Set marks for 5 subjects using indexed property
        student.setMarks(0, 85); // Math
        student.setMarks(1, 78); // Science
        student.setMarks(2, 92); // English
        student.setMarks(3, 88); // Social Studies
        student.setMarks(4, 80); // Computer

        // Display student information
        System.out.println("Student Name: " + student.getName());
        System.out.println("Subject-wise Marks:");

        String[] subjects = { "Math", "Science", "English", "Social", "Computer" };
        int total = 0;

        for (int i = 0; i < 5; i++) {
            int mark = student.getMarks(i);
            System.out.println(subjects[i] + ": " + mark);
            total += mark;
        }

        double average = total / 5.0;
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Result: " + (average >= 40 ? "Pass ✅" : "Fail ❌"));
    }
}

