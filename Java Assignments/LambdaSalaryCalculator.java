package classcode;

interface SalaryCalculator {
	double calculateSalary(double baseSalary);
	
}

public class LambdaSalaryCalculator {

	public static void main(String[] args) {
		// Base salary for calculation
		double baseSalary = 50000;

		// Salary with a 10% bonus
		SalaryCalculator withBonus = (sal) -> sal + (sal * 0.10);

		// Salary with a 5% deduction
		SalaryCalculator withDeduction = (sal) -> sal - (sal * 0.05);

		// Salary with a 15% increment if base salary is less than 20000
		SalaryCalculator withIncrement = (sal) -> {
			if (sal < 20000) {
				return sal + (sal * 0.15);
			} else {
				return sal;
			}
		};

		// Salary with no change (no increment or deduction)
		SalaryCalculator noChange = (salary) -> salary;

		// Printing the results by applying the lambda functions
		System.out.println("Base salary: " + baseSalary);
		System.out.println("Salary without change: " + noChange.calculateSalary(baseSalary));
		System.out.println("Salary with bonus: " + withBonus.calculateSalary(baseSalary));
		System.out.println("Salary with deduction of 5%: " + withDeduction.calculateSalary(baseSalary));
		System.out.println("Salary with increment (if base < 20000): " + withIncrement.calculateSalary(baseSalary));
	}
}
