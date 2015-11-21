import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by lukasz on 11.11.15.
 */
public class DatabaseConnector {

    Properties connectionProps;
    Connection conn;
    final String password = "root";
    final String username = "root";
    final String database = "localhost";
    public DatabaseConnector()
    {
        connectionProps = new Properties();
        connectionProps.put("user",this.username);
        connectionProps.put("password",this.password);
    }



    public Connection getConn() throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://"+this.database+"/",connectionProps);
        return conn;
    }


}
