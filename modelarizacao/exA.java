import java.util.Scanner;

public class exA {
  static final int K = 5;

  public static int numOfDigits(int n) {
    int nOfDigits = 0;
    int num = Math.abs(n);

    while (num > 0) {
      nOfDigits++;
      num /= 10;
    }

    return nOfDigits;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int maxDigits = scanner.nextInt();
    float sum = 0;
    int nOfNumbers = 0;

    int n = scanner.nextInt();

    while (numOfDigits(n) < maxDigits) {
      sum += n;
      nOfNumbers++;
      n = scanner.nextInt();
    }

    float result = sum / nOfNumbers;

    System.out.printf("%.2f%n", result);
  }
}
