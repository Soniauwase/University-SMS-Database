
import java.util.List;

    public interface IStudentDAO {
        void createTable() throws Exception;

        void updateTable() throws Exception;

        void insertStudent(int id, String fName, String email,
                           String phoneNumber, String faculty,
                           String department) throws Exception;

        void deleteStudent(int id) throws Exception;

        List<Student> getAllStudents() throws Exception;

        Student getStudentById(int id) throws Exception;
    }

