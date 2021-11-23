import java.util.Scanner;

public class exF {
  public static Scanner scanner = new Scanner(System.in);

  public static double calculateSolidVolume(double r, double h, double k) {
    return k * Math.PI * Math.pow(r, 2) * h;
  }

  public static void getSolidInformation(String shape) {
    double r = scanner.nextDouble();
    double h;

    if (shape.equals("esfera"))
      h = r;
    else
      h = scanner.nextDouble();

    if (r > 0 && h > 0) {
      double k = 0;

      if (shape.equals("cilindro"))
        k = 1;
      else if (shape.equals("esfera"))
        k = (double) (4) / 3;
      else if (shape.equals("cone"))
        k = (double) (1) / 3;

      if (k > 0)
        System.out.printf("%.2f%n", calculateSolidVolume(r, h, k));
    }
  }

  public static void main(String[] args) {
    String shape = scanner.next();

    while (!shape.equals("fim")) {
      if (shape.equals("cilindro") || shape.equals("cone") || shape.equals("esfera"))
        getSolidInformation(shape);
      shape = scanner.next();
    }
  }
}
