import java.util.Scanner;

public class exN {
  static Scanner scanner = new Scanner(System.in);

  private static int[][] readMatrix(int n) {
    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    return matrix;
  }

  public static void main(String[] args) {
    int N = scanner.nextInt();

    int[][] matrix = readMatrix(N);

    for (int k = 0; k < N; k++) {
      for (int i = 0; i <= k; i++) {
        // The values of the indexes diagonal would be given by the expression k - i
        // As the sequence needs to be crescent the absolute value of this expression is
        // suitable
        int j = Math.abs(-N + k - i + 1);
        System.out.printf("[%d]", matrix[i][j]);
      }
      System.out.println("");
    }

    // Invert the cycle

    // k = N - 2 to skip the main diagonal
    for (int k = N - 2; k >= 0; k--) {
      for (int i = 0; i <= k; i++) {
        // The values of the indexes diagonal would be given by the expression k - i
        // As the sequence needs to be crescent the absolute value of this expression is
        // suitable
        int j = Math.abs(-N + k - i + 1);
        System.out.printf("[%d]", matrix[j][i]);
      }
      System.out.println("");
    }
  }
}
