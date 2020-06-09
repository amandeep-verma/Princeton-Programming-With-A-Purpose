// Newton-Raphson method of finding the square root
public class Sqrt {
    public static void main(String[] args) {
        double EPS = 1.0E-15; // 1.0^(-15)
        double number = Double.parseDouble(args[0]);
        double t = number;

        while (Math.abs(t - number / t) > t * EPS) {
            t = (t + number / t) / 2.0;
        }

        System.out.println("Square root of " + number + " is " + t);
    }
}
