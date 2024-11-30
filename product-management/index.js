const express = require("express");
const bodyParser = require("body-parser");
const session = require("express-session");

const app = express();
const PORT = 4000; // 

app.use(express.static("public"));

// Middleware setup
app.use(bodyParser.urlencoded({ extended: false }));
app.set("view engine", "ejs");

// Session configuration
app.use(
    session({
        secret: "unique_secret_key_for_security",
        resave: false,
        saveUninitialized: true,
    })
);

// In-memory data for users and products
const productDatabase = [];
const userAccounts = [
    { username: "admin", password: "admin123", role: "admin" },
    { username: "shopper", password: "user123", role: "user" },
];

// Middleware to check if the user is logged in
const checkLogin = (req, res, next) => {
    if (req.session.currentUser) {
        next();
    } else {
        res.redirect("/");
    }
};

// Default route (Login Page)
// app.get("/", (req, res) => {
//   res.render("login", { errorMessage: null });
// });

// Default route - Welcome Page (Landing Page)
app.get("/", (req, res) => {
    res.render("index");
});

// Dynamic route to show login page based on user role
app.get("/login/:role", (req, res) => {
    const role = req.params.role;
    res.render("login", { errorMessage: null, role: role });
});

// Handle Login Post Request
app.post("/auth", (req, res) => {
    const { username, password } = req.body;
    const matchedUser = userAccounts.find(
        (user) => user.username === username && user.password === password
    );

    if (matchedUser) {
        req.session.currentUser = matchedUser;
        res.redirect(matchedUser.role === "admin" ? "/dashboard" : "/products");
    } else {
        res.render("login", { errorMessage: "Invalid username or password" });
    }
});

// Logout Route
app.get("/logout", (req, res) => {
    req.session.destroy(() => {
        res.redirect("/");
    });
});

// Admin Routes
app.get("/dashboard", checkLogin, (req, res) => {
    if (req.session.currentUser.role === "admin") {
        res.render("admin", { productDatabase, user: req.session.currentUser });
    } else {
        res.redirect("/");
    }
});

app.post("/add-product", checkLogin, (req, res) => {
    if (req.session.currentUser.role === "admin") {
        const { productName, productId, productPrice, category, mfgDate, expDate } =
            req.body;
        productDatabase.push({
            productName,
            productId,
            productPrice,
            category,
            mfgDate,
            expDate,
        });
        res.redirect("/dashboard");
    } else {
        res.redirect("/");
    }
});

// User Routes
app.get("/products", checkLogin, (req, res) => {
    if (req.session.currentUser.role === "user") {
        res.render("user", {
            productDatabase,
            searchResults: [],
            user: req.session.currentUser,
        });
    } else {
        res.redirect("/");
    }
});

app.post("/search-product", checkLogin, (req, res) => {
    const { searchKey, searchBy } = req.body;

    const filteredResults = productDatabase.filter((item) => {
        if (searchBy === "name") {
            return item.productName.toLowerCase().includes(searchKey.toLowerCase());
        } else if (searchBy === "category") {
            return item.category.toLowerCase().includes(searchKey.toLowerCase());
        }
        return false;
    });

    res.render("user", {
        productDatabase,
        searchResults: filteredResults,
        user: req.session.currentUser,
    });
});

// Start the Server
app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
});

