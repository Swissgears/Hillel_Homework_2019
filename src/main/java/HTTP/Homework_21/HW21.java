package HTTP.Homework_21;

public class HW21 {
    public static void main(String[] args) {
        String fileName = "test_users.json";
        FileStorage fileStorage = new FileStorage(fileName);

        System.out.println("Create few users");
        fileStorage.addUser(new User("Ivan", 25));      //0
        fileStorage.addUser(new User("Sergey", 30));    //1
        fileStorage.addUser(new User("Yulia", 20));     //2
        fileStorage.addUser(new User("Olga", 35));      //3
        fileStorage.addUser(new User("Igor", 40));      //4
        fileStorage.addUser(new User("Igor", 45));      //already exist

        System.out.println("Print users");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Remove user 1");
        fileStorage.removeUser(1);
        System.out.println("Print users");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Remove user Viktoria");
        fileStorage.removeUserByName("Viktoria");

        System.out.println("Remove user Yulia");
        fileStorage.removeUserByName("Yulia");
        System.out.println("Print users");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Update user Viktoria");
        fileStorage.updateUser(new User("Viktoria", 18));

        System.out.println("Update user Ivan");
        fileStorage.updateUser(new User("Ivan", 28));
        System.out.println("Print users");
        System.out.println(fileStorage.getAllUsers().toString());

        System.out.println("Get user 0");
        User user = fileStorage.getUser(0);
        System.out.println(user.toString());

        System.out.println("Get all users");
        System.out.println(fileStorage.getAllUsers().toString());

            System.out.println("Remove all users");
            fileStorage.removeAll();
            System.out.println(fileStorage.getAllUsers().toString());
//        fileStorage.addUser(new User("Ivan", 25));      //0
//        fileStorage.addUser(new User("Sergey", 30));    //1
//        fileStorage.addUser(new User("Yulia", 20));     //2
//        fileStorage.addUser(new User("Olga", 35));      //3
//        fileStorage.addUser(new User("Igor", 40));      //4
//        System.out.println(fileStorage.getAllUsers().toString());
    }
}

/*
Есть класс User:

User {
 int id;
 String name;
 int age;
}

Написать интерфейс Storage, и класс FileStorage который в конструкторе принимает имя файла где будут храниться данные:

- void removeAll()

- void removeUser(int id)

- void removeUserByName(String name)

- void addUser(User user)

- void updateUser(User user)

- getUser(int id)

- List<User> getAllUsers()

Продемонстрирвоать работу всех методов.

Данные должны храниться в тектовом файле в формате JSON.

При добавлении метод addUser должен назначить User уникальный id - порядковый номер.
 */