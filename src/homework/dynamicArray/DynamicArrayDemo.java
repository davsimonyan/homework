package homework.dynamicArray;

public class DynamicArrayDemo {
    public static void main(String[] args) {


        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(42);
        dynamicArray.add(55);
        dynamicArray.add(900);
        dynamicArray.add(27);
        dynamicArray.add(62);
        dynamicArray.add(2);
        dynamicArray.add(4);
        dynamicArray.add(5);

        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray.getByIndex(4));
        System.out.println(dynamicArray.getFirstIndexByValue(2));
        dynamicArray.set(2, 500);
        dynamicArray.add(0, 9);
        dynamicArray.delete(1);
        dynamicArray.print();


    }
}
