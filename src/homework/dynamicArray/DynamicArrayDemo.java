package homework.dynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {


        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i <= 25; i++) {
            dynamicArray.add(i);
            dynamicArray.print();
        }
    }
}