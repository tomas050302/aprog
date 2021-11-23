import java.util.Scanner;

public class exE {
  static final int NAME_INDEX = 0;
  static final int SALARY_INDEX = 1;

  private static int readEmployeesData(String[][] employeesData) {
    Scanner scanner = new Scanner(System.in);

    int currentNumberOfEmployees = 0;
    String employeeName = "";

    do {
      employeeName = scanner.nextLine();

      if (!employeeName.equals("fim")) {
        String employeeSalary = scanner.nextLine();

        employeesData[currentNumberOfEmployees][NAME_INDEX] = employeeName;
        employeesData[currentNumberOfEmployees][SALARY_INDEX] = employeeSalary;
        currentNumberOfEmployees++;

      }

    } while (!employeeName.equals("fim"));

    return currentNumberOfEmployees;
  }

  private static double[] getSalaries(String[][] employeesData, int nOfEmployees) {
    double[] salaries = new double[nOfEmployees];

    for (int i = 0; i < nOfEmployees; i++)
      salaries[i] = Double.parseDouble(employeesData[i][SALARY_INDEX]);

    return salaries;
  }

  private static double getAverageSalary(double[] salaries) {
    double sum = 0;

    for (double salary : salaries)
      sum += salary;

    return sum / salaries.length;
  }

  static void showResults(String[][] employeesData, double avgSalary, int nOfEmployees) {
    System.out.printf("%.1f%n", avgSalary);

    for (int i = 0; i < nOfEmployees; i++) {
      if (Double.parseDouble(employeesData[i][SALARY_INDEX]) < avgSalary)
        System.out.println(employeesData[i][NAME_INDEX]);

    }
  }

  public static void main(String[] args) {
    final int MAX_OF_EMPLOYEES = 20;
    String[][] employeesData = new String[MAX_OF_EMPLOYEES][2];

    int nOfEmployees = readEmployeesData(employeesData);

    double[] salaries = getSalaries(employeesData, nOfEmployees);
    double avgSalary = getAverageSalary(salaries);

    showResults(employeesData, avgSalary, nOfEmployees);
  }
}
