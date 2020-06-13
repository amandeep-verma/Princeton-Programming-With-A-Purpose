/* *****************************************************************************
 Suppose that people enter a room one at a time. How people must enter until two share a birthday?
 Counterintuitively, after 23 people enter the room, there is approximately a 50–50 chance that two
 share a birthday. This phenomenon is known as the birthday problem or birthday paradox.
 Program Birthday.java that takes two integer command-line arguments n and trials and performs the
 following experiment, trials times.
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] counter = new int[n + 2];
        double[] fraction = new double[n + 2];
        int counterLength = 0;

        boolean[] birthday;

        for (int i = 0; i < trials; i++) {

            birthday = new boolean[n + 1];

            for (int j = 1; ; j++) {
                int bday = 1 + (int) (Math.random() * (n));
                if (birthday[bday]) {
                    counter[j]++;
                    break;
                }
                birthday[bday] = true;
            }
        }

        for (int j = 2; j < counter.length; j++) {
            fraction[j] = ((fraction[j - 1] * trials) + counter[j]) / trials;
            if (fraction[j] >= 0.500000) {
                counterLength = j;
                break;
            }
        }

        for (int j = 1; j <= counterLength; j++) {
            System.out.println(j + "\t" + counter[j] + "\t" + fraction[j]);
        }

    }
}
