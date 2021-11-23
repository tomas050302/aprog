import java.util.Scanner;

public class exO {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int bannedN = scanner.nextInt();
    int numberOfPizzas = scanner.nextInt();
    int nOfNotBanned = 1;

    for (int i = 0; i < numberOfPizzas; i++) {
      int n = scanner.nextInt();
      int temp = n;
      boolean isBanned = false;

      while (temp > 0) {
        int digit = temp % 10;

        int tempBanned = bannedN;
        while (tempBanned > 0) {
          int bannedDigit = tempBanned % 10;

          if (bannedDigit == digit)
            isBanned = true;
          tempBanned /= 10;
        }

        temp /= 10;
      }

      if (!isBanned) {
        System.out.println("Sugestao #" + nOfNotBanned + ":" + n);
        nOfNotBanned++;
      }
    }
  }
}
