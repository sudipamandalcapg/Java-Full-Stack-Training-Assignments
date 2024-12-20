package employee2;

import java.util.*;

class Employee {
	public String name;
	public double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + ": " + salary;
	}
}

public class EmployeeJava8Sream {
	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee("Alice", 30000), new Employee("Bob", 50000),
				new Employee("Charlie", 120000), new Employee("David", 35000), new Employee("Eve", 80000),
				new Employee("Frank", 45000));

		System.out.println("Employees with salary < 40000: ");
		employees.stream().filter(e -> e.salary < 40000).forEach(System.out::println);

		System.out.println("\nEmployees with salary > 75000: ");
		employees.stream().filter(e -> e.salary > 75000).forEach(System.out::println);

		employees.stream().filter(e -> e.salary >= 33000 && e.salary <= 37000).forEach(e -> e.salary = e.salary * 1.10);

		double avgSalary = employees.stream().mapToDouble(e -> e.salary).average().orElse(0);
		System.out.println("\nAverage Salary: " + avgSalary);

		double yearlyTurnover = avgSalary * employees.size();
		System.out.println("\nCompany Yearly Turnover: " + yearlyTurnover);

		System.out.println("\nEmployees sorted by salary in descending order:");
		employees.stream().sorted((e1, e2) -> Double.compare(e2.salary, e1.salary)) // Sorting in descending order
				.forEach(System.out::println); // Printing each employee after sorting
	}
}
