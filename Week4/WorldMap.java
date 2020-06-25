/* *****************************************************************************
Program WorldMap.java that reads boundary information of a country (or other geographic entity) from standard input 
nd plots the results to standard drawing. A country consists of a set of regions (e.g., states, provinces, or 
other administrative divisions), each of which is described by a polygon.
Input format.   The first line contains two integers: width and height. The remaining part of the input is divided into regions.
The first entry in each region is the name of the region. For simplicity, names will not contain spaces.
The next entry is an integer specifying the number of vertices in the polygon describing the region.
Finally, the region contains the x- and y-coordinates of the vertices of the polygon.
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {

        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.enableDoubleBuffering();
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
        StdDraw.show();
    }
}
