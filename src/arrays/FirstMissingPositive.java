package arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    Set<Integer> bag = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        bag.add(nums[i]);
      }
    }

    int current = 1;
    while(bag.contains(current)) {
      current++;
    }
    return current;
  }

  public static void main(String[] args) {

  }
}
