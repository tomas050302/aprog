import java.util.Scanner;

public class exE {
  static Scanner scanner = new Scanner(System.in);

  private static int readEmployeesData(String[] employeesNames, double[] employeesSalaries) {
    int currentNumberOfEmployees = 0;
    String employeeName = "";

    do {
      employeeName = scanner.nextLine();

      if (!employeeName.equals("fim")) {
        double employeeSalary = Double.parseDouble(scanner.nextLine());

        employeesNames[currentNumberOfEmployees] = employeeName;
        employeesSalaries[currentNumberOfEmployees] = employeeSalary;
        currentNumberOfEmployees++;

      }

    } while (!employeeName.equals("fim"));

    return currentNumberOfEmployees;
  }

  private static double getAverageSalary(double[] salaries, int nOfEmployees) {
    double sum = 0;

    for (int i = 0; i < nOfEmployees; i++) {
      sum += salaries[i];
    }

    return sum / nOfEmployees;
  }

  static void showResults(String[] employeesNames, double[] employeesSalaries, double avgSalary, int nOfEmployees) {
    System.out.printf("%.1f%n", avgSalary);

    for (int i = 0; i < nOfEmployees; i++)
      if (employeesSalaries[i] < avgSalary)
        System.out.println(employeesNames[i]);
  }

  public static void main(String[] args) {
    final int MAX_OF_EMPLOYEES = 20;
    String[] employeesNames = new String[MAX_OF_EMPLOYEES];
    double[] employeesSalaries = new double[MAX_OF_EMPLOYEES];

    int nOfEmployees = readEmployeesData(employeesNames, employeesSalaries);

    double avgSalary = getAverageSalary(employeesSalaries, nOfEmployees);

    showResults(employeesNames, employeesSalaries, avgSalary, nOfEmployees);
  }
}
