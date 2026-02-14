package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    backtrack(nums, current, visited, res);
    return res;
  }

  private void backtrack(int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> res) {
    if (current.size() == nums.length) {
      res.add(new ArrayList<>(current));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
        continue;
      }
      if (visited[i]) {
        continue;
      }
      current.add(nums[i]);
      visited[i] = true;
      backtrack(nums, current, visited, res);
      current.removeLast();
      visited[i] = false;
    }
  }

  public static void main(String[] args) {
    Permutations2 p = new Permutations2();
    System.out.println(p.permuteUnique(new int[]{1,2,1}));
  }
}
