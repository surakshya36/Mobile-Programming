// JavaBean class with multiple features
class Student {
    private String name;
    private int rollNo;
    private int[] marks; // Indexed property for 5 subjects
    private boolean scholar;

    // Constructor
    public Student() {
        name = "";
        rollNo = 0;
        marks = new int[5];
        scholar = false;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setMarks(int index, int mark) {
        if (index >= 0 && index < marks.length) {
            marks[index] = mark;
            updateScholarshipStatus(); // Evaluate scholarship whenever a mark is set
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getMarks(int index) {
        return (index >= 0 && index < marks.length) ? marks[index] : -1;
    }

    public int[] getAllMarks() {
        return marks;
    }

    public double getAverage() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total / (double) marks.length;
    }

    public boolean isPassed() {
        for (int m : marks) {
            if (m < 40) return false;
        }
        return true;
    }

    public boolean isScholar() {
        return scholar;
    }

    private void updateScholarshipStatus() {
        scholar = getAverage() >= 90;
    }
}

// Main class to test the JavaBean
public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setName("Bishal");
        s.setRollNo(102);

        // Set marks
        int[] subjectMarks = {95, 90, 93, 92, 88};
        for (int i = 0; i < subjectMarks.length; i++) {
            s.setMarks(i, subjectMarks[i]);
        }

        // Display info
        String[] subjects = {"Math", "Science", "English", "Social", "Computer"};

        System.out.println("📄 Student Report Card");
        System.out.println("-------------------------");
        System.out.println("Name: " + s.getName());
        System.out.println("Roll No: " + s.getRollNo());

        System.out.println("\n📊 Subject-wise Marks:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + s.getMarks(i));
        }

        System.out.printf("\nAverage Marks: %.2f\n", s.getAverage());
        System.out.println("Result: " + (s.isPassed() ? "Pass ✅" : "Fail ❌"));
        System.out.println("Scholarship: " + (s.isScholar() ? "Eligible 🏅" : "Not Eligible"));
    }
}

