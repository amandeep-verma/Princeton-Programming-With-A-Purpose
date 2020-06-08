/*
Write a program RightTriangle that takes three int command-line arguments and determines whether they constitute 
the side lengths of some right triangle.
*/

public class RightTriangle {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        int possibleH = Math.max(a, Math.max(b, c));
        int possibleSide1 = Math.min(a, Math.min(b, c));
        int possibleSide2 = a + b + c - possibleH - possibleSide1;

        boolean isRight = ((long) (Math.pow(possibleH, 2))) == ((long)
                (Math.pow(possibleSide1, 2) + Math.pow(possibleSide2, 2)));

        boolean isRightTriangle = (isRight) && (a > 0) && (b > 0) && (c > 0);
        System.out.println(isRightTriangle);

    }
}
