import java.util.Scanner;

import javax.lang.model.type.PrimitiveType;

public class exZ {
  static Scanner scanner = new Scanner(System.in);

  public static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0)
        return false;
    }

    return true;
  }

  public static int permuteNumber(int n) {
    int nOfDigits = 0;

    int temp = n;

    while (temp > 0) {
      nOfDigits++;
      temp /= 10;
    }

    int lastDigit = n % 10;

    n += lastDigit * Math.pow(10, nOfDigits);
    n /= 10;

    return n;
  }

  public static boolean isFullTimePrime(int n) {
    int original = n;
    int permutedNumber = permuteNumber(n);

    if (!isPrime(permutedNumber))
      return false;

    while (permutedNumber != original) {
      permutedNumber = permuteNumber(permutedNumber);
      if (!isPrime(permutedNumber))
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    int x = scanner.nextInt();
    int y = scanner.nextInt();

    int nOfFullTimePrimes = 0;

    for (int i = x; i <= y; i++) {
      if (isPrime(i)) {
        if (isFullTimePrime(i)) {
          System.out.println(i);
          nOfFullTimePrimes++;
        }
      }
    }

    System.out.printf("(%d)%n", nOfFullTimePrimes);
  }
}
