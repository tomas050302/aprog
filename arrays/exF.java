import java.util.Scanner;

public class exF {
  static Scanner scanner = new Scanner(System.in);

  private static double[] getMonthlyTaxes() {
    final int N_OF_MONTHS = 6;
    double[] taxes = new double[N_OF_MONTHS];

    for (int i = 0; i < N_OF_MONTHS; i++)
      taxes[i] = scanner.nextDouble();

    return taxes;
  }

  private static double calculateFinalValue(double initialDeposit, double[] taxes) {
    double finalValue = initialDeposit;

    for (double tax : taxes)
      finalValue += finalValue * tax;

    return finalValue;
  }

  public static void main(String[] args) {
    double[] taxes = getMonthlyTaxes();

    double initialDeposit = scanner.nextDouble();

    System.out.printf("valor final=%.2f%n", calculateFinalValue(initialDeposit, taxes));
  }
}
