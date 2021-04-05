import java.awt.Color;

public class Element {

    double r; // real radius of ball
    double m;
    double vx;
    double vy;
    double height;
    double radius; // radius of ball (purely for graphical represation so as you can see the motion)
    double p;
    double D;
    double G = -9.81;
    double sideSquareFrame;
    int boucingFactorDrop;
    int xDirectionDrop;
    String picture;
    String info;
    double xinfo;
    double yinfo;
    double delta;
    Color BallSurfaceColor;
    Color BallFillColor;

    double rx;
    double ry;
    double K;

    double Area() {
        return 3.141 * (r) * (r);
    }


    public Element(double r, double m, double vx, double vy, double height, double radius, double p,
                   double d, double g,
                   double sideSquareFrame, int boucingFactorDrop, int xDirectionDrop,
                   String picture, String info,
                   double xinfo, double yinfo, double delta, Color ballSurfaceColor,
                   Color ballFillColor) {
        super();
        this.r = r;
        this.m = m;
        this.vx = vx;
        this.vy = vy;
        this.height = height;
        this.radius = radius;
        this.p = p;
        D = d;
        G = g;
        this.sideSquareFrame = sideSquareFrame;
        this.boucingFactorDrop = boucingFactorDrop;
        this.xDirectionDrop = xDirectionDrop;
        this.picture = picture;
        this.info = info;
        this.xinfo = xinfo;
        this.yinfo = yinfo;
        this.delta = delta;
        BallSurfaceColor = ballSurfaceColor;
        BallFillColor = ballFillColor;

        this.info = this.info + vx + "m/s SpeedY= " + vy + " m/s";
        rx = 00.0 + radius;
        ry = 0.0 + radius + height;
        K = 1.0 / 2 * (p * D * Area());
    }


    @Override
    public String toString() {
        return "Element [r=" + r + ", m=" + m + ", vx=" + vx + ", vy=" + vy + ", height=" + height
                + ", radius="
                + radius + ", p=" + p + ", D=" + D + ", G=" + G + ", boucingFactorDrop="
                + boucingFactorDrop
                + ", xDirectionDrop=" + xDirectionDrop + "]";
    }

}
