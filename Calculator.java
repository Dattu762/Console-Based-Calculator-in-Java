import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    // Method to perform addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method to perform subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method to perform multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method to perform division with exception handling for divide by zero
    public static double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1 / num2;
    }

    // Method to display the menu and get user input
    public static void displayMenu() {
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            try {
                // Get first number from the user
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                // Get second number from the user
                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                // Display the operation menu
                displayMenu();
                System.out.print("Choose the operation (1-5): ");
                int operation = scanner.nextInt();

                double result = 0;

                switch (operation) {
                    case 1:
                        result = add(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        System.out.println("Result: " + result);
                        break;
                    case 4:
                        try {
                            result = divide(num1, num2);
                            System.out.println("Result: " + result);
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the calculator. Goodbye!");
                        continueCalculating = false;
                        break;
                    default:
                        System.out.println("Invalid operation. Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
                scanner.next(); // clear the invalid input
            }

            System.out.println(); // blank line for formatting
        }

        scanner.close();
    }
}
