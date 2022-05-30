package homework.arrayutil.arraySort;

public class ArraySortDemo {
    public static void main(String[] args) {

        int[] numbers = {43, 55, 5, -9, 0, 12, 5, 65};
        ArraySort arraySort = new ArraySort();

        arraySort.arraySortMin(numbers);
        System.out.println();
        arraySort.arraySortMax(numbers);
    }
}
