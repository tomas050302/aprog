import java.util.Scanner;

public class exL {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int nOfPerfectNumbers = 0;
    int i = 1;

    while (nOfPerfectNumbers < n) {
      int sumOfDivisors = 0;

      for (int j = 1; j <= i / 2; j++)
        if (i % j == 0)
          sumOfDivisors += j;

      if (sumOfDivisors == i) {
        nOfPerfectNumbers++;
        System.out.println(i);
      }

      i++;
    }
  }
}
