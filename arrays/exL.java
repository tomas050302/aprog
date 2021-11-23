import java.util.Arrays;
import java.util.Scanner;

public class exL {
  static Scanner scanner = new Scanner(System.in);

  private static int[] readNumbersSequence() {
    final int MAX_NUMBERS = 30;
    int n = 1;
    int i = 0;

    int[] sequence = new int[MAX_NUMBERS];

    do {
      n = scanner.nextInt();
      if (n > 0) {
        sequence[i] = n;
        i++;
      }
    } while (n > 0 && i < MAX_NUMBERS);

    return Arrays.copyOf(sequence, i);
  }

  public static void main(String[] args) {
    int[] numbers = readNumbersSequence();

    for (int i = 1; i < numbers.length - 1; i++) {
      if (numbers[i] > numbers[i + 1] && numbers[i] > numbers[i - 1])
        System.out.println(numbers[i]);
    }
  }
}
