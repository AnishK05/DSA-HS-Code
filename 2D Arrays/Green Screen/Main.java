import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // edit the two filenames below so they match yours
        Pixel[][] picture = getPixelArray("anishgriddy.jpg");
        Pixel[][] background =getPixelArray("dtbackground.jpg");

        Pixel[][] newImage = Picture.merge(picture, background);
        saveImage(newImage, "MergedPicture");

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

    public static Pixel[][] getPixelArray(String fileName) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            throw new IllegalArgumentException("error reading: " + fileName, e);
        }
        System.out.println("Image File: " + fileName);
        System.out.println("Resolution: " + image.getWidth() + "x" + image.getHeight() + "\n");

        Pixel[][] array = new Pixel[image.getHeight()][image.getWidth()];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = new Pixel(new Color(image.getRGB(col, row)));
            }
        }
        return array;
    }

    public static void saveImage(Pixel[][] array, String fileName) {
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
            File outputfile = new File(fileName + ".jpg");
            ImageIO.write(image, "jpg", outputfile);
            System.out.println("File " + fileName + ".jpg has been saved.");
        } catch (IOException e) {
            System.out.println(e.getStackTrace().toString());
        }
    }
}
