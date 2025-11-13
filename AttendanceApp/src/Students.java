import java.util.*;

class Students {
    protected String name;
    protected int id;
    protected List<Integer> marks; // 6 marks for each student

    public Students(String name, int id) {
        this.name = name;
        this.id = id;
        this.marks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    // Calculate average marks
    public double getAverageMarks() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.size();
    }

    // Convert average marks to Grade
    public String getGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
}