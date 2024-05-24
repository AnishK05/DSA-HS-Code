import java.awt.Color;

/**
 * The smallest unit of an image is called a Pixel, and it is made up of 4
 * components namely: red, green, blue, and alpha.
 *
 * Alpha determines the transparency while Red, Green and Blue determines the
 * color of the pixel. Each of these four components (ARGB) take a value between
 * 0 to 255 both inclusive, where 0 means the component is missing and 255 means
 * the component is fully present.
 */
public class Pixel {

    private int red;
    private int green;
    private int blue;
    private int alpha;

    /**
     * Pixel constructor receives a Color object that is used to initialize the
     * pixel's properties / instance variables. A Color object consists of all
     * four color components. A Color object can be created using; Color
     * newColor = new Color(red, green, blue, alpha);
     *
     * @param newColor
     */
    public Pixel(Color aColor) {
        red = aColor.getRed();
        green = aColor.getGreen();
        blue = aColor.getBlue();
        alpha = aColor.getAlpha();
    }

    /**
     * @returns an array of three integers in the range of 0 to 255 for each
     * color component (red, green and blue). A value of zero is off while a
     * value of 255 is fully on.
     */
    public int[] getColors() {
        return new int[]{red, green, blue};
    }

    /**
     * The method sets the value of each of the three color components to the
     * given value where;
     *
     * @param r - value of the red component from 0 to 255.
     * @param g - value of the green component from 0 to 255.
     * @param b - value of the blue component from 0 to 255.
     */
    public void setColors(int r, int g, int b) {
        if (r >= 0 && r <= 255) {
            red = r;
        }
        if (g >= 0 && g <= 255) {
            green = g;
        }
        if (b >= 0 && b <= 255) {
            blue = b;
        }
    }

    /**
     * @returnd the alpha component of the pixel in the range of 0 to 255.
     */
    public int getApha() {
        return alpha;
    }

    /**
     * The method sets the alpha or transparency of the pixel.
     *
     * @param a - value of the alpha component from 0 to 255
     */
    public void setAlpha(int a) {
        if (a >= 0 || a <= 255) {
            alpha = a;
        }
    }

    /**
     * @return double that is the average color of the pixel
     */
    public int getAverageColor() {
        return (int)((red + green + blue) / 3.0 + .5);
    }

    /**
     * Receives a Color object that will be used to set the pixel to a new
     * color. A Color object consists of all four color components. A Color
     * object can be created using; Color newColor = new Color(red, green, blue,
     * alpha);
     *
     * @param newColor
     */
    public void setColor(Color newColor) {
        red = newColor.getRed();
        green = newColor.getGreen();
        blue = newColor.getBlue();
        alpha = newColor.getAlpha();
    }

    public Color getColor() {
        return new Color(red, green, blue, alpha);
    }
} // end of Pixel class
