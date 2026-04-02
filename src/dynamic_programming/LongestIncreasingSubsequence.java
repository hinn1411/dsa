package dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public int lengthOfLIS_Memoization(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, dfs(nums, i));
    }
    return max;
  }

  private int dfs(int[] nums, int cur) {
    int max = 1;
    for (int j = 0; j < cur; j++) {
      if (nums[j] < nums[cur]) {
        max = Math.max(max, 1 + dfs(nums, j));
      }
    }
    return max;
  }

  public int lengthOfLIS(int[] nums) {

    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int max = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}

