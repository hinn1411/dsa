package tree;

public class DiameterOfBinaryTree {
  public static class TreeNode {
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
  int globalDiameter = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return globalDiameter;
  }

  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = dfs(root.left);
    int rightHeight = dfs(root.right);
    globalDiameter = Math.max(globalDiameter, leftHeight + rightHeight);
    return 1 + Math.max(leftHeight, rightHeight);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = null;

    DiameterOfBinaryTree d = new DiameterOfBinaryTree();
    System.out.println(d.diameterOfBinaryTree(root));
  }
}
