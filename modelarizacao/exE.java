import java.util.Scanner;

public class exE {
  public static int nOfSameDigits(int a, int b) {
    if ((a % 10) <= 0 || (b % 10) <= 0)
      return 0;
    if (a % 10 == b % 10)
      return 1 + nOfSameDigits(a / 10, b / 10);

    return nOfSameDigits(a / 10, b / 10);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int nOfNumbers = scanner.nextInt();

    int biggestDuplicateDigits = 0;
    int biggestA = 0;
    int biggestB = 0;

    if (nOfNumbers > 0) {
      for (int i = 0; i < nOfNumbers; i++) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int nOfDuplicateDigits = nOfSameDigits(a, b);

        if (nOfDuplicateDigits >= biggestDuplicateDigits) {
          biggestDuplicateDigits = nOfDuplicateDigits;
          biggestA = a;
          biggestB = b;
        }
      }

      if (biggestDuplicateDigits != 0)
        System.out.printf("%d/%d%n", biggestA, biggestB);
      else
        System.out.println("sem resultados");
    }
  }
}
