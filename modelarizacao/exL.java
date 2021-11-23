import java.util.Scanner;

public class exL {
  public static int countWords(String phrase) {
    String[] words = phrase.split(" ");
    int nOfWords = 0;

    for (String word : words)
      if (!word.equals(""))
        nOfWords++;

    return nOfWords;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String phrase = scanner.nextLine();

    int nOfWords = countWords(phrase);

    System.out.println(nOfWords);
  }
}
