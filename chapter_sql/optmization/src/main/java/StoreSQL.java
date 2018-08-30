import xml.elements.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Генерация данных в SQLLite. Описывается классом StoreSQL
 * StoreSQL(Config) - Config - объект содержащий настройки для подключения к базе.
 *
 * @author Helena
 */
public class StoreSQL {

    private Config config;
    private final String tableName = "entry";

    private static final Logger LOG = Logger.getLogger(StoreSQL.class.getName());

    public StoreSQL(Config config) {
        this.config = config;
    }


    /**
     * Генерирует записи в таблице {@code entry}. Если таблицы нет, то создается и заполняется.
     * @param n максимальное значение для поля {@code field}
     */
    public void generate(int n) throws SQLException {
        try (Connection con = this.config.getConnection()) {
            con.setAutoCommit(false);
            try {
                this.connectDBandCreateTable(con);
                this.delete(con);
                this.fillEntryTable(con, n);
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            }
        }
    }



    private void connectDBandCreateTable(Connection con) throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS " + tableName + " ( field integer NOT NULL);";
        try (Statement st = con.createStatement()) {
            st.execute(createTable);
        }
    }

    /**
     * Если в таблице account
     * находились записи, то они удаляются перед вставкой.
     */
    public void delete(Connection con) {
        try (PreparedStatement ps = con.prepareStatement("delete from " + tableName)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void fillEntryTable(Connection con, int n) throws SQLException {
        String insertEntry = "INSERT INTO entry(field) VALUES (?);";
        try (PreparedStatement ps = con.prepareStatement(insertEntry)) {
            for (int i = 1; i <= n; i++) {
                ps.setInt(1, i);
                ps.executeUpdate();
            }
        }
    }

    public List<Entry> getAll() throws SQLException {
        List<Entry> result = new ArrayList<>();
        try (Connection con = this.config.getConnection()) {
            String select = "SELECT * FROM entry;";
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(select)) {
                while (rs.next()) {
                    result.add(new Entry(rs.getInt("field")));
                }
            }
        }
        return result;
    }

}
