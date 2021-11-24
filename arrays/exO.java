import java.util.Scanner;

public class exO {
  static Scanner scanner = new Scanner(System.in);

  private static int[][] readMatrix(int size) {
    int[][] matrix = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    return matrix;
  }

  /**
   * 
   * @param matrix      The matrix to get the sum
   * @param rowStart    Start index for both row (inclusive)
   * @param rowEnd      End index for both row (exclusive)
   * @param columnStart End index for both row (exclusive)
   * @param columnEnd   End index for both row (exclusive)
   * @return Sum of all elements in the region delimitated by params
   */
  private static int getSumFrom(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd) {
    int sum = 0;

    for (int i = rowStart; i < rowEnd; i++)
      for (int j = columnStart; j < columnEnd; j++)
        sum += matrix[i][j];

    return sum;
  }

  public static void main(String[] args) {
    int n = scanner.nextInt();

    int[][] matrix = readMatrix(n);

    int topLeftSum = getSumFrom(matrix, 0, matrix.length / 2, 0, matrix.length / 2);
    int topRightSum = getSumFrom(matrix, 0, matrix.length / 2, matrix.length / 2, matrix.length);
    int bottomLeftSum = getSumFrom(matrix, matrix.length / 2, matrix.length, 0, matrix.length / 2);
    int bottomRightSum = getSumFrom(matrix, matrix.length / 2, matrix.length, matrix.length / 2, matrix.length);

    System.out.printf("[%d][%d]%n", topLeftSum, topRightSum);
    System.out.printf("[%d][%d]%n", bottomLeftSum, bottomRightSum);
  }
}
