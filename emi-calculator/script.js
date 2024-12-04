// Predefined interest rates for different loan types
const loanTypes = {
    home: {
        name: "Home Loan",
        interestRate: 0.08, // 8% annual rate
    },
    car: {
        name: "Car Loan",
        interestRate: 0.10, // 10% annual rate
    },
    education: {
        name: "Education Loan",
        interestRate: 0.07, // 7% annual rate
    },
};

// Function to calculate EMI
function calculateEMI() {
    const salary = parseFloat(document.getElementById("salary").value);
    const loanAmount = parseFloat(document.getElementById("loanAmount").value);
    const loanType = document.getElementById("loanType").value;

    if (isNaN(salary) || isNaN(loanAmount) || salary <= 0 || loanAmount <= 0) {
        alert("Please enter valid values.");
        return;
    }

    // Get interest rate based on selected loan type
    const interestRate = loanTypes[loanType].interestRate;

    // Determine loan duration based on the salary
    let loanDuration = 12; // Default 1 year
    if (salary >= 50000) {
        loanDuration = 240; // 20 years for high salary
    } else if (salary >= 30000) {
        loanDuration = 180; // 15 years for medium salary
    } else {
        loanDuration = 120; // 10 years for low salary
    }

    // EMI calculation formula
    const monthlyInterestRate = interestRate / 12;
    const n = loanDuration;
    const EMI = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, n)) / (Math.pow(1 + monthlyInterestRate, n) - 1);

    // Display results
    document.getElementById("emiAmount").textContent = `₹${EMI.toFixed(2)}`;
    document.getElementById("loanDuration").textContent = `${loanDuration / 12} years`;

    // Show the result section
    document.getElementById("result").style.display = "block";
}
