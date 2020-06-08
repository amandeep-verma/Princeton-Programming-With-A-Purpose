/* Ramanujan's taxi -> prints all integers less than or equal to n that can be
expressed as the sum of two cubes in two different ways - find distinct positive
 integers a, b, c, and d such that a^3 + b^3 = c^3 + d^3
 */
// this will be slow compared to 4 for-loops method. As here we start from
// initial values of i and j iterator each time.
//
// (( https://introcs.cs.princeton.edu/java/13flow/Ramanujan.java.html ))
// Whereas in 4-for loops we go from initial values of variable in each loop
// and continue it to check if we have a^3 + b^3 = c^3 + d^3 and print all the
// values which satisfies the equation. Thats why number are not sorted

public class Ramanujan {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        for (int n = 2; n <= number; n++) {
            int maxCubeRoot = 1;
            while (maxCubeRoot * maxCubeRoot * maxCubeRoot <= n) {
                maxCubeRoot++;
            }
            int[] num1 = new int[2];
            int[] num2 = new int[2];
            int num1p = 0;
            int num2p = 0;

            for (int i = 1; i < maxCubeRoot && num1p != 2; i++) {
                int a = i * i * i;
                for (int j = i + 1; j < maxCubeRoot && num1p != 2; j++) {
                    int b = j * j * j;
                    if (a + b > n)
                        break;
                    if (a + b == n) {
                        num1[num1p++] = i;
                        num2[num2p++] = j;
                    }
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
