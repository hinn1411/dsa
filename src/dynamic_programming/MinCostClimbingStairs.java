package dynamic_programming;

import java.util.Arrays;

public class MinCostClimbingStairs {
  public int minCostClimbingStairs_Memoization(int[] cost) {
    int n = cost.length;
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    return Math.min(helper(cost, n - 1, memo),
        helper(cost, n - 2, memo));
  }

  private int helper(int[] cost, int i, int[] memo) {
    if (i <= 1) {
      memo[i] = cost[i];
      return memo[i];
    }
    if (memo[i] != -1) {
      return memo[i];
    }
    memo[i] = cost[i] + Math.min(helper(cost, i - 1, memo),
        helper(cost, i - 2, memo));
    return memo[i];
  }


  public int minCostClimbingStairs_Tabulation(int[] cost) {
    int n = cost.length;
    int[] dp = new int[n];
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < n; i++) {
      dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
    }
    return Math.min(dp[n - 1], dp[n - 2]);
  }
  public static void main() {

  }
}
