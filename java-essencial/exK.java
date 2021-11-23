import java.util.Scanner;

public class exK {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    for (int i = 2; i <= n; i++) {
      boolean isPrime = true;
      int j = 2;

      while (isPrime && j <= Math.sqrt(i)) {
        if (i % j == 0)
          isPrime = false;
        j++;
      }

      if (isPrime && i != 1)
        System.out.println(i);
    }
  }
}
