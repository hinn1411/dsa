package graph;

public class SurroundedRegions {

  private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

  public void solve(char[][] board) {
    int row = board.length, col = board[0].length;

    for (int c = 0; c < col; c++) {
      dfs(board, 0, c);
    }
    for (int r = 0; r < row; r++) {
      dfs(board, r, 0);
    }
    for (int c = 0; c < col; c++) {
      dfs(board, row - 1, c);
    }
    for (int r = 0; r < row; r++) {
      dfs(board, r, col - 1);
    }

    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c] == '#') {
          board[r][c] = 'O';
        } else if (board[r][c] == 'O') {
          board[r][c] = 'X';
        }
      }
    }
  }

  private void dfs(char[][] board, int r, int c) {
    if (board[r][c] != 'O') {
      return;
    }
    board[r][c] = '#';
    for (int[] dir: dirs) {
      int newRow = r + dir[0], newCol = c + dir[1];
      if (isOutOfRange(board, newRow, newCol)) {
        continue;
      }
      dfs(board, newRow, newCol);
    }
  }

  private boolean isOutOfRange(char[][] board, int r, int c) {
    return r < 0 || r >= board.length || c < 0 || c >= board[0].length;
  }
  public static void main(String[] args) {

  }
}
