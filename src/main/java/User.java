public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String SayName() {
       return "Hello! My name is " + name + "!";
    }

    public int SayAge() {
      return age;
    }
}

