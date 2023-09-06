package minimum_absolute_difference_in_bst_530;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return Integer.MAX_VALUE;
        }

        int min = getMinimumDifference(root.left);

        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }

        pre = root;

        min = Math.min(min, getMinimumDifference(root.right));

        return min;
    }

 static class TreeNode {
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
}