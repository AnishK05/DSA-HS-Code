import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static String fileName = "Picture.jpg";

    public static void main(String[] args) {

        Pixel[][] image = getPixelArray();
        show(image, "Original Image: " + fileName);
        Picture.showImageProperties(image, "Original Image: " + fileName);
        
        /*
         * Complete the Picture class and run the tests below
         */
        
        show(Picture.changeBrightness(image, -40), "Brightness -40");
        show(Picture.makeVibrant(image, 25), "makeVibrant 25");
        show(Picture.swapColors(image, 1, 2, 2), "SwapColors 1, 2, 2");
        show(Picture.blackAndWhite(image), "Black and White");
        show(Picture.getNegativeImage(image), "Negative Image");
        
        Pixel[][] newImage  = Picture.reduceColorDepth(image, 2);
        show(newImage, "Color Depth 2");
        Picture.showImageProperties(newImage, "Color Depth 2");
        
        Pixel[][] blurredImage = Picture.blur(image);
        for (int i = 0; i < 5; i++) {
            blurredImage = Picture.blur(blurredImage);
        }
        show(Picture.blur(blurredImage), "Blur");
    }

    public static void show(Pixel[][] array, String title) {
        if (array == null) {
            return;
        }
        BufferedImage image = new BufferedImage(array[0].length, array.length, BufferedImage.TYPE_INT_RGB);

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
        String[] formats = ImageIO.getWriterFormatNames();
        System.out.println(Arrays.toString(formats));
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

    public static void saveImage(Pixel[][] array, String title) {
        if (array == null) {
            return;
        }
        BufferedImage image = new BufferedImage(array[0].length, array.length, BufferedImage.TYPE_INT_RGB);

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] == null) {
                    array[row][col] = new Pixel(new Color(0, 0, 0, 255));
                }
                image.setRGB(col, row, array[row][col].getColor().getRGB());
            }
        }
        try {
            File outputfile = new File("save.jpg");
            ImageIO.write(image, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println(e.getStackTrace().toString());
        }
    }
}
