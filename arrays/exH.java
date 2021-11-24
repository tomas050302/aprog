import java.util.Scanner;

public class exH {
  static Scanner scanner = new Scanner(System.in);

  private static int[] readSequence(int n) {
    int[] sequence = new int[n];

    for (int i = 0; i < n; i++)
      sequence[i] = scanner.nextInt();

    return sequence;
  }

  private static void rotateRight(int[] arr) {
    int temp = arr[arr.length - 1];

    for (int i = arr.length - 1; i >= 1; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = temp;
  }

  private static void rotateLeft(int[] arr) {
    int temp = arr[0];

    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }

    arr[arr.length - 1] = temp;
  }

  private static void performAction(int[] sequence, String action) {
    if (action.equals("direita"))
      rotateRight(sequence);
    else if (action.equals("esquerda"))
      rotateLeft(sequence);
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
