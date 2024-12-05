package retail_store;

import java.util.Scanner;

public class RetailStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables for handling prices and totals
        double totalPrice = 0.0;
        double salesTaxRate = 0.1; 
        double discountRate = 0.05; 

        // Input for the number of items
        System.out.println("Retail Store System");
        System.out.println("Enter the number of items in your transaction:");
        int numberOfItems = scanner.nextInt();

        // Input and calculations for each item
        for (int i = 1; i <= numberOfItems; i++) {
            System.out.println("Enter price for item " + i + ": ");
            double price = scanner.nextDouble(); // Item price

            System.out.println("Enter quantity for item " + i + ": ");
            int quantity = scanner.nextInt(); // Item quantity

            // Add to total price
            totalPrice += price * quantity;
        }

        // Calculate sales tax and discount
        double salesTax = totalPrice * salesTaxRate;
        double discount = totalPrice * discountRate;

        // Final total after applying sales tax and discount
        double finalTotal = totalPrice + salesTax - discount;

        // Output the results
        System.out.printf("\nTotal Price (before tax and discount): $%.2f\n", totalPrice);
        System.out.printf("Sales Tax (10%%): $%.2f\n", salesTax);
        System.out.printf("Discount (5%%): -$%.2f\n", discount);
        System.out.printf("Final Total Price: $%.2f\n", finalTotal);

        scanner.close();
    }
}
