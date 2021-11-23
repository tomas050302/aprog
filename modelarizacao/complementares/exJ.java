import java.util.Scanner;

public class exJ {
  public static Scanner scanner = new Scanner(System.in);

  public static void printBlankLines(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println("");
    }
  }

  public static int tryToGuess(int secret) {
    int nOfTries = 0;
    boolean found = false;

    do {
      int guess = scanner.nextInt();

      if (guess == secret) {
        System.out.println("Acertou");
        found = true;
      }
      if (secret > guess)
        System.out.println("Tente maior");
      else if (secret < guess)
        System.out.println("Tente menor");

      nOfTries++;
    } while (!found);

    return nOfTries;
  }

  public static void main(String[] args) {
    final int N_OF_BLANK_LINES = 30;

    int secret = scanner.nextInt();

    printBlankLines(N_OF_BLANK_LINES);

    int nOfTries = tryToGuess(secret);

    System.out.println(nOfTries);
  }
}
