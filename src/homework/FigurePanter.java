package homework;

public class FigurePanter {

    public static void main(String[] args) {

        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         */

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("* ");
        }
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         */
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("* ");
        }

        /*\
         * * * * *
         * * * *
         * * *
         * *
         *
         */
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /*
         * * * *
         * * *
         * *
         *
         */

        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("  ");
            }
            for (int j = 3; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println("* ");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println("* ");
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println("* ");
        }
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         * * * *
         * * *
         * *
         *
         */

    }
}
