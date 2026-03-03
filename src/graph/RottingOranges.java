package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {


  public int orangesRotting(int[][] grid) {
    int freshCount = 0;
    Queue<int[]> q = new ArrayDeque<>();
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          freshCount++;
        } else if (grid[i][j] == 2) {
          q.add(new int[]{i, j});
        }
      }
    }

    if (freshCount == 0) {
      return 0;
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int timeElapsed = 0;
    while (!q.isEmpty()) {

      int queueSize = q.size();

      for (int i = 0; i < queueSize; i++) {
        int[] current = q.poll();
        int row = current[0], col = current[1];
        for (int[] dir : directions) {
          int newRow = row + dir[0], newCol = col + dir[1];
          if (!isOutOfBound(grid, newRow, newCol) && grid[newRow][newCol] == 1) {
            grid[newRow][newCol] = 2;
            freshCount--;
            q.add(new int[]{newRow, newCol});
          }
        }
      }
      timeElapsed++;

    }
    return freshCount > 0 ? -1 : timeElapsed - 1;
  }

  private boolean isOutOfBound(int[][] grid, int row, int col) {
    return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
  }


  public static void main(String[] args) {

  }
}
