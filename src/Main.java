import java.util.List;
import java.util.Scanner;

public class Main {
    private final static StudentDAO studentDAO = new StudentDAO();
    private final static CourseDAO courseDAO = new CourseDAO();

    public static void main(String[] args)  {
        try {
            studentDAO.createTable();
            courseDAO.createTable();
            EnrollmentDAO.creatingTable();
            System.out.println("Table successfully created!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Scanner scanner=new Scanner(System.in);
        boolean running=true;
        while (running){
            printMenu();
            String choice= scanner.nextLine();
            try {
                switch (choice){
                    case "1" -> addStudent(scanner);
                    case "2" ->deleteStudent(scanner);
                    case "3" -> addCourse(scanner);
                    case "4" -> enrollingStudent(scanner);
                    case "5" -> viewAllStudent();
                    case "6" -> viewAllCourse();
                    case "7" -> viewStudentWithEnrolledCourse();
                    case "8" -> viewStudentById(scanner);
                    case "9" -> {
                        running=false;
                        System.out.println("thank you for visiting us,you are welcome again! ");

                    }
                    default -> System.out.println(" invalid input choose between 1 and 9 option");




                }

            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }

        }


    }
    public static void addStudent(Scanner scanner) {
        try {
            System.out.println(" enter student id");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println(" enter full name");
            String fullName = scanner.nextLine().trim();
            System.out.println(" enter the email");
            String email = scanner.nextLine().trim();
            System.out.println(" enter the phone Number");
            String phoneNumber = scanner.nextLine().trim();
            System.out.println(" enter the faculty");
            String faculty = scanner.nextLine().trim();
            System.out.println(" enter the department ");
            String department = scanner.nextLine().trim();

            studentDAO.insertStudent(id, fullName, email, phoneNumber, faculty, department);
            System.out.println("student" + fullName + " added successfully!");

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    public  static void deleteStudent(Scanner scanner) {
        try {
            System.out.println(" enter the ID of student you want to delete");
            int id = Integer.parseInt(scanner.nextLine());
            studentDAO.deleteStudent(id);
            System.out.println(" student with id:"+ id + "deleted sucessfully");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    public  static void addCourse(Scanner scanner) {
        try {
            System.out.println(" enter the course id");
            int course_id = Integer.parseInt(scanner.nextLine());
            System.out.println(" enter the course name ");
            String course_name = scanner.nextLine().trim();
            System.out.println(" enter course code");
            String course_code = scanner.nextLine().trim();
            System.out.println("enter course credit");
            int course_credit =Integer.parseInt(scanner.nextLine());
            courseDAO.insertCourse(course_id, course_name, course_code, course_credit);
            System.out.println("course " + course_name + " successfully added !");
            System.out.println(" course registered successfully !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static  void enrollingStudent(Scanner scanner) {
        try {
            System.out.println("  enter Enrollment id");
            int enrollmentId =Integer.parseInt(scanner.nextLine());
            System.out.println(" enter student id");
            int studentId = Integer.parseInt(scanner.nextLine());
            System.out.println(" enter course id");
            int courseId =Integer.parseInt(scanner.nextLine());
            EnrollmentDAO.insertDataInEnrollment(enrollmentId, studentId, courseId);
            System.out.println("student enrolled!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static  void viewAllStudent() {
        try {
            List<Student> allStudents = studentDAO.getAllStudents();
            if (allStudents.isEmpty()) {
                System.out.println(" no student yet !");
            }
            for (Student student : allStudents) {
                System.out.println(student.toString());
            }
            studentDAO.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewAllCourse() {
        try {
            List<Course> AllCourses = courseDAO.getAllEnrolledCourse();
            if (AllCourses.isEmpty()) {
                System.out.println(" no course enrolled yet!");
            }
            for (Course course : AllCourses) {
                System.out.println(course.toString());
            }
            courseDAO.getAllEnrolledCourse();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewStudentWithEnrolledCourse() {
        try {
            EnrollmentDAO.DisplayJoinedTable();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
    public  static  void viewStudentById(Scanner scanner) {
        try {
            System.out.println(" enter id of student you want to see");
            int id =Integer.parseInt(scanner.nextLine());
            Student student = studentDAO.getStudentById(id);
            if (student == null) {
                System.out.println(" no student found with this id:" + id);
            } else {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void printMenu() {
        System.out.println("""
                ==== University SMS ====
                1. Add student
                2. Remove student
                3. Add course
                4. Enroll student in course
                5. View all students
                6. View all courses
                7. View students with enrolled courses (JOIN)
                8. View student by id
                0. Exit
                Choose an option:""");
    }
}