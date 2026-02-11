package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> currentSubset = new ArrayList<>();
    backtrack_Combination(nums, 0, currentSubset, res);

    return res;
  }

  private void backtrack(int[] nums, int currentIndex, List<Integer> currentState, List<List<Integer>> res) {
    if (currentIndex == nums.length) {
      res.add(new ArrayList<>(currentState));
      return;
    }
    backtrack(nums, currentIndex + 1, currentState, res);
    currentState.add(nums[currentIndex]);
    backtrack(nums, currentIndex + 1, currentState, res);
    currentState.removeLast();
  }

  private void backtrack_Combination(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
    res.add(new ArrayList<>(cur));

    for (int i = start; i < nums.length; i++) {
      cur.add(nums[i]);              // choose
      backtrack_Combination(nums, i + 1, cur, res); // explore
      cur.removeLast();
    }
  }

  public static void main(String[] args) {
    Subsets s = new Subsets();
    System.out.println(s.subsets(new int[]{1, 2, 3}));
  }
}
