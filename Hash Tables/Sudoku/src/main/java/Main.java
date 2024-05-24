public class Main {
    
    public static void main(String[] args) {

        char[][] board1 = 
            {{'5','3','.','.','7','.','.','.','6'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = 
            {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board1));
        System.out.println(isValidSudoku(board2));

    }

    public static boolean isValidSudoku(char[][] board) 
    {
      //Check rows and columns
      for (int i = 0; i < 9; i++)
      {
        HashTable rowH = new HashTable();
        HashTable colH = new HashTable();

        for (int j = 0; j < 9; j++)
        {
          if (!rowH.add(board[i][j]))
          {
            return false;
          }
          if (!colH.add(board[j][i]))
          {
            return false;
          }
        }
      }

      //Check 3x3 boxes
      for (int w = 0; w < 3; w++)
      {
        for (int x = 0; x < 3; x++)
        {
          HashTable boxH = new HashTable();
          
          for (int y = 0; y < 3; y++)
          {
            for (int z = 0; z < 3; z++)
            {
              int a = w*3 + y;
              int b = x*3 + z;

              if (!boxH.add(board[a][b]))
              {
                return false;
              }
            }
          }
        }
      }

      return true;
    }
}
