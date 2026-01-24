package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountGoodNodesInBinaryTree {
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

  private static int count = 0;
  public int goodNodes(TreeNode root) {
    count = 0;
    int maxValue = Integer.MIN_VALUE;
    dfs(root, maxValue);
    return count;
  }

  private void dfs(TreeNode root, int maxValue) {
    if (root == null) {
      return;
    }
    if (root.val >= maxValue) {
      count = count + 1;
    }
    maxValue = Math.max(maxValue, root.val);
    dfs(root.left, maxValue);
    dfs(root.right, maxValue);
  }

  public static class NodeInfo {
    TreeNode node;
    int maxSoFar;

    public NodeInfo(TreeNode node, int maxSoFar) {
      this.node = node;
      this.maxSoFar = maxSoFar;
    }
  }

  public int goodNodes_Bfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int count = 0;
    Queue<NodeInfo> q = new ArrayDeque<>();
    q.add(new NodeInfo(root, Integer.MIN_VALUE));

    while (!q.isEmpty()) {
      NodeInfo current = q.poll();
      TreeNode currentNode = current.node;
      int maxSoFar = current.maxSoFar;
      if (currentNode.val >= maxSoFar) {
        count++;
      }
      int nextMax = Math.max(maxSoFar, currentNode.val);

      if (currentNode.left != null) {
        q.add(new NodeInfo(currentNode.left, nextMax));
      }
      if (currentNode.right != null) {
        q.add(new NodeInfo(currentNode.right, nextMax));
      }
    }
    return count;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    CountGoodNodesInBinaryTree c = new CountGoodNodesInBinaryTree();
    System.out.println(c.goodNodes_Bfs(root));
  }
}
