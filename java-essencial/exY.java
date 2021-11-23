import java.util.Scanner;

public class exY {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();

    boolean hasDivisors = false;

    for (int i = 1; i <= n / 2; i++) {
      if (n % i == 0 && i % 3 == 0) {
        System.out.println(i);
        hasDivisors = true;
      }
    }

    if (!hasDivisors)
      System.out.println("sem divisores multiplos de 3");
  }
}
