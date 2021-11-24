import java.util.Scanner;

public class exJ {
  static Scanner scanner = new Scanner(System.in);

  static final int SALARY_INDEX = 0;
  static final int NAME_INDEX = 1;
  static final int MAX_VALUES = 100;
  static final int TOP = 3;

  private static int getData(String[] employeesNames, double[] employeesSalaries) {
    int nOfEmployees = 0;
    String employeeName = "";

    do {
      employeeName = scanner.nextLine();

      if (!employeeName.equals("FIM")) {
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        employeesNames[nOfEmployees] = employeeName;
        employeesSalaries[nOfEmployees] = employeeSalary;

        nOfEmployees++;
      }
    } while (!employeeName.equals("FIM") && nOfEmployees < MAX_VALUES);

    return nOfEmployees;
  }

  private static int getTopSalaryIndex(String[] employeesNames, double[] employeesSalaries, int nOfEmployees) {
    int topSalaryIndex = 0;
    double topEmployeeSalary = employeesSalaries[0];
    String topEmployeeName = employeesNames[0];

    for (int i = 1; i < nOfEmployees; i++) {
      double employeeSalary = employeesSalaries[i];

      if (employeeSalary > topEmployeeSalary) {
        topSalaryIndex = i;
        topEmployeeName = employeesNames[i];
        topEmployeeSalary = employeesSalaries[i];
      } else if (employeeSalary == topEmployeeSalary) {
        if (employeesNames[i].compareTo(topEmployeeName) < 0) {
          topSalaryIndex = i;
          topEmployeeName = employeesNames[i];
          topEmployeeSalary = employeesSalaries[i];
        }
      }
    }

    return topSalaryIndex;
  }

  private static String[] removeIndexFromArray(String[] array, int index, int nOfEmployees) {
    String[] finalArray = new String[nOfEmployees];
    int j = 0;

    for (int i = 0; i < nOfEmployees; i++) {
      if (i != index) {
        finalArray[j] = array[i];
        j++;
      }
    }

    return finalArray;
  }

  private static double[] removeIndexFromArray(double[] array, int index, int nOfEmployees) {
    double[] finalArray = new double[nOfEmployees];
    int j = 0;

    for (int i = 0; i < nOfEmployees; i++) {
      if (i != index) {
        finalArray[j] = array[i];
        j++;
      }
    }

    return finalArray;
  }

  private static void getTopEmployees(String[] employeesNames, double[] employeesSalaries, String[] topEmployeesNames,
      double[] topEmployeesSalaries, int nOfEmployees) {

    for (int i = 0; i < TOP; i++) {
      int topSalaryIndex = getTopSalaryIndex(employeesNames, employeesSalaries, nOfEmployees);

      topEmployeesNames[i] = employeesNames[topSalaryIndex];
      topEmployeesSalaries[i] = employeesSalaries[topSalaryIndex];

      employeesNames = removeIndexFromArray(employeesNames, topSalaryIndex, nOfEmployees);
      employeesSalaries = removeIndexFromArray(employeesSalaries, topSalaryIndex, nOfEmployees);
    }
  }

  public static void main(String[] args) {
    String[] employeesNames = new String[MAX_VALUES];
    double[] employeesSalaries = new double[MAX_VALUES];

    int nOfEmployees = getData(employeesNames, employeesSalaries);

    String[] topEmployeesNames = new String[TOP];
    double[] topEmployeesSalaries = new double[TOP];

    getTopEmployees(employeesNames, employeesSalaries, topEmployeesNames, topEmployeesSalaries, nOfEmployees);

    for (int i = 0; i < topEmployeesNames.length; i++) {
      System.out.printf("#%d:%s:%s%n", i + 1, topEmployeesNames[i], topEmployeesSalaries[i]);
    }
  }
}
