package classcode;

import java.util.HashMap;
import java.util.Scanner;

public class ProductManager {

	// Method to find a product in the map
	public static void findProduct(HashMap<String, String> productCatalog, String name) {
		if (productCatalog.containsKey(name)) {
			System.out.println("Product found: " + name + " - " + productCatalog.get(name));
		} else {
			System.out.println("Product not found: " + name);
		}
	}

	// Method to add a product to the map
	public static void addProduct(HashMap<String, String> productCatalog, String name, String description) {
		productCatalog.put(name, description);
		System.out.println("Product added: " + name + " - " + description);
	}

	public static void main(String[] args) {
		// Create a new HashMap to hold food item names and their descriptions
		HashMap<String, String> productCatalog = new HashMap<>();

		// Predefined food items
		productCatalog.put("Apple", "A sweet, crunchy fruit that is rich in vitamins.");
		productCatalog.put("Banana", "A soft, sweet fruit with a high potassium content.");
		productCatalog.put("Carrot", "A root vegetable, usually orange, rich in beta-carotene.");
		productCatalog.put("Pasta", "A type of Italian food made from wheat, often served with sauce.");
		productCatalog.put("Pizza", "A flatbread topped with tomato sauce, cheese, and various toppings.");

		Scanner inputScanner = new Scanner(System.in);

		// Adding a new food item based on user input
		System.out.println("Enter a food item name to add: ");
		String newFoodName = inputScanner.nextLine();
		System.out.println("Enter a description for the new food item: ");
		String newFoodDescription = inputScanner.nextLine();
		addProduct(productCatalog, newFoodName, newFoodDescription);

		// Searching for a food item
		System.out.println("\nEnter a food item name to search for: ");
		String searchFoodName = inputScanner.nextLine();
		findProduct(productCatalog, searchFoodName);

		System.out.println(productCatalog);
		
		inputScanner.close();
	}
}
