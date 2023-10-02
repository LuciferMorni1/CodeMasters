package StudentGradeTracker;
//--STUDENT GRADE TRACKER--//
import java.util.Scanner;
class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }
}

class GradeTracker {
    private Student student;

    public GradeTracker(Student student) {
        this.student = student;
    }

    public double calculateAverage() {
        int[] grades = student.getGrades();
        if (grades.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public void displayReport() {
        System.out.println("Student Name: " + student.getName());
        System.out.println("Grades: " + arrayToString(student.getGrades()));
        System.out.println("Average Score: " + calculateAverage());
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}

public class Project1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        int[] grades = new int[numGrades];

        System.out.println("Enter the grades:");
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        Student student = new Student(studentName, grades);
        GradeTracker gradeTracker = new GradeTracker(student);

        System.out.println("\nGenerating report...");
        gradeTracker.displayReport();
    }
}
