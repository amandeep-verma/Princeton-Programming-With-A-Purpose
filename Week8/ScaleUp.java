/*
The program ScaleUp.java scales up the images by filling up the alternative pixel by the original pixels and the gaps 
by calculating the average of the pixels surrounding it. 
*/
import java.awt.Color;

public class ScaleUp {
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        int scaleLevel = 2;
        // Picture dest = new Picture(source.width() * scaleLevel, source.height() * scaleLevel);
        //
        // for (int col = 0; col < source.width(); col++) {
        //     for (int row = 0; row < source.height(); row++) {
        //         Color color = source.get(col, row);
        //         // Color gray = Luminance.toGray(color);
        //         dest.set(col * scaleLevel, row * scaleLevel, color);
        //         dest.set(col * scaleLevel, row * scaleLevel + 1, color);
        //         dest.set(col * scaleLevel + 1, row * scaleLevel, color);
        //         dest.set(col * scaleLevel + 1, row * scaleLevel + 1, color);
        //     }
        // }
        // dest.show();

        Picture dest = new Picture(source.width() * scaleLevel, source.height() * scaleLevel);

        for (int col = 0; col < source.width(); col++) {
            for (int row = 0; row < source.height(); row++) {
                Color color = source.get(col, row);
                dest.set(col * scaleLevel, row * scaleLevel, color);
            }
        }


        for (int col = 0; col < source.width() - 1; col++) {
            for (int row = 0; row < source.height() - 1; row++) {
                Color color1 = dest.get(col * scaleLevel, row * scaleLevel);
                Color color2 = dest.get(col * scaleLevel + 2, row * scaleLevel);
                Color color3 = new Color((color1.getRed() + color2.getRed()) / 2,
                                         (color1.getGreen() + color2.getGreen()) / 2,
                                         (color1.getBlue() + color2.getBlue()) / 2);
                dest.set(col * scaleLevel + 1, row * scaleLevel, color3);

                Color color4 = dest.get(col * scaleLevel, row * scaleLevel + 2);
                Color color5 = new Color((color1.getRed() + color4.getRed()) / 2,
                                         (color1.getGreen() + color4.getGreen()) / 2,
                                         (color1.getBlue() + color4.getBlue()) / 2);
                dest.set(col * scaleLevel, row * scaleLevel + 1, color5);

            }
        }

        for (int col = 0; col < source.width() - 1; col++) {
            Color color1 = dest.get(col * scaleLevel, (source.height() - 1) * scaleLevel);
            Color color2 = dest.get(col * scaleLevel + 2, (source.height() - 1) * scaleLevel);
            Color color3 = new Color((color1.getRed() + color2.getRed()) / 2,
                                     (color1.getGreen() + color2.getGreen()) / 2,
                                     (color1.getBlue() + color2.getBlue()) / 2);
            dest.set(col * scaleLevel + 1, (source.height() - 1) * scaleLevel, color3);
        }

        for (int row = 0; row < source.height() - 1; row++) {
            Color color1 = dest.get((source.width() - 1) * scaleLevel, row * scaleLevel);
            Color color2 = dest.get((source.width() - 1) * scaleLevel, row * scaleLevel + 2);
            Color color3 = new Color((color1.getRed() + color2.getRed()) / 2,
                                     (color1.getGreen() + color2.getGreen()) / 2,
                                     (color1.getBlue() + color2.getBlue()) / 2);
            dest.set((source.width() - 1) * scaleLevel, row * scaleLevel + 1, color3);
        }


        for (int col = 0; col < source.width() - 1; col++) {
            for (int row = 0; row < source.height() - 1; row++) {
                Color color1 = dest.get(col * scaleLevel, row * scaleLevel + 1);
                Color color2 = dest.get(col * scaleLevel + 2, row * scaleLevel + 1);
                Color color3 = new Color((color1.getRed() + color2.getRed()) / 2,
                                         (color1.getGreen() + color2.getGreen()) / 2,
                                         (color1.getBlue() + color2.getBlue()) / 2);
                dest.set(col * scaleLevel + 1, row * scaleLevel + 1, color3);

            }
        }


        // for (int row = 0; row < source.height() - 1; row++) {
        //     for (int col = 0; col < source.width() - 1; col++) {
        //         Color color1 = dest.get(col * scaleLevel, row * scaleLevel);
        //         Color color2 = dest.get(col * scaleLevel, row * scaleLevel + 2);
        //     }
        // }

        dest.show();

    }
}
