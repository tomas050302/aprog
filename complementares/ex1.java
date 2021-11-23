import java.util.Scanner;

public class ex1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int lastFloor = 0;
    int elevatorTrips = 0;

    for (int i = 0; i < n; i++) {
      int info = scanner.nextInt();
      int currentFloor = info / 10;

      if (currentFloor != lastFloor) {
        elevatorTrips++;
        lastFloor = currentFloor;
      }
    }

    System.out.println(elevatorTrips + 1);
  }
}
