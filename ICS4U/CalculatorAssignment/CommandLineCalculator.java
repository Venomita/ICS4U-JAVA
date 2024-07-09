package CalculatorAssignment;
// Programmer: Hamza Paracha
// Date: April 7, 2024
// Program Description: This program implements a basic command-line calculator that evaluates arithmetic expressions.

import java.util.*;

public class CommandLineCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an expression: ");
        String input = scanner.nextLine();

        double result = evaluateExpression(input);
        System.out.println("Result: " + result);

        scanner.close();
    }

    // Function to evaluate the arithmetic expression
    public static double evaluateExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        
        // Stacks to store numbers and operators
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Loop through each token in the expression
        for (String token : tokens) {
            if (token.matches("[0-9]+(\\.[0-9]+)?")) { // Check if token is a number
                numbers.push(Double.parseDouble(token));
            } else if (token.equals("^")) { // Handle exponentiation
                double exponent = numbers.pop();
                double base = numbers.pop();
                numbers.push(Math.pow(base, exponent));
            } else if (token.equals("sqrt")) { // Handle square root
                double num = numbers.pop();
                numbers.push(Math.sqrt(num));
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) { // Handle basic arithmetic operators
                while (!operators.isEmpty() && hasPrecedence(token.charAt(0), operators.peek())) {
                    performOperation(numbers, operators);
                }
                operators.push(token.charAt(0));
            }
        }

        // Evaluate remaining operators
        while (!operators.isEmpty()) {
            performOperation(numbers, operators);
        }

        return numbers.pop(); // Return the final result
    }

    // Function to check operator precedence
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    // Function to perform arithmetic operations
    public static void performOperation(Stack<Double> numbers, Stack<Character> operators) {
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        char op = operators.pop();
        switch (op) {
            case '+':
                numbers.push(num1 + num2);
                break;
            case '-':
                numbers.push(num1 - num2);
                break;
            case '*':
                numbers.push(num1 * num2);
                break;
            case '/':
                numbers.push(num1 / num2);
                break;
        }
    }
}
