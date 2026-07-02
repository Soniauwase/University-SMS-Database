import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EnrollmentDAO {
    public static  void creatingTable()throws Exception{
        String createSql= """
                create table Enrollment(
                id int primary key,
                student_id int,
                course_id int,
                foreign key (student_id )references student(id),
                foreign key (course_id)  references course(id)
                )
                """;
        Connection connection=DataConnectivity.getConnection();
        Statement statement=connection.createStatement();
        statement.execute(createSql);
        connection.close();
        statement.close();

    }
    public static void insertDataInEnrollment(int id, int student_id, int course_id)throws  Exception{
        String insertSql= """
                insert into Enrollment values(?,?,?)
                """;
        Connection connection=DataConnectivity.getConnection();
         PreparedStatement preparedStatement= connection.prepareStatement(insertSql);
         preparedStatement.setInt(1,id);
         preparedStatement.setInt(2,student_id);
         preparedStatement.setInt(3,course_id);
        preparedStatement.executeUpdate();
        connection.close();
        preparedStatement.close();

    }
    public static void DisplayJoinedTable ()throws Exception{
        String InnerJoin= """
                select fname,faculty,department,course_name  from student
                       inner join Enrollment
                       ON student.id=student_id
                      inner join course
                       ON course.id=course_id
                
                """;
        Connection connection=DataConnectivity.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(InnerJoin);
         ResultSet resultSet=preparedStatement.executeQuery();
         while (resultSet.next()){
                 System.out.println(
                                 "Full Name: " + resultSet.getString("fname") +
                                 ", Faculty: " + resultSet.getString("faculty") +
                                 ", Department: " + resultSet.getString("department") +
                                 ", Course: " + resultSet.getString("course_name")
                 );

         }
         preparedStatement.executeUpdate();
         preparedStatement.close();
         resultSet.close();
         connection.close();




    }
}
