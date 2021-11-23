import java.util.Scanner;

public class exH {
  static Scanner scanner = new Scanner(System.in);

  private static int[] readSequence(int n) {
    int[] sequence = new int[n];

    for (int i = 0; i < n; i++)
      sequence[i] = scanner.nextInt();

    return sequence;
  }

  private static void performAction(int[] sequence, String action) {
    if (action.equals("direita")) {
      int temp = sequence[sequence.length - 1];

      for (int i = sequence.length - 1; i >= 1; i--) {
        sequence[i] = sequence[i - 1];
      }

      sequence[0] = temp;
    } else if (action.equals("esquerda")) {
      int temp = sequence[0];

      for (int i = 0; i < sequence.length - 1; i++) {
        sequence[i] = sequence[i + 1];
      }

      sequence[sequence.length - 1] = temp;
    }
  }

  private static void printSequence(int[] sequence) {
    for (int element : sequence)
      System.out.printf("[%d]", element);

    System.out.println("");
  }

  public static void main(String[] args) {
    int n = scanner.nextInt();

    int[] sequence = readSequence(n);
    String action = "";
    scanner.nextLine();
    do {
      action = scanner.nextLine();
      if (!action.equals("sair")) {
        performAction(sequence, action);
        printSequence(sequence);
      }
    } while (!action.equals("sair"));
  }
}
