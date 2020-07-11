/* *****************************************************************************
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    private static int mode(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] b) {

        int[][] a = new int[b.length][b[0].length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                a[i][j] = b[i][j];
            }
        }

        int highest = 0;
        int n = a[0].length;


        for (int j = 0; j < n; j++) {
            int i = 0;
            if (highest == 0 && (a[i][j] == 1 || a[j][i] == 1))
                highest = 1;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (highest == 0 && a[i][j] == 1)
                    highest = 1;
                if (a[i - 1][j - 1] != 0 && a[i - 1][j] != 0 && a[i][j - 1] != 0 && a[i][j] > 0) {

                    a[i][j] = mode(Math.abs(a[i - 1][j - 1]), Math.abs(a[i - 1][j]),
                                   Math.abs(a[i][j - 1])) + 1;


                    if (a[i - 1][j + 1] == 0 || a[i + 1][j - 1] == 0 || a[i - 1][j] < 0)
                        a[i][j] = -a[i][j];

                    if (Math.abs(a[i][j]) > highest)
                        highest = Math.abs(a[i][j]);

                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            int j = n - 1;
            if (highest == 0 && a[i][j] == 1)
                highest = 1;
            if (a[i - 1][j - 1] != 0 && a[i - 1][j] != 0 && a[i][j - 1] != 0 && a[i][j] > 0) {

                a[i][j] = mode(Math.abs(a[i - 1][j - 1]), Math.abs(a[i - 1][j]),
                               Math.abs(a[i][j - 1])) + 1;

                if (Math.abs(a[i][j]) > highest)
                    highest = Math.abs(a[i][j]);

            }
        }

        for (int j = 1; j < n; j++) {
            int i = n - 1;
            if (highest == 0 && a[i][j] == 1)
                highest = 1;
            if (a[i - 1][j - 1] != 0 && a[i - 1][j] != 0 && a[i][j - 1] != 0 && a[i][j] > 0) {

                a[i][j] = mode(Math.abs(a[i - 1][j - 1]), Math.abs(a[i - 1][j]),
                               Math.abs(a[i][j - 1])) + 1;

                if (Math.abs(a[i][j]) > highest)
                    highest = Math.abs(a[i][j]);

            }
        }


        return highest;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();

        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }

        System.out.println(size(a));
    }
}
