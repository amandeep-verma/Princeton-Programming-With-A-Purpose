/* *****************************************************************************
 Program Checkerboard.java that takes a command-line integer n and plots an n-by-n checkerboard 
 pattern to standard drawing. Color the squares blue and light gray, with the bottom-left square blue.
 Call StdDraw.setScale(0, n) so that x- and y-coordinates of the canvas range from 0 and n.
 **************************************************************************** */

import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i = i + 1) {

                if ((i + j) % 2 == 0)
                    StdDraw.setPenColor(Color.blue);
                else
                    StdDraw.setPenColor(Color.LIGHT_GRAY);

                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);

            }
        }
    }
}
