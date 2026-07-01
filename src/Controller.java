import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private List<Student> students;
    private List<Instructor> instructors;
    private List<Course> courses;
    private Map<Course, Instructor> courseAssignments;


    public Controller() {
        students = new ArrayList<>();
        instructors = new ArrayList<>();
        courses = new ArrayList<>();
        courseAssignments = new HashMap<>();
    }

    public void addingStudent(Student student) {
        students.add(student);
    }

    public void addingCourse(Course course) {
        courses.add(course);
    }

    public void addingInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    // Mapping the course to specific instructor
    public void assigningInstructor(Course course, Instructor instructor) {
        courseAssignments.put(course, instructor);
    }

    // enroll student in course
    public void enrollStudent(Student student, Course course) {
        student.enrollCourse(course);
        course.addingStudent(student);
    }

    // displaying all student
    public void displayStudents() {

        for (Student student : students) {
            System.out.println(student);
        }

    }

    //dispaly all courses
    public void displayCourse() {
        for (Course course : courses) {
            System.out.println(course);
        }

    }

    // display all instructors
    public void displayInstructors() {

        for (Instructor instructor : instructors) {
            System.out.println(instructor);
        }

    }

    // display the instructor teaching course
    public Instructor getInstructor(Course course) {
        return courseAssignments.get(course);
    }

    public void addStudent(UnderGraduate sonia) {

    }

    public void addInstructor(Instructor john) {

    }

    public void addCourse(Course oop) {

    }

    public void assignInstructor(Course oop, Instructor john) {

    }

    public class Main {
        public static void main(String[] args) {


            Controller controller = new Controller();
            UnderGraduate sonia = new UnderGraduate(1, "Sonia", "sonia@gmail.com", "798582090", "IT", "Software Engineering", 85, 78, 90
            );

            Instructor john = new Instructor(101, "John", "john@gmail.com", "788888888", "Senior Lecturer", "ICT"
            );

            Course oop = new Course(1, "Object Oriented Programming", "INSY8112", 4
            );

            controller.addStudent(sonia);

            controller.addInstructor(john);

            controller.addCourse(oop);

            controller.assignInstructor(oop, john);

            controller.enrollStudent(sonia, oop);
        }
    }
};


