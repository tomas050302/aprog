import java.util.Scanner;

public class exG {
  public static boolean isArmstrong(int n) {
    int nOfDigits = 0;
    int sumOfDigits = 0;
    int original = n;

    while (n > 0) {
      nOfDigits++;
      n /= 10;
    }

    n = original;

    while (n > 0) {
      sumOfDigits += Math.pow((n % 10), nOfDigits);
      n /= 10;
    }

    return sumOfDigits == original;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    for (int i = 0; i <= n; i++) {
      if (isArmstrong(i))
        System.out.println(i);
    }
  }
}
