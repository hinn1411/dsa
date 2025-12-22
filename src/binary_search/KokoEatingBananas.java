package binary_search;

import java.util.Arrays;

public class KokoEatingBananas {
  public int minEatingSpeed(int[] piles, int h) {
    int minRate = 1;
    int maxRate = Arrays.stream(piles).max().getAsInt();
    int eatRate;
    while (minRate <= maxRate) {
      eatRate = minRate + (maxRate - minRate) / 2;
      int totalHours = computeEatingHours(piles, eatRate);
      if (totalHours <= h) {
        maxRate = eatRate - 1;
      } else {
        minRate = eatRate + 1;
      }
    }
    return minRate;
  }

  private int computeEatingHours(int[] piles, int eatRate) {
    int totalHours = 0;
    for (int i = 0; i < piles.length; i++) {
      totalHours +=  (piles[i] + eatRate - 1) / eatRate;
    }
    return totalHours;
  }

  public static void main(String[] args) {
    KokoEatingBananas k = new KokoEatingBananas();
    System.out.println(k.minEatingSpeed(new int[]{3,6,7,11}, 8));
    System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    System.out.println(k.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
  }
}
