import java.util.*;

public class GradingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grades tracker = new Grades();
        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student (Enter 6 Marks)");
            System.out.println("2. View All Students");
            System.out.println("3. Check Grade of a Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> tracker.addStudent();
                case 2 -> tracker.viewAllStudents();
                case 3 -> tracker.checkStudentGrade();
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}