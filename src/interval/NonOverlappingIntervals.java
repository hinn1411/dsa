package interval;

import java.util.Arrays;

public class NonOverlappingIntervals {

  public int eraseOverlapIntervals(int[][] intervals) {
    int picked = 0;
    int n = intervals.length;
    Arrays.sort(intervals, (first, second) -> Integer.compare(first[1], second[1]));
    int lastEnd = Integer.MIN_VALUE;
    for (int[] interval: intervals) {
      if (interval[0] >= lastEnd) {
        lastEnd = interval[1];
        picked++;
      }
    }

    return n - picked;
  }

  public static void main(String[] args) {
    NonOverlappingIntervals n = new NonOverlappingIntervals();
    int[][] arr1 = {{1,2},{2,3},{3,4},{1,3}};
    int[][] arr2 = {{1,2}, {1,2}, {1,2}};
    int[][] arr3 = {{1,2}, {1,2}};
    System.out.println(n.eraseOverlapIntervals(arr1));
    System.out.println(n.eraseOverlapIntervals(arr2));
    System.out.println(n.eraseOverlapIntervals(arr3));
  }
}
