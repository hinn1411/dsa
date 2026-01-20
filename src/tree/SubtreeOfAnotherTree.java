package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {
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

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (subRoot == null) {
      return true;
    }

    if (root == null) {
      return false;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      TreeNode curRoot = q.poll();
      if (isSameTree(curRoot, subRoot)) {
        return true;
      }
      if (curRoot.left != null) {
        q.add(curRoot.left);
      }
      if (curRoot.right != null) {
        q.add(curRoot.right);
      }
    }
    return false;
  }

  private boolean isSameTree(TreeNode a, TreeNode b) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(a);
    q.add(b);
    while (!q.isEmpty()) {
      TreeNode curNode = q.poll();
      TreeNode subNode = q.poll();
      if (curNode == null && subNode == null) {
        continue;
      }
      if (curNode == null || subNode == null) {
        return false;
      }
      if (curNode.val != subNode.val) {
        return false;
      }
      q.add(curNode.left);
      q.add(subNode.left);
      q.add(curNode.right);
      q.add(subNode.right);
    }
    return true;
  }

  public boolean isSubtree_Dfs(TreeNode root, TreeNode subRoot) {
    if (subRoot == null) {
      return true;
    }
    if (root == null) {
      return false;
    }

    if (root.val == subRoot.val && isSameTree_Dfs(root, subRoot)) {
      return true;
    }

    return isSubtree_Dfs(root.left, subRoot) || isSubtree_Dfs(root.right, subRoot);
  }

  private boolean isSameTree_Dfs(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return true;
    }
    if (a == null || b == null) {
      return false;
    }
    if (a.val != b.val) {
      return false;
    }
    return isSameTree_Dfs(a.left, b.left) && isSameTree_Dfs(a.right, b.right);
  }

  public static void main(String[] args) {
    SubtreeOfAnotherTree s = new SubtreeOfAnotherTree();
  }
}
