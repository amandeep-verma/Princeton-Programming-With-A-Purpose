/* *****************************************************************************
Write a program Inversions.java ,
Permutations. A permutation of length n is an integer array of length n that contains each of the n
integers 0, 1, ..., n–1 exactly once.
Output format. The main() method should print the permutation of length n to standard output as a
sequence of n integers, separated by whitespace, all on one line.
Performance. The count() method should take time proportional to n2 in the worst case. The generate()
method should take time proportional to n in the worst case.
Corner cases. You may assume that the arguments to generate() satsify n≥0 and 0≤k≤12n(n−1)
; this guarantees the existence of a permutation of length n with exactly k inversions.
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] b) {
        int[] a = new int[b.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        long count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int[] b = new int[n];
        for (int j = 0; j < a.length; j++) {
            a[j] = j;
            b[j] = j;
        }
        int i;
        for (i = 0; i < n && k != 0; i++) {
            // System.out.println("trace for " + i + " k is " + k + " >= " + a[n - 1 - i]);
            if (k >= a[n - 1 - i]) {
                b[i] = a[n - 1 - i];
                k = k - b[i];
                // System.out.println(b[i]);
            }
            else
                break;
        }

        // System.out.println("trace for " + i + " k is " + k + " >= " + a[n - 1 - i]);
        for (int j = i; j <= n - 1; j++) {
            b[j] = a[j - i];
        }

        for (int j = n - 1; j >= 0 && k != 0; j--, k--) {
            int temp = b[j];
            b[j] = b[j - 1];
            b[j - 1] = temp;
        }
        return b;
    }


    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] a = generate(n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

    }
}
