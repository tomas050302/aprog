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
        System.out.printf("[%d]", matrix[i][N - 1 - k + i]);
      }
      System.out.println("");
    }

    for (int k = N - 2; k >= 0; k--) {
      for (int i = 0; i <= k; i++) {
        System.out.printf("[%d]", matrix[N - 1 - k + i][i]);
      }
      System.out.println("");
    }

  }
}
