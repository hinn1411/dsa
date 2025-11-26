package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> subGrids = new HashMap<>();
    for (int i = 0; i < 9; i++) {
      subGrids.put(i, new HashSet<>());
    }
    for (int i = 0; i < 9; i++) {
      if (!isValidColumn(board, i)) {
        return false;
      }
    }

    for (int i = 0; i < 9; i++) {
      if (!isValidRow(board, subGrids,  i)) {
        return false;
      }
    }

    return true;
  }

  private boolean isValidRow(char[][] board, Map<Integer, Set<Character>> subGrids, int rowIndex) {
    Set<Character> row = new HashSet<>();
    Set<Character> subSudoku;
    for (int i = 0; i < 9; i++) {
      char curCell = board[rowIndex][i];
      int subSodokuIndex = 3 * ( rowIndex / 3) + ( i / 3);
      subSudoku = subGrids.get(subSodokuIndex);
      if (curCell == '.') {
        continue;
      }

      if (row.contains(curCell) || subSudoku.contains(curCell)) {
        return false;
      }
      row.add(curCell);
      subSudoku.add(curCell);
    }
    return true;
  }

  private boolean isValidColumn(char[][] board, int columnIndex) {
    Set<Character> column = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      char curCell = board[i][columnIndex];
      if (curCell == '.') {
        continue;
      }

      if (column.contains(curCell)) {
        return false;
      }
      column.add(curCell);
    }
    return true;
  }

}
