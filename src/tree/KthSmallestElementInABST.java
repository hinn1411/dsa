package tree;

public class KthSmallestElementInABST {
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  private static int target;
  private static int count;
  public int kthSmallest(TreeNode root, int k) {
    target = 0;
    count = 0;
    dfs(root, k);
    return target;
  }

  private void dfs(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    if (count >= k) {
      return;
    }

    dfs(root.left, k);
    count++;
    if (count == k) {
      target = root.val;
      return;
    }
    dfs(root.right, k);

  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);
    KthSmallestElementInABST k = new KthSmallestElementInABST();
    System.out.println(k.kthSmallest(root, 1));
  }
}
