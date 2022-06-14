package homework.dynamicArray;

public class DynamicArray {

    private int[] array = new int[10];
    private int size = -1;


    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[++size] = value;
    }


    public void print() {
        for (int i = 0; i < size + 1; i++) {
            System.out.println(array[i]);
        }
    }


    private void extend() {
        if (size == array.length) {
            int[] temp = new int[array.length + 10];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }


    public boolean isEmpty() {
        if (size == -1) {
            return true;
        }
        return false;
    }


    public int getByIndex(int index) {
        if (index < array.length) {
            return array[index];
        }
        return 0;
    }


    public int getFirstIndexByValue(int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        return 0;
    }


    public int set(int index, int value) {
        if (index < array.length) {
            array[index] = value;
            return array[index];
        } else System.out.println("There is no such index");
        return 0;
    }


    public void add(int index, int value) {
        if (size == array.length) {
            extend();
        }
        if (index < array.length + 1) {
            for (int i = size + 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;
        } else System.out.println("There is no such index");
    }


    public void delete(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
}


