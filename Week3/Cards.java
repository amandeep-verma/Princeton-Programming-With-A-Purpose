/* *****************************************************************************

 **************************************************************************** */

public class Cards {
    public static void main(String[] args) {

        // n is number of random cards you want user to draw from deck
        int n = Integer.parseInt(args[0]);

        String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        String[] suite = { "♠", "♥", "♣", "♦" };
        String[] deck = new String[52];
        for (int i = 0; i < suite.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck[13 * i + j] = rank[j] + suite[i];
            }
        }
        // printing the complete deck
        for (int i = 0; i < deck.length; i++) {
            System.out.print(deck[i] + " ");
        }
        System.out.println("\n");

        // drawing random cards from the deck with replacement
        for (int i = 0; i < n; i++) {
            int pos = (int) (Math.random() * 52);
            System.out.print(deck[pos] + " ");
        }
        System.out.println("\n");

        // shuffling the deck
        for (int i = 0; i < n; i++) {
            // generating random position between i and 52
            int pos = i + (int) (Math.random() * (52 - i));
            String temp = deck[i];
            deck[i] = deck[pos];
            deck[pos] = temp;

        }

        // drawing random cards from the deck without replacement
        for (int i = 0; i < n; i++) {
            System.out.print(deck[i] + " ");
        }

    }
}
