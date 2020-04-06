package leetcode;

import tree.TreeNode;

public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumDown(root);
        return max;
    }

    private int maxSumDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxSumDown(node.left));
        int right = Math.max(0, maxSumDown(node.right));
        max = Math.max(max, (left + right + node.val));
        return Math.max(left, right) + node.val;
    }
}
