package homework.arrayutil;

public class ArrayUtil {

    public static void main(String[] args) {

        int[] array = {5, 4, 95, 62, 12, -21, 42, 5, 9, 13};
        int max = array[0];
        int min = array[0];
        int even = 0;
        int odd = 0;
        int amount = 0;
        int count = 0;

        System.out.print("մասիվի բոլոր էլեմենտները-");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("ամենամեծ թիվը=" + max);
        System.out.println("ամենափոքրը թիվը=" + min);

        System.out.print("զույգ էլեմենտները-");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even++;
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        System.out.print("կենտ էլեմենտները-");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                odd++;
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        System.out.println("զույգերի քանակը=" + even);
        System.out.println("կենտերի քանակը=" + odd);

        for (int i = 0; i < array.length; i++) {

            amount = amount + array[i];
            count++;
        }
        System.out.println("միջին թվաբանականը=" + amount / count);
        System.out.println("էլեմենտների գումարը=" + amount);


    }


}

