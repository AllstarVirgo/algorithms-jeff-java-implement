package recursion;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeetCode687 {
    int longestCount = 0;

    int currentCount = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;
            if (leftChild != null) {
                if (leftChild.val != root.val) {
                    if (currentCount > longestCount)
                        longestCount = currentCount;
                    currentCount = 0;
                    longestUnivaluePath(leftChild);
                } else {
                    currentCount++;
                    longestUnivaluePath(leftChild.left);
                    longestUnivaluePath(leftChild.right);
                }
            }
            if (rightChild != null) {
                if (rightChild.val != root.val) {
                    if (currentCount > longestCount)
                        longestCount = currentCount;
                    currentCount = 0;
                    longestUnivaluePath(rightChild);
                } else {
                    currentCount++;
                    longestUnivaluePath(rightChild.left);
                    longestUnivaluePath(rightChild.right);
                }
            }
        }
        return longestCount;
    }
}