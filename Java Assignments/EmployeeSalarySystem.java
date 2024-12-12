package empsalarysystem;

import java.util.Scanner;

public class EmployeeSalarySystem {

	static final double PERK_PERCENTAGE = 0.10;
	static final double TAX_RATE = 0.15;

	private String name;
	private String department;
	private double basicSalary;
	private double hra;
	private double ta; // Travel Allowance
	private double da; // Dearness Allowance
	private double perks;

	public EmployeeSalarySystem(String name, String department, double basicSalary) {
		this.name = name;
		this.department = department;
		this.basicSalary = basicSalary;
		this.hra = calculateHRA();
		this.ta = calculateTA();
		this.da = calculateDA();
		this.perks = calculatePerks();
	}

	public double calculateHRA() {
		return 0.20 * basicSalary;
	}

	public double calculateTA() {
		return 0.15 * basicSalary;
	}

	public double calculateDA() {
		return 0.10 * basicSalary;
	}

	public double calculatePerks() {
		return basicSalary * PERK_PERCENTAGE;
	}

	public double calculateGrossSalary() {
		return basicSalary + hra + ta + da + perks;
	}

	public static double calculateTax(double grossSalary) {
		return grossSalary * TAX_RATE;
	}

	public double calculateNetSalary() {
		double grossSalary = calculateGrossSalary();
		double tax = calculateTax(grossSalary); 
		return grossSalary - tax; 
	}

	public void displaySalaryDetails() {
		System.out.println("Employee Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("House Rent Allowance (HRA): " + hra);
		System.out.println("Travel Allowance (TA): " + ta);
		System.out.println("Dearness Allowance (DA): " + da);
		System.out.println("Perks: " + perks);
		System.out.println("Gross Salary: " + calculateGrossSalary());
		System.out.println("Tax Deduction: " + calculateTax(calculateGrossSalary()));
		System.out.println("Net Salary: " + calculateNetSalary());
	}

	public static void main(String[] args) {
//		EmployeeSalarySystem emp1 = new EmployeeSalarySystem("John Doe", "IT", 50000);
//		EmployeeSalarySystem emp2 = new EmployeeSalarySystem("Jane Smith", "HR", 45000);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter details for Employee 1: ");

		System.out.print("Enter Name: ");
		String name1 = scanner.nextLine();

		System.out.print("Enter Department: ");
		String department1 = scanner.nextLine();

		System.out.print("Enter Basic Salary: ");
		double basicSalary1 = scanner.nextDouble();

		EmployeeSalarySystem emp1 = new EmployeeSalarySystem(name1, department1, basicSalary1);

		System.out.println("Salary Details for Employee 1:");
		emp1.displaySalaryDetails();
	}
}
