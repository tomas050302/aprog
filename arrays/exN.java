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
      for (int i = 0; i < N; i++) {
        for (int j = N - i; j < N; j++) {
          System.out.printf("[%d]", matrix[k][j]);
        }

        System.out.println("");
      }
    }
  }
}
