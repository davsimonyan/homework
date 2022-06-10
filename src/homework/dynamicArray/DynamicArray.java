package homework.dynamicArray;

public class DynamicArray {

    private int[] array = new int[10];
    private int size = 0;


    public void add(int valeu) {
        if (size == array.length) {
            isEsempti();
        }
        array[size++] = valeu;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }

    }

    private void isEsempti() {
        if (size == array.length) {
            int[] temp = new int[array.length + 10];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

}
