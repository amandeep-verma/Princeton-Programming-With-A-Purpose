/* *****************************************************************************
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] xi = new int[m + 1];
        double[] pi = new double[m + 1];
        double shannonEntropy = 0;
        int count = 0;

        while (!StdIn.isEmpty()) {
            count++;
            int a = StdIn.readInt();
            xi[a]++;

        }
        for (int j = 1; j <= m; j++) {
            pi[j] = xi[j] / (count * 1.0);

            double pilog = 0;
            if (pi[j] == 0)
                pilog = 0;
            else
                pilog = -(pi[j] * (Math.log10(pi[j]) / Math.log10(2)));

            shannonEntropy += pilog;
        }
        StdOut.printf("%.4f\n", shannonEntropy);
    }
}
