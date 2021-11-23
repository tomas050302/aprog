import java.util.Scanner;

public class ex6 {
  private static int persistency(int n) {
    if (n < 10)
      return 0;

    int digitProduct = 1;
    while (n > 0) {
      int digit = n % 10;
      digitProduct *= digit;
      n /= 10;
    }

    return 1 + persistency(digitProduct);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    System.out.println(persistency(n));
  }
}
