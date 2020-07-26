/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class Potential {
    public static Charge[] readCharge() {
        int N = StdIn.readInt();
        Charge[] a = new Charge[N];
        for (int i = 0; i < N; i++) {
            double x0 = StdIn.readDouble();
            double y0 = StdIn.readDouble();
            double q0 = StdIn.readDouble();
            a[i] = new Charge(x0, y0, q0);
        }
        return a;
    }

    public static Color toColor(double V) {
        V = 128 + V / 2.0e10;
        int t = 0;
        if (V > 255)
            t = 255;
        else if (V >= 0)
            t = (int) V;
        return new Color(t, t, t);
    }

    public static void main(String[] args) {
        Charge[] a = readCharge();
        int SIZE = 800;
        Picture pic = new Picture(SIZE, SIZE);
        for (int col = 0; col < SIZE; col++) {
            for (int row = 0; row < SIZE; row++) {
                double V = 0.0;
                for (int k = 0; k < a.length; k++) {
                    // since all our charges are in between 0 and 1 co-ordinates of x axis and y axis
                    // so we are resizing it on a scale of 800
                    double x = 1.0 * col / SIZE;
                    double y = 1.0 * row / SIZE;
                    V += a[k].potentialAt(x, y);
                }
                pic.set(col, SIZE - 1 - row, toColor(V));
            }
            pic.show();
        }
    }
}
