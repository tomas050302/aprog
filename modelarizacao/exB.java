import java.util.Scanner;

public class exB {
  public static void printClassInformation(String className, int nOfApprovedStudents, int nOfNotApprovedStudents) {
    System.out.printf("Disciplina: %s%n", className);
    System.out.print("- Positivas: ");

    for (int i = 0; i < nOfApprovedStudents; i++) {
      System.out.print("*");
    }

    System.out.println("");

    System.out.print("- Negativas: ");

    for (int i = 0; i < nOfNotApprovedStudents; i++) {
      System.out.print("*");
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int nOfStudents = scanner.nextInt();
    int nOfClasses = scanner.nextInt();

    for (int i = 0; i < nOfClasses; i++) {
      String className = scanner.next();
      int nOfApprovedStudents = scanner.nextInt();

      if (nOfApprovedStudents > nOfStudents)
        nOfApprovedStudents = nOfStudents;

      printClassInformation(className, nOfApprovedStudents, nOfStudents - nOfApprovedStudents);
    }
  }
}
