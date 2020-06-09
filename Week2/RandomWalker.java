/* *****************************************************************************
 A Java programmer begins walking aimlessly. At each time step, she takes one step in a random
 direction (either north, east, south, or west), each with probability 25%. She stops once she
 is at Manhattan distance r from the starting point. How many steps will the random walker take?
 This process is known as a two-dimensional random walk.
 THe program RandomWalker.java that takes an integer command-line argument r and simulates the
 motion of a random walk until the random walker is at Manhattan distance r from the starting
 point. Print the coordinates at each step of the walk (including the starting and ending points),
 treating the starting point as (0, 0). Also, print the total number of steps taken.
 This process is a discrete version of a natural phenomenon known as Brownian motion
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);

        int i = 0;
        int j = 0;

        int steps = 0;
        while (Math.abs(i) + Math.abs(j) != r) {
            System.out.println("(" + i + ", " + j + ")");
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
        System.out.println("(" + i + ", " + j + ")");
        System.out.println("steps = " + steps);

    }
}
