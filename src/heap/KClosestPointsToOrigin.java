package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  public static class Coordinate {
    int x, y, dist;
    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
      this.dist = x * x + y * y;
    }
  }
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Coordinate> q = new PriorityQueue<>((a, b) -> Integer.compare(b.dist, a.dist));
    for (int[] point: points) {
      int currentX = point[0], currentY = point[1];
      Coordinate currentCoordinate  = new Coordinate(currentX, currentY);
      q.add(currentCoordinate);
      if (q.size() > k) {
        q.poll();
      }
    }
    int[][] res = new int[k][2];
    for(int i = 0; i < k; i++) {
      Coordinate current = q.poll();
      res[i] = new int[]{current.x, current.y};
    }
    return res;
  }
  public int[][] kClosest_Sort(int[][] points, int k) {
    List<int[]> sortedPoints = Arrays.stream(points).sorted((a, b) -> Integer.compare(getDistance(a), getDistance(b)))
        .toList();
    int[][] res = new int[k][];
    for (int i = 0; i < k; i++) {
      res[i] = new int[] { sortedPoints.get(i)[0], sortedPoints.get(i)[1] };
    }
    return res;
  }

  private int getDistance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }

  public static void main(String[] args) {
    KClosestPointsToOrigin k = new KClosestPointsToOrigin();
//    int[][] arr1 = {{-2, 2}};
//    System.out.println(Arrays.deepToString(k.kClosest(arr1, 1))); // [[-2, 2]]
    int[][] arr2 = {{3,3}, {5,-1}, {-2,4}};
    System.out.println(Arrays.deepToString(k.kClosest_Sort(arr2, 2))); // [[3,3], [-2, 4]]
  }
}
