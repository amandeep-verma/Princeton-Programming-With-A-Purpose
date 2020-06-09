//  program PrimeCounter that takes an integer command-line argument n and
//  finds the number of primes less than or equal to n.
public class PrimeCounter {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        int count = 0;
        for (int n = 2; n <= number; n++) {

            boolean flagCheck = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flagCheck = false;
                    break;
                }
            }
            if (flagCheck)
                count++;
        }
        System.out.println(count);

    }
}
