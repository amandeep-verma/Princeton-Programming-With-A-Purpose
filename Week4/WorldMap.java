/* *****************************************************************************
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int sides = StdIn.readInt();
            double[] xcordinate = new double[sides];
            double[] ycordinate = new double[sides];
            for (int i = 0; i < sides; i++) {
                xcordinate[i] = StdIn.readDouble();
                ycordinate[i] = StdIn.readDouble();
            }
            StdDraw.polygon(xcordinate, ycordinate);
        }
    }
}
