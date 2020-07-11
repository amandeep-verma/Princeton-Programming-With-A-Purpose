/* *****************************************************************************
 **************************************************************************** */

public class RevesPuzzle {


    // move n smallest discs from one pole to another, using the temp pole
    private static void revees(int n, String from, String temp1, String temp2,
                               String to) {
        if (n == 0) return;
        if (n == 1) {
            // StdOut.println("Move disc " + (n) + " from " + from + " to " + to);
            return;
        }

        revees(n - 2, from, to, temp1, temp2);

        StdOut.println("Move disc " + (n - 1) + " from " + from + " to " + temp1);
        StdOut.println("Move disc " + (n) + " from " + from + " to " + to);
        StdOut.println("Move disc " + (n - 1) + " from " + temp1 + " to " + to);
        revees(n - 2, temp2, temp1, from, to);
    }

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == k) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = (int) Math.round((n + 1 - Math.sqrt(2 * n + 1)));

        revees(k, "A", "C", "D", "B");
        // hanoi(n, k, "A", "C", "D");
        // revees(k, "B", "C", "A", "D");

    }
}
