import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements ICourseDAO {

    public void createTable() throws Exception {
        String createSql = """
                 CREATE TABLE IF NOT EXISTS course (
                id INT PRIMARY KEY,
                course_name VARCHAR(50),
                course_code VARCHAR(10) UNIQUE,
                course_credit int 
                )
                """;

        Connection connection = DataConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(createSql);


    }

    @Override
    public void insertCourse(int id, String course_name, String course_code, int course_credit) {
        try {
            String insertSql = """
                
                    insert into course values (?,?,?,?)
   

               """;

        Connection connection = DataConnectivity.
            getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, course_name);
        preparedStatement.setString(3, course_code);
        preparedStatement.setInt(4,course_credit );
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    } catch (Exception e) {
            e.printStackTrace();
        }
        }

    @Override
    public List<Course> getAllEnrolledCourse() throws Exception {
        String selectSql = """
                select  * from course;
                
                """;
        List<Course>courses=new ArrayList<>();
        Connection connection=DataConnectivity.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(selectSql);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            courses.add(new Course(resultSet.getInt("id"),resultSet.getString("course_name"),resultSet.getString("course_code"),resultSet.getInt("course_credit")));
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return courses;
    }

    };


