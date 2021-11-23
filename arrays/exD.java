import java.util.Scanner;

public class exD {
  static Scanner scanner = new Scanner(System.in);

  private static int[] readGrades(int nOfStudents) {
    int[] grades = new int[nOfStudents];

    for (int i = 0; i < grades.length; i++) {
      grades[i] = scanner.nextInt();
    }

    return grades;
  }

  private static int getFrequencyOfGrade(int grade, int[] grades) {
    int frequency = 0;

    for (int element : grades) {
      if (element == grade)
        frequency++;
    }

    return frequency;
  }

  private static void showGradeFrequency(int[] grades) {
    for (int i = 0; i <= 20; i++) {
      int frequencyOfGrade = getFrequencyOfGrade(i, grades);

      System.out.printf("%d %d%n", i, frequencyOfGrade);
    }
  }

  public static void main(String[] args) {

    int nOfStudents = scanner.nextInt();

    int[] grades = readGrades(nOfStudents);

    showGradeFrequency(grades);
  }
}
