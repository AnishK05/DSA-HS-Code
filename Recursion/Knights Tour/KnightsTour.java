import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class KnightsTour {

    private final int ROWS = 8;
    private final int COLS = 8;
    private int startRow   = 0;
    private int startCol   = 0;

    private int[][] board;
    private KnightsTourGUI GUI;
    private long numMoves;
    private boolean displayGUI;

    public KnightsTour(boolean displayGUI) {
        this.displayGUI = displayGUI;
        if (displayGUI) {
            GUI = new KnightsTourGUI();
            GUI.createGUI(ROWS, COLS);
        }
    }

    public void runTour() {

        board = new int[ROWS][COLS];
        numMoves = 0;
        System.out.println("\nStarting row: " + startRow + "\t" + "col: " + startCol);

        long start = System.nanoTime();
        boolean success = tour(startRow, startCol, 1, false);
        long time = System.nanoTime() - start;

        if (success) {
            System.out.printf("Moves = %,d\n", numMoves);
        } else {
            System.out.println("Tour not found.");
        }
        System.out.printf("Time = %.4f seconds.\n", time / 1_000_000_000.0);
    }

    private boolean tour(int row, int col, int count, boolean success) {

        numMoves++;
        board[row][col] = count;
        if (displayGUI) {
            GUI.button[row * COLS + col].setText("" + count);
        }

        // Your code goes here

        //Base Case
        if (count == 64)
        {
          return true;
        }

        //Up 2, Right 1
        if (!success && row > 1)
        {
          if (col < 7 && board[row - 2][col + 1] == 0)
          {
            success = tour(row - 2, col + 1, count+1, success);
          }
        }
      
        //Up 2, Left 1
        if (!success && row > 1)
        {
          if (col > 0 && board[row - 2][col - 1] == 0)
          {
            success = tour(row - 2, col - 1, count+1, success);
          }
        }

        //Right 2, Up 1
        if (!success && row > 0)
        {
          if (col < 6 && board[row - 1][col + 2] == 0)
          {
            success = tour(row - 1, col + 2, count+1, success);
          }
        }

        //Left 2, Up 1
        if (!success && row > 0)
        {
          if (col > 1 && board[row - 1][col - 2] == 0)
          {
            success = tour(row - 1, col - 2, count+1, success);
          }
        }

        //Right 2, Down 1
        if (!success && row < 7)
        {
          if (col < 6 && board[row + 1][col + 2] == 0)
          {
            success = tour(row + 1, col + 2, count+1, success);
          }
        }

        //Down 2, Right 1
        if (!success && row < 6)
        {
          if (col < 7 && board[row + 2][col + 1] == 0)
          {
            success = tour(row + 2, col + 1, count+1, success);
          }
        }

        //Left 2, Down 1
        if (!success && row < 7)
        {
          if (col > 1 && board[row + 1][col - 2] == 0)
          {
            success = tour(row + 1, col - 2, count+1, success);
          }
        }
        
        //Down 2, Left 1
        if (!success && row < 6)
        {
          if (col > 0 && board[row + 2][col - 1] == 0)
          {
            success = tour(row + 2, col - 1, count+1, success);
          }
        }
    
        if (!success) { // dead end, backtrack
            board[row][col] = 0;
            if (displayGUI) {
                GUI.button[row * COLS + col].setText("");
            }
        }
        return success;
    }

    class KnightsTourGUI {

        private JFrame frame;
        protected JButton[] button;

        public final void createGUI(int nRows, int nCols) {
            frame = new JFrame("Knight's Tour");
            button = new JButton[nRows * nCols];
            for (int i = 0; i < button.length; i++) {
                button[i] = new JButton("");
                button[i].setFont(new Font("Arial", Font.BOLD, 22));
                button[i].setBackground(new Color(255, 127, 127));
                if ((i / nCols % 2 == 0 && i % 2 == 0) || (i / nCols % 2 == 1 && i % 2 == 1)) {
                    button[i].setBackground(new Color(144, 238, 144));
                }
                frame.add(button[i]);
            }
            frame.setLayout(new GridLayout(nRows, nCols));
            frame.setSize(nCols * 60 + 45, nRows * 60 + 45);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
}
