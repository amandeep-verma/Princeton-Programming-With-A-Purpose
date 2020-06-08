/*
 2D random walk. A two-dimensional random walk simulates the behavior of a particle
 moving in a grid of points. At each step, the random walker moves north, south, east, or west
 with probability equal to 1/4, independent of previous moves.
 Program RandomWalker that takes an integer command-line argument n and estimates how long
 it will take a random walker to hit the boundary of a 2n-by-2n square centered at the starting point.
*/

public class RandomWalker {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        int i = (n / 2);
        int j = (n / 2);

        int timeStep = 0;
        while (i != 0 && i != n - 1 && j != 0 && j != n - 1) {
            // System.out.println("trace " + i + " " + j);
            double a = Math.random();
            if (a < 0.25)
                i = i - 1; // west
            else if (a < 0.5)
                i = i + 1; // east
            else if (a < 0.75)
                j = j - 1; // south
            else
                j = j + 1; // north

            timeStep++;
        }
        // System.out.println("trace " + i + " " + j);
        System.out.println(timeStep);

    }
}
