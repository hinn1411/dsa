package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
  /*
    Time: O(n^2)
    Space: O(1)
   */
  public int[] bruteForce(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1, -1};
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> seenElements = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      int complement = target - current;
      if (seenElements.containsKey(complement)) {
        return new int[]{seenElements.get(complement), i};
      }
      seenElements.put(nums[i], i);
    }
    return new int[]{-1, -1};
  }

  public static void main(String[] args) {
    TwoSum s = new TwoSum();
    System.out.println(Arrays.toString(s.bruteForce(new int[]{3, -3}, 0)));
    System.out.println(Arrays.toString(s.twoSum(new int[]{3 ,-3}, 0)));
  }
}
