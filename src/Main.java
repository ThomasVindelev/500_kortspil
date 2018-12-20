import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isOver = false;
        System.out.println("Velkommen til 500!\n1. Start spil   2. Afslut spil");
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        Deck deck = new Deck();

        while (!isOver) {
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                int theDeck[][] = deck.shuffleDeck();
                int[][] player1Hand = deck.dealCards(theDeck);
                deck.identifyCards(player1Hand);
                int[][] player2Hand = deck.dealCards(theDeck);
                System.out.println("--------");
                deck.identifyCards(player2Hand);
                game.newGame(player1Hand, player2Hand, theDeck);
            } else if (choice.equals("2")) {
                isOver = true;
            } else {
                System.out.println("Ikke en mulighed.\n1. Start spil   2. Afslut spil");
            }
        }
    }
}