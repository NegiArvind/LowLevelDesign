import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    Connection mysqlConnection;

    DbConnection() {
        try {
            mysqlConnection = DriverManager.getConnection("url","user", "password");
        } catch (Exception exception) {
            // System.out.println("Exception while connecting with mysql " + exception);
        }
    }
}
