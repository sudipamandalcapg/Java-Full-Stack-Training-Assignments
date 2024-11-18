// Constructor for BakeryItem object
function BakeryItem(name, price, weight) {
    this.name = name;
    this.price = price;
    this.weight = weight;
    this.quantity = 0; // Initially, no items are added
}

// Prototype method to update the quantity of an item in the cart
BakeryItem.prototype.addToCart = function () {
    this.quantity++;
    updateCartDisplay();
};

// List of items available in the bakery
const items = [
    new BakeryItem("Cake", 15.00, "1.5 kg"),
    new BakeryItem("Pastry", 3.50, "0.2 kg"),
    new BakeryItem("Croissant", 2.00, "0.15 kg")
];

// Function to update the cart's display on the webpage
function updateCartDisplay() {
    const cartInfoButton = document.getElementById('view-cart-button');
    const cartItemsList = document.getElementById('cart-items-list');

    // Clear previous cart items
    cartItemsList.innerHTML = '';

    let totalItems = 0;
    let totalPrice = 0;

    // Display all items in the cart
    items.forEach(item => {
        if (item.quantity > 0) {
            const listItem = document.createElement('li');
            listItem.textContent = `${item.name} - ${item.quantity} x $${item.price.toFixed(2)} = $${(item.quantity * item.price).toFixed(2)}`;
            cartItemsList.appendChild(listItem);
            totalItems += item.quantity;
            totalPrice += item.quantity * item.price;
        }
    });

    // Update the cart button text
    cartInfoButton.textContent = `View Cart (${totalItems} items)`;

    // Update the total price display in the cart
    const checkoutButton = document.getElementById('checkout-button');
    checkoutButton.textContent = `Checkout ($${totalPrice.toFixed(2)})`;
}

// Event listener for "Add to Cart" buttons
document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', () => {
        const itemId = button.getAttribute('data-id');  // Get the item's name from data-id
        const item = items.find(i => i.name === itemId); // Find the correct BakeryItem by name
        if (item) {
            item.addToCart();
        }
    });
});

// Event listener for "View Cart" button
document.getElementById('view-cart-button').addEventListener('click', () => {
    document.getElementById('bakery-items').style.display = 'none';
    document.getElementById('cart').style.display = 'block';
});

// Event listener for "Close Cart" button
document.getElementById('close-cart-button').addEventListener('click', () => {
    document.getElementById('bakery-items').style.display = 'block';
    document.getElementById('cart').style.display = 'none';
});

// Event listener for "Checkout" button
document.getElementById('checkout-button').addEventListener('click', () => {
    alert("Thank you for your order! Your items will be delivered shortly.");
    // Reset cart after checkout
    items.forEach(item => item.quantity = 0);
    updateCartDisplay();
});
