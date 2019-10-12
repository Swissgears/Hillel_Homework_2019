package http.homework_22_H2;

public class HW_22 {

    public static void main(String[] args) {

        FileStorage fileStorage = new FileStorage();
        fileStorage.createTable();

        fileStorage.addUser(new User(0, "Ivan", 25));
        fileStorage.addUser(new User(0, "Sergey", 30));
        fileStorage.addUser(new User(0, "julia", 20));
        fileStorage.addUser(new User(0, "Olga", 35));
        fileStorage.addUser(new User(0, "Igor", 40));

        System.out.println("Print users");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Remove user 3");
        fileStorage.removeUser(3);
        System.out.println("Print users");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Remove user Oleg");
        fileStorage.removeUserByName("Oleg");
        System.out.println("Remove user Ivan");
        fileStorage.removeUserByName("Ivan");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Update user Sergey");
        fileStorage.updateUser(new User(0, "Sergey", 18));
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Get user 4");
        User user = fileStorage.getUser(4);
        System.out.println(user.toString());

        System.out.println("Get all users");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Remove all users");
        fileStorage.removeAll();

    }
}


/*
Есть класс User:

class User {
 int id;
 String name;
 int age;
}

id - autoincrement
Взять тот же интерфейс Storage что и в предыдущем задании, и написать реализацию с использованием базы данных(на выбор DJBC/Hibernate, H2/Postgress/Mysql):

- void removeAll()

- void removeUser(int id)

- void removeUserByName(String name)

- void addUser(User user)

- void updateUser(User user)

- User getUser(int id)

- List<User> getAllUsers()

Продемонстрирвоать работу всех методов.
 */