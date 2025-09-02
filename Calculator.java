import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    // basic ops
    static double add(double a, double b)      { return a + b; }
    static double sub(double a, double b)      { return a - b; }
    static double mul(double a, double b)      { return a * b; }
    static double div(double a, double b) {
        if (b == 0.0) throw new ArithmeticException("cannot divide by zero");
        return a / b;
    }
    static double pow(double a, double b)      { return Math.pow(a, b); }
    static double sqrt(double a) {
        if (a < 0.0) throw new ArithmeticException("cannot sqrt a negative");
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Calculator ===");
            System.out.println("1) add");
            System.out.println("2) subtract");
            System.out.println("3) multiply");
            System.out.println("4) divide");
            System.out.println("5) power");
            System.out.println("6) square root");
            System.out.println("7) exit");
            System.out.print("choose: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("enter a number from 1 to 7");
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> {
                        double a = readDouble(sc, "a");
                        double b = readDouble(sc, "b");
                        System.out.printf("result: %.6f%n", add(a, b));
                    }
                    case 2 -> {
                        double a = readDouble(sc, "a");
                        double b = readDouble(sc, "b");
                        System.out.printf("result: %.6f%n", sub(a, b));
                    }
                    case 3 -> {
                        double a = readDouble(sc, "a");
                        double b = readDouble(sc, "b");
                        System.out.printf("result: %.6f%n", mul(a, b));
                    }
                    case 4 -> {
                        double a = readDouble(sc, "a");
                        double b = readDouble(sc, "b");
                        System.out.printf("result: %.6f%n", div(a, b));
                    }
                    case 5 -> {
                        double a = readDouble(sc, "base");
                        double b = readDouble(sc, "exponent");
                        System.out.printf("result: %.6f%n", pow(a, b));
                    }
                    case 6 -> {
                        double a = readDouble(sc, "value");
                        System.out.printf("result: %.6f%n", sqrt(a));
                    }
                    case 7 -> {
                        System.out.println("bye");
                        return;
                    }
                    default -> System.out.println("enter a number from 1 to 7");
                }
            } catch (ArithmeticException e) {
                System.out.println("error: " + e.getMessage());
            }
        }
    }

    private static double readDouble(Scanner sc, String name) {
        while (true) {
            System.out.print(name + " = ");
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("enter a valid number");
            }
        }
    }
}
