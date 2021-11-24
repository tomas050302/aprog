import java.util.Scanner;

public class exJ {
  static Scanner scanner = new Scanner(System.in);

  static final int MAX_VALUES = 100;
  static final int TOP = 3;

  private static int getData(String[] employeesNames, int[] employeesSalaries) {
    int nOfEmployees = 0;
    String employeeName = "";

    do {
      employeeName = scanner.nextLine();

      if (!employeeName.equals("FIM")) {
        int employeeSalary = Integer.parseInt(scanner.nextLine());
        employeesNames[nOfEmployees] = employeeName;
        employeesSalaries[nOfEmployees] = employeeSalary;

        nOfEmployees++;
      }
    } while (!employeeName.equals("FIM") && nOfEmployees < MAX_VALUES);

    return nOfEmployees;
  }

  private static int getTopSalaryIndex(String[] employeesNames, int[] employeesSalaries, int nOfEmployees) {
    int topSalaryIndex = 0;
    int topEmployeeSalary = employeesSalaries[0];
    String topEmployeeName = employeesNames[0];

    for (int i = 1; i < nOfEmployees; i++) {
      int employeeSalary = employeesSalaries[i];

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

  private static int[] removeIndexFromArray(int[] array, int index, int nOfEmployees) {
    int[] finalArray = new int[nOfEmployees];
    int j = 0;

    for (int i = 0; i < nOfEmployees; i++) {
      if (i != index) {
        finalArray[j] = array[i];
        j++;
      }
    }

    return finalArray;
  }

  private static void getTopEmployees(String[] employeesNames, int[] employeesSalaries, String[] topEmployeesNames,
      int[] topEmployeesSalaries, int nOfEmployees) {

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
    int[] employeesSalaries = new int[MAX_VALUES];

    int nOfEmployees = getData(employeesNames, employeesSalaries);

    if (nOfEmployees > 0) {
      String[] topEmployeesNames = new String[TOP];
      int[] topEmployeesSalaries = new int[TOP];

      getTopEmployees(employeesNames, employeesSalaries, topEmployeesNames, topEmployeesSalaries, nOfEmployees);

      for (int i = 0; i < topEmployeesNames.length; i++) {
        System.out.printf("#%d:%s:%s%n", i + 1, topEmployeesNames[i], topEmployeesSalaries[i]);
      }
    }
  }
}
