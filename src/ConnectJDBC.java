import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String userName = "root";
    private String password = "";
    private String dbName = "test2";
    private String hostName = "localhost:3306";

    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionURL,userName,password);
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
