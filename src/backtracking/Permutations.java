package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
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
    Permutations p = new Permutations();
    System.out.println(p.permute(new int[]{1,2,3}));
  }
}
