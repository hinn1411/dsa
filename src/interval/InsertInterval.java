package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

  public int[][] insert_Mutation(int[][] intervals, int[] newInterval) {
    List<int[]> res = new ArrayList<>();
    int[] merged = new int[]{newInterval[0], newInterval[1]};

    for (int[] current: intervals) {
      int[] former = merged, latter = current;
      if (former[0] > latter[0]) {
        former = current;
        latter = merged;
      }
      if (former[1] >= latter[0]) {
        merged = former;
        merged[1] = Math.max(former[1], latter[1]);
      } else {
        res.add(former);
        merged = latter;
      }
    }
    res.add(merged);
    return res.toArray(int[][]::new);
  }


  public int[][] insert(int[][] intervals, int[] newInterval) {
    int curIndex = 0;
    int n = intervals.length;
    List<int[]> res = new ArrayList<>();
    int newStart = newInterval[0], newEnd = newInterval[1];
    while (curIndex < n && intervals[curIndex][1] < newStart) {
      res.add(intervals[curIndex]);
      curIndex++;
    }
    while (curIndex < n && intervals[curIndex][0] <= newEnd) {
      newStart = Math.min(newStart, intervals[curIndex][0]);
      newEnd = Math.max(newEnd, intervals[curIndex][1]);
      curIndex++;
    }
    res.add(new int[]{newStart, newEnd});
    while (curIndex < n) {
      res.add(intervals[curIndex]);
      curIndex++;
    }

    return res.toArray(int[][]::new);
  }
  public static void main(String[] args) {
    InsertInterval i = new InsertInterval();
    int[][] intervals1 = {{1,3} ,{ 6,9}};
    int[] newInterval1 = {2, 5};
    System.out.println(Arrays.deepToString(i.insert(intervals1, newInterval1)));
    int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    int[] newInterval2 = {4, 8};
    System.out.println(Arrays.deepToString(i.insert(intervals2, newInterval2)));
  }
}
