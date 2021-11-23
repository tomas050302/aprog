import java.util.Scanner;

public class exM {
  /**
   * Gets a phrase and capitalizes or turns it lower case given a conversion type
   * 
   * @param phrase           The phrase to convert
   * @param typeOfConversion > 0 to Upper Case or < 0 to Lower Case, if = 0
   *                         returns null
   */
  public static String convertPhrase(String phrase, int typeOfConversion) {
    if (typeOfConversion > 0)
      return phrase.toUpperCase();
    if (typeOfConversion < 0)
      return phrase.toLowerCase();

    return null;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String phrase = scanner.nextLine();

    String lowerCasePhrase = convertPhrase(phrase, -1);
    String upperCasePhrase = convertPhrase(phrase, 1);

    System.out.println(lowerCasePhrase);
    System.out.println(upperCasePhrase);
  }
}
