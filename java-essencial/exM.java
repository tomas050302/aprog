import java.util.Scanner;

public class exM {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    long last = 0;
    long current = 1;

    if (n > 0)
      System.out.println(last);

    if (n > 1)
      System.out.println(last + current);

    for (int i = 1; i < n - 1; i++) {
      System.out.println(last + current);
      long temp = last;
      last = current;
      current = temp + current;
    }
  }
}
