
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static String fileName = "Picture.jpg";

    public static void main(String[] args) {

        /*
         * Complete the Picture class and uncomment the tests below one at a time to
         * test your methods.
         */

        Picture image = new Picture(getPixelArray());
        show(image.getPicture(), "Original");

        /*
         * Rotate the image 90 degrees to the left
         */
        //show(image.rotateLeft(),"Rotate Left");

        /*
         * Rotate the image 90 degrees to the right
         */
        //show(image.rotateRight(), "Rotate Right");

        /*
         * getMirrorImage flips the picture accross the y-axis
         */
        //show(image.getMirrorImage(), "Mirror Image");

        /*
         * getUpSideDownMirrorImage flips the picture accross the x-axis
         */
        //show(image.getUpsideDownMirrorImage(), "Upside Down Mirror Image");

    }

    public static void show(Pixel[][] array, String title) {

        if (array == null) return;
        BufferedImage image = new BufferedImage(array[0].length, array.length, BufferedImage.TYPE_INT_ARGB);

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] == null) {
                    array[row][col] = new Pixel(new Color(0, 0, 0, 255));
                }
                image.setRGB(col, row, array[row][col].getColor().getRGB());

            }
        }

        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setContentPane(new JLabel(new ImageIcon(image)));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.repaint();

    }

    public static Pixel[][] getPixelArray() {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            throw new IllegalArgumentException("error reading: " + fileName, e);
        }

        Pixel[][] array = new Pixel[image.getHeight()][image.getWidth()];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = new Pixel(new Color(image.getRGB(col, row)));
            }
        }
        return array;
    }

}
