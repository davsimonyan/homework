package homework.calcurator;

public class CalculatorDemo {
    public static void main(String[] args) {

        Calcurator calcurator = new Calcurator();
        System.out.println(calcurator.plus(5, 10));
        System.out.println(calcurator.minus(15, 10));
        System.out.println(calcurator.multiply(2, 5));
        System.out.println(calcurator.divide(10, 2));

    }
}
