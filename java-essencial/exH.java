import java.util.Scanner;

public class exH {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    boolean isPrime = true;
    int i = 2;

    while (isPrime && i <= Math.sqrt(n)) {
      if (n % i == 0)
        isPrime = false;
      i++;
    }

    if (isPrime && n != 1)
      System.out.println("primo");
    else
      System.out.println("nao e primo");
  }
}
