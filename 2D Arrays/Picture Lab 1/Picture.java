
import java.awt.Color;

public class Picture {

    private Pixel[][] image;

    public Picture(Pixel[][] image) {
        this.image = image;
    }

    public Pixel[][] getPicture() {
        return image;
    }

    // Return a new 2D Pixel array where the image has been rotated 90 degrees to
    // the left
    public Pixel[][] rotateLeft() {

        return null;
    }

    // Return a new 2D Pixel array where the image has been rotated 90 degrees to
    // the right
    public Pixel[][] rotateRight() {

        return null;
    }

    // Return a new 2D Pixel array where the image has been flipped accress the
    // y-axis
    public Pixel[][] getMirrorImage() {

        return null;
    }

    // Return a new 2D Pixel array where the image has been fliped accross the
    // x-axis
    public Pixel[][] getUpsideDownMirrorImage() {

        return null;
    }

}
