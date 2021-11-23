import java.util.Scanner;

public class exP {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int original = 1;

    while (original > 0) {
      int n = scanner.nextInt();
      original = n;
      int pos1 = 1;

      int used = -1;
      boolean isUsed = false;

      while (n > 0) {
        int digit = n % 10;

        int temp = n / 10;
        int pos2 = pos1 + 1;

        while (temp > 0) {
          int tempDigit = temp % 10;

          if (tempDigit == digit) {
            isUsed = false;
            int usedTemp = used;

            while (usedTemp > 0) {
              int usedDigit = usedTemp % 10;

              if (usedDigit == digit)
                isUsed = true;

              usedTemp /= 10;
            }

            if (!isUsed) {
              System.out.printf("%d : algarismo (%d) repetido nas posicoes (%d) e (%d)%n", original, digit, pos1, pos2);

              if (used == -1)
                used = digit;
              else {
                used = used * 10 + tempDigit;
              }
            }

            System.out.printf("used: %d%n", used);
          }

          temp /= 10;
          pos2++;
        }

        if (used == 0 && digit == 0)
          isUsed = true;

        pos1++;
        n /= 10;
      }
    }
  }
}
