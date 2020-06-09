//  Takes two integer command line arguments i and k and converts i to base k
//  For bases greater than 10, letters A - F represents the 11th - 16th digit
public class Kary {
    public static void main(String[] args) {
        // read in the command-line argument
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        // set power to the largest power of 2 that is <= n

        if (k == 10) {
            System.out.println(n);
        }
        else {

            int power = 1;
            while (power <= n / k) {
                power *= k;
            }

            while (power > 0) {
                // System.out.println("trace " + power + " " + n);

                if (n < power) {
                    System.out.print(0);
                }

                else {
                    int digit = n / power;
                    if (digit < 10)
                        System.out.print(digit);
                    else {
                        System.out.printf("%c", 55 + digit);
                    }
                    n -= (digit * power);
                }

                power /= k;
            }
        }
    }
}
