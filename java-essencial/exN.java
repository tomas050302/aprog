import java.util.Scanner;

public class exN {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int last = n + 1;

    while (n >= 0) {
      if (n > last) {
        int lastDigit = n % 10;
        int temp = n / 10;
        boolean digitsAreCrescent = true;

        while (temp > 0) {
          int digit = temp % 10;

          if (digit >= lastDigit) {
            digitsAreCrescent = false;
          }

          lastDigit = digit;
          temp /= 10;
        }

        if (digitsAreCrescent)
          System.out.println(n);
      }

      last = n;
      n = scanner.nextInt();
    }
  }
}
