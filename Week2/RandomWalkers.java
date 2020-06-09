/* *****************************************************************************
Monte Carlo simulation
The program RandomWalkers.java that takes two integer command-line arguments r and trials.
In each of trials independent experiments, simulate a random walk until the random walker
is at Manhattan distance r from the starting point. Print the average number of steps.
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int totalSumSteps = 0;
        for (int t = 0; t < trials; t++) {
            int i = 0;
            int j = 0;

            int steps = 0;
            while (Math.abs(i) + Math.abs(j) != r) {

                double a = Math.random();
                if (a < 0.25)
                    i = i - 1; // west
                else if (a < 0.5)
                    i = i + 1; // east
                else if (a < 0.75)
                    j = j - 1; // south
                else
                    j = j + 1; // north

                steps++;
            }
            totalSumSteps += steps;
        }
        System.out.println("average number of steps = " + (totalSumSteps / (trials * 1.0)));
    }
}
