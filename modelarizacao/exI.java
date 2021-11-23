import java.util.Scanner;

public class exI {
  public static int fibonacci(int n) {
    if (n == 0)
      return 0;
    if (n < 3)
      return 1;

    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int i = 0;
    int n = scanner.nextInt();
    int fibNum = 0;

    while (n > fibNum) {
      fibNum = fibonacci(i);
      i++;
    }

    if (fibNum == n)
      System.out.println("e de Fibonacci");
    else
      System.out.println("nao e de Fibonacci");
  }
}
