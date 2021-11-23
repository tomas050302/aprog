import java.util.Scanner;

public class exI {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int smallest;

    int mmc;

    if (a > b) {
      mmc = a;
      smallest = b;
    } else {
      mmc = b;
      smallest = a;
    }

    int i = 1;

    while ((mmc * i) % smallest != 0)
      i++;

    System.out.println(mmc * i);
  }
}
