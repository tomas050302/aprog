import java.util.Scanner;

public class exB {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    while (n > 0) {
      int sum = 0;
      int digit = 0;

      do {
        digit = n % 10;

        if (digit % 2 == 0) {
          sum += digit;
        }

        n /= 10;
      } while (n > 0);

      System.out.println(sum);
      n = scanner.nextInt();
    }

  }
}
