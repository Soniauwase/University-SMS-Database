
public class Main {
    public static void main(String[] args) throws Exception{
        EnrollmentDAO.DisplayJoinedTable();
        EnrollmentDAO.insertDataInEnrollment();
        EnrollmentDAO.creatingTable();
        System.out.println("table Enrollment created successfully!");

        System.out.println(CourseDAO.DisplayingAllCourse());
        StudentDAO.DeleteStudent(101);
        System.out.println(" student you want to delete deleted" );
        CourseDAO.insertCourse();
        System.out.println(" course inserted successfuly!");
        StudentDAO.InsertStudent();
        System.out.println("insertion went sucessfully!");


            StudentDAO.createTable();
            StudentDAO.updatingTable();
            CourseDAO.createTable();
            System.out.println("Table updated successfully.");

    }
};