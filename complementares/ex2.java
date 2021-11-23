import java.util.Scanner;

public class ex2 {
  public static double distanceBetweenPoints(int x1, int x2, int y1, int y2) {
    return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2 - x1), 2));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int centerX = scanner.nextInt();
    int centerY = scanner.nextInt();
    int radius = scanner.nextInt();
    int x, y = 0;

    int nOfPoints = 0;

    do {
      x = scanner.nextInt();
      y = scanner.nextInt();

      if (distanceBetweenPoints(x, centerX, y, centerY) < radius) {
        nOfPoints++;
      }
    } while (x != centerX && y != centerY);

    System.out.println(nOfPoints);
  }
}
