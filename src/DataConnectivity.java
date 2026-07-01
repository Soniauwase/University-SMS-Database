import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class DataConnectivity {
    public static Connection getConnection() throws Exception{
        return  DriverManager.getConnection("jdbc:postgresql://localHost:5432/University SMS", "postgres", "Admin");
    }



}

