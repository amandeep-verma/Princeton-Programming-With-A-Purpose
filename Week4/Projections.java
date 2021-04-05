/* *****************************************************************************

The code aims at simulating the  trajectory of an object and futher motion after hitting ground.
Here the ball reduces the y direction component(bouncing factor) and x direction component(due to friction), every time it
touches the ground.
The Drag Force is taken onto account here. All the information for the equations used, are in the comments.
Most of the variables are using standard values and there are couple of them left in comments to play with.
You can change the parametres to see how it affects the motion.
Note:
1. Check for mass of ball and speed to the density of medium.
2. Loss of speed in both direction when in hits the ground would depends on surface of the ball and the surface of the ground both.

Using Euler's method
To understand the equations -> https://www.youtube.com/watch?v=OukRTF6Bgcc

 **************************************************************************** */

public class Projections {
    public static void main(String[] args) {

        // double r;
        // double m;
        // double rx;
        // double ry;
        // double height;
        // double radius;
        // double p;
        // double D;
        // double G = -9.81;
        // double sideSquareFrame;
        // int boucingFactorDrop;
        // int xDirectionDrop;
        // String picture;
        // String info;
        // double xinfo;
        // double yinfo;
        // double delta;
        // Color BallSurfaceColor;
        // Color BallFillColor;


        //BaseBall In Air on Earth
        Element b1 = new Element(0.037, 0.142, 4.46, 20, 0, 0.15, 1.275, 0.3, -9.81, 30, 25, 10,
                                 "Air.jpg", "SpeedX = ", 15, 28, 0.005, StdDraw.BLACK,
                                 StdDraw.WHITE);


        // Lucrose Ball on Mars
        // Element b1 = new Element(0.051835, 0.058116, 6.00, 25, 0, 0.15, 0.020, 3.5, -3.71, 70, 55,
        //                          10,
        //                          "Mars.png", "SpeedX = ", 35, 60, 0.005, StdDraw.BLACK,
        //                          StdDraw.WHITE);

        // light Ball In Air on Earth
        // Element b1 = new Element(0.100, 0.050, 30, 100, 0, 0.15, 1.275, 0.3, -9.81, 30, 25, 10,
        //                          "Air.jpg", "SpeedX = ", 15,
        //                          28, 0.007, StdDraw.BLACK, StdDraw.WHITE);


        // bullet In Water
        // Element b1 = new Element(0.0045, 0.020, 800, 600, 5, 0.05, 997, 0.295, -9.81, 20, 80, 80,
        //                          "Water.jpg", "SpeedX = ", 10,
        //                          18, 0.001, StdDraw.BLACK, StdDraw.BLUE);


        double sideSquareFrame = b1.sideSquareFrame;
        StdDraw.setXscale(0, sideSquareFrame);
        StdDraw.setYscale(-3.0, sideSquareFrame);


        StdDraw.picture(sideSquareFrame / 2, sideSquareFrame / 2, b1.picture);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0, 0, sideSquareFrame, 0);
        //StdDraw.line(sideSquareFrame / 2, 0, sideSquareFrame / 2, sideSquareFrame); //(horizontal vertical line)
        StdDraw.line(b1.radius, 0, b1.radius, b1.height); // platform

        StdDraw.text(b1.xinfo, b1.yinfo, b1.info); // for the text display

        StdDraw.text(b1.xinfo, b1.yinfo - 1, "Baseball in air");   // 1a

        //StdDraw.text(b1.xinfo, b1.yinfo - 3, "Lucrose Ball on Mars");    // 2

        //StdDraw.text(b1.xinfo, b1.yinfo - 2, "Big light Ball on Earth");    // 2

        //StdDraw.text(b1.xinfo, b1.yinfo - 1, "Bullet in water");    // 3

        double ux = 0.0;
        double uy = 0.0;

        while (true) {

            // deltaT defines the calculation we make at each time frame for the changing values of accelaration and velocity
            double deltaT = b1.delta; // time value for each frame of video (delta(t))

            /* -----------
            vy = uy + (G * deltaT); // y component changing equation
            double distY = (vy * vy - uy * uy) / (2.0 * G);
            */

            // draws a line at highest peak of curve
            if (b1.vy < 0 && uy > 0) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.line(b1.rx, 0, b1.rx, b1.ry);
            }

            // calculates accelertion and velocity at deltaT in x direction
            ux = b1.vx;
            double ax = -(b1.K * b1.vx * b1.vx) / b1.m;
            b1.vx = ux + ax * deltaT;
            double dispX = b1.vx * deltaT + 1.0 / 2 * ax * deltaT * deltaT;

            // calculates accelertion and velocity at deltaT in y direction
            uy = b1.vy;
            double ay;
            // While going up force of drag is in same direction to G, so net accelaration = (F(grav)+F(drag)) /m
            // While going down force of drag is in opp direction to G, so net accelaration = (F(drag)-F(grav)) /mF(drag)
            if (b1.vy > 0)
                ay = -(b1.K * b1.vy * b1.vy - b1.m * b1.G) / b1.m;
            else
                ay = -(-b1.K * b1.vy * b1.vy - b1.m * b1.G) / b1.m;

            b1.vy = uy + ay * deltaT;
            double dispY = b1.vy * deltaT + 1.0 / 2 * ay * deltaT * deltaT;

            if (uy >= 0 && b1.vy <= 0)
                StdDraw.text(b1.rx, -2, Math.round(b1.rx * 100.0) / 100.0 + "");

            if (b1.ry - b1.radius - dispY <= 0 && b1.vy < 0) {
                b1.vy = -(b1.vy * (100 - b1.boucingFactorDrop)
                        / 100); // every point of touch reduces the y component of speed
                b1.vx = b1.vx * (100 - b1.xDirectionDrop)
                        / 100; // every point of touch reduces the x component of speed
                b1.ry = 0.0 + b1.radius;
                StdDraw.text(b1.rx, -2, Math.round(b1.rx * 100.0) / 100.0 + "");
            }

            b1.rx = b1.rx + dispX;
            b1.ry = b1.ry + dispY;

            //System.out.println(b1.rx + " " + b1.ry);  //  to print cordinates of trajectory

            StdDraw.setPenColor(b1.BallSurfaceColor);
            StdDraw.filledCircle(b1.rx, b1.ry, b1.radius);

            StdDraw.show(1);
            StdDraw.setPenColor(b1.BallFillColor);
            StdDraw.filledCircle(b1.rx, b1.ry, b1.radius);
        }
    }
}
