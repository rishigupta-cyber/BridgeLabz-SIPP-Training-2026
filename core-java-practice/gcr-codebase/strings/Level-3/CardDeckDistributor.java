import java.util.Scanner;

public class CardDeckDistributor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        int numOfCards = suits.length * ranks.length;

        String[] deck = initializeDeck(suits, ranks);
        deck = shuffleDeck(deck);

        System.out.println("Enter number of players:");
        int x = sc.nextInt();

        String[][] players = distributeCards(deck, numOfCards, x);
        printPlayers(players);

        sc.close();
    }

    public static String[] initializeDeck(String[] suits, String[] ranks) {
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }

        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    public static String[][] distributeCards(String[] deck, int n, int x) {
        if (n % x != 0) {
            System.out.println("Cards cannot be evenly distributed among " + x + " players");
            return new String[0][0];
        }

        int cardsPerPlayer = n / x;
        String[][] players = new String[x][cardsPerPlayer];

        int cardIndex = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }

        return players;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
        }
    }
}