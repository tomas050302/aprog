import java.util.Scanner;

public class exK {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String phrase = scanner.nextLine();
    String initialChar = scanner.next();
    String finalChar = scanner.next();

    if (initialChar.length() == 1 || finalChar.length() == 1) {
      String finalPhrase = phrase.replace(initialChar, finalChar);

      System.out.println(finalPhrase);
    }
  }
}
