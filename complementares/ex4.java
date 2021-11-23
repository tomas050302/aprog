import java.util.Scanner;

public class ex4 {
  public static boolean isOctal(int n) {
    while (n > 0) {
      // If any digit of the number is greater than 7, the number is not octal
      if (n % 10 > 7)
        return false;
      n /= 10;
    }

    return true;
  }

  public static int convertToDecimal(int n) {
    int sum = 0;
    int power = 0;

    while (n > 0) {
      int digit = n % 10;
      sum += digit * Math.pow(8, power);

      power++;
      n /= 10;
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean flag = true;

    do {
      int n = scanner.nextInt();
      flag = isOctal(n);

      if (flag)
        System.out.println(convertToDecimal(n));

    } while (flag);
  }
}
