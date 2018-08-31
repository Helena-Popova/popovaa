package tracker;


import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Возьми класс Tracker  2. Реализовать класс Tracker [#396] и расширьте для него интерфейс
 * AutoCloseable
 * Необходимо заменить в классе Tracker хранение данных из массива в базу данных.
 * Настройки подключение базы данных и скрипты должны находиться в отдельном файле и считываться при старте.
 * Предусмотреть возможность, что структуры в базе еще нет. И вам нужно ее создать при старте.
 * Все ресурсы необходимо закрывай через try-with-resources
 * В классе трекер появляется новое поле private Connection connection. Его нужно закрывать через AutoCloseable.
 */

public class SqlConnection {
    private Connection conn;
    String url = "jdbc:postgresql://localhost/tracker?user=postgres&password=root";
    final static Logger LOGGER = Logger.getLogger(SqlConnection.class);

    public SqlConnection() {
        PreparedStatement st = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            st = conn.prepareStatement("CREATE TABLE if not EXISTS comments ( "
                    + " id serial NOT NULL,"
                    + "  description character varying(2000),"
                    + "  item_id integer)");
            st.executeUpdate();
            st = conn.prepareStatement("CREATE TABLE if not EXISTS item("
                    + " id serial NOT NULL,"
                    + "  name character varying(2000),"
                    + "  description character varying(2000),"
                    + "  created bigint)");
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int addItem(Item item) {
        PreparedStatement st = null;
        try (Connection conn = DriverManager.getConnection(url)) {
            st = conn.prepareStatement("insert into item(name, description, created)"
                    + " values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setLong(3, item.getCreated());
            st.executeUpdate();

            try (ResultSet rs = st.getGeneratedKeys()) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create nem item");
    }

    /**
     * Метод удаляет найденное по id значение из списка.
     *
     * @param id
     */
    public int delete(int id) {
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement st = conn.prepareStatement("delete from item  where id = ?", Statement.RETURN_GENERATED_KEYS)) {
            st.setInt(1, id);
            st.executeUpdate();
            try (ResultSet rs = st.getGeneratedKeys()) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not delete item");
    }

    /**
     * Возвращает все ненулевые элементы списка.
     *
     * @return список Item[]
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> itemsCopy = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement  st = conn.prepareStatement("select * from item");
            ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                itemsCopy.add(new Item(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getLong("created")));
            }
            return itemsCopy;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not find all item");
    }

    /**
     * Находит все эелементы в списке по ключю, вовращает массивом.
     *
     * @param key
     * @return найденные занчения.
     * @since 24.03.18 довалено условие,что если ничего не найденно,то возвращает нулевой элемент.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsCopy = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement  st = conn.prepareStatement("Select * from item where name = ?")) {
            st.setString(1, key);
            try (ResultSet rs = st.executeQuery();) {
                while (rs.next()) {
                    itemsCopy.add(new Item(rs.getInt("id"), rs.getString("name"),
                            rs.getString("description"), rs.getLong("created")));
                }
                return itemsCopy;
            } catch (SQLException e) {
                printLog(String.format("%s %s", e.getSQLState(), e.getMessage()));
            }
        } catch (SQLException e) {
            printLog(String.format("%s %s", e.getSQLState(), e.getMessage()));
        }
        throw new IllegalStateException("Could not find by name item");
    }

    /**
     * Находит первое попавшееся значение по id
     *
     * @param id
     * @return Item
     */
    public Item findById(int id) {
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement  st = conn.prepareStatement("Select * from item where id = ?")) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    return new Item(rs.getInt("id"), rs.getString("name"),
                            rs.getString("description"), rs.getLong("created"));
                }
            } catch (SQLException e) {
                printLog(String.format("%s %s", e.getSQLState(), e.getMessage()));
            }
        } catch (SQLException e) {
            printLog(String.format("%s %s", e.getSQLState(), e.getMessage()));
        }
        throw new IllegalStateException("Could not find by id item");
    }

    public int replace(int id, Item item) {
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement st = conn.prepareStatement("Update item set name = ? ,"
                    + "description = ?,"
                    + "created = ?"
                    + " where id = ?", Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setLong(3, item.getCreated());
            st.setInt(4, id);
            st.executeUpdate();
            try (ResultSet resultSet = st.getGeneratedKeys()) {
                while (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            } catch (SQLException e) {
                printLog(String.format("%s %s", e.getSQLState(), e.getMessage()));
            }
        } catch (SQLException e) {
            printLog(String.format("%s %s", e.getSQLState(), e.getMessage()));
        }
        throw new IllegalStateException("Could not update item");
    }

    public void printLog(String parameter) {
        LOGGER.warn("This is warn : " + parameter);
    }
}
