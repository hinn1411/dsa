package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

  public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) {
      return intervals;
    }
   Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> res = new ArrayList<>();
    for (int[] interval : intervals) {
      int nextStart = interval[0], nextEnd = interval[1];
      if (res.isEmpty()) {
        res.add(new int[]{nextStart, nextEnd});
        continue;
      }

      int mergedEnd = res.getLast()[1];
      if (mergedEnd >= nextStart) {
        res.getLast()[1] = Math.max(mergedEnd, nextEnd);
      } else {
        res.add(new int[]{nextStart, nextEnd});
      }
    }
    return res.toArray(int[][]::new);
  }

  public static void main(String[] args) {
    MergeIntervals m = new MergeIntervals();
    int[][] arr1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] arr2 = {{1, 4}, {4, 5}};
    int[][] arr3 = {{4, 7}, {1, 4}};
    int[][] arr4 = {{4, 7}};
    System.out.println(Arrays.deepToString(m.merge(arr1)));
    System.out.println(Arrays.deepToString(m.merge(arr2)));
    System.out.println(Arrays.deepToString(m.merge(arr3)));
    System.out.println(Arrays.deepToString(m.merge(arr4)));
  }
}
