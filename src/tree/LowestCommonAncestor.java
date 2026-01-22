package tree;

public class LowestCommonAncestor {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int pVal = p.val, qVal = q.val;

    TreeNode cur = root;
    while (cur != null) {
      if (cur.val > pVal && cur.val > qVal) {
        cur = cur.left;
      } else if (cur.val < pVal && cur.val < qVal) {
        cur = cur.right;
      } else {
        return cur;
      }
    }
    return null;
  }

  public TreeNode lowestCommonAncestor_Recursion(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      return lowestCommonAncestor_Recursion(root, q, p);
    }

    if (root.val > q.val) {
      return lowestCommonAncestor_Recursion(root.left, p, q);
    } else if (root.val < p.val) {
      return lowestCommonAncestor_Recursion(root.right, p, q);
    } else {
      return root;
    }
  }

  public static void main(String[] args) {

  }
}
