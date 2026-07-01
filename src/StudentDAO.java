import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{

    public void createTable() throws Exception {
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
        System.out.println("table created successfully!");
    }

    @Override
    public void updateTable() throws Exception {
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
        System.out.println("table updated successfully!");

    }

     public void insertStudent(int id, String fName, String email,String phoneNumber, String faculty, String department) throws Exception{
        String insertSql= """
                insert into student values(?,?,?,?,?,?)
                
                """;
        Connection connection=DataConnectivity.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(insertSql);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,fName);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,phoneNumber);
        preparedStatement.setString(5,faculty);
        preparedStatement.setString(6,department);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();


    }

    @Override
    public void deleteStudent(int id) throws Exception {
        String DeleteSql= """
                Delete from  (student) where id=?
              ;
                """;
        Connection connection = DataConnectivity.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DeleteSql);
        preparedStatement.execute(DeleteSql);
        preparedStatement.setInt(1,102);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

    }

    @Override
    public List<Student> getAllStudents() throws Exception {
            String selectSql = "SELECT * FROM student";
            List<Student> students = new ArrayList<>();

            Connection connection = DataConnectivity.getConnection();
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("fName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("faculty"),
                        resultSet.getString("department")
                ));
            }

            resultSet.close();
            ps.close();
            connection.close();
            return students;
        }



    @Override
    public Student getStudentById(int id) throws Exception {
        String selectSql = "SELECT * FROM student WHERE id = ?";
        Student student = null;

        Connection connection = DataConnectivity.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            student = new Student(
                    resultSet.getInt("id"),
                    resultSet.getString("fName"),
                    resultSet.getString("email"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("faculty"),
                    resultSet.getString("department")
            );
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
        return student;
    }


    };


