package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    List<String> current = new ArrayList<>();
    backtrack(s, 0, current, res);
    return res;
  }

  private void backtrack(String s, int start, List<String> current, List<List<String>> res) {
    if (start == s.length()) {
      res.add(new ArrayList<>(current));
      return;
    }

    for (int end = start; end < s.length(); end++) {
      String currentPartition = s.substring(start, end + 1);
      if (!isPalindrome(currentPartition)) {
        continue;
      }
      current.add(currentPartition);
      backtrack(s, end + 1, current, res);
      current.remove(current.size() - 1);
    }
  }

  private boolean isPalindrome(String s) {
    int start = 0, end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    PalindromePartitioning p = new PalindromePartitioning();
    System.out.println(p.partition("aab"));
    System.out.println(p.partition("a"));
    System.out.println(p.partition("aabbaa"));
  }
}
