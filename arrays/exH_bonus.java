import java.util.Scanner;

public class exH_bonus {
  static Scanner scanner = new Scanner(System.in);

  private static int[] readSequence(int n) {
    int[] sequence = new int[n];

    for (int i = 0; i < n; i++)
      sequence[i] = scanner.nextInt();

    return sequence;
  }

  private static int[] fillTemp(int[] arr, int nTimes, boolean rightSide) {
    int[] temp = new int[nTimes];
    if (rightSide) {
      for (int i = arr.length - 1; i > nTimes; i--) {
        temp[i] = arr[i];
      }
    } else {
      for (int i = 0; i < nTimes; i++) {
        temp[i] = arr[i];
      }
    }

    return temp;
  }

  private static void rotateRight(int[] arr, int nTimes) {
    int temp[] = fillTemp(arr, nTimes, true);

    for (int i = arr.length - nTimes; i >= nTimes; i--) {
      arr[i] = arr[i - 1];
    }

    for (int i = 0; i < temp.length; i++) {
      arr[i] = temp[i];
    }
  }

  private static void rotateLeft(int[] arr, int nTimes) {
    int temp[] = fillTemp(arr, nTimes, false);

    for (int i = nTimes; i < arr.length - nTimes; i++) {
      arr[i] = arr[i + 1];
    }

    for (int i = temp.length - 1; i >= 0; i--) {
      arr[i] = temp[i];
    }
  }

  private static void performAction(int[] sequence, String action, int nTimes) {
    nTimes %= sequence.length;

    boolean invertAction = false;
    if (nTimes > sequence.length / 2) {
      invertAction = true;
      nTimes = sequence.length - nTimes;
    }

    if (action.equals("direita")) {
      if (invertAction)
        rotateLeft(sequence, nTimes);
      else
        rotateRight(sequence, nTimes);
    } else if (action.equals("esquerda")) {
      if (invertAction)
        rotateRight(sequence, nTimes);
      else
        rotateLeft(sequence, nTimes);
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
      int nTimes = Integer.parseInt(scanner.nextLine());

      if (!action.equals("sair")) {
        performAction(sequence, action, nTimes);
        printSequence(sequence);
      }
    } while (!action.equals("sair"));
  }
}
