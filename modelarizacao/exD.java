import java.util.Scanner;

public class exD {
  public static int fatorial(int n) {
    if (n < 1)
      return 1;
    return n * fatorial(n - 1);
  }

  public static int combinacoes(int m, int n) {
    return fatorial(m) / (fatorial(n) * fatorial(m - n));
  }

  public static int permutacoes(int m, int n) {
    return fatorial(m) / fatorial(m - n);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int m = scanner.nextInt();
    int n = scanner.nextInt();

    if (m >= n) {
      System.out.printf("C(%d,%d)=%d%n", m, n, combinacoes(m, n));
      System.out.printf("P(%d,%d)=%d%n", m, n, permutacoes(m, n));

    }
  }
}
