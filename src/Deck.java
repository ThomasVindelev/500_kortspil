import java.util.Random;

public class Deck {

    private int[] deck = new int[53];

    public int[] shuffleDeck() {
        for (int i = 1; i < deck.length; i++) {
            deck[i] = i;
        }
        return deck;
    }

    public int[] dealCards(int[] deck) {
        Random card = new Random();
        int[] cardsOnHand = new int[53];
        for (int i = 1; i <= 7; i++) {
            int cardType = card.nextInt(53);
            if (deck[cardType] == -1) {
                i--;
            } else {
                cardsOnHand[i] = deck[cardType];
                deck[cardType] = -1;
            }
        }
        return cardsOnHand;
    }

    public void drawCard(int[] deck, int[] playerHand) {
        Random draw = new Random();
        boolean hasDrawn = false;
        while (!hasDrawn) {
            int cardTypeDraw = draw.nextInt(52);
            if (deck[cardTypeDraw + 1] != -1) {
                playerHand[cardTypeDraw + 1] = deck[cardTypeDraw + 1];
                hasDrawn = true;
                deck[cardTypeDraw + 1] = -1;
                identifyCards(playerHand);
            }
        }
    }

    public void removeCard(int[] playerHand) {
        System.out.println("Læg ét kort i bunken.");
        for (int i = 1; i <= 7; i++) {

        }
    }

    public void rearrangeCards(int[] playerHand, int remainingCards, int removedCard) {
        for (int i = removedCard; i <= remainingCards; i++) {
            playerHand[i] = playerHand[i+1];
            if (i == remainingCards) {
               playerHand[i] = 0;
            }
        }
    }

    public void identifyCards(int[] playerHand) {
        for (int i = 1; i < playerHand.length; i++) {
            if (playerHand[i] > 0 && playerHand[i] < 14) {
                System.out.print("♠ ");
                if (playerHand[i] == 1) {
                    System.out.println("Es");
                } else if (playerHand[i] < 11 && playerHand[i] > 1) {
                    System.out.println(i);
                } else if (playerHand[i] == 11) {
                    System.out.println("Bonde");
                } else if (playerHand[i] == 12) {
                    System.out.println("Dronning");
                } else if (playerHand[i] == 13) {
                    System.out.println("Konge");
                }
            } else if (playerHand[i] > 13 && playerHand[i] < 27) {
                System.out.print("♣ ");
                if (playerHand[i] == 14) {
                    System.out.println("Es");
                } else if (playerHand[i] < 24 && playerHand[i] > 14) {
                    System.out.println(i - 13);
                } else if (playerHand[i] == 24) {
                    System.out.println("Bonde");
                } else if (playerHand[i] == 25) {
                    System.out.println("Dronning");
                } else if (playerHand[i] == 26) {
                    System.out.println("Konge");
                }
            } else if (playerHand[i] > 26 && playerHand[i] < 40) {
                System.out.print("♦ ");
                if (playerHand[i] == 27) {
                    System.out.println("Es");
                } else if (playerHand[i] < 37 && playerHand[i] > 27) {
                    System.out.println(i - (13*2));
                } else if (playerHand[i] == 37) {
                    System.out.println("Bonde");
                } else if (playerHand[i] == 38) {
                    System.out.println("Dronning");
                } else if (playerHand[i] == 39) {
                    System.out.println("Konge");
                }
            } else if (playerHand[i] > 39 && playerHand[i] < 53) {
                System.out.print("♥ ");
                if (playerHand[i] == 40) {
                    System.out.println("Es");
                } else if (playerHand[i] < 50 && playerHand[i] > 40) {
                    System.out.println(i - (13*3));
                } else if (playerHand[i] == 50) {
                    System.out.println("Bonde");
                } else if (playerHand[i] == 51) {
                    System.out.println("Dronning");
                } else if (playerHand[i] == 52) {
                    System.out.println("Konge");
                }
            }
        }
    }
}