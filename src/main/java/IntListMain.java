import java.util.Arrays;

public class IntListMain {

    public static void main(String[] args) {

        //IntList myList2 = new IntLinkedList();
        IntList myList = new IntArrayList();


        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }
        System.out.println(myList.toString());
        System.out.println("Количество элементов " + myList.size());
        System.out.println(myList.add(5, 9));
        System.out.println(myList.toString());
        System.out.println("Значение по индексу = " + myList.get(8));
        System.out.println(myList.isEmpty());
        System.out.println(myList.remove(3)) ;
        System.out.println(myList.toString());
        System.out.println(myList.removeByValue(5));
        System.out.println(myList.toString());
        System.out.println(myList.set(0, 7));
        System.out.println(myList.toString());
        System.out.println(Arrays.toString(myList.subList(4, 7)));
        myList.clear();
        System.out.println(myList.toString());
        System.out.println("Количество элементов " + myList.size());
    }

}

