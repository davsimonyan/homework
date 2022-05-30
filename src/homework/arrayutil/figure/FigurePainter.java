package homework.arrayutil.figure;

public class FigurePainter {

    char c;

    void figureOne(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(c + " ");
            }
            System.out.println(c + " ");
        }
    }

    void figureTwo(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(c + " ");
            }
            System.out.println(c + " ");
        }

    }

    void figureThree(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    void figureFour(char c) {
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("  ");
            }
            for (int j = 3; j > i; j--) {
                System.out.print(c + " ");
            }
            System.out.println(c + " ");
        }
    }

    void figureFive(char c) {
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(c + " ");
            }
            System.out.println(c + " ");
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print(c + " ");
            }
            System.out.println(c + " ");
        }
    }

}
