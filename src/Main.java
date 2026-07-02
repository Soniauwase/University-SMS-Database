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
        String fullName= scanner.nextLine();
        System.out.println(" enter the email");
        String email= scanner.nextLine();
        System.out.println(" enter the phone Number");
        String phoneNumber= scanner.nextLine();
        System.out.println(" enter the faculty");
        String faculty=scanner.nextLine();
        System.out.println(" enter the department ");
        String department=scanner.nextLine();

        studentDAO.insertStudent(id,fullName,email,phoneNumber,faculty,department);
        System.out.println( "student"+ fullName +" added successfully!");

    }
    public  static  void deleteStudent(Scanner scanner) throws Exception {
        System.out.println(" enter the ID of student you want to delete");
        int id= scanner.nextInt();
        studentDAO.deleteStudent(id);
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