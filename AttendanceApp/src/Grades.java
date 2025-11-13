import java.util.*;

class Grades extends Students {
    private Map<Integer, Students> students = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public Grades() {
        super("", 0); // dummy parent constructor
    }

    // Add a new student with 6 marks
    public void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        if (students.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        List<Integer> marks = new ArrayList<>();
        System.out.println("Enter 6 subject marks (0-100):");
        for (int i = 1; i <= 6; i++) {
            System.out.print("Subject " + i + ": ");
            int mark = sc.nextInt();
            if (mark < 0 || mark > 100) {
                System.out.println("Invalid mark entered! Try again.");
                i--; // repeat same subject input
                continue;
            }
            marks.add(mark);
        }

        Students s = new Students(name, id);
        s.setMarks(marks);
        students.put(id, s);

        System.out.println("Student added successfully!");
    }

    // View all students with average and grade
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Students s : students.values()) {
            double avg = s.getAverageMarks();
            String grade = s.getGrade(avg);

            System.out.println("\nID: " + s.getId() + ", Name: " + s.getName());
            System.out.println("Marks: " + s.getMarks());
            System.out.printf("Average: %.2f, Grade: %s\n", avg, grade);
            System.out.println("-----------------------------");
        }
    }
    
    public void checkStudentGrade() {
        System.out.print("Enter Student ID to check grade: ");
        int id = sc.nextInt();

        if (!students.containsKey(id)) {
            System.out.println("❌ Student not found!");
            return;
        }

        Students s = students.get(id);
        double avg = s.getAverageMarks();
        String grade = s.getGrade(avg);

        System.out.println("\n📘 Student Details:");
        System.out.println("Name: " + s.getName());
        System.out.printf("Average: %.2f\nGrade: %s\n", avg, grade);
    }
}
