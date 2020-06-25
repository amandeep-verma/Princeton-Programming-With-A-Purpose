/* *****************************************************************************
Write a program ActivationFunction.java to compute various activation functions that arise in neural networks.
An activation function is a function that maps real numbers into a desired range, such as between 0 and 1 or between –1 and +1.
-The Heaviside step function
-The sigmoid function
-The hyperbolic tangent
-The softsign function
-The square nonlinearity function
All activation functions should return NaN (not a number) if the argument is NaN.
 **************************************************************************** */

public class ActivationFunction {
    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (x < 0)
            return 0;
        else if (x == 0)
            return 0.5;
        else if (x > 0)
            return 1;
        return x;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (x >= 20)
            return 1;
        if (x <= -20)
            return -1;
        return (Math.pow(Math.E, x) - Math.pow(Math.E, -x)) / (Math.pow(Math.E, x) + Math
                .pow(Math.E, -x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY)
            return 1;
        if (x == Double.NEGATIVE_INFINITY)
            return -1;
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x <= -2)
            return -1;
        else if (x < 0)
            return x + (x * x) / 4;
        else if (x < 2)
            return x - (x * x) / 4;
        else if (x >= 2)
            return 1;
        return x;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double input = Double.parseDouble(args[0]);

        StdOut.println("heaviside(" + input + ") = " + heaviside(input));
        StdOut.println("  sigmoid(" + input + ") = " + sigmoid(input));
        StdOut.println("     tanh(" + input + ") = " + tanh(input));
        StdOut.println(" softsign(" + input + ") = " + softsign(input));
        StdOut.println("     sqnl(" + input + ") = " + sqnl(input));
    }
}
