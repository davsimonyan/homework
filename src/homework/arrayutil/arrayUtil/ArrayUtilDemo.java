package homework.arrayutil.arrayUtil;

public class ArrayUtilDemo {
    public static void main(String[] args) {

        int[] array = {5, 4, 95, 62, 12, -21, 42, 5, 9, 13};

        ArrayUtil arrayUtil = new ArrayUtil();
        System.out.println(arrayUtil.arrayMax(array));
        System.out.println(arrayUtil.arrayMin(array));
        System.out.println(arrayUtil.arrayEven(array));
        System.out.println(arrayUtil.arrayOdd(array));
        System.out.println(arrayUtil.arrayCount(array));
    }
}
