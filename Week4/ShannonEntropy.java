/* ****************************************************************************
*Write a program ShannonEntropy.java that takes a command-line integer m; reads a sequence of integers 
between 1 and m from standard input; and prints the Shannon entropy to standard output, with 4 digits after 
the decimal point. 
The Shannon entropy is a measure of the rate of information produced by a random source, such as the outcomes of flipping a fair coin or rolling a loaded die. 
It is a fundamental concept in information theory and data compression.
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
