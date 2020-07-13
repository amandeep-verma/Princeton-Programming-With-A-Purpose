/* *****************************************************************************
Program KernelFilter.java applies various kernel filters to images, such as Gaussian blur,
sharpen, Laplacian, emboss, and motion blur. A kernel filter modifies the pixels in an
image by replacing each pixel with a linear combination of its neighboring pixels. The
matrix that characterizes the linear combination is known as the kernel.
- Periodic boundary conditions. When applying a kernel filter to a pixel near the boundary,
some of its neighboring pixels may not exist. In such cases, assume the leftmost column
wraps around to the rightmost column and the top row wraps around to the bottom row (and
vice versa).
- Rounding. When applying a kernel filter, the resulting RGB components may become fractional
if the kernel weights are fractional. Round each RGB component to the nearest integer, with
ties rounding up.
- Clamping. When applying a kernel filter, the resulting RGB components may not remain between
0 and 255. If an RGB component of a pixel is less than 0, set it to 0; if is greater than 255,
set it to 255. This mechanism for handling arithmetic overflow and underflow is known as
clamping or saturating arithmetic.
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    private static Picture kernelFilter(Picture picture, double[][] kernel) {
        Picture output = new Picture(picture.width(), picture.height());

        int midPoint = kernel[0].length / 2;
        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                double red = 0;
                double green = 0;
                double blue = 0;

                for (int i = 0; i < kernel[0].length; i++) {
                    for (int j = 0; j < kernel.length; j++) {

                        int newcol = col - midPoint + i;
                        int newrow = row - midPoint + j;

                        // for corner cases
                        // while loops because motion blur looks for depth of 4 on corner cases
                        while (newcol < 0) {
                            newcol = picture.width() + newcol;
                        }
                        while (newrow < 0) {
                            newrow = picture.height() + newrow;
                        }
                        while (newcol >= picture.width()) {
                            newcol = newcol - picture.width();
                        }
                        while (newrow >= picture.height()) {
                            newrow = newrow - picture.height();
                        }

                        // performing the operation on each color
                        Color c = picture.get(newcol, newrow);
                        red += kernel[i][j] * c.getRed();
                        green += kernel[i][j] * c.getGreen();
                        blue += kernel[i][j] * c.getBlue();
                    }
                }

                // checking if value goes more than 255 or less than 0
                // clamping or saturating arithmetic
                if (red > 255)
                    red = 255;
                else if (red < 0)
                    red = 0;
                if (green > 255)
                    green = 255;
                else if (green < 0)
                    green = 0;
                if (blue > 255)
                    blue = 255;
                else if (blue < 0)
                    blue = 0;

                // rounding the values
                red = Math.round(red);
                blue = Math.round(blue);
                green = Math.round(green);

                // setting the color and making it into integer
                Color make = new Color((int) red, (int) green, (int) blue);
                // setting the color to calculated pixel
                output.set(col, row, make);
            }
        }
        return output;
    }


    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {

        double[][] kernel = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        return kernelFilter(picture, kernel);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = {
                { 1 / 16.0, 2 / 16.0, 1 / 16.0 },
                { 2 / 16.0, 4 / 16.0, 2 / 16.0 },
                { 1 / 16.0, 2 / 16.0, 1 / 16.0 }
        };

        return kernelFilter(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 }
        };

        return kernelFilter(picture, kernel);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };

        return kernelFilter(picture, kernel);
    }


    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernel = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };

        return kernelFilter(picture, kernel);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = {
                { 1 / 9.0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1 / 9.0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1 / 9.0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1 / 9.0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 / 9.0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1 / 9.0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1 / 9.0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1 / 9.0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1 / 9.0 },
                };

        return kernelFilter(picture, kernel);
    }

    public static void main(String[] args) {

        Picture source = new Picture(args[0]);
        Picture identity = identity(source);
        identity.show();
        Picture gaussian = gaussian(source);
        gaussian.show();
        Picture sharpen = sharpen(source);
        sharpen.show();
        Picture laplacian = laplacian(source);
        laplacian.show();
        Picture emboss = emboss(source);
        emboss.show();
        Picture motionBlur = motionBlur(source);
        motionBlur.show();
    }
}
