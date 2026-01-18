package tree;

public class BalancedBinaryTree {
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

  boolean isHeightBalance;
  public boolean isBalanced(TreeNode root) {
    isHeightBalance = true;
    dfs(root);
    return isHeightBalance;

  }
  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSubtreeHeight = dfs(root.left);
    int rightSubtreeHeight = dfs(root.right);
    if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) {
      isHeightBalance = false;
    }
    return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
  }

  public static void main(String[] args) {

  }
}
