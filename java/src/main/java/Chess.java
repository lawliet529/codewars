import java.util.Arrays;

public class Chess {

  public static int knight(String start, String finish) {
    int[][] board = new int[8][8];
    for (int[] row : board) {
      Arrays.fill(row, -1);
    }
    int x1 = start.charAt(0) - 'a';
    int y1 = start.charAt(1) - '1';
    int x2 = finish.charAt(0) - 'a';
    int y2 = finish.charAt(1) - '1';
    board[x1][y1] = 0; // starting point
    fillBoard(board, 0);
    return board[x2][y2];
  }

  private static void fillBoard(int[][] board, int count) {
    boolean changed = false;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (board[i][j] == count) {
          if (i > 1) {
            if (j > 0) {
              if (board[i - 2][j - 1] == -1) board[i - 2][j - 1] = count + 1;
              changed = true;
            }
            if (j < 7) {
              if (board[i - 2][j + 1] == -1) board[i - 2][j + 1] = count + 1;
              changed = true;
            }
          }
          if (i > 0) {
            if (j > 1) {
              if (board[i - 1][j - 2] == -1) board[i - 1][j - 2] = count + 1;
              changed = true;
            }
            if (j < 6) {
              if (board[i - 1][j + 2] == -1) board[i - 1][j + 2] = count + 1;
              changed = true;
            }
          }
          if (i < 7) {
            if (j > 1) {
              if (board[i + 1][j - 2] == -1) board[i + 1][j - 2] = count + 1;
              changed = true;
            }
            if (j < 6) {
              if (board[i + 1][j + 2] == -1) board[i + 1][j + 2] = count + 1;
              changed = true;
            }
          }
          if (i < 6) {
            if (j > 0) {
              if (board[i + 2][j - 1] == -1) board[i + 2][j - 1] = count + 1;
              changed = true;
            }
            if (j < 7) {
              if (board[i + 2][j + 1] == -1) board[i + 2][j + 1] = count + 1;
              changed = true;
            }
          }
        }
      }
    }
    if (!changed) return;
    fillBoard(board, count + 1);
  }
}
