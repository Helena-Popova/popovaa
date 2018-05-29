import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectDB {

    private static final String URL = "jdbc:mysql://localhost:3306/userlist";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    public void getConnect() {
        Connection connectionDB = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connectionDB = DriverManager.getConnection(URL, USER, PASSWORD);
            connectionDB.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ConnectDB model = new ConnectDB();
        model.getConnect();
    }
}
