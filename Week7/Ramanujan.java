/* *****************************************************************************
Write a program Ramanujan.java that takes a long integer command-line argument n
and prints true if it is a Ramanujan number, and false otherwise.
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {

        long j = (long) (Math.cbrt(n));
        int totalPairs = 0; // number of pair satisfying the property
        long i = 1;
        long sum;
        while (i < j) {
            sum = i * i * i + j * j * j;
            if (sum > n)
                j--;
            else if (sum < n)
                i++;
            else {
                i++;
                totalPairs++;
            }

        }
        return totalPairs >= 2;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {

        long k = Long.parseLong(args[0]);
        System.out.println(isRamanujan(k));

    }
}
