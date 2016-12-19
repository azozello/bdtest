import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

class Connector {

    private final static String URL = "jdbc:mysql://localhost:3306/lnp";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private static Connection connection;
    private static Connector value;

    private Connector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            this.value = new Connector();
        }
    }

    static Connector getValue(){
        if (value==null){
            return new Connector();
        } else {
            return value;
        }
    }

    static Connection getConnection(){
        return connection;
    }
}
