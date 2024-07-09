package StoreAssginment;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class hamzasstore {
    public hamzasstore() {
    }

    private String itemName;
    private int itemQuantity;
    private double itemPrice;

    public hamzasstore(String name, int quantity, double price) {
        itemName = name;
        itemQuantity = quantity;
        itemPrice = price;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double setItemPrice(double price) {
        itemPrice = price;
        return itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public double getTotalSales() {
        return Math.round((itemQuantity * itemPrice) * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hamza's Plug!");
        System.out.println("How many Shirts do you need?: ");
        int firstQuantity = scanner.nextInt();
        System.out.println("How many Pants do you need?: ");
        int secondQuantity = scanner.nextInt();
        System.out.println("How many Shoes do you need?: ");
        int thirdQuantity = scanner.nextInt();
        hamzasstore Shirts = new hamzasstore("Shirts", firstQuantity, 19.99);
        hamzasstore Pants = new hamzasstore("Pants", secondQuantity, 29.99);
        hamzasstore Shoes = new hamzasstore("Shoes", thirdQuantity, 49.99);
        System.out.println("********************************************************");
        System.out.println("            HAMZA'S PLUG            ");
        System.out.println("        456 Oak Street");
        System.out.println("      Cityville, State 54321");
        System.out.println("          987-654-3210");
        System.out.println("--------------------------------------------------------");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/Y hh:mm a");
        System.out.println(dateFormat.format(date));
        System.out.println("Cashier: Jane Doe");
        System.out.println("SUBTOTAL:");
        double finalShirts = Math.round((Shirts.getTotalSales() * 1.13) * 100.0) / 100.0;
        double finalPants = Math.round((Pants.getTotalSales() * 1.13) * 100.0) / 100.0;
        double finalShoes = Math.round((Shoes.getTotalSales() * 1.13) * 100.0) / 100.0;
        System.out.println("The cost of Shirts is: " + finalShirts);
        System.out.println("The cost of Pants is: " + finalPants);
        System.out.println("The cost of Shoes is: " + finalShoes);
        double subtotal = finalShirts + finalPants + finalShoes;
        double tax = Math.round((subtotal * 0.13) * 100.0) / 100.0;
        double total = Math.round((subtotal + tax) * 100.0) / 100.0;
        System.out.println("SUBTOTAL: $" + subtotal);
        System.out.println("TAX (13%): $" + tax);
        System.out.println("TOTAL: $" + total);
        System.out.println("--------------------------------------------------------");
        System.out.println("Thank you for shopping at HAMZA'S PLUG");
        System.out.println("We hope to see you again soon!");
        System.out.println("---------------------- RECEIPT -------------------------");
        System.out.println("Item         Quantity       Price       Total");
        System.out.println("--------------------------------------------------------");
        System.out.println(Shirts.itemName + "         " + Shirts.itemQuantity + "             $" + Shirts.itemPrice + "       $" + finalShirts);
        System.out.println(Pants.itemName + "         " + Pants.itemQuantity + "             $" + Pants.itemPrice + "       $" + finalPants);
        System.out.println(Shoes.itemName + "         " + Shoes.itemQuantity + "             $" + Shoes.itemPrice + "       $" + finalShoes);
        System.out.println("--------------------------------------------------------");
        System.out.println("SUBTOTAL:                                     $" + subtotal);
        System.out.println("TAX (13%):                                    $" + tax);
        System.out.println("TOTAL:                                        $" + total);
        System.out.println("--------------------------------------------------------");
        scanner.close();
    }
}
