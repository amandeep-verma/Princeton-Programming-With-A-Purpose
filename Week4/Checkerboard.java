/* *****************************************************************************
 **************************************************************************** */

import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        StdDraw.filledSquare(n / 2.0, n / 2.0, n / 2.0);
        for (int j = 0; j < n; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < n; i = i + 2) {
                    StdDraw.setPenColor(Color.blue);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }
            else {
                for (int i = 1; i < n; i = i + 2) {
                    StdDraw.setPenColor(Color.blue);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }
        }
    }
}
