/* 
    The great-circle distance is the length of the shortest path between two points (x1,y1) and (x2,y2)
    on the surface of a sphere, where the path is constrained to be along the surface.
    Write a program GreatCircle.java that takes four double command-line arguments x1, y1, x2, y2
    —the latitude and longitude (in degrees) of two points on the surface of the earth—and prints 
    the great-circle distance (in kilometers) between them. Use the following Haversine formula
    r=6,371.0 is the mean radius of the Earth (in kilometers).
*/
public class GreatCircle {
    public static void main(String[] args) {

        final double r = 6371.0;

        // scanning latitude and longitude in degrees & converting to radians
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double distance = 2 * r * Math
                .asin(Math.sqrt(
                        Math.pow(Math.sin((x2 - x1) / 2), 2)
                                + Math.cos(x1) * Math.cos(x2)
                                * Math.pow(Math.sin((y2 - y1) / 2), 2)));
        System.out.println(distance + " kilometers");

    }
}
