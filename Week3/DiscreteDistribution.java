/* *****************************************************************************
Write a program DiscreteDistribution.java that takes an integer command-line argument m,
followed by a sequence of positive integer command-line arguments a1, a2, ... , an
and prints m random indices (separated by whitespace), choosing each index i with probability
proportional to a(i)
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length];
        int[] s = new int[args.length];
        a[0] = 0;
        s[0] = 0;
        for (int i = 1; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
            s[i] = s[i - 1] + a[i];
            // System.out.println(s[i]);
        }
        for (int j = 0; j < m; j++) {
            int r = (int) (Math.random() * (s[args.length - 1]));
            // System.out.println(r);
            for (int i = 0; i < args.length; i++) {
                if (r < s[i]) {
                    System.out.print(i + " ");
                    break;
                }
            }
        }
        System.out.println();
    }
}
