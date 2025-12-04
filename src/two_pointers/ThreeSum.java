package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = -nums[i];
      int l = i + 1, r = n - 1;
      while (l < r) {
        int curSum = nums[l] + nums[r];
        if (curSum == target) {
          res.add(List.of(nums[i], nums[l], nums[r]));
          while (l < r && nums[l] == nums[l + 1]) {
            l++;
          }
          while (l < r && nums[r] == nums[r - 1]) {
            r--;
          }
          l++;
          r--;
        } else if (curSum > target) {
          r--;
        } else {
          l++;
        }
      }
    }

    return res;
  }
  public static void main(String[] args) {
    ThreeSum t = new ThreeSum();
    System.out.println(t.threeSum(new int[]{-1,0,1,2,-1,-4}));
    System.out.println(t.threeSum(new int[]{0,1,1}));
    System.out.println(t.threeSum(new int[]{0,0,0}));
  }
}
