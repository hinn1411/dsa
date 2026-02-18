package backtracking;

public class WordSearch {


  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, i, j, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int i, int j, String word, int curIndex) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
      return false;
    }
    if (board[i][j] != word.charAt(curIndex)) {
      return false;
    }
    if (curIndex == word.length() - 1) {
      return true;
    }

    char cur = board[i][j];
    board[i][j] = '#';
    boolean isFound = dfs(board, i, j - 1, word, curIndex + 1)
        || dfs(board, i, j + 1, word, curIndex + 1)
        || dfs(board, i - 1, j, word, curIndex + 1)
        || dfs(board, i + 1, j, word, curIndex + 1);
    board[i][j] = cur;
    return isFound;
  }

  public static void main(String[] args) {
    WordSearch w = new WordSearch();
    System.out.println(w.exist(new char[][]{new char[]{'A', 'B', 'C', 'E'},
        new char[]{'S', 'F', 'C', 'S'}, new char[]{'A', 'D', 'E', 'E'}}, "ABCCED"));
    System.out.println(w.exist(new char[][]{new char[]{'A','B','C','E'}, new char[]{'S','F','C','S'}, new char[]{'A','D','E','E'}}, "SES  "));
  }
}
