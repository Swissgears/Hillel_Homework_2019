package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlRequest {

    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/User";
    private static final String USER = "test";
    private static final String PASSWORD = null;

    // создаю таблицу в БД
    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS GROUPS(ID INT PRIMARY KEY, name_Group VARCHAR(255))");
            statement.execute("CREATE TABLE IF NOT EXISTS STUDENTS(ID INT PRIMARY KEY, NAME VARCHAR(255), group_id int)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Student student) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students(ID, NAME, group_id) VALUES(?,?,?);")) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getGroup_id());
            preparedStatement.execute();

            System.out.println("Student added! " + student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addGroup(Group group) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO groups(ID, name_Group) VALUES(?,?);")) {
            preparedStatement.setInt(1, group.getId());
            preparedStatement.setString(2, group.getNameGroup());
            preparedStatement.execute();

            System.out.println("Group added! " + group);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getListStudents(String groupName) {  // Список студентов по названию группы
        List<Student> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from students as s inner join groups as g WHERE g.name_group =" + "'" + groupName + "'" + " AND s.group_id= g.id");
            System.out.println("Group name: " + groupName);
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt(1),
                        rs.getString("NAME"),
                        rs.getInt(3)));
                for (Student student : list) {
                    System.out.println(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getListGroups(String studentName) {  // Список групп по имени студента

        List<Group> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from groups as g inner join students as s WHERE s.name =" + "'" + studentName + "'" + "AND s.group_id= g.id");
            System.out.println("Student name: " + studentName);
            while (rs.next()) {
                list.add(new Group(
                        rs.getInt(1),
                        rs.getString("NAME_GROUP")));
                for (Group group : list) {
                    System.out.println(group);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAll() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE students");
            statement.executeUpdate("DROP TABLE groups");
            System.out.println("Table 'STUDENTS' is DELETE!");
            System.out.println("Table 'GROUP' is DELETE!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
Сделать 1 из 2 заданий на выбор:
a) Отношение 1:M
Создать несколько групп
Добавить несколько студентов в каждую группу
Список студентов по названию группы (в любом регистре)
b) Отношение M:M
Создать несколько групп
Добавить несколько студентов в каждую группу
Добавить студента в несколько групп
И записать в БД. Сделать запрос в БД и вывести:
Список студентов по названию группы (в любом регистре)
Список групп по имени студента (в любом регистре)
 */