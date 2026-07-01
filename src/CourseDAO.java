import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public static void createTable() throws Exception {
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

    public static void insertCourse() throws Exception {
        String insertSql = """
                insert into course values (?,?,?,?)
                """;

        Connection connection = DataConnectivity.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setInt(1, 7);
        preparedStatement.setString(2, "Language");
        preparedStatement.setString(3, "LLI 1999");
        preparedStatement.setInt(4, 3);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();


    }

    public static List<Course> DisplayingAllCourse() throws  Exception{
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
}


