package tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> resList = new LinkedList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    if (root != null) {
      q.add(root);
    }

    while(!q.isEmpty()) {
      int totalNodes = q.size();
      List<Integer> levelList = new LinkedList<>();
      for (int i = 0; i < totalNodes; i++) {
        TreeNode current = q.poll();
        levelList.add(current.val);
        if (current.left != null) {
          q.add(current.left);
        }
        if (current.right != null) {
          q.add(current.right);
        }
      }
      resList.add(levelList);
    }
    return resList;
  }

  public static void main(String[] args) {

  }
}
