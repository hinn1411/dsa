package backtracking;

import java.util.*;

public class Subsets2 {


  public List<List<Integer>> subsetsWithDup_Set(int[] nums) {
    Arrays.sort(nums);
    Set<String> visited = new HashSet<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    backtrack_Set(nums, 0, current, visited, res);
    return res;
  }

  private void backtrack_Set(int[] nums, int curIndex, List<Integer> current,
                             Set<String> visited, List<List<Integer>> res) {
    if (curIndex == nums.length) {
      if (!visited.contains(current.toString())) {
        res.add(new ArrayList<>(current));
        visited.add(current.toString());
      }
      return;
    }
    backtrack_Set(nums, curIndex + 1, current, visited, res);
    current.add(nums[curIndex]);
    backtrack_Set(nums, curIndex + 1, current, visited, res);
    current.removeLast();
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    backtrack(nums, 0, current, res);
    return res;
  }

  private void backtrack(int[] nums, int curIndex, List<Integer> current, List<List<Integer>> res) {
    res.add(new ArrayList<>(current));

    for (int i = curIndex; i < nums.length; i++) {
      if (i > curIndex && nums[i] == nums[i - 1]) {
        continue;
      }
      current.add(nums[i]);
      backtrack(nums, i + 1, current, res);
      current.removeLast();
    }
  }


  public static void main(String[] args) {
    Subsets2 s = new Subsets2();
    System.out.println(s.subsetsWithDup(new int[]{1, 2, 1}));
  }
}
