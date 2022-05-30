package methodExample;

public class ArraySpaceExample {
    public static void main(String[] args) {
        char[] spaceArray = {' ', ' ', 'c', 'a', 't', ' ', ' ', 'b', 'i', ' ', 'b', ' ', ' ', ' ', ' ', ' ', ' ',};
        int first = 0;
        int last = 0;
        for (int i = 0; i < spaceArray.length; i++) {
            if (spaceArray[i] != ' ') {
                first = i;
                break;
            }
        }
        for (int i = spaceArray.length-1; i > 0; i--) {
            if (spaceArray[i] != ' ') {
                last = i;
                break;
            }
        }
        char[] chapter = new char[last - first + 1];
        for (int i = 0; i < chapter.length; i++) {
            chapter[i]=spaceArray[first++];
            System.out.print(chapter[i]);
        }
    }
}
