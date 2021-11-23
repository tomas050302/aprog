import java.util.Scanner;

public class exZ {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    double nOfEvenDigits = 0;
    int greatestOddDigit = 0;

    double nOfDigits = 0;

    while (n > 0) {
      int digit = n % 10;

      if (digit % 2 == 0)
        nOfEvenDigits++;
      else {
        if (digit > greatestOddDigit)
          greatestOddDigit = digit;
      }

      nOfDigits++;
      n /= 10;
    }

    System.out.format("%.2f", nOfEvenDigits / nOfDigits * 100);
    System.out.print("%\n");

    if (greatestOddDigit == 0)
      System.out.println("nao ha algarismos impares");
    else
      System.out.println(greatestOddDigit);
  }
}
