import java.util.Scanner;

public class TrabalhoPratico {
  static final int CUBE_SIZE = 3;

  private static int[][] readInput() {
    Scanner scanner = new Scanner(System.in);

    // Read the description of the terrain
    scanner.nextLine();

    int rows = scanner.nextInt();
    int cols = scanner.nextInt();

    int[][] matrix = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    return matrix;
  }

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.printf("%3d", matrix[i][j]);
      }
      System.out.println("");
    }
  }

  private static void addOffsetToSeaLevel(int[][] matrix, int offset) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] -= offset;
      }
    }
  }

  private static double getPercentageFloodedMatrix(int[][] matrix) {
    int totalCells = matrix.length * matrix[0].length;

    int nOfSubmerseCells = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] < 0)
          nOfSubmerseCells++;
      }
    }

    return ((double) (nOfSubmerseCells) / totalCells) * 100;
  }

  private static boolean isFlooded(int element) {
    return (element < 0);
  }

  private static int getVariationOfFloodedMatrix(int[][] matrix) {
    int floodedCellCounter = 0;

    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (matrix[i][j] == 0)
          floodedCellCounter--;

    return floodedCellCounter;
  }

  private static int getFloodedVolume(int[][] matrix) {
    int floodedCellVolume = 0;

    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (isFlooded(matrix[i][j]))
          // The volume of a flooded cell is the negative value of the cell
          floodedCellVolume -= matrix[i][j];

    return floodedCellVolume;
  }

  private static int getMaxHeight(int[][] matrix) {
    int maxHeight = matrix[0][0];

    for (int i = 0; i < matrix.length; i++)
      for (int j = 0; j < matrix[0].length; j++)
        if (matrix[i][j] > maxHeight)
          maxHeight = matrix[i][j];

    return maxHeight;
  }

  private static int[][] copyArray(int[][] matrix) {
    int[][] copy = new int[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        copy[i][j] = matrix[i][j];
      }
    }

    return copy;
  }

  private static int[] getAreaIncrementsForFlooding(int[][] matrix, int maxHeight) {
    int[][] temp = copyArray(matrix);
    int[] increments = new int[maxHeight + 1];

    for (int i = 0; i < maxHeight + 1; i++) {
      int variationOfFloodedMatrix = getVariationOfFloodedMatrix(temp);
      increments[i] = -variationOfFloodedMatrix;
      addOffsetToSeaLevel(temp, 1);
    }

    return increments;
  }

  private static void printIncrementsHeader() {
    System.out.println("subida da agua (m) | area inundada (m2)");
    System.out.println("------------------ | ------------------");
  }

  private static void printFloodingIncrements(int[] increments) {
    printIncrementsHeader();
    for (int i = 0; i < increments.length; i++) {
      System.out.printf("%18d | %18d%n", i, increments[i]);
    }
    System.out.println("");
  }

  private static int getEasternDryColumn(int[][] matrix) {
    for (int i = matrix[0].length - 1; i >= 0; i--) {
      boolean dry = true;
      for (int j = matrix.length - 1; j >= 0; j--) {
        if (matrix[j][i] < 0)
          dry = false;
      }

      // As the column index is returned immediately, in case of multiple dry columns,
      // the eastern one is returned
      if (dry)
        return i;
    }

    return -1;
  }

  private static int calculateCellMobilizedDirt(int[][] matrix, int x, int y) {
    int cellMobilizedDirt = 0;

    if (isFlooded(matrix[x][y]))
      return cellMobilizedDirt = matrix[x][y] + CUBE_SIZE;
    else
      cellMobilizedDirt = matrix[x][y] + CUBE_SIZE;

    return Math.abs(cellMobilizedDirt);
  }

  private static int calculateMobilizedDirtToFloodCube(int[][] matrix, int x, int y) {
    int mobilizedDirt = 0;

    for (int i = x; i < x + CUBE_SIZE; i++)
      for (int j = y; j < y + CUBE_SIZE; j++)
        mobilizedDirt += calculateCellMobilizedDirt(matrix, i, j);

    return mobilizedDirt;
  }

  private static int getBestDirtRatioToFloodCube(int[][] matrix) {
    int minMobilizedDirt = Integer.MAX_VALUE; // TODO Refactor
    int maxX = 0, maxY = 0;

    // TODO: Optimize this algorithm
    for (int i = 0; i < matrix.length - CUBE_SIZE + 1; i++) {
      for (int j = 0; j < matrix[0].length - CUBE_SIZE + 1; j++) {
        int mobilizedDirt = calculateMobilizedDirtToFloodCube(matrix, i, j);

        // As is used > instead of >=, the selected cell is both the
        // northen-western one
        if (mobilizedDirt < minMobilizedDirt) {
          minMobilizedDirt = mobilizedDirt;
          maxX = i;
          maxY = j;
        }
      }
    }

    // ! Refactor (no printing inside the method)
    System.out.printf("coordenadas do cubo: (%d,%d)", maxX, maxY);
    return minMobilizedDirt;
  }

  public static void main(String[] args) {
    int[][] matrix = readInput();

    System.out.println("b)");
    printMatrix(matrix);

    System.out.println("c)");
    addOffsetToSeaLevel(matrix, -1);
    printMatrix(matrix);

    System.out.println("d)");
    double percentageOfFloodedMatrix = getPercentageFloodedMatrix(matrix);
    System.out.printf("area submersa: %.2f", percentageOfFloodedMatrix);
    System.out.println("%");

    System.out.println("e)");
    double variationOfFloodedMatrix = getVariationOfFloodedMatrix(matrix);
    System.out.printf("variacao da area inundada: %.2f m2%n", variationOfFloodedMatrix);

    System.out.println("f)");
    int floodedVolume = getFloodedVolume(matrix);
    System.out.printf("volume da agua: %d m3%n", floodedVolume);

    System.out.println("g)");
    int maxHeight = getMaxHeight(matrix);
    System.out.printf("para inundacao total :%d m%n", maxHeight + 1);

    System.out.println("h)");
    int[] increments = getAreaIncrementsForFlooding(matrix, maxHeight);
    printFloodingIncrements(increments);

    System.out.println("i)");
    // ! Dúvida: Percorrer 3x a matrix ou passar tudo por referencia?
    int mobilizedDirt = getBestDirtRatioToFloodCube(matrix);
    System.out.printf(", terra a mobilizar: %d m2%n", mobilizedDirt);

    System.out.println("j)");
    int dryColumn = getEasternDryColumn(matrix);
    if (dryColumn == -1)
      System.out.println("nao ha caminho seco na vertical");
    else
      System.out.printf("caminho seco na vertical na coluna (%d)%n", dryColumn);
  }
}
