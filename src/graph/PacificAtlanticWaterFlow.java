package graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
  int[][] heights;
  int row, col;
  int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
     this.heights = heights;
     row = heights.length;
     col = heights[0].length;
     boolean[][] reachPacific = new boolean[row][col];
     boolean[][] reachAtlantic = new boolean[row][col];

     for (int c = 0; c < col; c++) {
       dfs(0, c, reachPacific);
     }
     for (int r = 0; r < row; r++) {
       dfs(r, 0, reachPacific);
     }
     for (int c = 0; c < col; c++) {
       dfs (row - 1, c, reachAtlantic);
     }
     for (int r = 0; r < row; r++) {
       dfs(r, col - 1, reachAtlantic);
     }

     List<List<Integer>> res = new ArrayList<>();
     for (int r = 0; r < row; r++) {
       for (int c = 0; c < col; c++) {
         if (reachPacific[r][c] && reachAtlantic[r][c]) {
           res.add(List.of(r, c));
         }
       }
     }
    return res;
  }

  private void dfs(int r, int c, boolean[][] visited) {
    visited[r][c] = true;
    for (int[] dir: dirs) {
      int newRow = r + dir[0], newCol = c + dir[1];
      if (isOutOfRange(newRow, newCol)) {
        continue;
      }
      if (visited[newRow][newCol]) {
        continue;
      }
      if (heights[r][c] > heights[newRow][newCol]) {
        continue;
      }
      dfs(newRow, newCol, visited);
    }
  }

  private boolean isOutOfRange(int r, int c) {
    return r < 0 || r >= heights.length || c < 0 || c >= heights[0].length;
  }

  public static void main(String[] args) {
    int[][] heights = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };
    PacificAtlanticWaterFlow p = new PacificAtlanticWaterFlow();
    System.out.println(p.pacificAtlantic(heights));
  }
}
