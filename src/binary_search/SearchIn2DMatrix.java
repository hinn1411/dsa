package binary_search;

import java.util.Arrays;

public class SearchIn2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int targetRow = searchRow(matrix, target);

    if (targetRow < 0) {
      return false;
    }
    return Arrays.binarySearch(matrix[targetRow], target) >= 0;
  }


  private int searchRow(int[][] matrix, int target) {
    int m = matrix.length;
    int lo = 0, hi = m - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int current = matrix[mid][0];
      if (current <= target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return hi;
  }

  public static void main(String[] args) {
    SearchIn2DMatrix s = new SearchIn2DMatrix();
    System.out.println(s.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    System.out.println(s.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    System.out.println(s.searchMatrix(new int[][]{{1}, {3}}, 1));
  }


}
