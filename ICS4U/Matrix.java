// Programmer: Hamza Paracha
// Date: June 4, 2024
// Program Description: This program inputs two matrices from the user, checks if they can be multiplied, and if possible, performs and displays the matrix multiplication result.

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first matrix:");
        int[][] matrix1 = inputMatrix(scanner); 
        System.out.println("First matrix:");
        printMatrix(matrix1);

        System.out.println("Enter the second matrix:");
        int[][] matrix2 = inputMatrix(scanner);
        System.out.println("Second matrix:");
        printMatrix(matrix2);

        if (canMultiply(matrix1, matrix2)) {
            int[][] result = multiplyMatrices(matrix1, matrix2);
            System.out.println("Result of multiplication:");
            printMatrix(result);
        } else {
            System.out.println("Error: matrices cannot be multiplied.");
        }

        scanner.close();
    }

    public static int[][] inputMatrix(Scanner scanner) {
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter number [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static boolean canMultiply(int[][] matrix1, int[][] matrix2) {
        return matrix1[0].length == matrix2.length;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
