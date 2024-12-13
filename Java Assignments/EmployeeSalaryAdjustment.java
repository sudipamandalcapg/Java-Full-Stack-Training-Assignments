package classcode;

public class EmployeeSalaryAdjustment {
	public static void main(String[] args) {
		double[] salaries = { 25000, 20000, 35000, 12000, 29000 };

		for (int i = 0; i < salaries.length; i++) {
			double currentSalary = salaries[i];
			double originalSalary = currentSalary;

			if (currentSalary >= 30000) {
				currentSalary += currentSalary * 0.10;
			}

			if (currentSalary == 20000) {
				currentSalary += 2000; 
			}

			if (currentSalary < 15000) {
				System.out.println("Employee " + (i + 1) + " should improve their work to earn a higher salary.");
			}

			double hra = currentSalary * 0.10; 
			double ta = currentSalary * 0.05; 
			double da = currentSalary * 0.08; 

			System.out.println("Employee " + (i + 1) + " - Original Salary: " + originalSalary);
			System.out.println("Updated Salary: " + currentSalary);
			System.out.println("HRA: " + hra);
			System.out.println("TA: " + ta);
			System.out.println("DA: " + da);
			System.out.println("Total Salary (including allowances): " + (currentSalary + hra + ta + da));
			System.out.println();
		}
	}
}
