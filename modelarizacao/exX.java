import java.util.Scanner;

public class exX {
  public static boolean isPalindrome(String word) {
    StringBuilder reversedWord = new StringBuilder();

    for (int i = word.length() - 1; i >= 0; i--) {
      reversedWord.append(word.charAt(i));
    }

    return reversedWord.toString().equals(word);
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    String word = "";
    int i = 0;

    do {
      word = scanner.next();
      i++;
    } while (!isPalindrome(word));

    System.out.println(i - 1);
  }
}
