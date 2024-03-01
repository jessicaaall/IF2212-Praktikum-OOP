import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            String op = sc.next();

            Calculator calcu = new Calculator();
            System.out.println(String.valueOf(calcu.calculate(x,y,op)));
        }

        catch (InvalidOperationException e) {
            System.out.println("InvalidOperationException! " + e.getMessage());
        }
        catch (InvalidDivisionByZero e) {
            System.out.println("InvalidDivisionByZero! " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Unknown exception!");
        }

        finally {
            System.out.println("Calculated.");
            sc.close();
        }
    }
}