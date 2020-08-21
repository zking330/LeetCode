package 二叉树的最小深度;

public class Solution {

   public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      TreeNode node1 = new TreeNode(9);
      TreeNode node2 = new TreeNode(20);
      TreeNode node3 = new TreeNode(15);
      TreeNode node4 = new TreeNode(17);

      node2.left = node3;
      node2.right = node4;
      root.left = node1;
      root.right = node2;

      System.out.println(minDepth(root));
   }

   public static int minDepth(TreeNode root) {
      if(root == null) {
         return 0;
      }

      if(root.left == null && root.right == null) {
         return 1;
      }

      int m1 = minDepth(root.left);
      int m2 = minDepth(root.right);

      if(m1 == 0 || m2 == 0) {
         return m1 + m2 + 1;
      }

      return Math.min(m1, m2) + 1;
   }
}
