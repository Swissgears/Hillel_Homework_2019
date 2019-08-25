import java.util.Arrays;

public class Iterator {

    private int[][] array;
    private int counter = -1;
    private int[] flatArray;

    public Iterator(int[][] array) {

        this.array = array;
    }

    public boolean hasNext() {
        int sumArray = 0;
        for (int row1 = 0; row1 < array.length; row1++) { // длина двумерного массива
            int sum = array[row1].length;
            sumArray = sumArray + sum;
        }
        flatArray = new int[sumArray];
        int count = 0;
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                flatArray[count++] = array[row][column]; // преобразование двумерного массива в одномерный
            }
        }
        Arrays.sort(flatArray);
        counter++;
        return counter < flatArray.length;
    }

    public int[] next() {
        return new int[]{flatArray[counter]};

    }
}
