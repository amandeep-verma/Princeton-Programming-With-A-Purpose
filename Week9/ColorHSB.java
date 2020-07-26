/*
ColorHSB.java that represents a color in hue–saturation–brightness (HSB) format,
along with a sample client. The HSB color format is widely used in color pickers.
- The hue is an integer between 0 and 359. It represents a pure color on the color wheel,
with 0° for red, 120° for green, and 240° for blue.
- The saturation is an integer between 0 and 100. It represents the purity of the hue.
- The brightness is an integer between 0 and 100. It represents the percentage of white that is mixed with the hue.
 */


public class ColorHSB {

    private final int h0, s0, b0;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        h0 = h;
        s0 = s;
        b0 = b;
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        else if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 99");
        else if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 99");

    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h0 + ", " + s0 + ", " + b0 + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        //if either its saturation or brightness component is 0
        return (s0 == 0 || b0 == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("passed argument cannot be null");
        return (int) (Math.min(Math.pow(h0 - that.h0, 2), Math.pow(360 - Math.abs(h0 - that.h0), 2))
                + Math.pow(s0 - that.s0, 2) + Math.pow(b0 - that.b0, 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB primary = new ColorHSB(h, s, b);

        String minColor = "";

        ColorHSB min = null;

        int minD = Integer.MAX_VALUE;
        while (!StdIn.isEmpty()) {
            String color = StdIn.readString();
            int ht = StdIn.readInt();
            int st = StdIn.readInt();
            int bt = StdIn.readInt();
            ColorHSB temp = new ColorHSB(ht, st, bt);
            if (minD > primary.distanceSquaredTo(temp)) {
                minD = primary.distanceSquaredTo(temp);
                minColor = color;
                min = temp;
            }
        }

        System.out.println(minColor + " " + min.toString());
    }

}
