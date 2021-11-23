import java.util.Scanner;

public class exC {
  public static double calculateAngle(double a, double b, double c) {
    return Math.toDegrees(Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
  }

  public static boolean isTriangleValid(double a, double b, double c) {
    if (a + b <= c || a + c <= b || b + c <= a)
      return false;
    else
      return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double a = scanner.nextDouble();
    double b = scanner.nextDouble();
    double c = scanner.nextDouble();

    if (isTriangleValid(a, b, c)) {
      System.out.printf("a=%.2f%n", a);
      System.out.printf("b=%.2f%n", b);
      System.out.printf("c=%.2f%n", c);

      System.out.printf("ang(a,b)=%.2f%n", calculateAngle(a, b, c));
      System.out.printf("ang(a,c)=%.2f%n", calculateAngle(a, c, b));
      System.out.printf("ang(b,c)=%.2f%n", calculateAngle(b, c, a));
    } else {
      System.out.print("impossivel");
    }
  }
}
