/* Ramanujan's taxi -> prints all integers less than or equal to n that can be
expressed as the sum of two cubes in two different ways - find distinct positive
 integers a, b, c, and d such that a^3 + b^3 = c^3 + d^3
 */
// this is a much faster version

public class RamanujanImprovised {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        for (int n = 2; n <= number; n++) {
            int j = (int) (Math.cbrt(n));


            int[] num1 = new int[2];
            int[] num2 = new int[2];
            int num1p = 0;
            int num2p = 0;

            int i = 1;
            int sum;
            while (i < j) {

                sum = i * i * i + j * j * j;
                if (sum > n)
                    j--;
                else if (sum < n)
                    i++;
                else {
                    i++;
                    num1[num1p++] = i;
                    num2[num2p++] = j;
                }
            }


            if (num1[1] > 0) {
                System.out.println(
                        n + " = " + num1[0] + "^3 + " + num2[0] + "^3 = " + num1[1] + "^3 + "
                                + num2[1]
                                + "^3 ");
            }
        }
    }
}
