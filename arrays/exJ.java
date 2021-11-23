import java.util.Arrays;
import java.util.Scanner;

public class exJ {
  static Scanner scanner = new Scanner(System.in);

  static final int SALARY_INDEX = 0;
  static final int NAME_INDEX = 1;
  static final int MAX_VALUES = 100;

  private static int getData(String[][] employeesData) {
    int nOfEmployees = 0;
    String employeeName = "";

    do {
      employeeName = scanner.nextLine();

      if (!employeeName.equals("FIM")) {
        String employeeSalary = scanner.nextLine();
        employeesData[nOfEmployees][NAME_INDEX] = employeeName;
        employeesData[nOfEmployees][SALARY_INDEX] = employeeSalary;

        nOfEmployees++;
      }
    } while (!employeeName.equals("FIM") && nOfEmployees < MAX_VALUES);

    return nOfEmployees;
  }

  private static int getTopSalaryIndex(String[][] employeesData) {
    int topSalaryIndex = 0;
    double topEmployeeSalary = Double.parseDouble(employeesData[0][SALARY_INDEX]);
    String topEmployeeName = employeesData[0][NAME_INDEX];

    for (int i = 1; i < employeesData.length; i++) {
      double employeeSalary = Double.parseDouble(employeesData[i][SALARY_INDEX]);

      if (employeeSalary > topEmployeeSalary) {
        topSalaryIndex = i;
        topEmployeeName = employeesData[i][NAME_INDEX];
        topEmployeeSalary = Double.parseDouble(employeesData[i][SALARY_INDEX]);
      } else if (employeeSalary == topEmployeeSalary) {
        if (employeesData[i][NAME_INDEX].compareTo(topEmployeeName) < 0) {
          topSalaryIndex = i;
          topEmployeeName = employeesData[i][NAME_INDEX];
          topEmployeeSalary = Double.parseDouble(employeesData[i][SALARY_INDEX]);
        }
      }
    }

    return topSalaryIndex;
  }

  private static String[][] removeIndexFromArray(String[][] array, int index) {
    String[][] finalArray = new String[array.length - 1][2];
    int j = 0;

    for (int i = 0; i < array.length; i++) {
      if (i != index) {
        finalArray[j] = array[i];
        j++;
      }
    }

    return finalArray;
  }

  private static String[][] getTopEmployees(String[][] employees, int nOfEmployees) {
    final int TOP = 3;
    String[][] topEmployees = new String[TOP][2];
    String[][] tempEmployees = Arrays.copyOf(employees, nOfEmployees);

    for (int i = 0; i < TOP; i++) {
      int topSalaryIndex = getTopSalaryIndex(tempEmployees);

      topEmployees[i] = tempEmployees[topSalaryIndex];

      tempEmployees = removeIndexFromArray(tempEmployees, topSalaryIndex);
    }

    return topEmployees;
  }

  public static void main(String[] args) {
    String[][] employeesData = new String[MAX_VALUES][2];

    int nOfEmployees = getData(employeesData);

    String[][] topEmployees = getTopEmployees(employeesData, nOfEmployees);

    for (int i = 0; i < topEmployees.length; i++) {
      System.out.printf("#%d:%s:%s%n", i + 1, topEmployees[i][NAME_INDEX], topEmployees[i][SALARY_INDEX]);
    }
  }
}
