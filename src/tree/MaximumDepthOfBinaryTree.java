package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
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

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = maxDepth(root.left);
    int rightHeight = maxDepth(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  public int maxDepth_Dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    int depth = 0;
    while (!q.isEmpty()) {
      int currentTotalNodes = q.size();
      for (int i = 0; i < currentTotalNodes; i++) {
        TreeNode current = q.poll();
        if (current != null && current.left != null) {
          q.add(current.left);
        }
        if (current != null && current.right != null) {
          q.add(current.right);
        }
      }
      depth++;
    }
    return depth;
  }

  public static void main(String[] args) {

  }
}
