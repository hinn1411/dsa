package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public int sort(int[] nums) {
    int n = nums.length;

    if (n == 0) {
      return 0;
    }

    Arrays.sort(nums);
    int maxLen = 1;
    int curLen = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }

      if (nums[i] == nums[i - 1] + 1) {
        curLen++;
        maxLen = Math.max(maxLen, curLen);
      } else {
        curLen = 1;
      }
    }

    return maxLen;
  }

  public int longestConsecutive(int[] nums) {

    Set<Integer> numSet = new HashSet<>();
    for (int num: nums) {
      numSet.add(num);
    }

    int maxLen = 0;
    int curLen;
    for (int num: numSet) {
      if (!numSet.contains(num - 1)) {
        int nextNum = num + 1;
        curLen = 1;
        while(numSet.contains(nextNum)) {
          curLen++;
          nextNum++;
        }
        maxLen = Math.max(maxLen, curLen);
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    LongestConsecutiveSequence l = new LongestConsecutiveSequence();
    System.out.println(l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})); // 4
    System.out.println(l.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
    System.out.println(l.longestConsecutive(new int[]{1, 0, 1, 2})); // 3
    System.out.println(l.longestConsecutive(new int[]{8, 7, 6, 5, 4, 3, 2, 2, 2, 3, 1})); // 8
    System.out.println(l.longestConsecutive(new int[]{})); // 0
    System.out.println(l.longestConsecutive(new int[]{1})); // 1
  }
}
