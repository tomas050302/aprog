import java.util.Scanner;

public class exP3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int original = n;
    boolean found = false;

    while (original >= 0 && !found) {
      int pos1 = 1;
      n = original;
      while (n > 0) {
        int digit = n % 10;

        int temp = n / 10;

        int pos2 = pos1 + 1;

        while (temp > 0 && !found) {
          int duplicateDigit = temp % 10;

          if (duplicateDigit == digit) {
            System.out.printf("%d : algarismo (%d) repetido nas posicoes (%d) e (%d)%n", original, digit, pos1, pos2);
            found = true;
          }

          pos2++;
          temp /= 10;
        }

        pos1++;
        n /= 10;
      }

      original = scanner.nextInt();
    }

  }
}
