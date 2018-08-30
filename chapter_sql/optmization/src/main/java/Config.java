import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Config {

    /** Имя файла базы данных */
    private String fileName;

    /**
     * Constructor
     * @param fileName
     */
    public Config(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return "jdbc:sqlite:" + fileName;
    }


    /**
     * Устанавливает соединение с базой
     * @return соеднинение
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(this.getUrl());
    }
}
