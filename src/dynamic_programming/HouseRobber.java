package dynamic_programming;

import java.util.Arrays;

public class HouseRobber {

  public int rob_Memoization(int[] nums) {
    int n = nums.length;
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    return helper(nums, n - 1, memo);
  }

  private int helper(int[] nums, int i, int[] memo) {
    if (i == 0) {
      memo[0] = nums[0];
      return memo[0];
    }
    if (i == 1) {
      memo[1] = Math.max(nums[0], nums[1]);
      return memo[1];
    }
    if (memo[i] != -1) {
      return memo[i];
    }
    memo[i] = Math.max(helper(nums, i - 1, memo),
        nums[i] + helper(nums, i - 2, memo));
    return memo[i];
  }
}
