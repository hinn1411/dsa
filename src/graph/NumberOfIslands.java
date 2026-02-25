package graph;

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

  public static void main(String[] args) {

  }
}
