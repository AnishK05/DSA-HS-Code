public class Picture
{

    public static Pixel[][] merge(Pixel[][] picture, Pixel[][] background)
    {
        for (int r = 0; r < picture.length; r++)
        {
            for (int c = 0; c < picture[0].length; c++)
            {
                int[] colors = picture[r][c].getColors();

                if (colors[1] > (colors[0] + 30) && colors[1] > (colors[2] + 30))
                {
                    picture[r][c] = background[r][c];
                }
            }
        }
        return picture;
    }
}
