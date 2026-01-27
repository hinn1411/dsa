package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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


  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inOrderMap.put(inorder[i], i);
    }
    return build(preorder, inOrderMap, 0, preorder.length - 1, 0, inorder.length - 1);
  }

  private TreeNode build(int[] preorder, Map<Integer, Integer> inorder, int preL, int preR, int inL, int inR) {
    if (preL > preR) {
      return null;
    }
    int rootVal = preorder[preL];
    TreeNode root = new TreeNode(rootVal);

    int rootIndex = inorder.get(rootVal);
    int leftSize = rootIndex - inL;
    root.left = build(preorder, inorder, preL + 1, preL + leftSize, inL, rootIndex - 1);
    root.right = build(preorder, inorder, preL + leftSize + 1, preR, rootIndex + 1, inR);
    return root;
  }

  public static void main(String[] args) {
    ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
    TreeNode root = c.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
  }
}
