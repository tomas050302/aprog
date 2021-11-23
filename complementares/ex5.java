import java.util.Scanner;

public class ex5 {

  private static int sumOfPairDivisors(int n) {
    int sum = 0;

    for (int i = 1; i <= n / 2; i++)
      if (n % i == 0)
        sum += i;

    return sum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int greatestSum = 0;
    int nOfGreatNumbers = 0;
    int nOfNumbers = 0;
    int n = 0;

    do {
      n = scanner.nextInt();
      int sumOfDivisors = sumOfPairDivisors(n);

      if (sumOfDivisors > greatestSum) {
        greatestSum = sumOfDivisors;
        nOfGreatNumbers = 0;
      } else if (sumOfDivisors == greatestSum)
        nOfGreatNumbers++;

      nOfNumbers++;
    } while (n > 0);

    System.out.printf("%.2f", ((double) nOfGreatNumbers / (nOfNumbers - 1)) * 100);
    System.out.println("%");
  }
}
