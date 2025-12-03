package two_pointers;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    int cur = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] > nums[cur]) {
        cur++;
        nums[cur] = nums[i];
      }
    }
    System.out.println(Arrays.toString(nums));
    return cur + 1;
  }

  public static void main(String[] args) {
    RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
    r.removeDuplicates(new int[]{1,1,2});
    r.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
  }
}
