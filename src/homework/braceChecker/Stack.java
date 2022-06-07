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

    public char pop() {
        if (size < 0) {
            return 0;
        } else {
            return (char) array[size--];
        }
    }

    public boolean isEmpty() {
        if (size == -1) {
            return true;
        }
        return false;

    }
}