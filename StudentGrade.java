import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;
    char grade;

    // Constructor to initialize student details
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);  // Calculate grade based on marks
    }

    // Method to calculate grade based on marks
    private char calculateGrade(double marks) {
        if (marks >= 90) return 'A';
        if (marks >= 80) return 'B';
        if (marks >= 70) return 'C';
        if (marks >= 60) return 'D';
        return 'F';
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an array to store student objects
        Student[] students = new Student[3];  // Assuming we are adding 3 students for simplicity

        // Taking student details as input
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter details for student " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Marks: ");
            double marks = sc.nextDouble();

            // Creating student object and adding to the array
            students[i] = new Student(id, name, marks);
            System.out.println();  // Blank line for better readability
        }

        // Displaying student details with grades
        System.out.println("\nStudent Details:");
        for (Student student : students) {
            System.out.println("ID: " + student.id + ", Name: " + student.name + ", Marks: " + student.marks + ", Grade: " + student.grade);
        }

        // Searching for a student by ID
        System.out.print("\nEnter ID to search for a student: ");
        int searchId = sc.nextInt();
        boolean found = false;
        for (Student student : students) {
            if (student.id == searchId) {
                System.out.println("Student Found: ID: " + student.id + ", Name: " + student.name + ", Marks: " + student.marks + ", Grade: " + student.grade);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }

        sc.close();
    }
}
