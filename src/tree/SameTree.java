package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
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
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if ((p == null && q != null) || (p != null && q == null)) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    boolean isLeftSubtreeSameTree = isSameTree(p.left, q.left);
    boolean isRightSubtreeSameTree = isSameTree(p.right, q.right);

    return isLeftSubtreeSameTree && isRightSubtreeSameTree;
  }

  public boolean bfs(TreeNode p, TreeNode q) {
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(p);
    nodeQueue.add(q);
    while (!nodeQueue.isEmpty()) {
      TreeNode pNode = nodeQueue.poll();
      TreeNode qNode = nodeQueue.poll();

      if (pNode == null && qNode == null) {
        continue;
      }

      if (pNode == null || qNode == null) {
        return false;
      }

      if (pNode.val != qNode.val) {
        return false;
      }

      nodeQueue.add(pNode.left);
      nodeQueue.add(qNode.left);
      nodeQueue.add(pNode.right);
      nodeQueue.add(qNode.right);
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode pRoot = new TreeNode(1);
    pRoot.left = new TreeNode(2);
    pRoot.right = new TreeNode(3);
    TreeNode qRoot = new TreeNode(1);
    qRoot.left = new TreeNode(2);
    qRoot.right = new TreeNode(3);
    SameTree s = new SameTree();
    System.out.println(s.bfs(pRoot, qRoot));

  }
}
