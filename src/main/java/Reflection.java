
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        User user = new User("Tom", 25);

        String methodName = "";

        methodName = "SayName";
        Method getNameMethod = user.getClass().getMethod(methodName);
        String name = (String) getNameMethod.invoke(user);
        System.out.println(name);


        methodName = "SayAge";
        Method getAgeMethod = user.getClass().getMethod(methodName);
        int age = (int) getAgeMethod.invoke(user);
        System.out.println("I am " + age);

    }
}

/*
Создать класс с несколькими методами.
Вызвать метод по имени заданном как строка используя рефлексию
 */