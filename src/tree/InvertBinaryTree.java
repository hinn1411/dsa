package tree;

public class InvertBinaryTree {
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

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftSubTree = invertTree(root.left);
    TreeNode rightSubTree = invertTree(root.right);

    root.left = rightSubTree;
    root.right = leftSubTree;
    return root;
  }

  public static void main(String[] args) {

  }
}
