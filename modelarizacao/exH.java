import java.util.Scanner;

public class exH {
  public static boolean isPalindrome(int n) {
    int original = n;
    int result = 0;

    while (n > 0) {
      result = result * 10 + (n % 10);
      n /= 10;
    }

    return result == original;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    boolean found = false;
    final int MAX_TRIES = 5;
    int i = 0;

    while (!found && i < MAX_TRIES) {
      int n = scanner.nextInt();

      if (isPalindrome(n))
        found = true;
      i++;
    }

    if (found)
      System.out.println("capicua");
    else
      System.out.println("tentativas excedidas");
  }
}
