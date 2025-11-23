package arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

  public int bruteForce(int[] nums, int k) {
    int n = nums.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int s = 0;
          for (int r = i; r <= j; r++) {
            s += nums[r];
          }
          if (s == k) {
            count++;
          }
      }
    }
    return count;
  }

  public int bruteForce_prefixSum(int[] nums, int k) {
    int n = nums.length;
    int count = 0;

    int[] prefix = new int[n];
    prefix[0] = nums[0];
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int s = prefix[j];
        if (i > 0) {
          s -= prefix[i - 1];
        }
        if (s == k) {
          count++;
        }
      }
    }
    return count;
  }

  public int prefixSum(int[] nums, int k) {
    int len = nums.length;
    int sum = 0;
    int count = 0;
    Map<Integer, Integer> fre = new HashMap<>();
    fre.put(0, 1);
    for (int i = 0; i < len; i++) {
      sum += nums[i];
      int complement = sum - k;
      count += fre.getOrDefault(complement, 0);
      fre.put(sum, fre.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    SubArraySumEqualsK s = new SubArraySumEqualsK();
    System.out.println(s.prefixSum(new int[]{1, 1, 1}, 2)); // 2
    System.out.println(s.prefixSum(new int[]{1, 2, 3}, 3)); // 2
    System.out.println(s.prefixSum(new int[]{3, 1, 2, 3}, 3)); // 3
    System.out.println(s.prefixSum(new int[]{1, 1, 1, 1}, 1)); // 4
    System.out.println(s.prefixSum(new int[]{1, 3, 1, 3, 1}, 4)); // 4

  }
}
