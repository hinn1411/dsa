package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    backtrack(candidates, 0, current, 0, target, res);
    return res;
  }

  private void backtrack(int[] candidates, int curIndex, List<Integer> current, int curSum, int target, List<List<Integer>> res) {
    if (curSum > target) {
      return;
    }

    if (curSum == target) {
      res.add(new ArrayList<>(current));
      return;
    }
    for (int i = curIndex; i < candidates.length; i++) {
      curSum += candidates[i];
      current.add(candidates[i]);
      backtrack(candidates, i, current, curSum, target, res);
      curSum -= candidates[i];
      current.removeLast();
    }
  }

  public static void main(String[] args) {
    CombinationSum c = new CombinationSum();
    System.out.println(c.combinationSum(new int[]{2,3,6,7}, 7));
  }
}
