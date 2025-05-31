
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentCourses {
    private String studentName;
    private Map<Integer, List<Course>> semesterCourses;

    public StudentCourses(String studentName) {
        this.studentName = studentName;
        this.semesterCourses = new HashMap<>();
    }

    public void addCourse(int semester, String courseName, int marks) {
        semesterCourses.putIfAbsent(semester, new ArrayList<>());
        semesterCourses.get(semester).add(new Course(courseName, marks));
    }

    public void displayCourses() {
        System.out.println("Courses and Marks for " + studentName + ":");
        for (int semester : semesterCourses.keySet()) {
            System.out.println("Semester " + semester + ":");
            for (Course c : semesterCourses.get(semester)) {
                System.out.println("  " + c.name + ": " + c.marks + " marks");
            }
        }
    }

    private static class Course {
        String name;
        int marks;

        public Course(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }


    public static void main(String[] args) {

        StudentCourses courses = new StudentCourses("Gaitri");
        courses.addCourse(1, "Mathematics", 85);
        courses.addCourse(1, "Physics", 90);
        courses.addCourse(2, "History", 88);
        courses.displayCourses();
    }
}
