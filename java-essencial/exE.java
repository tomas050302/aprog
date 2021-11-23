import java.util.Scanner;

public class exE {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int BASE = 8;

    int n = scanner.nextInt();

    while (n > 0) {
      int order = 0;
      int digit = 0;
      int result = 0;

      while (n > 0) {
        digit = n % 10;

        result += digit * Math.pow(BASE, order);
        order++;

        n /= 10;
      }

      System.out.println(result);

      n = scanner.nextInt();
    }
  }
}
