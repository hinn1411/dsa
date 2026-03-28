package dynamic_programming;

import java.util.Arrays;

public class CoinChange {
  private final int INF = 10000 + 1;

  public int coinChange(int[] coins, int amount) {
    int[] memo = new int[amount + 1];
    Arrays.fill(memo, -1);
    int min = helper(coins, amount, memo);
    return min == INF ? -1 : min;
  }

  private int helper(int[] coins, int remaining, int[] memo) {
    if (remaining < 0) {
      return INF;
    }
    if (remaining == 0) {
      memo[0] = 0;
      return memo[0];
    }
    if (memo[remaining] != -1) {
      return memo[remaining];
    }
    int minCoins = INF;
    for (int coin : coins) {
      minCoins = Math.min(minCoins, helper(coins, remaining - coin, memo) + 1);
    }
    memo[remaining] = minCoins;
    return memo[remaining];
  }
}
