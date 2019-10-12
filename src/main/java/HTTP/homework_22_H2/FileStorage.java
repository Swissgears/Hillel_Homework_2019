package http.homework_22_H2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements Storage {

    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/User";
    private static final String USER = "test";
    private static final String PASSWORD = null;

    // создаю таблицу в БД
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS USERS(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), AGE INT)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(NAME, AGE) VALUES(?,?);")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.execute();

            System.out.println("Create user! " + user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int id) {

        List<User> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE ID =" + "'" + id + "'");

            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),
                        rs.getString("NAME"),
                        rs.getInt(3)));
            }
            if (list.size() == 0) { // если контакт найден list.size() = 1
                System.out.println("Contact with this ID is NOT FOUND!"); // отсутствие искомого контакта в БД
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),
                        rs.getString("NAME"),
                        rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateUser(User user) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE NAME =" + "'" + user.getName() + "'");
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),
                        rs.getString("NAME"),
                        rs.getInt("AGE")));
            }
            if (list.size() == 0) { // если контакт найден list.size() = 1
                System.out.println("This user is NOT FOUND!"); // отсутствие искомого контакта в БД
            } else {
                statement.executeUpdate("DELETE FROM users WHERE NAME =" + "'" + user.getName() + "'");
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(NAME, AGE) VALUES(?,?);");
                {

                    preparedStatement.setString(1, user.getName()); // присвоение контакту нового значения "имя"
                    preparedStatement.setInt(2, user.getAge()); // присвоение контакту нового значения "возраст"
                    preparedStatement.execute();
                    System.out.println("User is update!\n" + user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUser(int id) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE ID =" + "'" + id + "'");
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),
                        rs.getString("NAME"),
                        rs.getInt("AGE")));
            }
            if (list.size() == 0) { // если контакт найден list.size() = 1
                System.out.println("User with this ID is NOT FOUND!"); // отсутствие искомого контакта в БД
            } else {
                statement.executeUpdate("DELETE FROM users WHERE ID =" + "'" + id + "'");
                System.out.println("User with this ID is DELETE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserByName(String name) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE NAME =" + "'" + name + "'");
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),
                        rs.getString("NAME"),
                        rs.getInt("AGE")));
            }
            if (list.size() == 0) { // если контакт найден list.size() = 1
                System.out.println("User with this name is NOT FOUND!"); // отсутствие искомого контакта в БД
            } else {
                statement.executeUpdate("DELETE FROM users WHERE NAME =" + "'" + name + "'");
                System.out.println("User with this name is DELETE!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeAll() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE users");
            System.out.println("Table 'USERS' is DELETE!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
