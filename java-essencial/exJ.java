import java.util.Scanner;

public class exJ {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    if (n > 0) {
      double greatestPercentage = 0.00f;

      for (int i = 0; i < n; i++) {
        int x = scanner.nextInt();
        int originalNumber = x;
        double nOfDivisorDigits = 0;
        double nOfDigits = 0;

        do {
          int digit = x % 10;
          nOfDigits++;

          if (digit != 0 && originalNumber % digit == 0)
            nOfDivisorDigits++;

          x /= 10;
        } while (x > 0);

        double percentage = nOfDivisorDigits / nOfDigits * 100;

        if (percentage > greatestPercentage)
          greatestPercentage = percentage;

        System.out.format("%.2f", percentage);
        System.out.print("%\n");
      }

      System.out.print("(");
      System.out.format("%.2f", greatestPercentage);
      System.out.println("%)");
    }
  }
}
