package tree;

import java.util.*;

public class BinaryTreeRightSideView {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    while (!q.isEmpty()) {
      int totalNodes = q.size();
      TreeNode lastNode = null;
      for (int i = 0; i < totalNodes; i++) {
        TreeNode current = q.removeFirst();
        lastNode = current;

        if (current.left != null) {
          q.addLast(current.left);
        }
        if (current.right != null) {
          q.addLast(current.right);
        }
      }

      res.add(lastNode.val);
    }

    return res;
  }


  public List<Integer> rightSideView_Dfs(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    int level = 0;
    dfs(root, level, res);
    return res;
  }

  private void dfs(TreeNode root, int level, List<Integer> res) {
    if (root == null) {
      return;
    }
    if (res.size() == level) {
      res.add(root.val);
    }
    dfs(root.right, level + 1, res);
    dfs(root.left, level + 1, res);
  }
  public static void main(String[] args) {

  }
}
