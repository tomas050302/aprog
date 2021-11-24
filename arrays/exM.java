import java.util.Scanner;

public class exM {
  static Scanner scanner = new Scanner(System.in);
  static final int MAX_NUMBERS = 100;

  private static int readNumbers(int[] numbers) {
    int n;
    int i = 0;

    do {
      n = scanner.nextInt();
      if (n >= 0) {
        numbers[i] = n;

        i++;
      }
    } while (i < MAX_NUMBERS && n >= 0);

    return i;
  }

  private static boolean contains(String[] arr, String needle) {
    for (String element : arr) {
      if (element != null && element.equals(needle))
        return true;
    }

    return false;
  }

  private static int getNOfDistinctNumbers(int n) {
    String[] digits = Integer.toString(n).split("");

    String[] used = new String[digits.length];

    int nOfDistinctDigits = 0;
    int i = 0;

    for (String digit : digits) {
      if (!contains(used, digit))
        nOfDistinctDigits++;

      used[i] = digit;
      i++;
    }

    return nOfDistinctDigits;
  }

  public static void main(String[] args) {
    int[] numbers = new int[MAX_NUMBERS];

    int nOfNumbers = readNumbers(numbers);

    for (int i = 0; i < nOfNumbers; i++) {
      int nOfDistinctDigits = getNOfDistinctNumbers(numbers[i]);

      System.out.printf("%d:%d%n", numbers[i], nOfDistinctDigits);
    }
  }
}
