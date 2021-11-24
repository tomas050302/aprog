import java.util.Arrays;
import java.util.Scanner;

public class exM {
  static Scanner scanner = new Scanner(System.in);

  private static int[] readNumbers() {
    final int MAX_NUMBERS = 100;
    int[] numbers = new int[MAX_NUMBERS];
    int n;
    int i = 0;

    do {
      n = scanner.nextInt();
      if (n > 0) {
        numbers[i] = n;

        i++;
      }
    } while (i < MAX_NUMBERS && n > 0);

    return numbers;
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
    int[] numbers = readNumbers();

    for (int i = 0; i < numbers.length; i++) {
      int nOfDistinctDigits = getNOfDistinctNumbers(numbers[i]);

      System.out.printf("%d:%d%n", numbers[i], nOfDistinctDigits);
    }
  }
}
