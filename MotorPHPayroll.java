import java.util.Scanner;

public class MotorPHPayroll {

    public static double calculateGrossSalary(double hourlyRate, double hoursWorked) {
        return hourlyRate * hoursWorked;
    }

    public static double[] calculateDeductions(double grossSalary, double taxRate, double sssRate, double philhealthRate, double pagibigRate) {
        double tax = grossSalary * taxRate;
        double sss = grossSalary * sssRate;
        double philhealth = grossSalary * philhealthRate;
        double pagibig = grossSalary * pagibigRate;
        double totalDeductions = tax + sss + philhealth + pagibig;
        return new double[]{totalDeductions, tax, sss, philhealth, pagibig};
    }

    public static double calculateNetSalary(double grossSalary, double totalDeductions) {
        return grossSalary - totalDeductions;
    }

    public static void displayPayslip(String name, double grossSalary, double[] deductions, double netSalary) {
        System.out.println("\n=== MotorPH Payslip ===");
        System.out.println("Employee Name: " + name);
        System.out.printf("Gross Salary: PHP %.2f%n", grossSalary);
        System.out.printf("Tax Deduction: PHP %.2f%n", deductions[1]);
        System.out.printf("SSS Deduction: PHP %.2f%n", deductions[2]);
        System.out.printf("PhilHealth Deduction: PHP %.2f%n", deductions[3]);
        System.out.printf("Pag-IBIG Deduction: PHP %.2f%n", deductions[4]);
        System.out.printf("Total Deductions: PHP %.2f%n", deductions[0]);
        System.out.printf("Net Salary: PHP %.2f%n", netSalary);
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter hourly rate (PHP): ");
        double hourlyRate = scanner.nextDouble();

        System.out.print("Enter total hours worked: ");
        double hoursWorked = scanner.nextDouble();

        double grossSalary = calculateGrossSalary(hourlyRate, hoursWorked);

        // Example deduction rates
        double taxRate = 0.12;         // 12%
        double sssRate = 0.045;        // 4.5%
        double philhealthRate = 0.03;  // 3%
        double pagibigRate = 0.02;     // 2%

        double[] deductions = calculateDeductions(grossSalary, taxRate, sssRate, philhealthRate, pagibigRate);
        double netSalary = calculateNetSalary(grossSalary, deductions[0]);

        displayPayslip(name, grossSalary, deductions, netSalary);

        scanner.close();
    }
}
