/* *****************************************************************************
 Write a program GeneralizedHarmonic.java that takes two integer command-line arguments
 n and r and uses a for loop to compute the nth generalized harmonic number of order r
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);

        double harmonicNumber = 0;
        for (int i = 1; i <= n; i++) {
            harmonicNumber += (1.0 / Math.pow(i, r));
        }
        System.out.println(harmonicNumber);
    }
}
