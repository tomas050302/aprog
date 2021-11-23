import java.util.Scanner;

public class exD {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    while (n > 0) {
      boolean hasOddNumbers = false;

      int result = 1;
      int digit = 0;

      while (n > 0) {
        digit = n % 10;
        n /= 10;

        if (digit % 2 == 1) {
          hasOddNumbers = true;
          result *= digit;
        }
      }

      if (hasOddNumbers)
        System.out.println(result);
      else
        System.out.println("nao ha algarismos impares");

      n = scanner.nextInt();
    }
  }
}
