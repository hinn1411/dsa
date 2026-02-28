package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int numOfIslands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (dfs(grid, i, j, visited)) {
          numOfIslands++;
        }
      }
    }
    return numOfIslands;
  }

  private boolean dfs(char[][] grid, int i, int j, boolean[][] visited) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return false;
    }
    if (grid[i][j] == '0') {
      return false;
    }
    if (visited[i][j]) {
      return false;
    }

    visited[i][j] = true;
    dfs(grid, i, j - 1, visited);
    dfs(grid, i, j + 1, visited);
    dfs(grid, i - 1, j, visited);
    dfs(grid, i + 1, j, visited);
    return true;
  }

  public int numIslands_Bfs(char[][] grid) {
    int count = 0;
    int m = grid.length, n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          bfs(grid, i, j, visited);
          count++;
        }
      }
    }
    return count;
  }

  private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{i, j});

    while (!q.isEmpty()) {
      int[] current = q.poll();
      int currentX = current[0], currentY = current[1];
      if (isOutOfRange(grid, currentX, currentY)) {
        continue;
      }
      if (grid[currentX][currentY] == '0') {
        continue;
      }
      if (visited[currentX][currentY]) {
        continue;
      }
      visited[currentX][currentY] = true;
      for (int[] dir: dirs) {
        q.add(new int[]{currentX + dir[0], currentY + dir[1]});
      }
    }
  }


  private boolean isOutOfRange(char[][] grid, int i, int j) {
    return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
  }
  public static void main(String[] args) {

  }
}
