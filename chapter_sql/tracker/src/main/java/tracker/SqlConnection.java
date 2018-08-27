package tracker;

import java.sql.*;
import java.util.ArrayList;

public class SqlConnection {
    private Connection conn;

    public SqlConnection() {
        getConnection();
        PreparedStatement st = null;
        try {
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
        } finally {
            close(st);
        }
    }


    private void getConnection() {
        String url = "jdbc:postgresql://localhost/tracker?user=postgres&password=root";
        try {
            conn = DriverManager.getConnection(url);
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
        getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into item(name, description, created)"
                    + " values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setLong(3, item.getCreated());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(st);
        }
        throw new IllegalStateException("Could not create nem item");
    }

    /**
     * Метод удаляет найденное по id значение из списка.
     *
     * @param id
     */
    public int delete(int id) {
        getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("delete from item  where id = ?", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, id);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(st);
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
        getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("select * from item");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                itemsCopy.add(new Item(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getLong("created")));
            }
            return itemsCopy;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(st);
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
        getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("Select * from item where name = ?");
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                itemsCopy.add(new Item(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getLong("created")));
            }
            return itemsCopy;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(st);
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
        getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("Select * from item where id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Item(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getLong("created"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(st);
        }
        throw new IllegalStateException("Could not find by id item");
    }

    public int replace(int id, Item item) {
        getConnection();
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("Update item set name = ? ,"
                    + "description = ?,"
                    + "created = ?"
                    + " where id = ?", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setLong(3, item.getCreated());
            st.setInt(4, id);
            st.executeUpdate();
            ResultSet resultSet = st.getGeneratedKeys();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(st);
        }
        throw new IllegalStateException("Could not update item");
    }


    private void close(PreparedStatement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

}
