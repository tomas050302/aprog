import java.util.Scanner;

public class ex3a {
  private static boolean isPerfect(int n) {
    int sumOfDivisors = 0;

    for (int i = 1; i <= n / 2; i++) {
      if (n % i == 0)
        sumOfDivisors += i;
    }

    return sumOfDivisors == n;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    if (isPerfect(n))
      System.out.println("É perfeito");
    else
      System.out.println("Não é perfeito");
  }
}
