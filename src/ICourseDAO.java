import java.util.List;

public interface ICourseDAO {
    void createTable() throws Exception;
    void insertCourse(int id, String course_name, String course_code, int course_credit)throws Exception;
    List<Course> getAllEnrolledCourse() throws Exception;
}
