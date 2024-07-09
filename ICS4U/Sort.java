// Programmer: Hamza Paracha
// Date: June 4, 2024
// Program Description: This program demonstrates basic sorting algorithms.


import java.util.Scanner;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter size of array:");
        System.out.println("1. 10");
        System.out.println("2. 100");
        System.out.println("3. 10000");
        
        int size = scanner.nextInt();
        
        if (size == 10 || size == 100 || size == 10000) {
            double[] array = generateArray(size);
            
            System.out.println("Generated array:");
            displayArray(array);
            
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Gnome Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Bogo Sort");
            System.out.println("6. Insertion Sort");
            
            int choice = scanner.nextInt();
            double startTime = System.nanoTime();
            
            switch (choice) {
                case 1:
                    bubbleSort(array);
                    break;
                case 2:
                    gnomeSort(array);
                    break;
                case 3:
                    quickSort(array, 0, array.length - 1);
                    break;
                case 4:
                    selectionSort(array);
                    break;
                case 5:
                    bogoSort(array);
                    break;
                case 6:
                    insertionSort(array);
                    break;
                default:
                    System.out.println("Invalid choice");
                    scanner.close();
                    return;
            }
            
            double endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1_000_000_000;
            
            System.out.println("Sorted array:");
            displayArray(array);
            System.out.println("Time to sort: " + totalTime + " seconds");
            
            scanner.close();
        } else {
            System.out.println("Error");
        }
    }

    public static double[] generateArray(int size) {
        Random random = new Random();
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.round(random.nextDouble() * 100000) / 100.0;
        }
        return array;
    }

    public static void displayArray(double[] array) {
        for (double v : array) {
            System.out.println(v);
        }
    }

    public static void bubbleSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void gnomeSort(double[] array) {
        int index = 1;
        while (index < array.length) {
            if (index == 0 || array[index] >= array[index - 1]) {
                index++;
            } else {
                double temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }

    public static void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        double temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void selectionSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            double temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    public static void bogoSort(double[] array) {
        while (!isSorted(array)) {
            shuffleArray(array);
        }
    }

    public static boolean isSorted(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void shuffleArray(double[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            double temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
