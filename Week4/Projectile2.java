/*
The code aims at simulating the projectile motion of a ball and futher motion after hitting ground.
Here the ball reduces the y direction component(bouncing factor) and x direction component(due to friction), every time it
touches the ground.
The Drag Force is taken onto account here. All the information for the equations used are in the comments.
Most of the variables are using standard values and there are couple of them left in comments to play with.
You can change the parametres to see how it affects the motion.
Note:
1. Check for mass of ball and speed to the density of medium.
2. Loss of speed in both direction when in hits the ground would depends on surface of the ball and the surface of the ground both.

Using Euler's method
To understand the equations -> https://www.youtube.com/watch?v=OukRTF6Bgcc

The execution gets easier if you chose to go with the files Projections.java and Elements.java in the same folder.
*/


public class Projectile2 {
    public static void main(String[] args) {

        double height = 10; // height from which ball is being projected
        // You might want to increase or decrease it as per the size of the frame you are using
        double radius
                = 0.95; // radius of ball (purely for graphical represation so as you can see the motion)
        double rx = 00.0 + radius, ry = 0.0 + radius + height;  // point of starting
        double vx = 910.5, vy = 500.0; // speed component of x and y direction in m/s
        double G = -9.81;

        int boucingFactorDrop = 25; // boucingFactorDrop percent
        int xDirectionDrop = 10; // xDirectionDrop percent

        // Force of drag equation
        // F(drag) = 1/2 *p * V* V* D* A
        // p = Density of the medium the ball is in
        // V = velocity of the object
        // D = drag coefficient(is usually calcualted by experiementation)
        // A = crossectional area of the ball
        //double p = 1.275; // density of air (about.com)
        double p = 997; // density of water
        double D = 0.3; // drag coefficient for a baseball (Nasa)
        // double D = 0.295; // drag coefficient for a bullet (Nasa)
        // double D = 0.5; // drag coefficient for a smooth ball (Nasa)
        // double r = 0.037; // radius of typical baseball is 0.037
        double r = 0.0091835; // radius of actuall ball
        double A = 3.141 * (r) * (r); // pi *r* r
        double K = 1.0 / 2 * (p * D * A); // constant K = 1/2* p* D* A
        // double m = 0.142; // mass of baseball in kg
        double m = 1.154529;

        // For F(x)  x-direction
        // F(x) = F(drag) = K* Vx* Vx  - (1)
        // Also you know F(x) = m* a   - (2)
        // Using (1) and (2)
        // m* ax = K* V* V
        // ax = (K * vx * vx) / m;

        // For F(y)  y-direction
        // F(y) = F(drag) - F(Gravitational force)
        // F(y) = K* Vy* Vy - mg      - (3)
        // Also you know F(y) = m* a  - (4)
        // Using (3) and (4)
        // m* ay = K* Vy* Vy - mg
        // ay = (K * vx * vx - mg) / m;


        // The frame values values can be changed if vx and vy are increased
        // try to keep both xScale and yScale equal, as the program output comes on square screen,
        // you dont want to lose the shape of objects in animation
        double sideSquareFrame = +300.0;
        StdDraw.setXscale(0, sideSquareFrame);
        StdDraw.setYscale(-1.0, sideSquareFrame);

        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledSquare(sideSquareFrame / 2, sideSquareFrame / 2, sideSquareFrame / 2 + 10);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0, 0, sideSquareFrame, 0);
        // StdDraw.line(sideSquareFrame / 2, 0, sideSquareFrame / 2, sideSquareFrame); //(horizontal vertical line)
        StdDraw.line(radius, 0, radius, height); // platform
        StdDraw.text(10, sideSquareFrame - sideSquareFrame / 50, "hell"); // for the text display
        double ux = 0.0;
        double uy = 0.0;
        while (true) {

            // deltaT defines the calculation we make at each time frame for the changing values of accelaration and velocity
            double deltaT = 0.01; // time value for each frame of video (delta(t))

            /* -----------
            vy = uy + (G * deltaT); // y component changing equation
            double distY = (vy * vy - uy * uy) / (2.0 * G);
            */

            // draws a line at highest peak of curve
            if (vy < 0 && uy > 0) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(rx, 0, rx, ry);
            }

            // calculates accelertion and velocity at deltaT in x direction
            ux = vx;
            double ax = -(K * vx * vx) / m;
            vx = ux + ax * deltaT;
            double dispX = vx * deltaT + 1.0 / 2 * ax * deltaT * deltaT;

            // calculates accelertion and velocity at deltaT in y direction
            uy = vy;
            double ay;
            // While going up force of drag is in same direction to G, so net accelaration = (F(grav)+F(drag)) /m
            // While going down force of drag is in opp direction to G, so net accelaration = (F(drag)-F(grav)) /mF(drag)
            if (vy > 0)
                ay = -(K * vy * vy - m * G) / m;
            else
                ay = -(-K * vy * vy - m * G) / m;

            vy = uy + ay * deltaT;
            double dispY = vy * deltaT + 1.0 / 2 * ay * deltaT * deltaT;

            if (ry - radius - dispY <= 0 && vy < 0) {
                vy = -(vy * (100 - boucingFactorDrop)
                        / 100); // every point of touch reduces the y component of speed
                vx = vx * (100 - xDirectionDrop)
                        / 100; // every point of touch reduces the x component of speed
                ry = 0.0 + radius;
            }

            rx = rx + dispX;
            ry = ry + dispY;

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);

            StdDraw.show(1);
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
            StdDraw.filledCircle(rx, ry, radius);
        }
    }
}

