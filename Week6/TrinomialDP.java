/* *****************************************************************************
 **************************************************************************** */

public class TrinomialDP {
    private static long helper(long[][] term, int n, int k) {
        // System.out.println("TRACEhelper " + n + " " + k);
        if (k > n || k < -n)
            return 0;
        else if (k < 0)
            k = -k;

        return term[n][k];
    }

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (k < 0)
            k = -k;
        if (k > n || k < -n)
            return 0;
        long[][] term = new long[n + 1][n + 1];
        term[0][0] = 1;
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= i; j++) {
                // System.out.println("Main call " + i + " " + j);

                long term1 = helper(term, i - 1, j - 1);
                long term2 = helper(term, i - 1, j);
                long term3 = helper(term, i - 1, j + 1);

                // System.out.println("TRACE1 " + term1 + " " + term2 + " " + term3 + " ");
                term[i][j] = term1 + term2 + term3;
                if (j > n + j - i)
                    break;
            }
        }
        return term[n][k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(trinomial(a, b));
    }
}
