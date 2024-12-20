package collections;

import java.util.HashSet;
import java.util.Objects;

// BankAccount class
class BankAccount {
	private String accountNumber;
	private double balance;
	private boolean isActive;

	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.isActive = true; // Accounts are active by default
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public boolean withdraw(double amount) {
		if (amount > 0 && balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}

	public void deactivate() {
		this.isActive = false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BankAccount that = (BankAccount) o;
		return Objects.equals(accountNumber, that.accountNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}

	@Override
	public String toString() {
		return "BankAccount{" + "accountNumber='" + accountNumber + '\'' + ", balance=" + balance + ", isActive="
				+ isActive + '}';
	}
}

// Main class
public class BankingSystem {
	public static void main(String[] args) {
		// Create a HashSet to store BankAccount objects
		HashSet<BankAccount> accounts = new HashSet<>();

		// 1. Add accounts
		BankAccount account1 = new BankAccount("501", 5000);
		BankAccount account2 = new BankAccount("502", 3000);
		BankAccount account3 = new BankAccount("503", 10000);

		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);

		// 2. Deposit money
		deposit(accounts, "501", 1000);
		deposit(accounts, "502", 500);

		// 3. Withdraw money
		withdraw(accounts, "501", 1500);

		// 4. Check balances
		System.out.println("Balance of account 501: " + checkBalance(accounts, "501"));
		System.out.println("Balance of account 502: " + checkBalance(accounts, "502"));
		System.out.println("Balance of account 503: " + checkBalance(accounts, "503"));

		// 6. Display account with highest and lowest balance
		BankAccount highest = getAccountWithHighestBalance(accounts);
		BankAccount lowest = getAccountWithLowestBalance(accounts);
		System.out.println("\nAccount with highest balance: " + highest);
		System.out.println("Account with lowest balance: " + lowest);

		// 5. Deactivate and remove an account
		account2.deactivate();
		removeInactiveAccounts(accounts);

		// Display all accounts
		System.out.println("\nAll Accounts:");
		accounts.forEach(System.out::println);
	}

	// Method to deposit money into an account
	public static void deposit(HashSet<BankAccount> accounts, String accountNumber, double amount) {
		BankAccount account = findAccount(accounts, accountNumber);
		if (account != null) {
			account.deposit(amount);
		}
	}

	// Method to withdraw money from an account
	public static void withdraw(HashSet<BankAccount> accounts, String accountNumber, double amount) {
		BankAccount account = findAccount(accounts, accountNumber);
		if (account != null) {
			account.withdraw(amount);
		}
	}

	// Method to check the balance of an account
	public static double checkBalance(HashSet<BankAccount> accounts, String accountNumber) {
		BankAccount account = findAccount(accounts, accountNumber);
		if (account != null) {
			return account.getBalance();
		}
		return -1; // Account not found
	}

	// Method to find an account by account number
	public static BankAccount findAccount(HashSet<BankAccount> accounts, String accountNumber) {
		return accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst()
				.orElse(null);
	}

	// Method to remove inactive accounts
	public static void removeInactiveAccounts(HashSet<BankAccount> accounts) {
		accounts.removeIf(account -> !account.isActive());
	}

	// Method to get the account with the highest balance
	public static BankAccount getAccountWithHighestBalance(HashSet<BankAccount> accounts) {
		BankAccount highestAccount = null;
		for (BankAccount account : accounts) {
			if (highestAccount == null || account.getBalance() > highestAccount.getBalance()) {
				highestAccount = account;
			}
		}
		return highestAccount;
	}

	// Method to get the account with the lowest balance
	public static BankAccount getAccountWithLowestBalance(HashSet<BankAccount> accounts) {
		BankAccount lowestAccount = null;
		for (BankAccount account : accounts) {
			if (lowestAccount == null || account.getBalance() < lowestAccount.getBalance()) {
				lowestAccount = account;
			}
		}
		return lowestAccount;
	}
}
