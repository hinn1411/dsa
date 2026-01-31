package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  public static class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getDistance() {
      return (int) (Math.pow(x, 2) + Math.pow(y, 2));
    }
  }
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Coordinate> q = new PriorityQueue<>((a, b) -> a.getDistance() -  b.getDistance());
    for (int[] point: points) {
      int currentX = point[0], currentY = point[1];
      Coordinate currentCoordinate  = new Coordinate(currentX, currentY);
      q.add(currentCoordinate);
    }
    int[][] res = new int[k][];
    for(int i = 0; i < k; i++) {
      Coordinate current = q.poll();
      res[i] = new int[]{current.x, current.y};
    }
    return res;
  }
  public static void main(String[] args) {
    KClosestPointsToOrigin k = new KClosestPointsToOrigin();
    int[][] arr1 = {{-2, 2}};
    System.out.println(Arrays.deepToString(k.kClosest(arr1, 1)));
    int[][] arr2 = {{3,3}, {5,-1}, {-2,4}};
    System.out.println(Arrays.deepToString(k.kClosest(arr2, 2)));
  }
}
