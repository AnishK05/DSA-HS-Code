
public class Cube 
{

    private int[][][] cube;

    public Cube() 
    {
        cube = new int[6][3][3];
        int num = 0;
        for (int[][] side : cube) 
        {
            num++;
            for (int row = 0; row < side.length; row++) 
            {
                for (int col = 0; col < side[row].length; col++) 
                {
                    side[row][col] = num++;
                }
            }
        }
    }

    /**
    * rotate the given side of the cube 90 degrees to the right.
    */
    public void rotateCube(int side) 
    {
        int[][][] newCube = new int[6][3][3];

        int[][][] deepCopyCube = getDeepCopy(cube);
        
        for (int row = 0; row < cube[side].length; row++)
        {
          for (int col = 0; col < cube[side][row].length; col++)
          {
              newCube[side][col][newCube[side][row].length - 1 - row] = cube[side][row][col];
          }
        }
  
        cube[side] = newCube[side];

        if (side == 0) //White
        {
            for (int i = 0; i < 3; i++) //Adjust Red for Blue
            {
              cube[3][0][i] = deepCopyCube[4][0][i];
            }

            for (int i = 0; i < 3; i++) //Adjust Green for Red
            {
              cube[2][0][i] = deepCopyCube[3][0][i];
            }

            for (int i = 0; i < 3; i++) //Adjust Orange for Green
            {
              cube[1][0][i] = deepCopyCube[2][0][i];
            }

            for (int i = 0; i < 3; i++) //Adjust Blue for Orange
            {
              cube[4][0][i] = deepCopyCube[1][0][i];
            }
        }

        if (side == 1) //Orange
        {
          for (int i = 0; i < 3; i++) //Adjust Green for White
            {
              cube[2][i][0] = deepCopyCube[0][i][0];
            }

            for (int i = 0; i < 3; i++) //Adjust Yellow for Green
            {
              cube[5][i][0] = deepCopyCube[2][i][0];
            }

            for (int i = 0; i < 3; i++) //Adjust Blue for Yellow
            {
              cube[4][i][2] = deepCopyCube[5][2-i][0];
            }

            for (int i = 0; i < 3; i++) //Adjust White for Blue
            {
              cube[0][i][0] = deepCopyCube[4][2-i][2];
            }
        }

        if (side == 2) //Green
        {
            for (int i = 0; i < 3; i++) //Adjust Red for White
            {
              cube[3][i][0] = deepCopyCube[0][2][i];
            }

            for (int i = 0; i < 3; i++) //Adjust Yellow for Red
            {
              cube[5][0][i] = deepCopyCube[3][2-i][0];
            }

            for (int i = 0; i < 3; i++) //Adjust Orange for Yellow
            {
              cube[1][i][2] = deepCopyCube[5][0][i];
            }

            for (int i = 0; i < 3; i++) //Adjust White for Orange
            {
              cube[0][2][i] = deepCopyCube[1][2-i][2];
            }
        }

        if (side == 3) //Red
        {
            for (int i = 0; i < 3; i++) //Adjust White for Green
            {
              cube[0][i][2] = deepCopyCube[2][i][2];
            }

            for (int i = 0; i < 3; i++) //Adjust Green for Yellow
            {
              cube[2][i][2] = deepCopyCube[5][i][2];
            }

            for (int i = 0; i < 3; i++) //Adjust Blue for White
            {
              cube[4][i][0] = deepCopyCube[0][2-i][2];
            }

            for (int i = 0; i < 3; i++) //Adjust Yellow for Blue
            {
              cube[5][i][2] = deepCopyCube[4][2-i][0];
            }
        }

        if (side == 4) //Blue
        {
            for (int i = 0; i < 3; i++) //Adjust Orange for White
            {
              cube[1][i][0] = deepCopyCube[0][0][2-i];
            }
          
            for (int i = 0; i < 3; i++) //Adjust Yellow for Orange
            {
              cube[5][2][i] = deepCopyCube[1][i][0];
            }

            for (int i = 0; i < 3; i++) //Adjust Red for Yellow
            {
              cube[3][i][2] = deepCopyCube[5][2][2-i];
            }

            for (int i = 0; i < 3; i++) //Adjust White for Red
            {
              cube[0][0][i] = deepCopyCube[3][i][2];
            }
        }

        if (side == 5) //Yellow
        {
            for (int i = 0; i < 3; i++) //Adjust Red for Green
            {
              cube[3][2][i] = deepCopyCube[2][2][i];
            }

            for (int i = 0; i < 3; i++) //Adjust Green for Orange
            {
              cube[2][2][i] = deepCopyCube[1][2][i];
            }

            for (int i = 0; i < 3; i++) //Adjust Orange for Blue
            {
              cube[1][2][i] = deepCopyCube[4][2][i];
            }

            for (int i = 0; i < 3; i++) //Adjust Blue for Red
            {
              cube[4][2][i] = deepCopyCube[3][2][i];
            }
        }
    }
    
    public String toString() {
        String str = "\n";

        // top of cube
        for (int row = 0; row < 3; row++) {
            str += "\t\t\t";
            for (int col = 0; col < 3; col++) {
                str += setColor(cube[0][row][col]);
            }
            str += "\n";
        }
        str += "\n";

        // sides
        for (int row = 0; row < 3; row++) {
            for (int side = 1; side < 5; side++) {
                for (int col = 0; col < 3; col++) {
                    str += setColor(cube[side][row][col]);
                }
                str += "\t";
            }
            str += "\n";
        }
        str += "\n";

        // bottom
        for (int row = 0; row < 3; row++) {
            str += "\t\t\t";
            for (int col = 0; col < 3; col++) {
                str += setColor(cube[5][row][col]);
            }
            str += "\n";
        }
        return str + "\n\n\033[0m";
    }

    public String setColor(int num) {
        if (num < 10 ){
            return "\033[38;5;7m" + String.format("%02d ", num); // white
        } else if (num < 20 ){
            return "\033[38;5;208m" + String.format("%02d ", num); // orange
        }else if (num < 30 ){
            return "\033[38:5:34m" + String.format("%02d ", num); // green
        }else if (num < 40 ){
            return "\033[38:5:196m" + String.format("%02d ", num); // red
        }else if (num < 50 ){
            return "\033[38;5;63m" + String.format("%02d ", num); // blue
        }else {   
            return "\033[38;5;226m" + String.format("%02d ", num); // yellow
        }
    }

    public int[][][] getDeepCopy (int[][][] cube)
    {
      int[][][] deepCopy = new int [6][3][3];
    
      for (int s = 0; s < 6; s++)
      {
        for (int r = 0; r < 3; r++)
        {
          for (int c = 0; c < 3; c++)
          {
            deepCopy[s][r][c] = cube[s][r][c];
          }
        }
      }
      return deepCopy;
    }

  public int[][][] getCube()
  {
    return cube;
  }

}