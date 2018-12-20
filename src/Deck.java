import java.util.Random;

public class Deck {

    private int[][] deck = new int[4][13];

    public int[][] shuffleDeck() {
        for (int i = 0; i < deck.length; i++) {
            for (int j = 1; j < deck[i].length + 1; j++) {
                if (i == 0) {
                    deck[i][j-1] = j;
                } else if (i == 1) {
                    deck[i][j-1] = j + 20;
                } else if (i == 2) {
                    deck[i][j-1] = j + 40;
                } else if (i == 3) {
                    deck[i][j-1] = j + 60;
                }
            }
        }
        return deck;
    }

    public int[][] dealCards(int[][] deck) {
        Random colour = new Random();
        Random card = new Random();
        int[][] cardsOnHand = new int[4][13];
        for (int i = 0; i < 7; i++) {
            int cardColour = colour.nextInt(4);
            int cardType = card.nextInt(13);
            if (deck[cardColour][cardType] == -1) {
                i--;
            } else {
                cardsOnHand[cardColour][cardType] = deck[cardColour][cardType];
                deck[cardColour][cardType] = -1;
            }
        }
        return cardsOnHand;
    }

    public void drawCard(int[][] deck, int[][] playerHand) {
        Random draw = new Random();
        boolean hasDrawn = false;
        while (!hasDrawn) {
            int cardColourDraw = draw.nextInt(4);
            int cardTypeDraw = draw.nextInt(13);
            if (deck[cardColourDraw][cardTypeDraw] != -1) {
                playerHand[cardColourDraw][cardTypeDraw] = deck[cardColourDraw][cardTypeDraw];
                hasDrawn = true;
                deck[cardColourDraw][cardTypeDraw] = -1;
                identifyCards(playerHand);
            }
        }
    }

    public void identifyCards(int[][] playerHand) {
        for (int i = 0; i < playerHand.length; i++) {
            for (int j = 0; j < playerHand[i].length; j++) {
                if (playerHand[i][j] > 0 && playerHand[i][j] < 14) {
                    System.out.print("♠ ");
                    if (playerHand[i][j] == 1) {
                        System.out.println("Es");
                    } else if (playerHand[i][j] < 11 && playerHand[i][j] > 1) {
                        System.out.println(j + 1);
                    } else if (playerHand[i][j] == 11) {
                        System.out.println("Bonde");
                    } else if (playerHand[i][j] == 12) {
                        System.out.println("Dronning");
                    } else if (playerHand[i][j] == 13) {
                        System.out.println("Konge");
                    }
                } else if (playerHand[i][j] > 20 && playerHand[i][j] < 34) {
                    System.out.print("♣ ");
                    if (playerHand[i][j] == 21) {
                        System.out.println("Es");
                    } else if (playerHand[i][j] < 31 && playerHand[i][j] > 21) {
                        System.out.println(j + 1);
                    } else if (playerHand[i][j] == 31) {
                        System.out.println("Bonde");
                    } else if (playerHand[i][j] == 32) {
                        System.out.println("Dronning");
                    } else if (playerHand[i][j] == 33) {
                        System.out.println("Konge");
                    }
                } else if (playerHand[i][j] > 40 && playerHand[i][j] < 54) {
                    System.out.print("♦ ");
                    if (playerHand[i][j] == 41) {
                        System.out.println("Es");
                    } else if (playerHand[i][j] < 51 && playerHand[i][j] > 41) {
                        System.out.println(j + 1);
                    } else if (playerHand[i][j] == 51) {
                        System.out.println("Bonde");
                    } else if (playerHand[i][j] == 52) {
                        System.out.println("Dronning");
                    } else if (playerHand[i][j] == 53) {
                        System.out.println("Konge");
                    }
                } else if (playerHand[i][j] > 60 && playerHand[i][j] < 74) {
                    System.out.print("♥ ");
                    if (playerHand[i][j] == 61) {
                        System.out.println("Es");
                    } else if (playerHand[i][j] < 71 && playerHand[i][j] > 61) {
                        System.out.println(j + 1);
                    } else if (playerHand[i][j] == 71) {
                        System.out.println("Bonde");
                    } else if (playerHand[i][j] == 72) {
                        System.out.println("Dronning");
                    } else if (playerHand[i][j] == 73) {
                        System.out.println("Konge");
                    }
                }
            }
        }
    }
}