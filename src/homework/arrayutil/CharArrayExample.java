package homework.arrayutil;

public class CharArrayExample {
    public static void main(String[] args) {

        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e' };
        char c = 'o';
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                count++;
            }
        }
        System.out.println(count);


        char[] chars2 = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e' };

        System.out.println(chars2[chars2.length / 2 - 1] + " " + chars2[chars2.length / 2]);


        char[] chars3 = {'j', 'a', 'v', 'a', 'l', 'o', 'l', 'y' };

        System.out.println(chars3[chars3.length - 2] == 'l' && chars3[chars3.length - 1] == 'y');


        char[] bobArray = {'b', 'a', 'b', 'o', 'l', 'a' };
        boolean contain = false;
        for (int i = 0; i < bobArray.length - 2; i++) {
            if (bobArray[i] == 'b' && bobArray[i + 2] == 'b') {
                contain = true;
            }
        }
        System.out.println(contain);


        char[] text = {' ', ' ', 'b', 'a', 'r', 'e', 'v', ' ', ' ' };

        for (int i = 0; i < text.length; i++) {
            if (text[i] != ' ') {
                System.out.print(text[i]);
            }
        }
    }
}
