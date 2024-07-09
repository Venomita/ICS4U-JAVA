package MyMathAssignment;
/* 
   name: hamza paracha
   date: february 28, 2024
   file: mymath.java

   description: mymath and main are the 
   two classes in this file. exponentiation, 
   tolerance-based number comparison, and 
   absolute value computation are all possible 
   with the help of the mymath class. the main 
   class uses user input for a variety of 
   calculations to show how to use mymath 
   functions.
*/
import java.util.Scanner;

public class MyMath {

    // method to calculate absolute value
    public static double calculateAbsoluteValue(double number) {
        return Math.abs(number);
    }

    // method to compare two numbers with a tolerance value
    public static boolean compare(double num1, double num2, double tolerance) {
        return Math.abs(num1 - num2) <= tolerance;
    }

    // method to calculate power of a number
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // main method for demonstration
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // getting user input for absolute value calculation
        System.out.print("enter a number to calculate absolute value: ");
        double inputNumber = scanner.nextDouble();
        double absoluteValueResult = calculateAbsoluteValue(inputNumber);
        System.out.println("absolute value: " + absoluteValueResult);

        // getting user input for number comparison with tolerance
        System.out.print("enter the first number to compare: ");
        double num1 = scanner.nextDouble();
        System.out.print("enter the second number to compare: ");
        double num2 = scanner.nextDouble();
        System.out.print("enter the tolerance value: ");
        double tolerance = scanner.nextDouble();
        boolean compareResult = compare(num1, num2, tolerance);
        System.out.println("comparison within tolerance: " + compareResult);

        // getting user input for exponentiation
        System.out.print("enter the base number for power calculation: ");
        double base = scanner.nextDouble();
        System.out.print("enter the exponent for power calculation: ");
        double exponent = scanner.nextDouble();
        double powerResult = power(base, exponent);
    
    }
}