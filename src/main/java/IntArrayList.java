import java.util.Arrays;

public class IntArrayList implements IntList {

    private int[] arr = new int[10];
    private int size = 0;

    @Override
    public void add(int element) {
        if (size >= arr.length) {
            int newSize = arr.length * 3 / 2 + 1; //емкость массива
            int[] newArr = new int[newSize];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size] = element;
        size++;
    }

    @Override
    public boolean add(int index, int element) {
        if (size >= arr.length) {
            int newSize = arr.length * 3 / 2 + 1; //емкость массива
            int[] newArr = new int[newSize];

            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            System.arraycopy(arr, index, newArr, index + 1, size - index); //копировать массив
            newArr[index] = element;
            arr = newArr;
            size++;
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = 0;
        }
        size = 0;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public boolean isEmpty() { // Возвращает true, если этот список не содержит элементов.

        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {

        int numMoved = size - index - 1; // количество єлементов для копирования
        int[] newArr = new int[size];

        for (int i = 0; i < size; i++) { // наполняю второй массив значениями из первого
            newArr[i] = arr[i];
        }
        arr = newArr;
        System.arraycopy(arr, index + 1, newArr, index, numMoved); // копирую часть первого массива во второй
        /*
         У него 5 параметров:
           1 - из какого массива копировать
        2 - с какой позиции в 1 массиве
        3 - в какой массив копировать
        4 - в какую позицию во 2 массиве
        5 - сколько элементов
          */

        --size; // отсекаю последний єлемент
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        int counter = 0;
        for (int i = 0; i < size; i++) {

            if (arr[i] == value) {
                counter = arr[i];
                break;
            }
        }
        int numMoved = size - counter - 1; // количество єлементов для копирования
        int[] newArr = new int[size];

        for (int j = 0; j < size; j++) { // наполняю второй массив значениями из первого
            newArr[j] = arr[j];
        }
        arr = newArr;
        System.arraycopy(arr, counter + 1, newArr, counter, numMoved); // копирую часть первого массива во второй
        --size;
        return true;
    }

    @Override
    public boolean set(int index, int element) { // замена элемента по индексу
        arr[index] = element;
        return true;
        }

    @Override
    public int size() {
        return size; // возвращаю количество єлементов в массиве
    }

    @Override
    public int[] subList(int fromIndex, int toIndex) { // fromIndex - нижняя точка (включительно) подсписка, toIndex - верхняя точка (исключая) из подсписка

        int numMoved = toIndex - fromIndex; // количество єлементов для копирования
        int[] newArr = new int[numMoved];
        for (int i = 0; i < size; i++) {

            if (i == fromIndex) {
                System.arraycopy(arr, fromIndex, newArr, 0, numMoved); // копирую часть первого массива во второй
                break;
            }
        }
        return newArr;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}

