
public class Main {
    public static void main(String[] args) throws Exception{
        IStudentDAO studentDAO=new StudentDAO();
        studentDAO.createTable();
         studentDAO.updateTable();
         studentDAO.deleteStudent(101);
         studentDAO.getAllStudents();
         studentDAO.insertStudent(110,"UMUHIRE CLAIRE Nadia","nadiaumuhire@gmail.com","0798567880"," Management","Hotel Management");
         studentDAO.getStudentById(102);
         ICourseDAO courseDAO=new CourseDAO();
         courseDAO.createTable();
         courseDAO.getAllEnrolledCourse();
         courseDAO.insertCourse(10,"Computer Mantainance","INSY8115",3);


         EnrollmentDAO.DisplayJoinedTable();
        EnrollmentDAO.insertDataInEnrollment();
        EnrollmentDAO.creatingTable();
    }
};