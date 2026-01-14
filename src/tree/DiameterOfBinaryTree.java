package tree;

public class DiameterOfBinaryTree {
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

  public int maxHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSubtreeHeight = maxHeight(root.left);
    int rightSubtreeHeight = maxHeight(root.right);
    return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int currentDiameter = maxHeight(root.left) + maxHeight(root.right);
    int leftDiameter = diameterOfBinaryTree(root.left);
    int rightDiameter = diameterOfBinaryTree(root.right);
    return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
  }

  public static void main(String[] args) {

  }
}
