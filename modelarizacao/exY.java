import java.util.Scanner;

public class exY {
  static Scanner scanner = new Scanner(System.in);

  public static int lerValorInteiroPositivo() {
    int n;

    do {
      n = scanner.nextInt();
    } while (n <= 0);

    return n;
  }

  public static void mostrarTabuadaDoNumero(int n) {
    System.out.printf("Tabuada de %d%n", n);

    for (int i = 1; i <= 10; i++) {
      System.out.printf("%d x %d = %d%n", n, i, i * n);
    }
  }

  public static void mostrarTabuadasDoIntervalo(int min, int max) {
    if (min > max) {
      int temp = max;
      max = min;
      min = temp;
    }

    for (int i = min; i <= max; i++) {
      mostrarTabuadaDoNumero(i);
    }
  }

  public static void main(String[] args) {
    int min = lerValorInteiroPositivo();
    int max = lerValorInteiroPositivo();

    mostrarTabuadasDoIntervalo(min, max);
  }
}
