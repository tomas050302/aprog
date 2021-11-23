import java.util.Scanner;

public class exG {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    if (n > 0) {
      int nOfDivisors = 0;

      for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
          System.out.println(i);
          nOfDivisors++;
        }
      }

      System.out.println("(" + nOfDivisors + ")");
    }
  }
}
