/* *****************************************************************************
 program ThueMorse.java that takes an integer command-line argument n and prints an n-by-n
 pattern like the ones below. Include two space characters between each + and - character.
 Its an infinite sequence of 0s and 1s that is constructed by starting with 0 and successively
 appending the bitwise negation (interchange 0s and 1s) of the existing sequence.
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        char[][] thue = new char[n][n];

        thue[0][0] = '+';

        int ipointer = 0;
        int jpointer = 0;
        for (int j = 0; j < n; j++) {

            int twoPowerCheck = (int) (Math.log(j) / Math.log(2));
            if ((Math.log(j) / Math.log(2)) == twoPowerCheck) {
                jpointer = 0;
            }
            if (thue[jpointer][0] == '+')
                thue[j][0] = '-';
            else
                thue[j][0] = '+';
            jpointer++;

            thue[0][0] = '+';
            System.out.print(thue[j][0] + "  ");

            for (int i = 1; i < n; i++) {

                twoPowerCheck = (int) (Math.log(i) / Math.log(2));
                if ((Math.log(i) / Math.log(2)) == twoPowerCheck) {
                    ipointer = 0;
                }

                if (thue[j][ipointer] == '+')
                    thue[j][i] = '-';
                else
                    thue[j][i] = '+';
                ipointer++;
                System.out.print(thue[j][i] + "  ");
            }
            System.out.println();
        }
    }
}
