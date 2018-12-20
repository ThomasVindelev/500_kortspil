import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isOver = false;
        System.out.println("Velkommen til 500!\n1. Start spil   2. Afslut spil");
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Deck deck = new Deck();
        int player1cards = 7;
        int player2cards = 7;

        while (!isOver) {
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                int theDeck[] = deck.shuffleDeck();
                int[] player1Hand = deck.dealCards(theDeck);
                deck.identifyCards(player1Hand);
                System.out.println("--------");
                String test = scanner.nextLine();
                while (test.equals("1")) {
                    deck.drawCard(theDeck, player1Hand);
                    test = scanner.nextLine();
                }
            } else if (choice.equals("2")) {
                isOver = true;
            } else {
                System.out.println("Ikke en mulighed.\n1. Start spil   2. Afslut spil");
            }
        }
    }
}