package dynamic_programming;

import java.util.Arrays;

public class DecodeWays {

  public int numDecodings(String s) {
    int n = s.length();
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    return decode(s, n - 1, memo);
  }

  private int decode(String s, int i, int[] memo) {
    if (i < 0) {
      return 1;
    }

    if (i == 0 && s.charAt(i) != '0') {
      memo[0] = s.charAt(0) != '0' ? 1 : 0;
      return memo[0];
    }

    if (memo[i] != -1) {
      return memo[i];
    }

    int count = 0;
    if (s.charAt(i) != '0') {
      count += decode(s, i - 1, memo);
    }

    if (i >= 1) {
      int twoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
      if (10 <= twoDigits && twoDigits <= 26) {
        count += decode(s, i - 2, memo);
      }
    }

    return count;
  }
}
