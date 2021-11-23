import java.util.Scanner;

public class ex7 {
  public static int getMaxCrescentSegment(int n) {
    int maxCrescentSequence = 1;
    int currentCrescentSequence = 1;
    int lastDigit = n % 10;
    n /= 10;

    while (n > 0) {
      int digit = n % 10;

      if (digit > lastDigit)
        currentCrescentSequence = 1;
      else {
        currentCrescentSequence++;

        if (currentCrescentSequence > maxCrescentSequence)
          maxCrescentSequence = currentCrescentSequence;
      }

      lastDigit = digit;
      n /= 10;
    }

    return maxCrescentSequence;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    int maxCrescentSequence = getMaxCrescentSegment(n);

    System.out.println(maxCrescentSequence);
  }
}
