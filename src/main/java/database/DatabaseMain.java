package database;

public class DatabaseMain {

    public static void main(String[] args) {

        SqlRequest.createTable();

        SqlRequest.addStudent(new Student(1, "Ivan", 1));
        SqlRequest.addStudent(new Student(2, "Sergey", 3));
        SqlRequest.addStudent(new Student(3, "julia", 2));
        SqlRequest.addStudent(new Student(4, "Olga", 3));
        SqlRequest.addStudent(new Student(5, "Igor", 1));

        SqlRequest.addGroup(new Group(1, "JAVA"));
        SqlRequest.addGroup(new Group(2, "C#"));
        SqlRequest.addGroup(new Group(3, "PHP"));

        SqlRequest.getListStudents("JAVA");
        SqlRequest.getListStudents("C#");
        SqlRequest.getListStudents("PHP");

        SqlRequest.getListGroups("Igor");
        SqlRequest.getListGroups("Sergey");
        SqlRequest.getListGroups("julia");
        SqlRequest.getListGroups("Vlad");

        SqlRequest.deleteAll();

    }
}

