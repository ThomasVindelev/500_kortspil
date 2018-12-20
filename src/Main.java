import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isOver = false;
        System.out.println("Velkommen til 500!\n1. Start spil   2. Afslut spil");
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Deck deck = new Deck();
        int[][] playerHand;

        while (!isOver) {
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                int theDeck[][] = deck.shuffleDeck();
                playerHand = deck.dealCards(theDeck);
                deck.identifyCards(playerHand);

            } else if (choice.equals("2")) {
                isOver = true;
            } else {
                System.out.println("Ikke en mulighed.\n1. Start spil   2. Afslut spil");
            }
        }
    }
}
