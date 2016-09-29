import java.util.Scanner;
import java.util.Random;

public class Desert {
    private Scanner scan = new Scanner(System.in);
    private Random r = new Random();

    public int findTreasure() {
        int randLost = r.nextInt(10);
        if (randLost == 1) { //10% because 1 is one of the 10 possible numbers
            do {
                lost();
            } while (lost());
        }
        int randTreasure = r.nextInt(500) + 1;
        return randTreasure;
    }

    public boolean lost() {
        System.out.println("You have gotten lost! Press 1 to try escaping the"
            + " Desert.\nHopefully you can make it out alive.");
        int move = scan.nextInt();
        return (move == 1) ? false : true;
    }
}
