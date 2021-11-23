import java.util.Scanner;

public class exP2 {
  private static int getPositionOfDigit(int n, int digit, int fromDigit) {
    int pos = fromDigit + 1;
    n /= Math.pow(10, fromDigit);

    while (n > 0) {
      int tempDigit = n % 10;

      if (digit == tempDigit)
        return pos;

      pos++;
      n /= 10;
    }

    return -1;
  }

  private static int updateUsedNumbers(int used, int digit) {
    if (used == -1)
      return digit;

    return used * 10 + digit;
  }

  private static boolean isDigitAlreadyUsed(int used, int digit) {
    if (digit == used)
      return true;

    while (used > 0) {
      int usedDigit = used % 10;

      if (digit == usedDigit)
        return true;

      used /= 10;
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int original = scanner.nextInt();

    while (original >= 0) {
      int n = original;
      int posOfDigit = 1;
      int used = -1;

      while (n > 0) {
        int digit = n % 10;

        int posOfDuplicateDigit = getPositionOfDigit(original, digit, posOfDigit);

        while (posOfDuplicateDigit != -1 && !isDigitAlreadyUsed(used, digit)) {
          System.out.printf("%d : algarismo (%d) repetido nas posicoes (%d) e (%d)%n", original, digit, posOfDigit,
              posOfDuplicateDigit);

          posOfDuplicateDigit = getPositionOfDigit(original, digit, posOfDuplicateDigit);
        }

        used = updateUsedNumbers(used, digit);

        posOfDigit++;
        n /= 10;
      }

      original = scanner.nextInt();
    }
  }
}
