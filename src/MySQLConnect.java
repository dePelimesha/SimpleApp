import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnect {
    private static final String connectionURL = "jdbc:mysql://localhost:3306/dictionary?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "Dread322Solo";

    public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connectionURL, user, password);
        System.out.println("connected");
        return conn;
    }
}
