package homework.braceChecker;

public class Stack {

    private int[] array = new int[10];
    private int size;

    public Stack() {
        size = -1;
    }

    public void push(int valeu) {
        if (size == array.length) {
            System.out.println("stack full");
        } else {
            array[++size] = valeu;
        }
    }

    public int pop() {
        if (size < 0) {
            return 0;
        } else {
            return array[size--];
        }
    }
}