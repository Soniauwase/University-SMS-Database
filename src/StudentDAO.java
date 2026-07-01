import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {

    public static void createTable() throws Exception {
        String createSql = """
                  CREATE TABLE IF NOT EXISTS student (
                id INT PRIMARY KEY,
                fName VARCHAR(50),
                email VARCHAR(25) UNIQUE,
                phoneNumber VARCHAR(10)
                
                )
                """;

        Connection connection = DataConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(createSql);
        statement.close();
        connection.close();
    }
    public static void updatingTable()throws Exception{
        String AlterSql= """
                ALTER TABLE student
                ADD COLUMN department Varchar(25),
                ADD COLUMN faculty varchar(25);
                """;
        Connection connection = DataConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(AlterSql);
        statement.close();
        connection.close();

    }
    public static  void InsertStudent() throws Exception{
        String insertSql= """
                insert into student values(?,?,?,?,?,?)
                
                """;
        Connection connection=DataConnectivity.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(insertSql);
        preparedStatement.setInt(1,105);
        preparedStatement.setString(2,"KEZA Darina");
        preparedStatement.setString(3,"keza50@gmail.com");
        preparedStatement.setString(4,"0793216160");
        preparedStatement.setString(5,"Hospitality");
        preparedStatement.setString(6,"Tourism");
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();


    }
    public  static  void DeleteStudent(int id) throws Exception {
        String DeleteSql= """
                Delete from ONLY (student) where id=101
              ;
                """;
        Connection connection = DataConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(DeleteSql);
    }
};