package dynamic_programming;

import java.util.Arrays;

public class HouseRobberII {

  public int rob(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }

    int[] first = new int[n];
    int[] second = new int[n];
    Arrays.fill(first, -1);
    Arrays.fill(second, -1);

    return Math.max(
        helper(nums, 0, n - 2, first),
        helper(nums, 1, n - 1, second)
    );
  }

  private int helper(int[] nums, int start, int cur, int[] memo) {
    if (cur < start) {
      return 0;
    }
    if (memo[cur] != -1) {
      return memo[cur];
    }
    memo[cur] = Math.max(
        nums[cur] + helper(nums, start, cur - 2, memo),
        helper(nums, start, cur - 1, memo)
    );
    return memo[cur];
  }
}
