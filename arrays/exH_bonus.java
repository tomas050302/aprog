import java.util.Scanner;

/*
  Melhorias aplicadas:
  - Adicionada a possibilidade de especificar o número de vezes que uma ação é realizada
  - Ex.: direita 5 -> rodar 5x o array para a direita

  - De notar as seguintes situações nestas rotações:
    - Se nº de rotações > N, nº de rotações é simplificado para nRotacoes % N
    - Se nº de rotações > N / 2 -> rotação é invertida (esquerda -> direita)
    e são realizadas, no limite, N / 2 operações.
    - Cada vez que se aplica uma transformação o array só é percorrido uma vez.
    Cada alteração a um elemento do array coloca o mesmo no seu destino final.
    Desta forma, em vez de serem realizadas nRotacoes * N são realizadas apenas 
    N operações.

    (Nota: N = tamanho do array)

  - Desta forma, o limite de iterações que o programa faz deixa de ser definido
  pelo utilizador e passa a ser apenas dependente de N.

  - (1) Numa situação limite, sem otimizações, este programa realizaria:
      nRotacoes * N
  - (2) Com a otimização de nRotacoes %= N;
      N ^ 2
  - (3) Da maneira otimizada:
      N * (N / 2)

  - Ex.: N = 10000; nRotacoes = 1000000000
    (1) 1000000000000
    (2) 100000000
    (3) 50000000
  */

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
      for (int j = 0; j < nTimes; j++) {
        temp[j] = arr[Math.abs(-arr.length + nTimes - j)];
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

    for (int i = arr.length - 1; i >= nTimes; i--) {
      arr[i] = arr[i - nTimes];
    }

    for (int i = 0; i < nTimes; i++) {
      arr[i] = temp[i];
    }
  }

  private static void rotateLeft(int[] arr, int nTimes) {
    int temp[] = fillTemp(arr, nTimes, false);

    for (int i = 0; i < arr.length - nTimes; i++) {
      arr[i] = arr[i + nTimes];
    }

    for (int i = 0; i < nTimes; i++) {
      arr[Math.abs(-arr.length + nTimes - i)] = temp[i];
    }
  }

  private static void printArray(int[] arr) {
    for (int i : arr) {
      System.out.println(i);
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

      if (!action.equals("sair")) {
        int nTimes = Integer.parseInt(scanner.nextLine());
        performAction(sequence, action, nTimes);
        printSequence(sequence);
      }
    } while (!action.equals("sair"));
  }
}
