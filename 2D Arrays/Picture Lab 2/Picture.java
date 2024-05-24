import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class Picture {

    /**
     * Return a deep copy of the given image. A deep copy is a copy of the array
     * where every object (Pixel) is newly created with the properties of the
     * original pixel.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @return Pixel[][] - deep copy of the original image
     */
    public static Pixel[][] getDeepCopy(Pixel[][] image)
    {
        Pixel[][] deepCopy = new Pixel[image.length][image[0].length];

        for (int r = 0; r < image.length; r++)
        {
            for (int c = 0; c < image[0].length; c++)
            {
                deepCopy[r][c] = new Pixel(image[r][c].getColor());
            }
        }
        return deepCopy;
    }

    /**
     * Returns a new 2D Pixel array where every pixel's red, green, and blue
     * values have been altered by the given value. For example, if value
     * were 30 then every pixel's red, green and blue values would be increased
     * by 30. Value can be negative which would darken the picture.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @param value - Value to increase or decrease each pixel's color by
     * @return Pixel[][] - Altered Image
     */
    public static Pixel[][] changeBrightness(Pixel[][] image, int value)
    {
        Pixel[][] newImage = getDeepCopy(image);

        for (int r = 0; r < image.length; r++)
        {
            for (int c = 0; c < image[0].length; c++)
            {
                int[] colors = newImage[r][c].getColors();
                for (int i = 0; i < colors.length; i++)
                {
                    colors[i] += value;
                }
                newImage[r][c].setColors(colors[0], colors[1], colors[2]);
            }
        }
        return newImage;
    }

    /**
     * Returns a new 2D Pixel array where each pixel's dominate color (red,
     * greed, blue) is increased by the given percentage.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @param percentage - Percentage change for each pixel's dominate color
     * @return Pixel[][] - Altered Image
     */
    public static Pixel[][] makeVibrant(Pixel[][] image, double percentage)
    {
        Pixel[][] newImage = getDeepCopy(image);
        int maxIndex = 0;

        for (int r = 0; r < image.length; r++)
        {
            for (int c = 0; c < image[0].length; c++)
            {
                int[] colors = newImage[r][c].getColors();

                for (int i = 0; i < colors.length; i++)
                {
                    if (colors[i] > colors[maxIndex])
                    {
                        maxIndex = i;
                    }
                }

                if (maxIndex == 0)
                {
                    double temp = colors[maxIndex] * (1 + percentage/100);
                    newImage[r][c].setColors((int)temp, colors[1], colors[2]);
                }

                if (maxIndex == 1)
                {
                    double temp = colors[maxIndex] * (1 + percentage/100);
                    newImage[r][c].setColors(colors[0], (int)temp, colors[2]);
                }

                if (maxIndex == 2)
                {
                    double temp = colors[maxIndex] * (1 + percentage/100);
                    newImage[r][c].setColors(colors[0], colors[1], (int)temp);
                }
            }
        }
        return newImage;
    }

    /**
     * Returns a new 2D Pixel array where each pixel's colors are swapped
     * according to the given colors. For example, if color0, color1, and color2
     * contain the values 1, 0, 2 respectively then the values for the red and
     * green pixels are swapped but the blue pixel retains its original value.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @param color0 - Index for red
     * @param color1 - Index for green
     * @param color2 - Index for blue
     * @return Pixel[][] - Altered Image
     */
    public static Pixel[][] swapColors(Pixel[][] image, int color0, int color1, int color2)
    {
        Pixel[][] newImage = getDeepCopy(image);

        for (int r = 0; r < image.length; r++)
        {
            for (int c = 0; c < image[0].length; c++)
            {
                int[] colors = newImage[r][c].getColors();
                newImage[r][c].setColors(colors[color0], colors[color1], colors[color2]);
            }
        }

        return newImage;
    }

    /**
     * Returns a new 2D Pixel array where the image is altered to gray scale
     * (black and white). To make an image gray scale set each colors red, green
     * and blue values to the same. You can choose an average for each pixel or
     * use that pixels dominate color value and set to the other colors to the
     * same value.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @return Pixel[][] - Altered Image
     */
    public static Pixel[][] blackAndWhite(Pixel[][] image)
    {
        Pixel[][] newImage = getDeepCopy(image);
        double average = 0;

        for (int r = 0; r < image.length; r++)
        {
            for (int c = 0; c < image[0].length; c++)
            {
                int[] colors = newImage[r][c].getColors();
                average = newImage[r][c].getAverageColor();
                newImage[r][c].setColors((int)average, (int)average, (int)average);
            }
        }
        return newImage;
    }

    /**
     * Returns a new 2D Pixel array where the image is a negative of the
     * original. To make a negative image set each color to the value 255 minus
     * it's current value. For example, if the RGB color values for a pixel are
     * 75, 150, 100 then the new values should be 180, 105, 155.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @return Pixel[][] - Altered Image
     */
    public static Pixel[][] getNegativeImage(Pixel[][] image)
    {
        Pixel[][] newImage = getDeepCopy(image);

        for (int r = 0; r < image.length; r++)
        {
            for (int c = 0; c < image[0].length; c++)
            {
                int[] colors = newImage[r][c].getColors();
                newImage[r][c].setColors(255 - colors[0], 255 - colors[1], 255 - colors[2]);
            }
        }
        return newImage;
    }

    /**
     * Returns a new 2D Pixel array where the color depth (number of possible
     * colors) has been reduced to the number of specified bits. The original
     * image contains 8 bits per color giving each color 256 different values. A
     * color depth of 3 bits is 2^3 or 8 different colors. You may round down to
     * the nearest color value.
     *
     * 8 bits - 256 values. 7 bits - 128 values. 6 bits - 64 values. 5 bits - 32
     * values 4 bits - 16 values 3 bits - 8 values 2 bits - 4 values 1 bit - 2
     * values
     *
     * For example, if the number of bits is set to 3 then there are only 8
     * values for each color (0, 32, 64, 96, 128 160, 192, 224). if the value
     * for red in the original pixel is 188 and the given bits are 3 then the
     * new value for red should be 160.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @param bits - number of bits used to represent a color value from 1 - 7.
     * @return Pixel[][] - Altered Image
     */
    public static Pixel[][] reduceColorDepth(Pixel[][] image, int bits)
    {
        Pixel[][] newImage = getDeepCopy(image);

        int redPixel = 0;
        int greenPixel = 0;
        int bluePixel = 0;

        double intervalIncrement = 256 / Math.pow(2, bits);

        for (int r = 0; r < image.length; r++)
        {
            for (int c = 0; c < image[0].length; c++)
            {
                int[] colors = newImage[r][c].getColors();
                redPixel = colors[0];
                greenPixel = colors[1];
                bluePixel = colors[2];

                int i = 0;
                while (redPixel > (intervalIncrement * i))
                {
                    i++;
                }
                redPixel = (int) (intervalIncrement*(i-1));

                i = 0;
                while (greenPixel > (intervalIncrement * i))
                {
                    i++;
                }
                greenPixel = (int) (intervalIncrement*(i-1));

                i = 0;
                while (bluePixel > (intervalIncrement * i))
                {
                    i++;
                }
                bluePixel = (int) (intervalIncrement*(i-1));

                newImage[r][c].setColors(redPixel, greenPixel, bluePixel);
            }
        }
        return newImage;
    }

    /**
     * Returns a new 2D Pixel array where the original image has been blurred.
     * To blur the image set the value for each color to the average of it and
     * it's 8 neighbors (up, down, left, right and diagonal). To make it easier
     * you may ignore blurring the edge rows and columns. They may contain the
     * original values for red, green, and blue.
     *
     * @param image - Pixel[][] of the image to be altered.
     * @return Pixel[][] - Altered Image
     */
    public static Pixel[][] blur(Pixel[][] image)
    {
        Pixel[][] newImage = getDeepCopy(image);

        double sumRed= 0;
        double sumGreen = 0;
        double sumBlue = 0;

        for (int r = 1; r < image.length - 1; r++)
        {
            for (int c = 1; c < image[0].length - 1; c++)
            {
                int[] colors = newImage[r][c].getColors();

                sumRed = newImage[r][c-1].getColors()[0] + newImage[r][c].getColors()[0] +
                        newImage[r][c+1].getColors()[0]  +
                        newImage[r-1][c-1].getColors()[0]  + newImage[r-1][c].getColors()[0]  +
                        newImage[r-1][c+1].getColors()[0] + newImage[r+1][c-1].getColors()[0]  +
                        newImage[r+1][c].getColors()[0]  + newImage[r+1][c+1].getColors()[0];

                sumGreen = newImage[r][c-1].getColors()[1] + newImage[r][c].getColors()[1] +
                        newImage[r][c+1].getColors()[1]  +
                        newImage[r-1][c-1].getColors()[1]  + newImage[r-1][c].getColors()[1]  +
                        newImage[r-1][c+1].getColors()[1] + newImage[r+1][c-1].getColors()[1]  +
                        newImage[r+1][c].getColors()[1]  + newImage[r+1][c+1].getColors()[1];

                sumBlue = newImage[r][c-1].getColors()[2] + newImage[r][c].getColors()[2] +
                        newImage[r][c+1].getColors()[2]  +
                        newImage[r-1][c-1].getColors()[2]  + newImage[r-1][c].getColors()[2]  +
                        newImage[r-1][c+1].getColors()[2] + newImage[r+1][c-1].getColors()[2]  +
                        newImage[r+1][c].getColors()[2]  + newImage[r+1][c+1].getColors()[2];

                newImage[r][c].setColors((int)(sumRed / 9.0), (int)(sumGreen / 9.0), (int)(sumBlue / 9.0));
            }
        }
        return newImage;
    }

    public static void showImageProperties(Pixel[][] image, String title) {
        int[] rgbAvg = {0, 0, 0};
        Set<Color> uniqueColors = new HashSet<>();
        for (Pixel[] row : image) {
            for (Pixel pix : row) {
                int[] colors = pix.getColors();
                rgbAvg[0] += colors[0];
                rgbAvg[1] += colors[1];
                rgbAvg[2] += colors[2];
                uniqueColors.add(pix.getColor());
            }
        }
        int numPixels = image.length * image[0].length;
        System.out.println("\nImage Properties: " + title);
        System.out.println("Resolution:    " + image[0].length + "x" + image.length);
        System.out.println("Pixels:        " + numPixels);
        System.out.println("Average Red:   " + (rgbAvg[0] / numPixels));
        System.out.println("Average Green: " + (rgbAvg[1] / numPixels));
        System.out.println("Average Blue:  " + (rgbAvg[2] / numPixels));
        System.out.println("Unique Colors: " + uniqueColors.size());
    }
}
