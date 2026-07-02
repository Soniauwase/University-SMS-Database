import java.util.List;
import java.util.Scanner;

public class Main {
    private final static IStudentDAO studentDAO = new StudentDAO();
    private final static ICourseDAO courseDAO = new CourseDAO();

    public static void main(String[] args) throws Exception {
        try {
            studentDAO.createTable();
            studentDAO.updateTable();
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
                        System.out.println("thank you for visiting us,you are welcome again ");
                    }
                    default -> System.out.println("invalid choice input,choose between number 1 to 9");


                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }


    }
    public static void addStudent(Scanner scanner) throws  Exception{
        System.out.println(" enter student id");
        int id= scanner.nextInt();
        System.out.println(" enter full name");
        String fullName= scanner.next();
        System.out.println(" enter the email");
        String email= scanner.next();
        System.out.println(" enter the phone Number");
        String phoneNumber=scanner.next();
        System.out.println(" enter the faculty");
        String faculty=scanner.next();
        System.out.println(" enter the department ");
        String department=scanner.next();

        studentDAO.insertStudent(id,fullName,email,phoneNumber,faculty,department);
        System.out.println( "student"+ fullName +" added successfully!");

    }
    public  static  void deleteStudent(Scanner scanner) throws Exception {
        System.out.println(" enter the ID of student you want to delete");
        int id= scanner.nextInt();
        studentDAO.deleteStudent(id);
    }
    public  static void addCourse(Scanner scanner) throws Exception {
        System.out.println(" enter the course id");
        int course_id= scanner.nextInt();
        System.out.println(" enter the course name ");
        String course_name= scanner.next();
        System.out.println(" enter course code");
        String course_code=scanner.next();
        System.out.println("enter course credit");
        int course_credit= scanner.nextInt();
        courseDAO.insertCourse(course_id,course_name,course_code,course_credit);
        System.out.println("course " + course_name + " successfully added !");
    }
    public  static  void enrollingStudent(Scanner scanner) throws Exception {
        System.out.println("  enter Enrollment id");
         int enrollmentId=scanner.nextInt();
        System.out.println(" enter student id");
        int studentId = scanner.nextInt();
        System.out.println(" enter course id");
        int courseId= scanner.nextInt();
        EnrollmentDAO.insertDataInEnrollment(enrollmentId,studentId,courseId);
        System.out.println("student enrolled!");
    }
    public  static  void viewAllStudent() throws Exception {
        List< Student>allStudents=studentDAO.getAllStudents();
        if(allStudents.isEmpty()){
            System.out.println(" no student yet !");
        }
        for(Student student: allStudents){
            System.out.println(student.toString());
        }
        studentDAO.getAllStudents();
    }
    public static void viewAllCourse() throws Exception {
        List<Course>AllCourses=courseDAO.getAllEnrolledCourse();
        if(AllCourses.isEmpty()){
            System.out.println(" no course enrolled yet!");
        }
        for (Course course: AllCourses){
            System.out.println(course.toString());
        }
        courseDAO.getAllEnrolledCourse();


    }
    public static void viewStudentWithEnrolledCourse() throws Exception {
        EnrollmentDAO.DisplayJoinedTable();
    }
    public  static  void viewStudentById(Scanner scanner) throws Exception {
        System.out.println(" enter id of student you want to see");
        int id= scanner.nextInt();
         Student student=studentDAO.getStudentById(id);
         if (student==null){
             System.out.println(" no student found with this id:"+ id);
         }
         else {
             System.out.println(student);
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