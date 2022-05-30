package homework.arrayutil.arrayUtil;

public class ArrayUtil {

    int arrayMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    int arrayMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }

        }
        return min;
    }

    int arrayEven(int[] array) {
        int even = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even++;
            }
        }
        return even;
    }

    int arrayOdd(int[] array) {
        int odd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                odd++;
            }
        }
        return odd;
    }

    int arrayCount(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count = count + array[i];
        }
        return count;
    }

}
