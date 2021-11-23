import java.util.Scanner;

public class exF {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int reversedNumber = 0;
    int digit = 0;

    int original = n;

    while (n > 0) {
      digit = n % 10;

      reversedNumber = reversedNumber * 10 + digit;

      n /= 10;
    }

    if (original > 0) {
      if (reversedNumber == original)
        System.out.println("capicua");
      else
        System.out.println("nao capicua");
    }
  }
}
