package VendingMachineAssignment;
/*Name: Hamza Paracha
Date: February 25, 2024
File: VendingMachine.java

Description: This Java code simulates 
a vending machine. It creates instances 
for various products, prompts the user 
to choose one, and updates the inventory 
after a simulated purchase. The updated 
stock is then printed for each product.*/

import java.util.Scanner;
public class VendingMachine {
    private String productName;
    private double price;
    private final int maxQuantity = 50;
    private int currentStock;

    // constructor with no arguments
    public VendingMachine() {
        this.productName = "";
        this.price = 0.0;
        this.currentStock = maxQuantity;
    }

    // constructor with specified arguments
    public VendingMachine(String productName, double price) {
        this.productName = productName;
        this.price = price;
        this.currentStock = maxQuantity;
    }

    // getters and setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    // method to check total sales
    public double checkTotalSales(int cansSold) {
        return price * (maxQuantity - currentStock + cansSold);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        // creating 5 objects with different products
        VendingMachine sodaMachine = new VendingMachine("Soda", 1.50);
        VendingMachine chipsMachine = new VendingMachine("Chips", 1.75);
        VendingMachine candyMachine = new VendingMachine("Candy", 1.00);
        VendingMachine waterMachine = new VendingMachine("Water", 1.25);
        VendingMachine coffeeMachine = new VendingMachine("Coffee", 2.00);
    
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Choose a product to buy:");
    
        // displaying product options
        System.out.println("1. Soda");
        System.out.println("2. Chips");
        System.out.println("3. Candy");
        System.out.println("4. Water");
        System.out.println("5. Coffee");
    
        // taking user input for product selection
        System.out.print("Enter the number corresponding to the product: ");
        int userChoice = scanner.nextInt();
    
        // updating inventory and printing the updated stock
        switch (userChoice) {
            case 1:
                System.out.println("You chose to buy Soda.");
                // assuming the user buys 1 can of soda
                int sodasBought = 1;
                sodaMachine.currentStock -= sodasBought;
                break;
            case 2:
                System.out.println("You chose to buy Chips.");
                // assuming the user buys 1 pack of chips
                int chipsBought = 1;
                chipsMachine.currentStock -= chipsBought;
                break;
            case 3:
                System.out.println("You chose to buy Candy.");
                // assuming the user buys 1 candy
                int candiesBought = 1;
                candyMachine.currentStock -= candiesBought;
                break;
            case 4:
                System.out.println("You chose to buy Water.");
                // assuming the user buys 1 bottle of water
                int waterBought = 1;
                waterMachine.currentStock -= waterBought;
                break;
            case 5:
                System.out.println("You chose to buy Coffee.");
                // assuming the user buys 1 cup of coffee
                int coffeeBought = 1;
                coffeeMachine.currentStock -= coffeeBought;
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid product.");
        }
    
        // asking the user if they want to retrieve the current stock
        System.out.print("Do you want to retrieve the current stock for the selected product? (yes/no): ");
        String retrieveStockChoice = scanner.next().toLowerCase();
    
        // checking users choice to retrieve the current stock
        if (retrieveStockChoice.equals("yes")) {
            // Printing the updated stock
            System.out.println("Updated Inventory:");
            System.out.println("Soda Stock: " + sodaMachine.getCurrentStock());
            System.out.println("Chips Stock: " + chipsMachine.getCurrentStock());
            System.out.println("Candy Stock: " + candyMachine.getCurrentStock());
            System.out.println("Water Stock: " + waterMachine.getCurrentStock());
            System.out.println("Coffee Stock: " + coffeeMachine.getCurrentStock());
        }
    
        // close the scanner
        scanner.close();
    }
}