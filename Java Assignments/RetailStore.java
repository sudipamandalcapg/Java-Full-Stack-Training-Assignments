package retail_store;

import java.util.Scanner;

class Item {
	// Price and quantity of an item
	private double price;
	private int quantity;

	// Constructor
	public Item(double price, int quantity) {
		this.price = price;
		this.quantity = quantity;
	}

	// Getters for price and quantity
	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
}

public class RetailStore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Variables for handling prices and totals
		double totalPrice = 0.0;
		double salesTaxRate = 0.1; // Example: 10% sales tax
		double discountRate = 0.05; // Example: 5% discount

		// Menu options
		System.out.println("Retail Store System");
		System.out.println("Enter the number of items in your transaction:");
		int numberOfItems = scanner.nextInt();

		Item[] items = new Item[numberOfItems];

		// Input item details
		for (int i = 0; i < numberOfItems; i++) {
			System.out.println("Enter price for item " + (i + 1) + ": ");
			double price = scanner.nextDouble();

			System.out.println("Enter quantity for item " + (i + 1) + ": ");
			int quantity = scanner.nextInt();

			items[i] = new Item(price, quantity);
		}

		// Calculate the total price before tax or discounts
		for (Item item : items) {
			totalPrice += item.getPrice() * item.getQuantity();
		}

		// Calculate sales tax
		double salesTax = totalPrice * salesTaxRate;

		// Calculate discount
		double discount = totalPrice * discountRate;

		// Final total after applying sales tax and discount
		double finalTotal = totalPrice + salesTax - discount;

		// Output the results
		System.out.println("\n===== Final Transaction Details =====");
		System.out.printf("Total Price (before tax and discount): $%.2f\n", totalPrice);
		System.out.printf("Sales Tax (10%%): $%.2f\n", salesTax);
		System.out.printf("Discount (5%%): -$%.2f\n", discount);
		System.out.printf("Final Total Price: $%.2f\n", finalTotal);

		scanner.close();
	}
}
