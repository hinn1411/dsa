package graph;

public class MaxAreaOfIsland {

  public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int maxArea = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          int currentArea = dfs(grid, i, j, visited);
          maxArea = Math.max(currentArea, maxArea);
        }
      }
    }

    return maxArea;
  }

  private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return 0;
    }
    if (grid[i][j] == 0) {
      return 0;
    }
    if (visited[i][j]) {
      return 0;
    }

    visited[i][j] = true;
    int area = 1;
    area += dfs(grid, i, j - 1, visited);
    area += dfs(grid, i, j + 1, visited);
    area += dfs(grid, i - 1, j, visited);
    area += dfs(grid, i + 1, j, visited);
    return area;
  }
  public static void main(String[] args) {

  }
}
