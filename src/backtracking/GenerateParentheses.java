package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    backtrack(n, 0, 0, "", res);

    return res;
  }

  private void backtrack(int n, int openCount, int closedCount, String current, List<String> res) {
    if (current.length() == 2 * n) {
      res.add(current);
      return;
    }

    if (openCount < n) {
      backtrack(n, openCount + 1, closedCount, current + "(", res);
    }

    if (closedCount < openCount) {
      backtrack(n, openCount, closedCount + 1, current + ")", res);
    }
  }

  public static void main(String[] args) {
    GenerateParentheses g = new GenerateParentheses();
    System.out.println(g.generateParenthesis(3));
  }
}
