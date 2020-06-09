// Program takes input as the a number and prints all the factorials
public class Fact {
    public static void main(String[] args) {
        long number = Long.parseLong(args[0]);
        for (int i = 2; i <= number / i; i++) {

            // Use either this if condition or the while loop below
            /*
            if (number % i == 0) {
                System.out.print(i + " ");
                number = number / i;
                i--;
            }
             */

            while (number % i == 0) {
                System.out.print(i + " ");
                number = number / i;
            }
        }
        if (number != 1)
            System.out.println(number);
        else
            System.out.println();

    }
}
