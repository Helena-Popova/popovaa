package sql;

import helper.Vacancy;

import java.sql.*;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

public class ConnectDB implements AutoCloseable {

    private Properties properties;
    private Connection connection;

    private final String url;
    private final String driver;
    private final String database;
    private final String tablename;
    private final String databasename;
    private final String username;
    private final String password;

    public ConnectDB(Properties properties) {
        this.properties = properties;
        this.url = this.properties.getProperty("jdbc.url");

        this.driver = String.format("jdbc:%s:",
                this.properties.getProperty("jdbc.driver"));
        this.database = this.properties.getProperty("jdbc.url");
        this.tablename = this.properties.getProperty("jdbc.tableName");
        this.databasename = this.properties.getProperty("jdbc.databaseName");
        this.username = this.properties.getProperty("jdbc.username");
        this.password = this.properties.getProperty("jdbc.password");
    }

    /**
     * подключается к базе дынных. если ее нет.то создает базу данных и таблицу
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean connect() throws SQLException, ClassNotFoundException {
        try {
            connection = DriverManager.getConnection(url + databasename, username, password);
        } catch (SQLException e0) {
            if ("3D000".equals(e0.getSQLState())) {
                try {
                    this.create();
                    System.out.println("create");
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        }
        return connection != null;
    }

    /**
     * сохдает базу данных
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private boolean create() throws SQLException, ClassNotFoundException {
        boolean result = false;
        // You'll need a PostgreSQL account with 'create database' privileges.
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url + databasename, username, password);
        Statement statement = connection.createStatement();
        result = statement.execute("CREATE DATABASE " + databasename);
        // Now close the default DB so that we can connect to the new DB.
        connection.close();
        this.connect();
        this.createTable();
        return result;
    }

    /**
     * удаляет базу данных
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void drop() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(url + databasename, username, password);
        Statement statement = connection.createStatement();
        statement.execute("drop DATABASE " + databasename);
        // Now close the default DB so that we can connect to the new DB.
        connection.close();
    }


    /**
     * создает таблицу
     * @throws SQLException
     */
    private void createTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS " + tablename + " ( "
                + "                id       serial primary key, "
                + "                descript text, "
                + "                dt       TIMESTAMP )";
        try (Statement st = connection.createStatement()) {
            st.execute(createTable);
        }
    }

    /**
     * вставляет данные
     * @param positions
     */
    public void insert(List<Vacancy> positions) {
        String query = String.format("INSERT INTO %s (descript, dt) VALUES (?, ?)", tablename);
        try (PreparedStatement prepared = this.connection.prepareStatement(query)) {
            for (Vacancy position : positions) {
                prepared.setString(1, position.getDescription());
                prepared.setTimestamp(2, new Timestamp(position.getDate().getTime()));
                prepared.executeUpdate();
            }
        } catch (SQLException exception) {
            if (!"23505".equals(exception.getSQLState())) {
                throw new RuntimeException(exception);
            }
        }
    }

    /**
     * выгружает n значений
     * @param n
     * @return
     * @throws SQLException
     */
    public List<Vacancy> getAllFirstN(int n) throws SQLException {
        List<Vacancy> result = new ArrayList<>();
        String query = String.format("select * from %s", tablename);
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next() && n > 0) {
                result.add(new Vacancy(rs.getString("descript"), new Date(rs.getTimestamp("dt").getTime())));
                n--;
            }
        }
        return result;
    }

    /**
     * выдает последнюю дату введенной в базу вакансии ,
     * если ничего нет. выдает дату годичной давности
     * @return
     */
    public Timestamp getLastTImeInsert() {
        String query = String.format("select max(dt) from  %s", tablename);
        Timestamp result;
        try (Statement statement = this.connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            result = rs.getTimestamp(1);
            if (result == null) {
                // one year ago
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.YEAR, -1);
                result = new Timestamp(calendar.getTimeInMillis());
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return result;
    }

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
