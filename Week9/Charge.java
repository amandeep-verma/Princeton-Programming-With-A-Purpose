/* *****************************************************************************
 **************************************************************************** */

public class Charge {
    private final double rx, ry;
    private final double q;

    public Charge(double x, double y, double q0) {
        rx = x;
        ry = y;
        q = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = y - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }


    public static void main(String[] args) {
        Charge c = new Charge(.72, .31, 20.1);
        System.out.println(c);
        StdOut.printf("%6.2e\n", c.potentialAt(.42, .71));

    }
}
