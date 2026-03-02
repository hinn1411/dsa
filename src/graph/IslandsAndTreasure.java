package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandsAndTreasure {
  private static int INF = Integer.MAX_VALUE;

  public void islandsAndTreasure(int[][] grid) {
    Queue<int[]> q = new ArrayDeque<>();
    enqueueAllTreasures(q, grid);

    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    while (!q.isEmpty()) {
      int[] cell = q.poll();
      int row = cell[0], col = cell[1];

      for (int[] dir: dirs) {
        int nextRow = row + dir[0], nextCol = col + dir[1];
        if (isOutOfBound(grid, nextRow, nextCol)) {
          continue;
        }
        if (grid[nextRow][nextCol] == -1 || grid[nextRow][nextCol] != INF) {
          continue;
        }

        grid[nextRow][nextCol] = grid[row][col] + 1;
        q.add(new int[]{nextRow, nextCol});
      }

    }
  }

  public void enqueueAllTreasures(Queue<int[]> q, int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          q.add(new int[]{i, j});
        }
      }
    }
  }

  public boolean isOutOfBound(int[][] grid, int row, int col) {
    return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
  }
  public static void main(String[] args) {

  }
}
