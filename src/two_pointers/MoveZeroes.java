package two_pointers;

import java.util.Arrays;

public class MoveZeroes {
  public void naive(int[] nums) {
    int n = nums.length;
    int[] clonedNums = new int[n];
    int nonZeroIndex = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] != 0) {
        clonedNums[nonZeroIndex] = nums[i];
        nonZeroIndex++;
      }
    }
    for (int i = 0; i < n; i++) {
      nums[i] = clonedNums[i];
    }
    System.out.println(Arrays.toString(nums));
  }

  public void moveZeroes(int[] nums) {
    int n = nums.length;
    int nonZeroIndex = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] != 0) {
        nums[nonZeroIndex] = nums[i];
        nonZeroIndex++;
      }
    }

    while (nonZeroIndex < n) {
      nums[nonZeroIndex] = 0;
      nonZeroIndex++;
    }
    System.out.println(Arrays.toString(nums));
  }

  public static void main(String[] args) {
    MoveZeroes m = new MoveZeroes();
    m.moveZeroes(new int[]{0, 1, 0, 3, 12}); // [1,3,12,0,0]
    m.moveZeroes(new int[]{1, 0});
    m.moveZeroes(new int[]{0,0,0,1,1,1,0,0,0,1});
  }
}
