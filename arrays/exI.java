import java.util.Scanner;

public class exI {
  static Scanner scanner = new Scanner(System.in);

  private static String[][] readData() {
    final int nOfFloors = 4;
    final int nOfDoors = 3;
    String[][] habitants = new String[nOfFloors][nOfDoors];

    for (int j = 0; j < habitants[0].length; j++)
      for (int i = 0; i < habitants.length; i++)
        habitants[i][j] = scanner.nextLine();

    return habitants;
  }

  private static void printSearchResult(String[][] habitants, String searchName) {
    boolean found = false;

    for (int j = 0; j < habitants[0].length; j++) {
      for (int i = 0; i < habitants.length; i++) {
        if (habitants[i][j].equals(searchName)) {
          System.out.printf("nome=%s%n", habitants[i][j]);
          System.out.printf("entrada=%s%n", j);
          System.out.printf("piso=%s%n", i);

          found = true;
        }
      }
    }

    if (!found)
      System.out.println("Nao mora no predio");
  }

  public static void main(String[] args) {
    String[][] habitants = readData();

    String searchName = scanner.nextLine();

    printSearchResult(habitants, searchName);
  }
}
